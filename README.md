# pub-sub-app
A small demo of Apache Pulsar using Java and Spring Boot

# Pre-Requisites
Open Docker and run this command

docker run -it \
-p 6650:6650 \
-p 8080:8080 \
--mount source=pulsardata,target=/pulsar/data \
--mount source=pulsarconf,target=/pulsar/conf \
apachepulsar/pulsar:4.0.1 \
bin/pulsar standalone
