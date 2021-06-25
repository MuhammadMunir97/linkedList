public class IDedLinkedList<AnyType extends IDedObject> {

	Node head;

	class Node 
	{
		AnyType data;
		Node next;
		
		public Node(AnyType data) {
			this.data = data;
		}
	}
	
	public void makeEmpty() 
	{
		head = null;
	}
	
	public AnyType findID (int id)
	{
		if (head == null)
		{
			return null;
		}

		if (head.data.getID() == id)
			return head.data;
		return findID (id, head.next);
	}

	private AnyType findID (int id, Node node)
	{
		if (node == null)
			return null;
		if (node.data.getID() == id)
			return node.data;
		
		return findID (id, node.next);
	}
	
	public boolean insertAtFront(AnyType x)
	{
		// if ID exists return false
		if (findID (x.getID()) != null)
		{
			return false;
		}

		Node newHead = new Node (x);
		newHead.next = head;
		this.head = newHead;

		return true;
	}
	
	public AnyType deleteFromFront()
	{
		if (head == null)
		{
			return null;
		}
		
		AnyType returnData = head.data;
		Node nextNode = head.next;
		head.next = null;
		this.head = nextNode;

		return returnData;
	} 
	
	public AnyType delete(int id)
	{
		if (head == null)
		{
			return null;
		}

		if (head.data.getID() == id)
		{
			return deleteFromFront();
		}

		return delete (id, head, head.next);
	}

	private AnyType delete (int id, Node previousNode, Node currentNode)
	{
		if (currentNode == null)
		{
			return null;
		}

		if (currentNode.data.getID() == id)
		{
			previousNode.next = currentNode.next;
			currentNode.next = null;
			return currentNode.data;
		}

		return delete (id, currentNode, currentNode.next);
	}
	
	public int printTotal()
	{
		if (head == null)
		{
			return 0;
		}
		int total = head.data.getID();
		Node currentNode = head.next;
		while (currentNode != null)
		{
			total += currentNode.data.getID();
			currentNode = currentNode.next;
		}
		return total;
	}
}
