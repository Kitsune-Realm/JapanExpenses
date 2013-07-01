package control;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import model.Ticket;
import view.TicketDisplayPanel;

public class FunctionControl
{
	private List<Ticket> tickets;
	private TicketDisplayPanel ticketDisplay;
	private SuperControl superC;
	
	public FunctionControl(SuperControl superC)
	{
		this.superC = superC;
		tickets = new ArrayList<Ticket>();
		ticketDisplay = new TicketDisplayPanel();
	}
	
	public void addNewTicket(Ticket ticket)
	{
		tickets.add(ticket);
	}
	
	public void displayAllTickets()
	{
		if (tickets.size() != 0) {			
			for (Ticket ticket : tickets) {
				ticketDisplay.appendTop(ticket.toString());		
			}
			ticketDisplay.appendTop("Displaying tickets");
		}
		else {
			ticketDisplay.appendTop("There are no tickets to display");
		}
	}
	
	public void clearScreen()
	{
		ticketDisplay.setText(null);
	}
	
	public void openTickets() throws FileNotFoundException, IOException, ClassNotFoundException
	{
		ObjectInputStream input = new ObjectInputStream(new FileInputStream("tickets.jec"));
		tickets = (List<Ticket>)input.readObject();
		
		input.close();
	}
	
	public void saveTickets() throws FileNotFoundException, IOException
	{
		ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("tickets.jec"));		
		output.writeObject(tickets);
		
		output.close();
	}

	public List<Ticket> getTickets()
	{
		return tickets;
	}

	public TicketDisplayPanel getTicketDisplayPanel()
	{
		return ticketDisplay;
	}
	
}
