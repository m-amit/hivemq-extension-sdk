/*
 * Copyright 2018-present HiveMQ GmbH
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

package com.hivemq.extension.sdk.api.packets.subscribe;

import com.hivemq.extension.sdk.api.annotations.DoNotImplement;
import com.hivemq.extension.sdk.api.annotations.Immutable;
import com.hivemq.extension.sdk.api.annotations.NotNull;
import com.hivemq.extension.sdk.api.packets.general.Qos;

/**
 * Represents a subscription from a SUBSCRIBE packet.
 * <p>
 * Contains all values of an MQTT 5 SUBSCRIBE, but will also used to represent MQTT 3 subscribes.
 *
 * @author Christoph Schäbel
 * @since 4.0.0, CE 2019.1
 */
@Immutable
@DoNotImplement
public interface Subscription {

    /**
     * The topic filter the client wants to subscribe to.
     *
     * @return The topic filter of the subscription.
     * @since 4.0.0, CE 2019.1
     */
    @NotNull String getTopicFilter();

    /**
     * The quality of service level of the subscription.
     *
     * @return The quality of service level of the subscription.
     * @since 4.0.0, CE 2019.1
     */
    @NotNull Qos getQos();

    /**
     * The retain handling states how a retained message should be send for a subscription.
     * <ul>
     *   <li>{@link RetainHandling#SEND} -&gt; Send every retained message for any subscription.
     *   <li>{@link RetainHandling#SEND_IF_NEW_SUBSCRIPTION} -&gt; Send retained messages for new subscriptions only.
     *   <li>{@link RetainHandling#DO_NOT_SEND} -&gt; Do not send retained message for a subscription.
     * </ul>
     * <p>
     * For an MQTT 3 subscription this MQTT 5 property will always be {@link RetainHandling#SEND}.
     *
     * @return The retain handling of the subscription.
     * @since 4.0.0, CE 2019.1
     */
    @NotNull RetainHandling getRetainHandling();

    /**
     * The retain as published flag indicates if the client wants the retain flag preserved for received messages to the
     * topic filter of the subscription.
     * <p>
     * If <code>true</code> the retain flag is preserved. If <code>false</code> it isn't.
     * <p>
     * For an MQTT 3 subscription this MQTT 5 property will always be <code>false</code>.
     *
     * @return The retain as published flag of the subscription.
     * @since 4.0.0, CE 2019.1
     */
    boolean getRetainAsPublished();

    /**
     * The no local flag indicates if the client wants to receive messages published by itself to the topic filter of
     * the subscription.
     * <p>
     * If <code>false</code> the client also receives it's own messages. If <code>true</code> it doesn't.
     * <p>
     * For an MQTT 3 subscription this MQTT 5 property will always be <code>false</code>.
     *
     * @return The no local flag of the subscription.
     * @since 4.0.0, CE 2019.1
     */
    boolean getNoLocal();
}
