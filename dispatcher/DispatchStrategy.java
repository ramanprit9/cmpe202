package dispatcher;
import request.Request;
//This is the interface for STRATEGY pattern
public interface DispatchStrategy {

	public boolean findTransportation(Request r);
}
