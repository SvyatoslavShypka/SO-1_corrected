public class SProcess extends Process implements Comparable<SProcess> {
	int delay;
	public SProcess() {
		delay = 0;
	}

	public SProcess(int id, int procTime) {
		super(id, procTime);
		delay = 0;
	}
	public SProcess(int id, int procTime, int delay)
	{
		super(id, procTime);
		this.delay = delay;
	}

	@Override
	public int compareTo(SProcess arg0) {
		return this.delay-arg0.delay;
	}

}
