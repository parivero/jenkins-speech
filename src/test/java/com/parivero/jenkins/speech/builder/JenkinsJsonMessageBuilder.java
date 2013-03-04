/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parivero.jenkins.speech.builder;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author parivero
 */
public class JenkinsJsonMessageBuilder {

    private static String defaultJob = "{\"name\":\"myJob\","
            + "\"lastBuild\":{\"building\":false,\"duration\":371121,"
            + "\"result\":\"SUCCESS\",\"timestamp\":jobTimeStamp}}";
    private Collection<String> jobs;

    public JenkinsJsonMessageBuilder() {
        jobs = new ArrayList<>();
    }

    public JenkinsJsonMessageBuilder addJobWithTimeStamp(Long timeStamp) {
        String newJob = defaultJob.replaceAll("jobTimeStamp", String.valueOf(timeStamp));
        jobs.add(newJob);
        return this;
    }

    public JenkinsJsonMessageBuilder addJob() {
        jobs.add(defaultJob.replaceAll("jobTimeStamp", String.valueOf(System.currentTimeMillis())));
        return this;
    }

    public String build() {
        String message = "";
        for (String job : jobs) {
            if (!message.isEmpty()) {
                message = message + ",";
            }
            message = message + job;
        }
        return "{\"jobs\":[" + message + "]}";
    }
}
