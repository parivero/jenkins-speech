package com.parivero.jenkins.speech;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) throws InterruptedException {

        AbstractApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/jenkins-speech-integration.xml");
        context.registerShutdownHook();

    }
}
