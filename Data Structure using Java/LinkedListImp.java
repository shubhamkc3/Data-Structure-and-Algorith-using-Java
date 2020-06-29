import java.io.*; 

// Java program to implement 
// a Singly Linked List 
public  class LinkedListImp { 

	Node head; // head of list 

	// Linked list Node. 
	// This inner class is made static 
	// so that main() can access it 
public class Node { 

		int data; 
		Node next; 

		// Constructor 
		public Node(int d) 
		{ 
			data = d; 
			next = null; 
		} 
	} 

	// Method to insert a new node 
	public void insert(int data) 
	{ 
		// Create a new node with given data 
		Node new_node = new Node(data); 
		new_node.next = null; 

		// If the Linked List is empty, 
		// then make the new node as head 
		if (head == null) { 
			head = new_node; 
		} 
		else { 
			// Else traverse till the last node 
			// and insert the new_node there 
			Node last = head; 
			while (last.next != null) { 
				last = last.next; 
			} 
    
			// Insert the new_node at last node 
			last.next = new_node; 
		} 

    } 
    public void InsertAtFirst(int data)
    {
        Node new_node = new Node(data); 
        if(head==null)
        {
            head=new_node;
        }
        else
        {
            new_node.next=head;
            head=new_node;
        }
       
    }

    public void reverselist()
    {
        Node temp=head;
        Node next=null;
        Node prev=null;
        while(temp!=null)
        {
            head=temp;
            next=temp.next;
            temp.next=prev;
            prev=temp;
            temp=next;
		}
		
	}
	
	public void remove(int target)
	{
		Node prev=head;
		Node temp=null;
		if((head.data==target))
		{

			head=prev.next;	
		}
		else
		{
			while((prev!=null) && (prev.data!=target))
			{
				temp=prev;
				prev=prev.next;
			}
			temp.next=prev.next;
		}
		
		
	}
	// Method to print the LinkedList. 
	public void printList() 
	{ 
		Node currNode =head; 

		System.out.print("LinkedList: "); 

		// Traverse through the LinkedList 
		while (currNode != null) { 
			// Print the data at current node 
			System.out.print(currNode.data + " "); 

			// Go to next node 
			currNode = currNode.next; 
		} 
	} 

	// Driver code 
	public static void main(String[] args) 
	{ 
		/* Start with the empty list. */
		LinkedListImp list = new LinkedListImp(); 

	    // Insert the values 
		
		list.insert(2); 
		list.insert(3); 
		list.insert(4); 
		list.insert(5);
		list.insert(6);
        list.InsertAtFirst(1);
		// Print the LinkedList 
        list.printList(); 
        list.remove(3);
        list.printList();
        
	} 
} 
