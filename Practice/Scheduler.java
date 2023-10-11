package utils;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**  
* Nicholas Jacobs - ndjacobs2  
* CIS171 <11232>
* Oct 6, 2023  
*/
public class Scheduler {
	private PausableThreadPoolExecutor executor;
	private LinkedBlockingQueue<Runnable> queue;
	
	public Scheduler() {
		int processors = 4;//Runtime.getRuntime().availableProcessors();
		queue = new LinkedBlockingQueue<Runnable>();
		executor = new PausableThreadPoolExecutor(processors, 10, 10, TimeUnit.SECONDS, queue);
		
	}
	
	public void schedule(Runnable runnable) {
		executor.execute(runnable);
	}
	
	  public void pause() {
	        executor.pause();
	    }

	    public void resume() {
	        executor.resume();
	    }

	    public void clear() {
	        queue.clear();
	    }

	    public boolean isEmpty() {
	        return queue.isEmpty();
	    }
	
}








//old game thread below

//@Override
//public void run() {
//	//render
//	//update
//	//checking FPS and UPS
//	double timePerFrame = 1000000000.0 / FPS_SET;
//	double timePerUpdate = 1000000000.0 / UPS_SET;
//	
//	long previousTime = System.nanoTime();
//	
//	int frames = 0;
//	int updates = 0;
//	long lastCheck = System.currentTimeMillis();
//	
//	double deltaU = 0;
//	double deltaF = 0;
//	
//	while (true) 
//	{
//		long currentTime = System.nanoTime();
//		
//		deltaU += (currentTime - previousTime)/timePerUpdate;
//		deltaF += (currentTime - previousTime)/timePerFrame;
//		previousTime = currentTime;
//		
//		//UPS
//		while(deltaU > 1) 
//		{
//			
//			updateGame();
//			gamePanel.updateGamePanel();
//			//gamePanel.updateGamePanel();
//			//getPlaying().gameLoop();
//			updates++;
//			deltaU--;
//		}
//		//FPS
//		if (deltaF > 1) 
//		{
//			repaint();
//			frames++;
//			deltaF--;
//		}
//		if(System.currentTimeMillis() - lastCheck >= 1000) 
//		{
//			lastCheck = System.currentTimeMillis();
//			System.out.println("FPS: " + frames + " | UPS: " + updates);
//			frames = 0;
//			updates = 0;
//			
//		}
//		
//		
//	}
//
//
//}
