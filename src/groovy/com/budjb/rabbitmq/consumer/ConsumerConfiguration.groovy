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
package com.budjb.rabbitmq.consumer

import com.budjb.rabbitmq.RabbitManagedContextConfiguration

interface ConsumerConfiguration extends RabbitManagedContextConfiguration {
    /**
     * Returns whether the consumer should auto acknowledge.
     */
    AutoAck getAutoAck()

    /**
     * Sets whether the consumer should auto acknowledge.
     */
    void setAutoAck(AutoAck autoAck)

    /**
     * Returns the consumer binding.
     */
    Object getBinding()

    /**
     * Sets the consumer binding.
     */
    void setBinding(Object binding)

    /**
     * Returns the name of the connection that should be used to consume from.
     */
    String getConnection()

    /**
     * Sets the name of the connection that should be used to consume from.
     */
    void setConnection(String connection)

    /**
     * Returns the number of concurrent consumers.
     */
    int getConsumers()

    /**
     * Sets the number of concurrent consumers.
     */
    void setConsumers(int consumers)

    /**
     * Returns whether to attempt conversion of incoming messages.
     * This also depends on the appropriate handler signature being present.
     */
    MessageConvertMethod getConvert()

    /**
     * Sets whether to attempt conversion of incoming messages.
     * This also depends on the appropriate handler signature being present.
     */
    void setConvert(MessageConvertMethod convert)

    /**
     * Returns the exchange to subscribe to.
     */
    String getExchange()

    /**
     * Sets the exchange to subscribe to.
     */
    void setExchange(String exchange)

    /**
     * Returns the headers consume binding requirement.
     */
    String getMatch()

    /**
     * Sets the headers consume binding requirement.
     */
    void setMatch(String match)

    /**
     * Returns the number of messages that should be pre-fetched from the queue.
     */
    int getPrefetchCount()

    /**
     * Sets the number of messages that should be pre-fetched from the queue.
     */
    void setPrefetchCount(int prefetchCount)

    /**
     * Returns the queue to listen on.
     */
    String getQueue()

    /**
     * Sets the queue to listen on.
     */
    void setQueue(String queue)

    /**
     * Returns whether to retry the message on failure.
     */
    boolean getRetry()

    /**
     * Sets whether to retry the message on failure.
     */
    void setRetry(boolean retry)

    /**
     * Returns whether to mark the consumer as transacted.
     */
    boolean getTransacted()

    /**
     * Sets whether to mark the consumer as transacted.
     */
    void setTransacted(boolean transacted)
}
