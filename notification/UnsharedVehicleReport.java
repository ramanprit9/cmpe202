package notification;
import main.ServiceManager;

public class UnsharedVehicleReport extends Report{
	public UnsharedVehicleReport(String aValue){
	this();
		value= aValue;
	}
	
public UnsharedVehicleReport(){
		title = "Unshared Vehicle Report";
	}
	
public void	printRevenue(){
	super.printRevenue();
   }
}

