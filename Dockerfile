FROM maven:3.9.3-eclipse-temurin-20-alpine

WORKDIR /home/build
COPY . .

CMD [ ".build/entrypoint.sh" ]

ENTRYPOINT ["sh"]
