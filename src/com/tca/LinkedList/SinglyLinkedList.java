package com.tca.LinkedList;

import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class SinglyLinkedList {

	private Node first;
	private Node last;
	private int count;

	private static class Node {
		public int data;
		public Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public SinglyLinkedList() {
		first = null;
		last = null;
		count = 0;
	}

	// Method of add element in the LinkedList
	public void add(int element) {
		if (first == null) {
			Node T = new Node(element);
			first = T;
			last = T;
			count++;
		} else {
			Node T = new Node(element);
			last.next = T;
			last = last.next;
			count++;
		}
	}

	// Method of Size of LinkedList
	public int size() {
		return count;
	}

	public int length() {
		return count;
	}

	// Method of display LinkedList
	public void display() {
		for (Node T = first; T != null; T = T.next) {
			System.out.print(T.data + " -> ");
		}
		System.out.println("null");
	}

	public String toString() {
		/*
		 * // Attempt-1 //No. of times you are creating object and immediatly you are
		 * destroying String s = "["; for(Node T = first ; T!=null; T=T.next) { s = s +
		 * T.data + ",";
		 * 
		 * } s = s.substring(0,s.length()-1); s=s+"]"; return s.toString();
		 */

		StringJoiner sj = new StringJoiner(",", "[", "]");

		for (Node T = first; T != null; T = T.next) {
			sj.add(String.valueOf(T.data));
		}

		return sj.toString();
	}

	// addfirst element
	public void addFirst(int element) {
		if (first == null) {
			Node T = new Node(element);
			first = T;
			last = T;
			count++;
		} else {
			Node T = new Node(element);
			T.next = first;
			first = T;
			count++;
		}

	}

	// It will add element in last position
	public void addLast(int element) {
		add(element);
	}

	// Get reference of given index
	private Node getNodeAt(int index) // Utility-Helper Function
	{
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
	/*
	 * public void show(int index) { Node s = this.getNodeAt(index);
	 * System.out.println(s.data); }
	 */

	// Get data of given index
	public int getElement(int index) {
		Node T = getNodeAt(index);
		return T.data;
	}

	// set data for given index
	public int setElement(int index, int element) {
		Node T = getNodeAt(index);
		int item = T.data;
		T.data = element;

		return item;
	}

	// add element at given index
	public void add(int index, int element) {
		if (index < 0 || index > count) {
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + count);
		}

		if (index == 0) {
			addFirst(element);
		} else if (index == count) {
			addLast(element);
			// add(element);
		} else {
			// want to add element in between first & last node
			Node T = new Node(element);
			Node S = getNodeAt(index - 1);
			T.next = S.next; // Link Joda mg toda
			S.next = T;
			count++;
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	// search element in the LL and return index
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

	// search element in the LL and return index
	public int lastIndexOf(int element) {
		int i = 0;
		int rindex = -1;

		for (Node T = first; T != null; T = T.next) {
			if (T.data == element) {
				rindex = i;
			}
			i++;
		}
		return rindex;
	}

	// Remove first node from LL
	public int remove() {

		if (first == null) {
			throw new NoSuchElementException("LinkedList is Empty !!");
		}
		if (count == 1) {
			int item = first.data;
			first = null;
			last = null;
			count = 0; // Only one node present in LL
			return item;
		}
		int item = first.data;
		Node T = first;
		first = first.next;
		T.next = null;
		count--;

		return item;
	}

	// Remove first node from LL
	public int removeFirst() {
		return remove();
	}

	// Remove last from LL
	public int removeLast() {

		if (first == null) {
			throw new NoSuchElementException("LinkedList is Empty !!");
		}
		if (first == last) {
			int item = last.data;
			first = null;
			last = null;
			count = 0;
			return item;
		}

		// My Logic
		/*
		 * int item = last.data; Node T = getNodeAt(count - 2); T.next = null; count--;
		 */

		// Sir's Logic
		int item = last.data;
		last = getNodeAt(count - 2);
		last.next = null;
		count--;

		return item;
	}

	// Remove element of given index from LL
	public int remove(int index) {

		if (first == null) {
			throw new NoSuchElementException("LinkedList is Empty !!");
		}

		if (index < 0 || index >= count) {
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + count);
		}

		if (index == 0) {
			return removeFirst();
		} else if (index == count - 1) {
			return removeLast();
		} else {
			Node T = getNodeAt(index);
			Node S = getNodeAt(index - 1);
			int item = T.data;
			S.next = T.next;
			T.next = null;
			count--;

			return item;
		}
	}

	// It will remove the first found element from list
	public boolean removeElement(int element) {

		int index = indexOf(element);

		if (index == -1) {
			return false;
		}

		remove(index);
		return true;
	}

	// It will remove first Occurrence
	public boolean removeFirstOccurrence(int element) {
		return removeElement(element);

	}

	// It will remove last Occurrence
	public boolean removeLastOccurrence(int element) {
		int index = lastIndexOf(element);
		if (index == -1) {
			return false;
		}
		remove(index);
		return true;
	}

	// It will remove all Occurrence
	public boolean removeAllOccurrence(int element) {
		boolean status = false;

		while (removeElement(element)) {
			status = true;
		}
		return status;
	}

	//
	public int indexOf(int occurance, int element) {
		if (first == null) {
			throw new NoSuchElementException("List is Empty !!");
		}

		if (occurance < 1) {
			throw new NoSuchElementException("Occurance should be greater than 0");
		}

		int cnt = 0;
		int i = 0;

		for (Node T = first; T != null; T = T.next) {

			if (T.data == element) {
				cnt++;

				if (cnt == occurance) {
					return i;
				}

			}

			i++;
		}

		return -1;
	}

}
