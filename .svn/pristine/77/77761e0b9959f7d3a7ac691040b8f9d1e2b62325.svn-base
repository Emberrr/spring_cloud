package com.cjzf.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ProducerTest
 * @Description
 * @author nicholas
 * @Date 2018年1月10日 下午14:13:26
 * @version 1.0.1
 */
@Slf4j
public class ProducerTest {
    private static final Logger log = LoggerFactory.getLogger(ProducerTest.class);
    
    private QueueConsumer consumer;
    private Producer producer;

    @Before
    public void setUp() throws Exception {
        consumer = new QueueConsumer("queue");
        producer = new Producer("queue");

        Thread consumerThread = new Thread(consumer);
        consumerThread.start();
    }

    @After
    public void tearDown() {
        consumer = null;
        producer = null;
    }

    @Test
    public void sendMessage() throws Exception {
        for (int i = 0; i < 100; i++) {
            Map<String, Integer> message = new HashMap<>();
            message.put("message number", i);
            producer.sendMessage((Serializable) message);
            log.info("Message Number {} sent.", i);
        }
    }
}