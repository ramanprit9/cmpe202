package notification;
//import main.ServiceManager;

public class SharedVehicleReport extends Report{
	public SharedVehicleReport(String aValue){
		this();
		value= aValue;
	}
	
public SharedVehicleReport(){
		title = "Shared Vehicle Report";
	}
	
public void	printRevenue(){
	super.printRevenue();
   }

}
