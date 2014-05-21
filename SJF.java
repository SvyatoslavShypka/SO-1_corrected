import java.util.ArrayList;


public class SJF extends Algorithm{
	
	public SJF(ArrayList<Process> list){
		super(list);
	}
	public Process activeProcess() throws InterruptedException{
		//Thread.sleep(500);
		int shortest =0;
		for(int i=1; i<list.size(); i++){
			if(list.get(i).getremaining()<list.get(shortest).getremaining()){
				shortest=i;
			}
		}
		return list.get(shortest);
	}
	public void updateList(ArrayList<Process> list) {
		this.list = list;
	}
}