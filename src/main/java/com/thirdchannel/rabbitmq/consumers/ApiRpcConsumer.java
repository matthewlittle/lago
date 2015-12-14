package com.thirdchannel.rabbitmq.consumers;

import com.thirdchannel.rabbitmq.RabbitMQDeliveryDetails;
import com.thirdchannel.rabbitmq.messages.ApiResponse;
import com.thirdchannel.rabbitmq.messages.ConsumerApiResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Steve Pember
 */
public class ApiRpcConsumer extends LagoRpcConsumer<Object, ApiResponse> {
    @Override
    public ApiResponse handleRPC(Object message, RabbitMQDeliveryDetails rabbitMQDeliveryDetails) {
        return null;
    }

    public Map buildApi() {
        ApiResponse response = new ApiResponse();

        for (EventConsumer consumer : getLago().getRegisteredConsumers()) {
            log.info(consumer.getClass().getSimpleName() + " message: " + consumer.getMessageClass().toString());

            log.info("Instance of Lagorpc? " + (consumer instanceof RpcConsumer));

            if (consumer instanceof RpcConsumer) {
                Class c = ((LagoRpcConsumer) consumer).getResponseClass();
                log.info(consumer.getClass().getSimpleName() + " response: " + (c));
            }

//            try {
//
//                Method method = consumer.getClass().getMethod("handleMessage", Object.class, RabbitMQDeliveryDetails.class );
//                log.info("Generic Parameter types: ");
//                Class c = method.getParameterTypes()[0];
//                Type t = method.getGenericParameterTypes()[0];
//
//                log.info("Eh");
//            } catch (NoSuchMethodException e) {
//                log.warn("Class " + consumer.getClass().getSimpleName() + " does not contain 'handleMessage'!");
//                log.info("But it does havE: ");
//                for (Method m: consumer.getClass().getMethods()) {
//                    log.info(m.getName() + ": " + m.getParameterTypes().toString());
//                }
//            } catch(ClassCastException | NullPointerException cce) {
//                log.error("Could not cast: ", cce);
//            }
        }

        return new HashMap<String, String>();
    }

    private ConsumerApiResponse parseConsumer(EventConsumer consumer) {
        ConsumerApiResponse response = new ConsumerApiResponse();

        return response;
    }


}