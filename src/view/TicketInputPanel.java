package view;

import java.awt.GridLayout;
import java.util.Calendar;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.RangeModel;

public class TicketInputPanel extends JPanel
{
	private static final long	serialVersionUID	= -5976627309974771994L;
	private JPanel dateField;
	private JComboBox<Integer> jcbYear;
	private JComboBox<Integer> jcbMonth;
	private JComboBox<Integer> jcbDay;
	private JTextField priceField;
	private JTextField descField;
	private JComboBox<String> methodField;
	
	public TicketInputPanel()
	{
		dateField = createDateField();
		priceField = new JTextField();
		descField = new JTextField();
		String[] methods = {"Credit card", "Cash"};
		methodField = new JComboBox<String>(methods);
		
		setLayout(new GridLayout(4, 2));
		add(new JLabel("Date: "));
		add(dateField);
		add(new JLabel("Price: "));
		add(priceField);
		add(new JLabel("Description: "));
		add(descField);
		add(new JLabel("Method: "));
		add(methodField);
	}

	public void reset()
	{
		priceField.setText(null);
		descField.setText(null);
	}
	
	public JPanel createDateField()
	{
		JPanel p = new JPanel();
		
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		int currentMonth = Calendar.getInstance().get(Calendar.MONTH);
		int currentDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
				
		Integer[] years = {currentYear, currentYear-1, currentYear-2, currentYear-3, currentYear-4};
		Integer[] months = new RangeModel(1,12).getRange();
		Integer[] days = new RangeModel(1,31).getRange();
		
		jcbYear = new JComboBox<Integer>(years);
		jcbMonth = new JComboBox<Integer>(months);
		jcbDay = new JComboBox<Integer>(days);
		
		p.add(jcbYear);
		p.add(jcbMonth);
		p.add(jcbDay);
		
		return p;
	}
	
	public JPanel getDateField()
	{
		return dateField;
	}

	public JTextField getPriceField()
	{
		return priceField;
	}

	public JTextField getDescField()
	{
		return descField;	
	}

	public JComboBox<String> getMethodField()
	{
		return methodField;
	}

	public void setMethodField(JComboBox<String> methodField)
	{
		this.methodField = methodField;
	}

	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}

	public JComboBox<Integer> getJcbYear()
	{
		return jcbYear;
	}

	public JComboBox<Integer> getJcbMonth()
	{
		return jcbMonth;
	}

	public JComboBox<Integer> getJcbDay()
	{
		return jcbDay;
	}
	
}
