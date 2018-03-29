import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;


import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
//flashcards
public class Panel extends JPanel
{
	JFrame frame = new JFrame();
	//private Processing proc;
	private JLabel label;
	public Panel()
	{
		label = new JLabel("Empty");
		frame.add(label);
	}
	public void paintCompnent(Graphics g)
	{
		super.paintComponent(g);
		g.drawRect(0, 0, 30, 30);
	}
	public void changeLabel(String str)
	{
		label.setText(str);
	}
}
