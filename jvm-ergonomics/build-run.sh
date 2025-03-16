#!/bin/sh

mvn clean package
docker build -t jvm-ergonomics .
docker run --rm --memory=4792MB --cpus="0.5" jvm-ergonomics | grep -Ei "App\:|ergonomic"
