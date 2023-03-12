import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class FCFS extends Algorithm {
	
	Queue<Process> listq;
	
	public FCFS(ArrayList<Process> list) {
		super(list);
		listq= new LinkedList<Process>(list);
	}

	@Override
	public Process activeProcess() {
		return listq.peek();
	}

	@Override
	public void updateList(ArrayList<Process> list) {
		listq= new LinkedList<Process>(list);
		
	}

}
