public class Process {
	
	private int id;
	private int procTime; //id i procTime - mog� przyda� si� p�niej przy statystykach
	private int remaining;
	
	public Process()
	{
		id=-1;
		procTime=0;
		remaining=0;
	}
	
	public Process(int id, int procTime)
	{
		this.id = id;
		this.procTime = procTime;
		this.remaining = procTime;
	}
	
	public void doOnce()
	{
		remaining --; // wywo�ywane je�li zosta� przydzielony procesor
	}
	
	public boolean isDone()
	{
		return (remaining<1) ? true : false;
	}
}
