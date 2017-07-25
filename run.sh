#!/bin/sh
set -e
cd /opt/application
if [ "${1:0:1}" != '-' ]; then
  exec "$@"
fi
exec java -jar *.jar \
  --server.port=8080 
"$@"
