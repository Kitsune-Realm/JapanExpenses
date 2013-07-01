package control;

import java.io.FileNotFoundException;
import java.io.IOException;

import view.ApplicationFrame;

public class Main
{
	public static void main(String[] args)
	{
		SuperControl superC = new SuperControl();
		
		try {
			superC.getFunctionControl().openTickets();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		
		new ApplicationFrame(superC);
	}
}
