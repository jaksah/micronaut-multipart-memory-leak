## Example app to reproduce multipart/form-data memory leak
Steps to reproduce:

1. Build the application `./gradlew build`
1. Build the docker image `docker build -t memory-leak-app .`
1. Run the application `docker-compose up -d`
1. Run the following 1-5 times ` for i in {1..300}; do curl --silent --location --request POST 'http://localhost:8080/image' --form 'file=@"src/main/resources/image.png"' -o /dev/null &; done`
1. Observe the logs `docker logs -f micronaut-multipart-memory-leak_app_1`
