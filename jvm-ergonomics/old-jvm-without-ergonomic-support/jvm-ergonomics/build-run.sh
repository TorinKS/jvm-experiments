#!/bin/sh

mvn clean package
docker build -t jvm-ergonomics .
docker run --rm --memory=4792MB --cpus="2.0" jvm-ergonomics | grep -Ei "App\:|ergonomic"
