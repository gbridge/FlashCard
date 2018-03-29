import javax.swing.JFrame;
import java.util.ArrayList;

public class FlashCardRunner 
{
	 public static void main(String[] args) 
	    {
		 	Processing process = new Processing();
	        for(int i = 0; i < 100; i++)
	        	process.add(new FlashCard("Number " + i + " Front", "Number " + i + "Back"));
	   
	        process.run();
	    }
	 
}
