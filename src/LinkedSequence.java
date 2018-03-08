
public class LinkedSequence<T> 
{
	int manyNodes;
	private Node<T> head;
	private Node<T> tail;
	private Node<T> cursor;
	private Node<T> precursor;
	private Node<T> dummy;
	
	public LinkedSequence() 
	{
		// TODO Auto-generated constructor stub
		head = new Node<T>(null, null);
		tail = head;
		dummy = head;
		cursor = null;
		precursor = null;
	}
	
	//ADD METHOD:
	// Add a node after
	public void addAfter(T data)
	{
		//case empty sequence
		if (dummy == head)
		{
			head = new Node<T>(data,null);
			dummy.setLink(head);
			tail = dummy.getLink();
		}
		else
		{
			//case no cursor
			if (cursor==null)
			{
				Node<T> newN = new Node<T>(data,null);
				tail.setLink(newN);
				tail = newN;
			}
			//case exist a cursor
			else
			{
				Node<T> newN = new Node<T>(data,cursor.getLink());
				cursor = newN;
				precursor.setLink(precursor.getLink());
				
			}
		}
	}
	
	// Add a method before
	public void addBefore(T data)
	{
		//case empty sequence
		if (dummy == head)
		{
			head = new Node<T>(data,null);
			dummy.setLink(head);
			tail = dummy.getLink();
		}
		else
		{
			//case no cursor
			if (cursor==null)
			{
				Node<T> newN = new Node<T>(data,head);
				head = newN;
				dummy.setLink(head);
			}
			//case exist a cursor
			else
			{
				Node<T> newN = new Node<T>(data,cursor);
				cursor.setLink(newN);
				precursor.setLink(cursor);
			}
		}
	}
	
	// Add a sequence
	public void addAll(LinkedSequence<T> addend)
	{
		if(addend!=null && addend.head!= addend.dummy)
		{
			if (this.head!=this.dummy)	
			{	
				this.tail.setLink(addend.head);
				this.tail = addend.tail;
			}
			else
				this.head = addend.head;
		}	
	}
	
	//RETURN VALUES METHOD
	public LinkedSequence<T> clone()
	{
		LinkedSequence<T> newLS = new LinkedSequence<T>();
		
		start();
		
		while(cursor.getLink()!=null)
		{
			newLS.addAfter(cursor.getData());
			advance();
		}
		
		return newLS;
	}
	
	//remove current
	public Node<T> removeCurrent()
	{
		if (cursor!=null)
		{
			Node<T> removed = cursor;
			
			if (cursor == tail)
			{
				cursor = head;
				precursor = dummy;
			}
			else
			{
				cursor = cursor.getLink();
				precursor.setLink(cursor);
			}
			
			return removed;
		}
		else
			return null;
	}
	
	//prin it
	public void displayList()
	{
		System.out.println(head.toString(0));
	}
	
	//CURSOR METHOD
	//Move forward 1 node
	public void advance()
	{
		if (cursor!=null && cursor!=tail)
		{	
			precursor = cursor;
			cursor = cursor.getLink();
		}
	}
	
	//Start cursoring
	public void start()
	{
		if (head!= dummy)
		{
			cursor = head;
			precursor = dummy;
		}
	}
	
	//STATIC METHOD
	public static LinkedSequence concatenate(LinkedSequence ls1, LinkedSequence ls2)
	{
		LinkedSequence newLS = new LinkedSequence();
		
		newLS.head.listCopy(ls1.head);
		newLS.tail = ls1.head.getTail(ls1.head);
		newLS.tail.listCopy(ls2.head);
		return newLS;
	}

}
