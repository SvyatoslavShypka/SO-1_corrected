import java.util.ArrayList;

public class Scheduler {
	private Algorithm activeAlgorithm;
	public ArrayList<Process> processList;
	public ArrayList<Process> statpList;
	private Generator gen;
	int worktime = 0;
	
	public Scheduler(Generator g)
	{
		activeAlgorithm = null;
		processList = new ArrayList<Process>();
		statpList = new ArrayList<Process>();
		gen = g;
	}
	
	public void assignProcess() throws InterruptedException
	{
		worktime++;
		checkGenerator();
		for(int i = 0; i < processList.size(); i++)
		{
			if(processList.get(i).isDone())
			{
				statpList.add(processList.get(i));
				processList.remove(i);
				i--;
			}
			else
			{
				processList.get(i).waitTime++;
			}
		}
		activeAlgorithm.updateList(processList);
		if(!processList.isEmpty())
		{
			Process p = activeAlgorithm.activeProcess();
			p.doOnce();
			p.waitTime--;
		}
	}
	
	public void checkGenerator()
	{
		while(Generator.isActive() && gen.isReady())
		{
			processList.add(gen.getNext());
		}
	}
	
	public void SetAlgorithm(Algorithm algorithm)
	{
		this.activeAlgorithm = algorithm;
		worktime = 0;
		statpList.clear();
		gen.id = 0;
	}
	public void clearList()
	{
		statpList.clear();
		processList.clear();
	}
}
