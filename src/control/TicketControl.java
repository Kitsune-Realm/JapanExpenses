package control;

import javax.swing.JOptionPane;

import model.Ticket;
import view.TicketInputPanel;

public class TicketControl
{
	private SuperControl superC;
	private TicketInputPanel inputPanel;
	
	public TicketControl(SuperControl superC)
	{
		this.superC = superC;
		inputPanel = new TicketInputPanel();
	}
	
	public void addNewTicket()
	{
		inputPanel.reset();
		int result = JOptionPane.showConfirmDialog(null, inputPanel, "Add new Ticket", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
	      if (result == JOptionPane.OK_OPTION) {
	    	 (superC.getFunctionControl().getTickets()).add(new Ticket(
	    			 (Integer)inputPanel.getJcbYear().getSelectedItem(),
	    			 (Integer)inputPanel.getJcbMonth().getSelectedItem(),
	    			 (Integer)inputPanel.getJcbDay().getSelectedItem(),
	    			 Double.parseDouble(inputPanel.getPriceField().getText()),
	    			 inputPanel.getDescField().getText(),
	    			 (String)inputPanel.getMethodField().getSelectedItem()
	    			 ));
	    	  
	    	 System.out.println("Date: " + inputPanel.getJcbYear().getSelectedItem() + "/" + inputPanel.getJcbMonth().getSelectedItem() + "/" + inputPanel.getJcbDay().getSelectedItem());
	         System.out.println("Price: " + (inputPanel.getPriceField()).getText());
	         System.out.println("Method: " + (inputPanel.getMethodField()).getSelectedItem());
	      }
	}
	
	public void showAllTickets()
	{
		superC.getFunctionControl().displayAllTickets();
	}
	
	public void totalAllTickets()
	{
		JOptionPane.showMessageDialog(null, "Total");
	}
}
