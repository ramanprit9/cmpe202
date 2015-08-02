package dispatcher;
import request.Request;
//This is the interface for STRATEGY pattern
public interface DispatchStrategy {

	public void findTransportation(Request r);
}
