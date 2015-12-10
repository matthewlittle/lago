package com.thirdchannel.rabbitmq.consumers;

import com.rabbitmq.client.Consumer;
import com.thirdchannel.rabbitmq.RabbitMQDeliveryDetails;

/**
 * @author Steve Pember
 */
public interface RpcConsumer<M, R> {

    R handleRPC(M message, RabbitMQDeliveryDetails rabbitMQDeliveryDetails);
}