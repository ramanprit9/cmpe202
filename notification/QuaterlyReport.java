package notification;

//import main.ServiceManager;



public class QuaterlyReport extends ConsolidatedReport{
	public QuaterlyReport(String aValue){
		this();
		value= aValue;
	}
	
public QuaterlyReport(){
		super();
		title = "Quarterly Report";
	}
	
public void	printRevenue(){
	super.printRevenue();
   }

}
