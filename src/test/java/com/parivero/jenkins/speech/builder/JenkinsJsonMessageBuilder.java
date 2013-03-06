/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package com.parivero.jenkins.speech.builder;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author parivero
 */
public class JenkinsJsonMessageBuilder {

    private static String jobTemplate = "{\"name\":\"myJob\","
            + "\"lastBuild\":{\"building\":false,\"duration\":371121,"
            + "\"result\":\"SUCCESS\",\"timestamp\":jobTimeStamp}}";
    private Collection<String> jobs;

    public JenkinsJsonMessageBuilder() {
        jobs = new ArrayList<>();
    }

    public JenkinsJsonMessageBuilder addJobWithTimeStamp(Long timeStamp) {
        String newJob = jobTemplate.replaceAll("jobTimeStamp", String.valueOf(timeStamp));
        jobs.add(newJob);
        return this;
    }
    
    public JenkinsJsonMessageBuilder addJobWithJobName(String jobName) {
        String newJob = getDaefaultJob().replaceAll("myJob", jobName);
        jobs.add(newJob);
        return this;
    }

    public JenkinsJsonMessageBuilder addJob() {
        String newJob = getDaefaultJob();
        jobs.add(newJob);
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
    
    private String  getDaefaultJob() {
        return jobTemplate.replaceAll("jobTimeStamp", String.valueOf(System.currentTimeMillis()));
    }
    
}
