FROM openjdk:17
ADD target/fortuneservice-aws.jar fortuneservice-aws.jar
EXPOSE 8000
ENTRYPOINT [ "java","-jar","fortuneservice-aws.jar" ]