FROM gradle:6.6-jdk11 as builder
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build -x test -i

FROM adoptopenjdk/openjdk11-openj9:alpine-slim
RUN mkdir /opt/app
COPY --from=builder /home/gradle/src/build/libs/wishlist-graphql-api-0.1-all.jar /opt/app/app.jar
EXPOSE 8080
ENTRYPOINT [ "java", "-Xshareclasses", "-Xquickstart", "--Xmx512M", "-Xms256M", "-jar", "/opt/app/app.jar" ]