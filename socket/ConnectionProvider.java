package com.jinfuzi.wmc.socket;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 定义的抽象类，所有的子类必须单子模式去实现， 统一方法为public ConnectionProvider newInstance();
 * 连接提供器的抽象接口，每一个实现它的子类最好都是JAVABEAN， 这样它的方法就可以是被外界控制
 */
public interface ConnectionProvider {
	public static final String SERVER_IP = "SERVER_IP_ADDRESS";
	public static final String SERVER_PORT = "SERVER_IP_PORT";
	public static final String MAX_SIZE = "MAX_SIZE";
	public static final String MIN_SIZE = "MIN_SIZE";

	/**
	 * 判断连接池内是否有连接
	 * 
	 * @return true 有连接返回true,否则返回false
	 */
	public boolean isPooled();

	/**
	 * 当此方法被调用的时候提供一个 socket
	 * 
	 * @see Socket
	 * @return Socket a Connection object.
	 */
	public Socket getConnection() throws java.net.SocketException;

	/**
	 * 连接池初始化
	 */
	public void init() throws UnknownHostException, IOException;

	/**
	 * 连接池重新启动
	 */
	public void restart() throws UnknownHostException, IOException;

	/**
	 * 注销连接池
	 */
	public void destroy();
}
