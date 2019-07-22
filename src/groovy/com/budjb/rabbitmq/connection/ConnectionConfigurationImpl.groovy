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

import com.rabbitmq.client.ConnectionFactory
import org.apache.log4j.Logger

class ConnectionConfigurationImpl implements ConnectionConfiguration {
    /**
     * Logger.
     */
    Logger log = Logger.getLogger(ConnectionConfigurationImpl)

    /**
     * RabbitMQ host.
     */
    String host

    /**
     * RabbitMQ name.
     */
    String name

    /**
     * Whether the connection is the default connection.
     */
    boolean isDefault = false

    /**
     * Username.
     */
    String username

    /**
     * Password.
     */
    String password

    /**
     * Virtual host.
     */
    String virtualHost = ConnectionFactory.DEFAULT_VHOST

    /**
     * Whether to automatically reconnect.
     */
    boolean automaticReconnect = true

    /**
     * Number of concurrent threads (0 is unlimited).
     */
    int threads = 0

    /**
     * Sets the requested heartbeat delay, in seconds, that the server sends in the connection.tune frame.
     *
     * 5 is the RabbitMQ default. 0 means unlimited.
     */
    int requestedHeartbeat = ConnectionFactory.DEFAULT_HEARTBEAT

    /**
     * Whether the connection uses SSL.
     */
    boolean ssl = false

    /**
     * Port to use to connect to the RabbitMQ broker.
     */
    int port = ConnectionFactory.DEFAULT_AMQP_PORT

    /**
     * Basic constructor.
     */
    ConnectionConfigurationImpl() {}

    /**
     * SSL TLS Protocol TLSv1.1,TLSv1.2
     */

    String sslProtocol

    /**
     * Constructor.
     *
     * @param configuration
     */
    ConnectionConfigurationImpl(Map configuration) {
        // Assign values
        setAutomaticReconnect(parseConfigOption(Boolean, configuration['automaticReconnect'], automaticReconnect))
        setHost(parseConfigOption(String, configuration['host'], host))
        setIsDefault(parseConfigOption(Boolean, configuration['isDefault'], isDefault))
        setName(parseConfigOption(String, configuration['name'], name))
        setPassword(parseConfigOption(String, configuration['password'], password))
        setPort(parseConfigOption(Integer, configuration['port'], port))
        setRequestedHeartbeat(parseConfigOption(Integer, configuration['requestedHeartbeat'], requestedHeartbeat))
        setSsl(parseConfigOption(Boolean, configuration['ssl'], ssl))
        setThreads(parseConfigOption(Integer, configuration['threads'], threads))
        setUsername(parseConfigOption(String, configuration['username'], username))
        setVirtualHost(parseConfigOption(String, configuration['virtualHost'], virtualHost))
        setSslProtocol(parseConfigOption(String, configuration['sslProtocol'], sslProtocol))

    }

    /**
     * Parses a configuration option given a class type and possible values.
     *
     * @param clazz
     * @param values
     * @return
     */
    private Object parseConfigOption(Class clazz, Object... values) {
        for (Object value : values) {
            if (value == null) {
                continue
            }

            try {
                return value.asType(clazz)
            }
            catch (Exception e) {
                // Continue...
            }
        }

        return null
    }

    /**
     * Returns whether the configuration is valid.
     *
     * @return
     */
    @Override
    boolean isValid() {
        boolean valid = true

        if (!host) {
            log.warn("RabbitMQ connection host configuration is missing")
            valid = false
        }

        if (!username) {
            log.warn("RabbitMQ connection username is missing")
            valid = false
        }

        if (!password) {
            log.warn("RabbitMQ connection password is missing")
            valid = false
        }

        if (!virtualHost) {
            log.warn("RabbitMQ connection virtualHost is missing")
            valid = false
        }

        if (port <= 0) {
            log.warn("RabbitMQ connection port is missing")
            valid = false
        }

        if (threads < 0) {
            log.warn("RabbitMQ connection threads must be greater than or equal to 0")
            valid = false
        }

        return valid
    }

    /**
     * Sets the name.  If the name is null or empty, a name will be assigned.
     *
     * @param name
     */
    @Override
    void setName(String name) {
        if (!name) {
            name = UUID.randomUUID().toString()
            log.warn("connection to RabbitMQ host '${host}:${port}' on virtual host '${virtualHost}' had no name assigned; assigning name '${name}'")
        }
        this.name = name
    }

    void setIsDefault(boolean b) {
        this.isDefault = b;
    }

    boolean  getIsDefault() {
        return isDefault;
    }
}
