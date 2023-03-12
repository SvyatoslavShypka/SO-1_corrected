public class Process {
	
	private int id;
	private int procTime; //id i procTime - mogą przydać się póniej przy statystykach
	public int waitTime;
	private int remaining;
	
	public Process()
	{
		id=-1;
		procTime=0;
		remaining=0;
		waitTime = 0;
	}
	
	public Process(int id, int procTime)
	{
		this.id = id;
		this.procTime = procTime;
		this.remaining = procTime;
		waitTime = 0;
	}
	
	public void doOnce()
	{
		remaining --; // wywoływane jeśli został przydzielony procesor
	}
	
	public boolean isDone()
	{
		return (remaining<1) ? true : false;
	}
	public int getprocTime(){
		return procTime;
	}
	public int getremaining(){
		return remaining;
	}
	public String toString()
	{
		return id + " " + remaining + " " + procTime + " " + waitTime;
	}
}
