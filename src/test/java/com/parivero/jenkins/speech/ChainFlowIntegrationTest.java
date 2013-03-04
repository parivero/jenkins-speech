/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parivero.jenkins.speech;

import com.parivero.jenkins.speech.builder.JenkinsJsonMessageBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.message.GenericMessage;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author parivero
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/jenkins-speech-integration-test.xml"})
public class ChainFlowIntegrationTest {

    @Autowired
    @Qualifier("jobsChannel")
    private MessageChannel jobsChannel;
    @Autowired
    @Qualifier("testChannel")
    private QueueChannel testChannel;

    
    @Before
    public void setUp() {
        testChannel.clear();
    }

    @Test
    public void chain_withOneJob_returnOneMessage() {

        String message = new JenkinsJsonMessageBuilder().addJob().build();
        System.out.println("Message" + message);

        jobsChannel.send(new GenericMessage<>(message));
        Message<String> outMessage = (Message<String>) testChannel.receive();
        Assert.assertTrue(outMessage.getPayload().contains("myJob"));
    }

    @Test
    public void chain_withOldJob_returnNullMessage() {
        String message = new JenkinsJsonMessageBuilder().addJobWithTimeStamp(System.currentTimeMillis() - 10000000).build();

        System.out.println("Message" + message);
        jobsChannel.send(new GenericMessage<>(message));
        Message<String> outMessage = (Message<String>) testChannel.receive(100);
        Assert.assertNull(outMessage);
    }

    @Test
    public void chain_whitTwoJobs_returnTwoJobs() {
        String message = new JenkinsJsonMessageBuilder().addJob().addJob().build();
        System.out.println("Message" + message);
        jobsChannel.send(new GenericMessage<>(message));
        Assert.assertEquals(2, testChannel.getQueueSize());
    }

    @Test
    public void chain_whitTwoJobs_returnOneJobs() {
        String message = new JenkinsJsonMessageBuilder().addJob().addJobWithTimeStamp(System.currentTimeMillis() - 10000000).build();
        System.out.println("Message" + message);
        jobsChannel.send(new GenericMessage<>(message));
        Assert.assertEquals(1, testChannel.getQueueSize());
    }
}
