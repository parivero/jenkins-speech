/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package com.parivero.jenkins.speech;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) throws InterruptedException {

        AbstractApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/jenkins-speech-integration.xml");
        context.registerShutdownHook();

    }
}
