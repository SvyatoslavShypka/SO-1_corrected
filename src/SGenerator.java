import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class SGenerator extends Generator {
	Queue<SProcess> list;
	
	public SGenerator() {
	}
	
	public SGenerator(String filename) throws FileNotFoundException
	{
		active = true;
		Scanner f = new Scanner(new File(filename));
		list = new LinkedList<SProcess>();
		int id, procTime, delay;
		while(f.hasNext())
		{
			id = f.nextInt();
			procTime = f.nextInt();
			delay = f.nextInt();
			list.add(new SProcess(id,procTime,delay));
		}
		f.close();
		timeNext = list.peek().delay;
	}
	
	public Process getNext()
	{
		if(list.isEmpty())
		{
			switchOff();
			return null;
		}
		Process a = list.poll();
		if(list.isEmpty())
		{
			switchOff();
			timeNext = 0;
		}
		else timeNext = list.peek().delay;
		return a;
	}
}
