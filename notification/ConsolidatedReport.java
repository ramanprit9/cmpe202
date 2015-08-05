package notification;

import java.util.Vector;

public abstract class ConsolidatedReport extends Report {
	
	protected Vector directReports = new Vector();
	
	public void printBilling() {
		super.printBilling();
		if (directReports.size() > 0) {
			for(int i = 0; i < directReports.size(); ++i) {
				((Report)directReports.elementAt(i)).printBilling();
			}
		}
	}

	public void add(Report report) {
		this.directReports.addElement(report);
	}
}
