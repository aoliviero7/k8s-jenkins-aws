FROM node:14.20-alpine as build-env
LABEL desc="docker image of angular 9 app"
WORKDIR /app
COPY ["package.json","package-lock.json","/app/"]
RUN npm install
RUN npm install -g @angular/cli

COPY . /app
#ENTRYPOINT ["ng","--version"]

CMD ng serve --host 0.0.0.0 --port 8080