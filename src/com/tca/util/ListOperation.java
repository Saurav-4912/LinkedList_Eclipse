package com.tca.util;

import java.util.Scanner;

import com.tca.LinkedList.DoublyLinkedList;

public class ListOperation {

	public static DoublyLinkedList joinTwoList(DoublyLinkedList L1, DoublyLinkedList L2) {
		if (L1.size() == 0 && L2.size() == 0) {
			return null;
		} else if (L1 != null && L2.size() == 0) {
			return L1;
		} else if (L1.size() == 0 && L2 != null) {
			return L2;
		} else {

			DoublyLinkedList list = new DoublyLinkedList();
			for (int i = 0; i < L1.size(); i++) {
				list.add(L1.getElement(i));
			}
			for (int i = 0; i < L2.size(); i++) {
				list.add(L2.getElement(i));
			}
			return list;
		}
	}

	public static DoublyLinkedList reverseCreate(int n) {
		Scanner sc = new Scanner(System.in);
		DoublyLinkedList temp = new DoublyLinkedList();
		for (int i = 1; i <= n; i++) {
			System.out.println("Enter the data : ");
			int data = sc.nextInt();

			temp.addFirst(data);
			
		}
		sc.close();
		return temp;
	}
}
