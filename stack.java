// first in last out

public class stack<T> extends queue
{
	stack()								// default constructor
	{
		super();
	}
									
	stack(int maxsize)					// constructor with size parameter
	{
		super(maxsize);
	}
	
	public Node pop()					// removes and returns the Node that was last added to the stack
	{									// FILO
		temp = head;
		head = head.getNext();
		temp.setNext(null);
		size--;
		return temp;
	}
	
	public void push(Node pushnode)		// adds a Node to the top of the stack
	{
		if (maxsize <= 0)
		{
			if (head == null)
			{
				head = pushnode;
			}
			
			else 
			{
				temp = head;
				head = pushnode;
				head.setNext(temp);
			}
			size++;		
		}
		
		else
		{
			if (head == null)
			{
				head = pushnode;
				size++;		
			}
			
			else 
			{
				if (size < maxsize)
				{
					temp = head;
					head = pushnode;
					head.setNext(temp);
					size++;		
				}
			}
		}
	}
}