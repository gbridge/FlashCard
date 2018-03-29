import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.MouseListener;
//import java.awt.event.MouseEvent;


import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.JFrame;



public class Processing implements MouseListener
{
	private ArrayList<ArrayList<FlashCard>> deck;
	private FlashCard card;
	private boolean front;
	private int skill;
	private int ind;
	public final int[] MAX = {Integer.MAX_VALUE, 30, 40, 50, 60, Integer.MAX_VALUE};
	public final int LEVELS = 6;
	private int width;


	Panel panel = new Panel();
	public Processing(ArrayList<ArrayList<FlashCard>> deck)
	{
		Panel panel = new Panel();
        //System.out.println("here");
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setSize(600, 400);
        frame.setVisible(true);
        
		this.deck = deck;
		card = deck.get(0).get(0);
		front = true;
		skill = 0;
		ind = (int)(Math.random() * deck.get(skill).size());
		width = panel.getWidth();
	}
	public Processing()
	{
		Panel panel = new Panel();
        //System.out.println("here");
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setSize(600, 800);
        frame.setVisible(true);
        
		deck = new ArrayList<ArrayList<FlashCard>>();
		for(int i = 0; i < LEVELS; i++)
			deck.add(new ArrayList<FlashCard>());
		card = new FlashCard("null", "null");
		front = true;
		skill = 0;
		ind = (int)(Math.random() * deck.get(skill).size());
		width = panel.getWidth();
	}
	public void newCard(int x, int level)
	{
		if(x > width/2)
			incCard();
		else
			decCard();
		skill = level;
		ind = (int)(Math.random() * deck.get(skill).size());
		card = deck.get(level).get((int)(Math.random() * deck.get(level).size()));
		front = true;
	}
	public void newCard(int x)
	{
		newCard(x, level());
	}

	public int level()
	{
		for(int i = 0; i<LEVELS; i++)
			if(MAX[i] < deck.get(i).size())
				return i;
		for(int i = 0; i<LEVELS; i++)
			if(deck.get(i).size() > 5 && Math.random() < .6)
				return i;
		for(int i = 0; i < LEVELS; i++)
			if(deck.get(i).size() > 5)
				return i;
		return 0;
		//that last part should never happen if there's at least one FlashCard
	}
	public void rotate(int x)
	{
		if(front)
			front = false;
		else
			newCard(x);
	}
	private void incCard()
	{
		if(skill < 5)
		{
			deck.get(skill).remove(ind);
			deck.get(skill + 1).add(card);
		}
	}
	private void decCard()
	{
		if(skill > 0)
		{
			deck.get(skill).remove(ind);
			deck.get(skill - 1).add(card);
		}
	}
	public FlashCard getCard(int level, int index)
	{
		return deck.get(level).get(index);
	}
	public String getDisp()
	{
		if(front)
			return card.getFront();
		else
			return card.getBack();
	}
	public void add(FlashCard flash)
	{
		deck.get(0).add(flash);
	}
	public void run()
	{
		while(true)
		{
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) { 
				//System.out.println("Thread stopped");
				//e.printStackTrace();
				return;
			}
			panel.changeLabel(getDisp());
			panel.repaint();
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		rotate(e.getX());
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
