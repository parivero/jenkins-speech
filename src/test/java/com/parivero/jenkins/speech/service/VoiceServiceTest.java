/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package com.parivero.jenkins.speech.service;

import com.gtranslate.Audio;
import java.io.InputStream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kubek2k.springockito.annotations.ReplaceWithMock;
import org.kubek2k.springockito.annotations.SpringockitoContextLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.times;
import org.springframework.test.annotation.DirtiesContext;

/**
 *
 * @author parivero
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = SpringockitoContextLoader.class,
        locations = {"classpath:spring/jenkins-speech-integration-test.xml"})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class VoiceServiceTest {

    @Autowired
    private VoiceService instance;
    
    @ReplaceWithMock
    @Autowired
    private Audio audio;

    @Test
    public void talk_messageWithPreSound_executePlayMethodTwoTimes() throws Exception {
        String message = "Hola";
        instance.talk(message);
        verify(audio, times(2)).play((InputStream) any());

    }

    @Test
    public void talk_messageWithoutPreSound_executePlayMethodOneTimes() throws Exception {
        instance.setPreSound("");
        String message = "Hola";
        instance.talk(message);
        verify(audio, times(1)).play((InputStream) any());
    }
}