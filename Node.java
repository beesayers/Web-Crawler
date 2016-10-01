public class Node<T> 
{
	private T data;
	private Node next;
	
	public Node()						// default constructor
	{
		data = null;
		next = null;
	}
	
	public Node(T data, Node next)
	{
		this.data = data;
		this.next = next;
	}
	
	public Node getNext()				// returns the Node the current node "points" to
	{
		return this.next;
	}
	
	public void setNext(Node next)		// sets Node's next "pointer"
	{
		this.next = next;
	}
	
	public T getData()					// returns Node's data
	{
		return this.data;
	}
	
	public void setData(T data)			// sets Node's data
	{
		this.data = data;
	}
}
