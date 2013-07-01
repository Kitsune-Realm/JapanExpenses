package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import control.SuperControl;
import control.TicketControl;

public class ApplicationFrame extends JFrame
{
	private static final long	serialVersionUID	= -8577148100328281639L;
	private SuperControl superC;
	private TicketControl ticketC;
	
	public ApplicationFrame(SuperControl superC)
	{
		this.superC = superC;
		this.ticketC = superC.getTicketControl();
		setTitle("Japan Expenses Calculator");
		createCloseListener();
		setSize(new Dimension(450, 320));		
		
		getContentPane().setLayout(new BorderLayout());
		JScrollPane scroll = new JScrollPane(superC.getFunctionControl().getTicketDisplayPanel());
		getContentPane().add(scroll, BorderLayout.CENTER);
		getContentPane().add(createButtonPanel(), BorderLayout.EAST);
		
		setLocationRelativeTo(null);		
		setVisible(true);
	}
	
	public JPanel createButtonPanel()
	{
		JPanel p = new JPanel();

		p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
		
		
		JButton btnAdd = new JButton("Add");
		JButton btnShow = new JButton("Show");
		JButton btnClear = new JButton("Clear");
		JButton btnTotal = new JButton("Total");
		
		btnAdd.setAlignmentX(RIGHT_ALIGNMENT);
		btnShow.setAlignmentX(RIGHT_ALIGNMENT);
		btnClear.setAlignmentX(RIGHT_ALIGNMENT);
		btnTotal.setAlignmentX(RIGHT_ALIGNMENT);
		
		btnAdd.setToolTipText("Add a new Ticket");
		btnShow.setToolTipText("Show all Tickets");
		btnClear.setToolTipText("Clears the screen");
		btnTotal.setToolTipText("Display total expenses");
		
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				ticketC.addNewTicket();
			}			
		});
		
		btnShow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				ticketC.showAllTickets();
			}			
		});
		
		btnClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				superC.getFunctionControl().clearScreen();
			}			
		});
		
		btnTotal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				ticketC.totalAllTickets();
			}			
		});
		
		p.add(btnAdd);
		p.add(btnShow);
		p.add(btnClear);
		p.add(btnTotal);
		return p;
	}
	
	public void createCloseListener()
	{
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
            public void windowClosing(WindowEvent we)
			{
				try {
					superC.getFunctionControl().saveTickets();
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.exit(0);
			}
		});
	}
}
