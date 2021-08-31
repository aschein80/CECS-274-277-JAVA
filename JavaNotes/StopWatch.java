package demos;

public class StopWatch {
	
	private long startTime;
	private long endTime;
	private boolean isRunning;
	
	public StopWatch(){
		startTime = 0L;
		endTime = 0L;
		isRunning = false;
	}
	
	/**
	 * starts the stopwatch
	 * */
	public void start(){
		if(!isRunning){
			startTime = System.currentTimeMillis();
			isRunning = true;
		}
		else{
			System.out.println("Stopwatch is currently running...");
		}
		
	}
	
	
	/**
	 * stops the stopwatch
	 * */
	public void stop(){
		if(isRunning){
			endTime = System.currentTimeMillis();
			isRunning = false;
		}
		else{
			System.out.println("Stopwatch is NOT currently running...");
		}
		
	}
	
	
	/**
	 * returns the number of seconds elapsed
	 * @return the elapsed seconds as a double
	 * */
	public long getMilliSecondsElapsed(){
		long elapsed =  endTime - startTime;
		return elapsed;
	}
	
	/**
	 * resets the stop watch
	 * */
	public void reset(){
		startTime = 0L;
		endTime = 0L;
		isRunning = false;	
	}


}



