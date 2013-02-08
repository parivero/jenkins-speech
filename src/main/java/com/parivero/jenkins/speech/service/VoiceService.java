/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parivero.jenkins.speech.service;

import com.gtranslate.Audio;
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

    public VoiceService() {
        audio = Audio.getInstance();
    }

    public void talk(String alerta) throws IOException, JavaLayerException {
        
        logger.info("Mensaje de alerta: {}",alerta);
        
        InputStream sound = audio.getAudio(alerta, getIdioma());
        audio.play(sound);
    }

    /**
     * @return the idioma
     */
    public String getIdioma() {
        return language;
    }

    /**
     * @param idioma the idioma to set
     */
    public void setIdioma(String idioma) {
        this.language = idioma;
    }
}
