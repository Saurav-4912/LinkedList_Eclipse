package com.main;

import com.tca.LinkedList.DoublyLinkedList;
import com.tca.util.ListOperation;

public class LinkedListApp {

	public static void main(String[] args) {

		DoublyLinkedList L1 = new DoublyLinkedList();
		L1.add(11);
		L1.add(22);
		L1.add(33);
		
		DoublyLinkedList L2 = new DoublyLinkedList();
		L2.add(44);
		L2.add(55);
		L2.add(66);
		
		DoublyLinkedList result = ListOperation.joinTwoList(L1 , L2);
		
		System.out.println(result);
		
		DoublyLinkedList status = ListOperation.reverseCreate(3);
		System.out.println(status);
		
		
	}

	

}
