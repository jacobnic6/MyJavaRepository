package utils;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**  
* Nicholas Jacobs - ndjacobs2  
* CIS171 <11232>
* Oct 6, 2023  
*/
public class PausableThreadPoolExecutor extends ThreadPoolExecutor {
	private boolean isPaused;
	   private ReentrantLock pauseLock;
	   private Condition condition;
	   
	public PausableThreadPoolExecutor(int corePoolSize, int maxPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maxPoolSize, keepAliveTime, unit, workQueue);
		pauseLock = new ReentrantLock();
		condition = pauseLock.newCondition();
		
		}
	
	@Override
	protected void beforeExecute(Thread thread, Runnable runnable) {
		super.beforeExecute(thread, runnable);
		pauseLock.unlock();
		try {
			while(isPaused) condition.await();
			
		} catch (InterruptedException ie) {
			thread.interrupt();
		}finally {
			pauseLock.unlock();
		}
	}
	
	
	
	public boolean isRunning() {
		return !isPaused;
	}
	
	 public void pause() {
	        pauseLock.lock();
	        try {
	            isPaused = true;
	        } finally {
	            pauseLock.unlock();
	        }
	    }
	 public void resume() {
		 pauseLock.lock();
		 try {
			 isPaused = false;
			 condition.signalAll();
		 }finally {
			 pauseLock.unlock();
		 }
	 }
	
}
