/*
 * Copyright 2015 Bud Byrd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.budjb.rabbitmq.connection

/**
 * Builder class for building connection contexts from a configuration file.
 */
class ConnectionBuilderImpl implements ConnectionBuilder {
    /**
     * Class that handles the connection configuration closure.
     */
    private class ConnectionBuilderDelegate {
        /**
         * Creates a connection context from a configuration or closure method.
         *
         * @param parameters
         * @return
         */
        void connection(Map parameters) {
            // Build the context
            ConnectionContext context = ConnectionBuilderImpl.this.connectionManager.createContext(parameters)

            // Store the context
            ConnectionBuilderImpl.this.connectionContexts << context
        }
    }

    /**
     * Connection manager.
     */
    ConnectionManager connectionManager

    /**
     * List of connections created by the builder.
     */
    private List<ConnectionContext> connectionContexts

    /**
     * Loads connection contexts from a configuration provided by a closure.
     *
     * @param closure
     * @return
     */
    @Override
    List<ConnectionContext> loadConnectionContexts(Closure closure) {
        connectionContexts = []

        ConnectionBuilderDelegate delegate = new ConnectionBuilderDelegate()
        closure.resolveStrategy = Closure.DELEGATE_ONLY
        closure.delegate = delegate
        closure()

        return connectionContexts
    }

    /**
     * Loads connection contexts from a configuration based on a map.
     *
     * @param configuration
     * @return
     */
    @Override
    List<ConnectionContext> loadConnectionContexts(Map configuration) {
        return [connectionManager.createContext(configuration)]
    }
}
