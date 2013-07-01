package control;

public class SuperControl
{
	private FunctionControl functionC;
	private TicketControl ticketC;
	
	public SuperControl()
	{
		this.functionC = new FunctionControl(this);
		this.ticketC = new TicketControl(this);		
	}

	public FunctionControl getFunctionControl()
	{
		return functionC;
	}

	public TicketControl getTicketControl()
	{
		return ticketC;
	}	
}
