
public class FlashCard 
{
	private String front;
	private String back;
	private int skill;
	public FlashCard()
	{
		front = "";
		back = "";
		//skill = 0;
	}
	public FlashCard(String f, String b)
	{
		front = f;
		back = b;
	}
	public void setFront(String s)
	{
		front = s;
	}
	public void setBack(String s)
	{
		back = s;
	}
	
	public String getFront()
	{
		return front;
	}
	public String getBack()
	{
		return back;
	}
	
	@Override
	public String toString()
	{
		return this.getFront() + " \n" + this.getBack();
	}
	public void incSkill()
	{
		
	}
}
