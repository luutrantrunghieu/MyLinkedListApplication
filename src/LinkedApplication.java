
public class LinkedApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//NODE TEST
		Node<String> head;
		Node<String> tail;
		
		head = new Node<String>("Paul", null);
		head.addNodeAfter("Saul");
		tail = head.getLink();
		
		System.out.println(head.toString(0));
		System.out.println();
		
		//test add node after
		head.addNodeAfter("mauls");
		tail.addNodeAfter("Saul");
		tail = tail.getLink();
		tail.addNodeAfter("mauls");
		tail = tail.getLink();
		tail.addNodeAfter("Raul");
		
		//test toString
		System.out.println(head.toString(0));
		System.out.println();
		
		Node<String> dummy = new Node<String>(null, head);
		dummy.addNodeAfter("Raul");
		head = dummy;
		System.out.println(head.toString(0));
		System.out.println();
		
		//test 1000
		Node<String> thousand = new Node<String>("Thousand", null);
		for (int i = 0; i < 10; ++i)
		{
			thousand.addNodeAfter("thousand");
		}
		System.out.println(thousand.toString(0));
		System.out.println();
		
		//test no number toString
		thousand = new Node<String>("Thousand2", null);
		for (int i = 0; i < 10; ++i)
		{
			thousand.addNodeAfter("thousand2");
		}
		for (int i = 0; i < 10; ++i)
		{
			System.out.println(thousand.toString());
			thousand = thousand.getLink();
		}
		System.out.println();
		
		Node<String> newNode = null;
		newNode = Node.listCopy(thousand);
		System.out.println(Node.listPosition(newNode, 0).toString());
		System.out.println(Node.listLength(newNode));
		System.out.println(Node.getTail(newNode).toString());
		
		//test linked sequence add after and add before
		LinkedSequence<String> ls = new LinkedSequence<String>();
		for(int i = 0; i < 4; ++i)
			ls.addAfter("Raul");
		ls.displayList();
		for(int i = 0; i < 4; ++i)
			ls.addBefore("Saul");
		ls.displayList(); 
		
		//test linked sequence add all
		LinkedSequence<String> ls2 = new LinkedSequence<String>();
		for(int i = 0; i < 4; ++i)
		{
			ls2.addBefore("Raul");
		}
		ls.addAll(ls2);
		ls.displayList();
		
		//test clone
		ls = ls2.clone();
		ls.displayList();
		
		//test toString on rectangle
		LinkedSequence<Rectangle> ls3 = new LinkedSequence<Rectangle>();
		for(int i = 0; i < 4; ++i)
		{
			ls3.addBefore(new Rectangle(2, 2));
		}
		ls3.displayList();
		
		//test 100000 rectangles
		/*LinkedSequence<Rectangle> ls4 = new LinkedSequence<Rectangle>();
		for(int i = 0; i < 100000; ++i)
		{
			ls4.addBefore(new Rectangle(2, 2));
		}
		ls4.displayList();
		
		//test 1000000 rectangles
		LinkedSequence<Rectangle> ls5 = new LinkedSequence<Rectangle>();
		for(int i = 0; i < 1000000; ++i)
		{
			ls5.addBefore(new Rectangle(2, 2));
		}
		ls5.displayList();
		
		//test 10000000 rectangles
		LinkedSequence<Rectangle> ls6 = new LinkedSequence<Rectangle>();
		for(int i = 0; i < 100000; ++i)
		{
			ls6.addBefore(new Rectangle(2, 2));
		}
		ls6.displayList();
		*/
	}

}
