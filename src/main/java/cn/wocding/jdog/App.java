package cn.wocding.jdog;

import org.apache.log4j.Logger;

import cn.wocding.jdog.server.Server;
import cn.wocding.jdog.server.SocketConnector;

/**
 * start server :to be done
 * {@link cn.wocding.jdog.server.Server}}
 *
 */
public class App 
{
	private  static Logger logger=Logger.getLogger(App.class);
	
    public static void main( String[] args )
    {
        try {
        	Server server=new Server();
        	server.setConnector(new SocketConnector());
			server.start();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("server start failed, error" +e.getMessage());
		}
    }
}
