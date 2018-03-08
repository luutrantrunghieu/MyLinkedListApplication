
public class Node<T> 
{
	private T data;
	private Node<T> link;

	//Constructor
	public Node(T initData, Node<T> initLink) 
	{
		// TODO Auto-generated constructor stub
		data = initData;
		link = initLink;
	}
	
	//Getter
	public Node<T> getLink()
	{
		return link;
	}
	
	public T getData()
	{
		return data;
	}
	
	//Setter
	public void setLink(Node<T> other)
	{
		link = other;
	}
	
	public void setData(T other)
	{
		data = other;
	}
	
	//Add another node after 
	public Node<T> addNodeAfter(T newEle)
	{
		link = new Node<T>(newEle, link);
		return link;
	}
	
	//Change to string method
	//Recursive
	public String toString(int n)
	{
		String field1;
		String field2;
		
		if (data == null)
			field1 = "dummy";
		else 
			field1 = data.toString();
		
		if (link == null)
			field2 = "null in tail";
		else
			field2 = link.toString(n+1);
			
		String tab = "";
		int i = 0;
		while (i < n)
		{
			tab = tab + "\t";
			++i;
		}
		
		String result = "data: " + field1 + "\n" + tab + "link:\t" + field2;
		
		return result;
	}
	
	//Non-recursive
	public String toString()
	{
		if (data == null)
			return "dummy";
		else 
			return data.toString();
	}
	
	//STATIC METHOD
	// Copy the list
	public static Node listCopy(Node source)
	{
	   Node copyHead;
	   Node copyTail;
	   
	   // Exception of an empty list.
	   if (source == null)
	      return null;
	   
	   // Make the first node for the newly created list.
	   copyHead = new Node(source.data, null);
	   copyTail = copyHead;
	   
	   // Make the rest of the nodes for the newly created list.
	   while (source.link != null)
	   {
	      source = source.link;
	      copyTail.addNodeAfter(source.data);
	      copyTail = copyTail.link;
	   }
	   
	   // Return the head reference for the new list.
	   return copyHead;
	}
	
	//Find a position in the list
	public static Node listPosition(Node head, int position)
	{
		//Exceptions
		if (head == null)
			return null;
		if (position < 0)
			return null;
		else if (position == 0)
			return head;
		
		Node result = head;
		
		//Go to the position selected
		for (int i = 0; i < position; ++i)
			result = head.getLink();
		
		return result;
	}
	
	//Length of the linked list
	public static int listLength(Node head)
	{
		int length = 0;
		Node cursor = head;
		
		while (cursor!=null)
		{
			length++;
			cursor = cursor.getLink();
		}
		
		return length;
	}
	
	//Get the tail
	public static Node getTail(Node head)
	{
		if (head==null)
			return null;
		
		Node cursor = head;
		
		while (cursor.getLink()!=null)
			cursor = cursor.getLink();
		
		return cursor;
	}

}
