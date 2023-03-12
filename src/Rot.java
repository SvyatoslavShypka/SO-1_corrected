import java.util.ArrayList;

public class Rot extends Algorithm {
	public static int deltaTime = 1;
	int index;
	int remainingDelta;
	public Rot(ArrayList<Process> list) {
		super(list);
		index = 0;
		remainingDelta = deltaTime;
	}

	@Override
	public Process activeProcess() {
		if(index >= list.size()) index = 0;
		if(list.get(index).getremaining() == 1 || remainingDelta == 0)
		{
			remainingDelta = deltaTime;
			index++;
		}
		if(index >= list.size()) index = 0;
		remainingDelta--;
		return list.get(index);
		
	}

	@Override
	public void updateList(ArrayList<Process> list) {

	}


}
