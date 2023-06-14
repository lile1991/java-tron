#!/bin/bash
#java options
PROC_NAME=tron

#Xms inin memery
#Xmx max memery
#Xmn young memery
# 启动方法
start() {
	# 重新获取一下pid，因为其它操作如stop会导致pid的状态更新
	pid=`ps -ef | grep $PROC_NAME | grep -v grep | awk '{print $2}'`
	# -z 表示如果$pid为空时执行
	if [ -z $pid ]; then
	  nohup java -cp -Xms8G -Xmx24G -XX:ReservedCodeCacheSize=256m -XX:MetaspaceSize=256m -XX:MaxMetaspaceSize=512m -XX:MaxDirectMemorySize=1G -XX:+PrintGCDetails -XX:+PrintGCDateStamps  -Xloggc:gc.log -XX:+UseConcMarkSweepGC -XX:NewRatio=2 -XX:+CMSScavengeBeforeRemark -XX:+ParallelRefProcEnabled -XX:+HeapDumpOnOutOfMemoryError -XX:+UseCMSInitiatingOccupancyOnly  -XX:CMSInitiatingOccupancyFraction=70 -jar libs/FullNode.jar -c main_net_config.conf -d /disk2/tron/output-directory > nohup.out 2>&1 &
#		nohup java -jar $PROC_NAME $JAVA_OPTS /dev/null 2>&1 &
		pid=`ps -ef | grep $PROC_NAME | grep -v grep | awk '{print $2}'`
		echo ""
		echo "Service ${PROC_NAME} is starting！pid=${pid}"
		echo "........................Here is the log.............................."
		echo "....................................................................."
		# tail -f $LOG_PATh
		echo "........................Start successfully！........................."
	else
		echo ""
		echo "Service ${PROC_NAME} is already running,it's pid = ${pid}. If necessary, please use command: sh auto_deploy.sh restart."
		echo ""
  fi
}

# 停止方法
stop() {
  # 重新获取一下pid，因为其它操作如start会导致pid的状态更新
  pid=`ps -ef | grep $PROC_NAME | grep -v grep | awk '{print $2}'`
  # -z 表示如果$pid为空时执行。 注意：每个命令和变量之间一定要前后加空格，否则会提示command找不到
  if [ -z $pid ]; then
	  echo ""
	  echo "Service ${PROC_NAME} is not running! It's not necessary to stop it!"
	  echo ""
  else
    kill -15 $pid
    echo ""
    echo "Service stop successfully！pid:${pid} which has been killed forcibly!"
    echo ""
	fi
}

# 输出运行状态方法
status() {
	# 重新获取一下pid，因为其它操作如stop、restart、start等会导致pid的状态更新
	pid=`ps -ef | grep $PROC_NAME | grep -v grep | awk '{print $2}'`
	# -z 表示如果$pid为空时执行。注意：每个命令和变量之间一定要前后加空格，否则会提示command找不到
	if [ -z $pid ];then
		echo ""
		echo "Service ${PROC_NAME} is not running!"
		echo ""
  else
		echo ""
		echo "Service ${PROC_NAME} is running. It's pid=${pid}"
		echo ""
	fi
}

# 重启方法
restart() {
	echo ""
	echo ".............................Restarting.............................."
	echo "....................................................................."
	stop
	start
}

info() {
	echo "System Information:"
	echo "****************************"
	echo `head -n 1 /etc/issue`
	echo `uname -a`
	echo "****************************"
	echo "JAVA_HOME=$JAVA_HOME"
	echo `$JAVA_HOME/bin/java -version`
	echo "****************************"
}

if [ ! -n "$1" ] ;then
	echo "Usage: $0 {start|stop|restart|status|info}"
elif [ $1 = "start" ];then
	start
elif [ $1 = "stop" ];then
	stop
elif [ $1 = "restart" ];then
	restart
elif [ $1 = "status" ];then
	status
elif [ $1 = "info" ];then
	info
fi