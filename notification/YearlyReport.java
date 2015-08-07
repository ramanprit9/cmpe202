package notification;
//import main.ServiceManager;

public class YearlyReport extends ConsolidatedReport{
	private static YearlyReport yearlyReport = new YearlyReport();
	private YearlyReport(String aValue){
		this();
		value = aValue;
	}
	
private YearlyReport(){
		super();
		title = "Yearly Report";
	}
	
public void	printRevenue(){
	super.printRevenue();
   }

public static YearlyReport getYearlyReport(String aValue){
	yearlyReport.value= aValue;
	return YearlyReport.yearlyReport;
}
}
