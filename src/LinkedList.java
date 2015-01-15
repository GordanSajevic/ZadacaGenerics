import java.util.Iterator;


public class LinkedList<T> implements Iterable{
	
	private Node head;
	
	/**
	 * Konstruktor bez parametara
	 */
	
	public LinkedList()
	{
		this.head = head;
	}
	
	/**
	 * Metoda koja dodaje elemente listi
	 * @param value
	 */
	
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
	
	/**
	 * Metoda koja uklanja element određen indeksom iz liste
	 * @param index
	 */
	
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
	
	/**
	 * Metoda koja vraća broj elemenata
	 * @return counter
	 */
	
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
	
	/**
	 * Metoda koja vraća jedan element određen indeksom
	 * @param index
	 * @return
	 */
	
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
	
	/**
	 * Metoda koja vraća string sa svim elementima liste 
	 */
	
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
	
	/**
	 * node klasa
	 * @author gordansajevic
	 * @param <T>
	 */
	
	private class Node<T>
	{
		private T value;
		private Node next;
		
		/**
		 * Konstrukor sa jednim parametrom
		 * @param value
		 */
		
		public Node(T value)
		{
			this.value = value;
			this.next = null;
		}
		
		/**
		 * Konstruktor sa dva parametra
		 * @param value
		 * @param next
		 */
		
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
	
	/**
	 * Klasa koja implementira iterator
	 * @author gordansajevic
	 * @param <T>
	 */
	
	private class Biterator<T> implements Iterator<T> {
		private Node<T> current;
		
		/**
		 * Konstruktor sa jednim parametrom
		 * @param start
		 */
		
		public Biterator(Node start) {
			current = start;
		}
		
		/**
		 * Metoda koja provjerava da li postoji sljedeći element
		 */

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
