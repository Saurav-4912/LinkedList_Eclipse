package com.tca.LinkedList;

import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class DoublyLinkedList {

	private Node first;
	private Node last;
	private int count;

	private static class Node {
		private Node prev;
		private int data;
		private Node next;

		public Node(int data) {
			this.prev = null;
			this.data = data;
			this.next = null;
		}

		/*
		 * public Node(Node prev , int data , Node next) { this.prev = prev; this.data =
		 * data; this.next = next; }
		 */
	}

	public DoublyLinkedList() {
		this.first = null;
		this.last = null;
		this.count = 0;
	}

	// To add element in the LinkedList
	public void add(int element) {
		if (first == null) {
			Node T = new Node(element);
			first = T;
			last = T;
			count++;
		} else {
			Node T = new Node(element);
			last.next = T;
			last.next.prev = last;
			last = last.next;
			count++;

		}
	}

	// It will return the size of LinkedList
	public int size() {
		return count;
	}

	// It will return the length of LinkedList
	public int length() {
		return count;
	}

	// It will display data of LinkedList
	public void display() {
		for (Node T = first; T != null; T = T.next) {
			System.out.print(T.data + " -> ");
		}
		System.out.println("null");
	}

	// It will display data of LinkedList
	public String toString() {
		StringJoiner str = new StringJoiner(",", "[", "]");

		for (Node T = first; T != null; T = T.next) {
			str.add(String.valueOf(T.data));
		}

		return str.toString();
	}

	// Inserts the specified element at the beginning of this list.
	public void addFirst(int element) {
		if (first == null) {
			Node T = new Node(element);
			first = T;
			last = T;
			count++;
		} else {
			Node T = new Node(element);
			T.next = first;
			T.next.prev = T;
			// first.prev = T;
			first = T;
			count++;
		}
	}

	// Inserts the element at the end of this list.
	public void addLast(int element) {
		add(element);
	}

	private Node getNodeAt(int index) {
		if (index < 0 || index >= count) {
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + count);
		}

		Node T = first;
		for (int i = 0; i < count; i++) {
			if (i == index) {
				return T;
			}
			T = T.next;
		}
		return null;
	}

	public int getElement(int index) {

		Node T = getNodeAt(index);

		return T.data;
	}

	// Replaces the element at the specified position in this list with the
	// specified element.
	public int setElement(int index, int element) {
		Node T = getNodeAt(index);
		int item = T.data;
		T.data = element;

		return item;

	}

	public void add(int index, int element) {
		if (index < 0 || index > count) {
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + count);
		}
		if (index == 0) {
			addFirst(element);
		} else if (index == count) {
			addLast(element);
		} else {
			Node T = new Node(element);
			Node S = getNodeAt(index - 1);
			T.next = S.next; // Link Joda mg toda

			T.prev = S;

			S.next.prev = T;
			S.next = T;

//			T.next = S.next;
//			S.next.prev=T;
//			T.prev=S;
//			S.next =T;

			count++;
		}
	}

	// Returns the index of the first occurrence of the specified element in this
	// list, or -1 if this list does not contain the element.
	public int indexOf(int element) {
		int i = 0;
		for (Node T = first; T != null; T = T.next) {
			if (T.data == element) {
				return i;
			}
			i++;
		}
		return -1;
	}

	public int lastIndexOf(int element) {
		int i = 0;
		int rindex = -1;
		for (Node T = first; T != null; T = T.next) {
			if (element == T.data) {
				rindex = i;
			}
			i++;
		}
		return rindex;
	}

	public int remove() {
		if (first == null) {
			throw new NoSuchElementException("LinkedList is Empty !!");
		}
		if (count == 1)// There is only one node in list.
		{
			int item = first.data;
			first = null;
			last = null;
			count = 0;
			return item;
		} else {
			int item = first.data;
			Node T = first;
			first = first.next;
			T.next = null;
			first.prev = null;
			count--;
			return item;
		}
	}

	public int removeFirst() {
		return remove();
	}

	public int removeLast() {
		if (first == null) {
			throw new NoSuchElementException("LinkedList is Empty !!");
		}
		if (count == 1) {
			int item = last.data;
			first = null;
			last = null;
			count = 0;
			return item;
		} else {
			int item = last.data;
			last = last.prev;
			last.next.prev = null;
			last.next = null;
			count--;
			return item;
		}
	}

	public int remove(int index) {
		if (first == null) {
			throw new NoSuchElementException("List is Empty !!");
		} else if (index < 0 || index >= count) {
			throw new IndexOutOfBoundsException("Index :" + index + ", Size: " + count);
		} else if (index == 0) {
			return removeFirst();
		} else if (index == count - 1) {
			return removeLast();
		} else {
			Node T = getNodeAt(index);
			int item = T.data;

			Node S = T.prev;

			S.next = T.next;
			T.next.prev = S;

			T.next = null;
			T.prev = null;

			count--;

			return item;
		}
	}

	public boolean removeElement(int element) {

		int index = indexOf(element);
		if (index == -1) {
			return false;
		}

		remove(index);

		return true;
	}

	public boolean removeFirstOccurrence(int element) {
		return removeElement(element);
	}

	/* It will remove the First found element from list */

	public boolean removeLastOccurrence(int element) {
		int index = lastIndexOf(element);

		if (index == -1) {
			return false;
		}

		remove(index);
		return true;
	}

	public boolean removeAllOccurances(int element) 
	{ 
		boolean status = false; // TRUE

		while (removeElement(element)) {
			status = true;
		}

		return status;
	}

}
