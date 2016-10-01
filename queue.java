// first in first out

public class queue<T>
{
	protected Node head;
	protected Node temp;
	protected Node tail;
	protected int maxsize;
	protected int size;
	
	queue()								// default constructor
	{
		head = null;
		tail = null;
		temp = null;
		maxsize = 0;
		size = 0;
	}
										
	queue(int maxsize)					// constructor with size parameter
	{
		this.maxsize = maxsize;
		head = null;
		tail = null;
		temp = null;
		size = 0;
	}
	
	public Node dequeue()				// removes and returns the Node that was first added to the queue
	{									// FIFO
		temp = head;
		head = head.getNext();
		temp.setNext(null);
		size--;
		return temp;
	}
	
	public void enqueue(Node pushnode)	// adds a Node to the top of the queue
	{
		if (maxsize <= 0)				// unlimited queue size
		{
			if (head == null)
			{
				head = pushnode;
				tail = head;
			}
		
			else 
			{
				tail.setNext(pushnode);
				tail = pushnode;
			}
			size++;		
		}
		
		else 							// queue has a set size
		{
			if (head == null)
			{
				head = pushnode;
				tail = head;
				size++;		
			}
			
			else
			{
				if (size < maxsize)		// will only push if our queue's size is lower than our max size
				{
					tail.setNext(pushnode);
					tail = pushnode;
					size++;		
				}
			}
				
		}
		
	}
	
	public int getSize()				// returns the size of queue
	{
		return size;
	}
	
	public void setSize(int maxsize)	// sets the max size of the queue
	{
		this.maxsize = maxsize;
	}
}