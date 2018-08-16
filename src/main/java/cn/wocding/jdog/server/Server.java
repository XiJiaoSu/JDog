package cn.wocding.jdog.server;

import org.apache.log4j.Logger;

/**
 * 启动server {@link cn.wocding.jdog.server.SocketConnector}}
 * 
 * @author wills
 *
 */
public class Server {

	private static final Logger logger = Logger.getLogger(Server.class);

	private SocketConnector connector;

	private int port = 9090;// default server port

	private int minPoolSize = 5;
	private int maxPoolSize = 50;

	public void start() throws Exception {
		logger.info("server is starting");
		connector.setThreadPool(new ThreadPool(maxPoolSize, minPoolSize));
		connector.open(port);
		connector.accept();
	}

	public SocketConnector getConnector() {
		return connector;
	}

	public void setConnector(SocketConnector connector) {
		this.connector = connector;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getMinPoolSize() {
		return minPoolSize;
	}

	public void setMinPoolSize(int minPoolSize) {
		this.minPoolSize = minPoolSize;
	}

	public int getMaxPoolSize() {
		return maxPoolSize;
	}

	public void setMaxPoolSize(int maxPoolSize) {
		this.maxPoolSize = maxPoolSize;
	}

}
