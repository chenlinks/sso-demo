#!/bin/bash
cd `dirname $0`

img_mvn="maven:3.3.3-jdk-8"                 # docker image of maven
m2_cache=~/.m2                              # the local maven cache dir
proj_home=$PWD                              # the project root dir
img_output="epxing/application-demo"      # output image tag
project="epxing-demo"
env="DEV"
eureka="http://localhost:8761"

git pull  # should use git clone https://name:pwd@xxx.git

echo "use docker maven"
docker run --rm \
   -v $m2_cache:/root/.m2 \
   -v $proj_home:/usr/src/mymaven \
   --net=host \
   -w /usr/src/mymaven $img_mvn mvn clean package -U -Dmaven.test.skip=true

sudo mv $proj_home/target/$project-*.jar $proj_home/target/application.jar # 兼容所有sh脚本
docker build -t $img_output .

mkdir -p $PWD/logs
chmod 777 $PWD/logs

# 删除容器
docker rm -f $project &> /dev/null

version=`date "+%Y%m%d%H"`

# 启动镜像
docker run -d --restart=on-failure:5 --privileged=true \
    --net=host \
    -w /home \
    -v $PWD/logs:/home/logs \
    --name $project $img_output \
    java -Denv=$env \
    -Djava.security.egd=file:/dev/./urandom \
    -Duser.timezone=Asia/Shanghai \
    -XX:+PrintGCDateStamps \
    -XX:+PrintGCTimeStamps \
    -XX:+PrintGCDetails \
    -XX:+HeapDumpOnOutOfMemoryError \
    -Dapollo.configService=$eureka \
    -jar /home/application.jar

