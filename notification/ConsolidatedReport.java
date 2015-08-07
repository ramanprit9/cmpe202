package notification;
//import main.ServiceManager;

import java.util.Vector;

public abstract class ConsolidatedReport extends Report {
	
	protected Vector<Report> directReports = new Vector<Report>();
	
	public void printRevenue(){
		super.printRevenue();
		if (directReports.size() > 0) {
			for(int i = 0; i < directReports.size(); ++i) {
				((Report)directReports.elementAt(i)).printRevenue();
			}
		}
	}

	public void add(Report anReport) {
		this.directReports.addElement(anReport);
	}
}
