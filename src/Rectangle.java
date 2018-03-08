
public class Rectangle 
{

	private int width;
	private int length;
	
	public Rectangle(int a, int b) 
	{
		// TODO Auto-generated constructor stub
		width = a;
		length = b;
	}

	public boolean equals(Rectangle other)
	{
		if (other.width == width && other.length == length)
			return true;
		return false;
	}
	
	public String toString()
	{
		return Integer.toString(width) + Integer.toString(length);
	}
}
