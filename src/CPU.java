public class CPU implements Runnable {
	public boolean active = false;
	Scheduler s;
	public Thread t;
	
	public CPU(Scheduler s)
	{
		this.s = s;
		Generator.switchOn();
	}
	
	public void doCycle() throws InterruptedException{
		if(Generator.isActive()) Generator.updateTime();
		s.assignProcess();
		Thread.sleep(10);
	}

	@Override
	public void run() {
		while(active)
		{
			try {
				doCycle();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public void start()
	{
		t = new Thread(this, "CPUSym");
		t.start();
	}
}
