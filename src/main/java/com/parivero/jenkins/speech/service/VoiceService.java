/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parivero.jenkins.speech.service;

import com.gtranslate.Audio;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javazoom.jl.decoder.JavaLayerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author parivero
 */
public class VoiceService {

    private static Logger logger = LoggerFactory.getLogger(VoiceService.class);
    private String language;
    private Audio audio;
    private String preSound;

    public VoiceService() throws FileNotFoundException {
        audio = Audio.getInstance();

    }

    public void talk(String message) throws IOException, JavaLayerException {

        logger.info("Mensaje a hablar: {}", message);

        if (!preSound.isEmpty()) {
            InputStream startSound = getResource(preSound);
            audio.play(startSound);
        }

        InputStream sound = audio.getAudio(message, getLanguage());
        audio.play(sound);

    }
    
    private InputStream getResource(String path) throws IOException {
        
        File file = new File(path);
        if (file.exists()) {
            return new FileInputStream(file);
        }
        
        return Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
    }

    /**
     * @return the language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * @param language the language to set
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * @param preSound the preSound to set
     */
    public void setPreSound(String preSound) {
        this.preSound = preSound;
    }

    
}
