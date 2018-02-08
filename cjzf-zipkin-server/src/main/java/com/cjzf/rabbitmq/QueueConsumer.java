package com.cjzf.rabbitmq;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.SerializationUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName QueueConsumer
 * @Description
 * @author nicholas
 * @Date 2018年1月10日 下午14:13:26
 * @version 1.0.1
 */
@Slf4j
public class QueueConsumer extends EndPoint implements Runnable, Consumer {
    private static final Logger log = LoggerFactory.getLogger(QueueConsumer.class);
    
    QueueConsumer(String endPointName) throws IOException, TimeoutException {
        super(endPointName);
    }

    @Override
    public void run() {
        try {
            //start consuming messages. Auto acknowledge messages.
            channel.basicConsume(endPointName, true, this);
        } catch (IOException e) {
            log.error("exception message is: {}", ExceptionUtils.getStackTrace(e));
        }
    }

    /**
     * Called when consumer is registered.
     */
    @Override
    public void handleConsumeOk(String consumerTag) {
        log.info("Consumer {} registered", consumerTag);
    }

    /**
     * Called when new message is available.
     */
    @Override
    public void handleDelivery(String consumerTag, Envelope env,
                               BasicProperties props, byte[] body) throws IOException {
        Map map = SerializationUtils.deserialize(body);
        log.info("Message Number {} received.", map.get("message number"));

    }

    @Override
    public void handleCancel(String consumerTag) {
        log.info("Consumer {} cancel", consumerTag);
    }

    @Override
    public void handleCancelOk(String consumerTag) {
        log.info("Consumer {} cancel", consumerTag);
    }

    @Override
    public void handleRecoverOk(String consumerTag) {
        log.info("Consumer {} recover", consumerTag);
    }

    @Override
    public void handleShutdownSignal(String consumerTag, ShutdownSignalException sig) {
        log.info("Consumer {},{} shutdown", consumerTag, sig);
    }
}