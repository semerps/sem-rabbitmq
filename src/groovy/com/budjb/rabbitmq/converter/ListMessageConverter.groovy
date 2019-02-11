/*
 * Copyright 2013-2015 Bud Byrd
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
package com.budjb.rabbitmq.converter

import groovy.json.JsonBuilder
import groovy.json.JsonException
import groovy.json.JsonSlurper

class ListMessageConverter extends MessageConverter<List> {
    @Override
    boolean canConvertFrom() {
        return true
    }

    @Override
    boolean canConvertTo() {
        return true
    }

    @Override
    List convertTo(byte[] input) {
        try {
            return new JsonSlurper().parseText(new String(input))
        }
        catch (Exception e) {
            return null
        }
    }

    @Override
    byte[] convertFrom(List input) {
        try {
            return new JsonBuilder(input).toString().getBytes()
        }
        catch (JsonException e) {
            return null
        }
    }

    @Override
    String getContentType() {
        return 'application/json'
    }

}
