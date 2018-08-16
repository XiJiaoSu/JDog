package cn.wocding.jdog.server;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

/**
 *线程池，提供多线程服务
 *
 * @author wills 
 *
 */
public class ThreadPool {
	
	private static final Logger loger=Logger.getLogger(ThreadPool.class);
	
	private int maxPoolSize=10;
	private int minPoolSize=2;
	
	private int keepAliveTime=5;
	
	private ThreadPoolExecutor executor;
	
	
	public ThreadPool() {
		init();
	}

	public ThreadPool(int maxPoolSize, int minPoolSize) {
		super();
		this.maxPoolSize = maxPoolSize;
		this.minPoolSize = minPoolSize;
		init();
	}


	private void init() {
		BlockingQueue<Runnable> workQueue=new LinkedBlockingDeque<Runnable>();
		executor=new ThreadPoolExecutor(minPoolSize, maxPoolSize, keepAliveTime, TimeUnit.SECONDS, workQueue,new RejectedExecutionHandler() {
			
			public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
				
			}
		});
	}
	
	public void dispatch(Runnable runnable) {
		executor.execute(runnable);
	}

	public void destory(){
		executor.shutdown();
	}
	
	public void setMinPoolSize(int minPoolSize) {
		this.minPoolSize = minPoolSize;
	}

	public void setMaxPoolSize(int maxPoolSize) {
		this.maxPoolSize = maxPoolSize;
	}

	public void setKeepAliveTime(int keepAliveTime) {
		this.keepAliveTime = keepAliveTime;
	}
	
}
