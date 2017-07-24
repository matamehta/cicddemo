#!/bin/bash
DIR="/opt/application"

if [ -d "$DIR" ]
then
	echo "$DIR directory  exists!"
else
	echo "$DIR directory not found!"
fi
echo before set e

set -e
cd /opt/application
echo moving to opt directory 
if [ "${1:0:1}" != '-' ]; then
  exec "$@"
fi
echo after exec directory 
exec java -jar *.jar \
  --server.port=8080 
"$@"
