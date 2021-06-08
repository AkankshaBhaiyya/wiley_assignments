package org.assignment4;

public class Clock {
private int flag=0;
	
	synchronized void showTick(int second) {
		  while(flag!=0 ) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.print(Thread.currentThread().getName()+" : "+second+" ");
		flag=1;
		notifyAll();
	}
	
	synchronized void showTack(int second) {
		while(flag!=1 ) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.print(Thread.currentThread().getName()+" : "+second+" ");
		flag=2;
		notifyAll();
	}
	
	synchronized void showTock(int second) {
		while(flag!=2) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName()+" : "+second);
		flag=0;
		notifyAll();
	}
}
