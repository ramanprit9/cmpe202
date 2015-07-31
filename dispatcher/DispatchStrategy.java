package dispatcher;
import request.Request;

public interface DispatchStrategy {

	public void findTransportation(Request r);
}
