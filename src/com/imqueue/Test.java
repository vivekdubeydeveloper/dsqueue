package com.imqueue;

public class Test {

	public static void main(String[] args) {
		Queue<Integer> imq=new ImmutableQueue<Integer>();
		
		imq.enQueue(17);
		
		imq.enQueue(27);
		
		imq.enQueue(47);
		imq.enQueue(37);
		imq.enQueue(97);
		
		System.out.println(imq.isEmpty());
		
		System.out.println(imq.head());
		
		while(!imq.isEmpty()) {
			imq.deQueue();
			
		}
		
		System.out.println(imq.isEmpty());
	}

}
