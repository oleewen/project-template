#!/bin/sh
if [ ! -n "$1" ]; then
   echo "usage: $0 APPNAME"
   echo "usage: $0 APPNAME GROUP PACKAGE"
   exit
fi

APP_NAME=$1

GROUP="com.company.department.business"

if [ -n "$2" ]; then
   GROUP=$2
fi

PACKAGE=$GROUP.$APP_NAME

if [ -n "$3" ]; then
   PACKAGE=$3
fi

rm -rf $APP_NAME

cd parent
mvn clean install

cd ..

cd template

mvn clean install

cd ..

mvn archetype:generate -DgroupId=$GROUP -DartifactId=$APP_NAME -Dpackage=$PACKAGE -Dversion=1.0.0-SNAPSHOT -DarchetypeArtifactId=template -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeVersion=1.0.0-SNAPSHOT
