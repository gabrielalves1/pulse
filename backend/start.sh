#!/bin/sh
cat /config/backend.application.properties
cd /config/
ls

cd /pulse
java -jar backend-1.0-SNAPSHOT.jar --spring.config.location=/config/backend.application.properties