/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parivero.jenkins.speech.domain;

import java.util.Collection;

/**
 *
 * @author parivero
 */
public class Response {
    
    private Collection<Job> jobs;

    /**
     * @return the jobs
     */
    public Collection<Job> getJobs() {
        return jobs;
    }

    /**
     * @param jobs the jobs to set
     */
    public void setJobs(Collection<Job> jobs) {
        this.jobs = jobs;
    }

    
    
}
