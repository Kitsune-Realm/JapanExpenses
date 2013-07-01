package view;

import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;

import control.SuperControl;

public class TicketDisplayPanel extends JTextArea
{
	private static final long	serialVersionUID	= -6655224578249805801L;

	public TicketDisplayPanel()
	{
		setCaretPosition(0);
		setEditable(false);
	}
	
	public void appendTop(String message)
	{
		try {
            getDocument().insertString(0, message + "\n", null);
        } catch (BadLocationException e1) {
            e1.printStackTrace();
        }
	}
	
	
}
