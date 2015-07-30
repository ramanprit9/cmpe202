package request;

public interface State {
	
	public String receiveRequest();
	public String evaluateRequest();
	public String fulfillRequest();
	
}
