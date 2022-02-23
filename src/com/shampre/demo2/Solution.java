package com.shampre.demo2;

/**
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 *
 */
public class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode nodeTemp = l1;

//		l1,l2都为空
		if (l1 == null && l2 == null) {
			return nodeTemp;
		}

//		l1,l2都有值
		int temp = 0;
		while (l1 != null && l2 != null) {
			int sumTemp = l1.val + l2.val + temp;
			temp = sumTemp / 10;
			l1.val = sumTemp % 10;
			if (l1.next != null && l2.next != null) {
				l1 = l1.next;
				l2 = l2.next;
			} else {
				break;
			}
		}
		
		if(l1.next==null&&l2.next==null) {
			if(temp>0) {
				l1.next=new ListNode(temp,null);
			}
			return nodeTemp;
		}

		if (l1.next == null) {
			l1.next = l2.next;
		} else if (l2.next == null) {
			l1.next = l1.next;
		}

		l1=l1.next;
		while (l1 != null) {
			int sumTemp = l1.val + temp;
			temp = sumTemp / 10;
			l1.val = sumTemp % 10;

			if (l1.next != null) {
				l1 = l1.next;
			} else {
				break;
			}
		}
		
		if (temp > 0) {
			ListNode node = new ListNode();
			node.val = temp;
			node.next = null;
			l1.next = node;
		}
		
		return nodeTemp;
	}
}
