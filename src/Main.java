import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 * @throws FileNotFoundException
	 * @throws InterruptedException
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws FileNotFoundException, InterruptedException {
		CPU cpu = new CPU(new Scheduler(new Generator()));
		cpu.s.SetAlgorithm(new FCFS(cpu.s.processList));
		cpu.active = true;
		Scanner f = new Scanner(System.in);
		menu();
		String a = f.next();
		while(a.charAt(0) != 'q')
		{
			if(a.equals("start")) // Uruchamia cpu
			{
				cpu.start();
			}
			else if(a.equals("stop")) // Zatrzymuje cpu
			{
				cpu.t.suspend();
				int srednia = 0;
				for(Process p : cpu.s.statpList)
				{
					srednia+=p.waitTime;
				}
				if(!cpu.s.statpList.isEmpty())srednia/=cpu.s.statpList.size();
				System.out.println("Średni czas: " + srednia);
				System.out.println("Ilość procesów: " + cpu.s.statpList.size());
				System.out.println("Wykonanych cykli: " + cpu.s.worktime);
			}
			else if(a.equals("startstoptime")) // Uruchamia cpu na określny czas w milisekundach
			{
				int t = f.nextInt();
				cpu.start();
				Thread.sleep(t);
				cpu.t.suspend();
				int srednia = 0;
				for(Process p : cpu.s.statpList)
				{
					srednia+=p.waitTime;
				}
				if(!cpu.s.statpList.isEmpty())srednia/=cpu.s.statpList.size();
				System.out.println("Średni czas: " + srednia);
				System.out.println("Ilość procesów: " + cpu.s.statpList.size());
				System.out.println("Wykonanych cykli: " + cpu.s.worktime);
			}
			else if(a.equals("switch")) // Zmienia algorytm przydzialający zasoby
			{
				System.out.println("Choose: FCFS, ROT, SJF, SJFw");
				a = f.next();
				if(a.compareTo("FCFS") == 0) cpu.s.SetAlgorithm(new FCFS(cpu.s.processList));
				else if(a.compareTo("ROT") == 0) cpu.s.SetAlgorithm(new Rot(cpu.s.processList));
				else if(a.compareTo("SJF") == 0) cpu.s.SetAlgorithm(new SJF(cpu.s.processList));
				else if(a.compareTo("SJFw") == 0) cpu.s.SetAlgorithm(new SJFw(cpu.s.processList));
				cpu.s.clearList();
			}
			else if(a.equals("load")) // Wczytuje generator z gotowym zestawem procesów
			{
				cpu.s  = new Scheduler(new SGenerator(a));
				cpu.s.SetAlgorithm(new FCFS(cpu.s.processList));
			}
			else if(a.equals("loadgen")) // Wczytuje generator losowych procesów
			{
				cpu.s = new Scheduler(new Generator());
				cpu.s.SetAlgorithm(new FCFS(cpu.s.processList));
			}
			else if(a.equals("showlist")) // wyświetla listę procesów
			{
				System.out.println("Aktywne: ");
				for(Process p : cpu.s.processList)
				{
					System.out.println(p);
				}
				System.out.println("Ukończone: ");
				for(Process p : cpu.s.statpList)
				{
					System.out.println(p);
				}
			}
			else if(a.equals("genconfig")) //Zmienia ustawienia generatora procesów
			{
				Generator.maxProcTime = f.nextInt();
				Generator.maxTimeNext = f.nextInt();
			}
			else if(a.equals("rotconfig")) // Zmienia ustawienia algorymu rotacyjnego
			{
				Rot.deltaTime = f.nextInt();
			}
			menu();
			a = f.next();
		}

		f.close();
		System.out.println("finish of main process");
	}
	public static void menu() {
		System.out.println("choose your options");
		System.out.println("q, start, stop, switch, load, loadgen, showlist, genconfig, rotconfig");
	}
}
