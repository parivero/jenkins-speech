/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parivero.jenkins.speech.domain;

/**
 *
 * @author parivero
 */
public class Job {
    
    private String name;
    private LastBuild lastBuild;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the lastBuild
     */
    public LastBuild getLastBuild() {
        return lastBuild;
    }

    /**
     * @param lastBuild the lastBuild to set
     */
    public void setLastBuild(LastBuild lastBuild) {
        this.lastBuild = lastBuild;
    }
    
}
