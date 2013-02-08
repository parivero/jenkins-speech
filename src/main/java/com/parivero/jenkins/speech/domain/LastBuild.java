/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parivero.jenkins.speech.domain;

/**
 *
 * @author parivero
 */
public class LastBuild {
    
    private Boolean  building;
    private String result;
    private Long timestamp;
    private Long duration;
    
    /**
     * @return the building
     */
    public Boolean getBuilding() {
        return building;
    }

    /**
     * @param building the building to set
     */
    public void setBuilding(Boolean building) {
        this.building = building;
    }

    /**
     * @return the result
     */
    public String getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(String result) {
        this.result = result;
    }

    /**
     * @return the timestamp
     */
    public Long getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp the timestamp to set
     */
    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * @return the duration
     */
    public Long getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(Long duration) {
        this.duration = duration;
    }

    
}
