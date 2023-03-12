import java.util.ArrayList;


public class SJFw extends Algorithm{

	Process active = null;
	
	public SJFw(ArrayList<Process> list){
		super(list);
	}
	public Process activeProcess(){
		int shortest =0;
		if(active != null)
		{
			
			if(!active.isDone())return active;
			else active = null;
		}
		for(int i=1; i<list.size(); i++){
			if(list.get(i).getremaining()<list.get(shortest).getremaining()){
				shortest=i;
			}
		}
		active = list.get(shortest);
		return active;
	}
	public void updateList(ArrayList<Process> list) {
		this.list = list;

	}
}
