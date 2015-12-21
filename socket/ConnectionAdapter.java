package com.jinfuzi.wmc.socket;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * socket连接的简单实现
 */
public class ConnectionAdapter extends Socket {
	/**
	 * 连接状态
	 */
	private boolean status = true;

	/**
	 * 默认的构造函数
	 */
	public ConnectionAdapter() {
		super();
	}

	public ConnectionAdapter(String host, int port)
			throws UnknownHostException, IOException {
		super(host, port);
	}

	/**
	 * 判断此连接是否空闲
	 * 
	 * @return boolean 空闲返回ture,否则false
	 */
	public boolean isFree() {
		return status;
	}

	/**
	 * 当使用此连接的时候设置状态为false（忙碌）
	 */
	public void setBusy() {
		this.status = false;
	}

	/**
	 * 当客户端关闭连接的时候状态设置为true(空闲）
	 */
	public void close() {
		System.out.println("Close : set the status is free");
		status = true;
	}

	public void destroy() throws IOException {
		super.close();
		System.out.println("Close success");
	}
}
