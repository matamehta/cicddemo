FROM openjdk:8-jre-alpine
MAINTAINER Judewin Gabriel <judewin.gabriel@karsun-llc.com>

ENV APP_HOME=/opt/application

# Http port
EXPOSE 8080

ENV RUN_USER            tenant
ENV RUN_GROUP           tenant

RUN  addgroup -g 1014 -S tenant \
    && adduser  -u 1014 -D -S -G tenant tenant \
    && mkdir -p ${APP_HOME}/logs \
    && mkdir -p ${APP_HOME}/app 

VOLUME ["$APP_HOME/logs", "$APP_HOME/app", /tmp]

WORKDIR $APP_HOME
COPY run.sh $APP_HOME/
COPY target/demoapplication-1.0.jar $APP_HOME/
RUN chmod -R 700            "${APP_HOME}" 
RUN chown -R tenant:tenant  "${APP_HOME}" 
USER ${RUN_USER}:${RUN_GROUP}
ENTRYPOINT ["./run.sh"]
