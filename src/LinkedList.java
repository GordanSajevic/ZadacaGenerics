import java.util.Iterator;


public class LinkedList<T> implements Iterable{
	
	private Node head;
	
	public LinkedList()
	{
		this.head = head;
	}
	
	public void add(T value)
	{
		Node newNode = new Node(value);
		if (head == null)
		{
			head = newNode;
		}
		Node previous = null;
		Node current = head;
		while (current != null)
		{
			previous = current;
			current = current.next;
		}
		if (previous == null)
		{
			newNode.next = head;
			head = newNode;
		}
		else
		{
			previous.next = newNode;
			newNode.next = current;
		}
		
	}
	
	public void removeAt(int index)
	{
		if (index < 0)
		{
			throw new IndexOutOfBoundsException("Index is not valid!");
		}
		else if (index == 0)
		{
			head = head.next;
		}
		else
		{
			Node previous = head;
			Node current = head.next;
			int counter = 1;
			while(counter < index)
			{
				previous = previous.next;
				current = current.next;
			}
			previous.next = current.next;
			current.next = null;
		}
		
	}
	
	public int getSize()
	{
		Node current = head;
		int counter = 0;
		while(current != null)
		{
			current = current.next;
			counter++;
		}
		return counter;
	}
	
	public T getAt(int index)
	{
		Node current = head;
		int counter = 0;
		while (counter < index)
		{
			current = current.next;
			counter++;
		}
		return (T) current.value;
	}
	
	public String toString()
	{
		String str="";
		Node current = head;
		while(current != null)
		{
			str += current.value;
			current = current.next;
		}
		return str;
	}
	
	private class Node<T>
	{
		private T value;
		private Node next;
		
		public Node(T value)
		{
			this.value = value;
			this.next = null;
		}
		
		public Node (T value, Node next)
		{
			this.value = value;
			this.next = next;
		}
	}

	@Override
	public Iterator<T> iterator() {
		return new Biterator<T>(head);
	}
	
	private class Biterator<T> implements Iterator<T> {
		private Node<T> current;
		
		public Biterator(Node start) {
			current = start;
		}

		@Override
		public boolean hasNext() {
			return current != null;
		}

		/**
		 * Metoda vrati vrijednost noda i pomjeri se na slijedeći.
		 */
		@Override
		public T next() {
			T value = current.value;
			current = current.next;
			return value;
		}
	}

}
