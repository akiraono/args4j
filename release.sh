#!/bin/sh -xe
cd args4j
maven clean:clean javanet:dist javanet:site javanet:deploy-jar jar:install
cd ../args4j-tools
maven clean:clean javanet:dist javanet:deploy-jar jar:install
cd ..
maven javanet:site
