import groovy.json.JsonSlurper

def jobs = new JsonSlurper().parseText( payload );

return jobs;


