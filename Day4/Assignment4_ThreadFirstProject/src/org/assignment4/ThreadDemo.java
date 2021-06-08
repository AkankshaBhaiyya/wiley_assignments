package org.assignment4;
class ThreadProperties extends Thread
{
	public ThreadProperties()
	{
		super();
	}
	public ThreadProperties(String threadName)
	{
		super(threadName);
	}
	public void run() {
		for(int i=0;i<5;i++) {
			
		System.out.format("%-5s %-20s %-20s %-20s %-5s\n",Thread.currentThread().getId(),Thread.currentThread().getName(),Thread.currentThread().isAlive(),Thread.currentThread().getState(),Thread.currentThread().getPriority());
		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
	}
}
public class ThreadDemo {
	public static void main(String args[])
	{
		ThreadProperties thread1=new ThreadProperties("threadOne");
		ThreadProperties thread2=new ThreadProperties("threadTwo");
		ThreadProperties thread3=new ThreadProperties("threadThree");
		ThreadProperties thread4=new ThreadProperties("threadFour");
		System.out.format("%-5s %-20s %-20s %-20s %-5s\n","ID","Name","ISAlive","Status","Priority");
		thread1.start();
		thread1.setPriority(1);
		thread2.start();
		thread2.setPriority(2);
		thread3.start();
		thread3.setPriority(3);
		thread4.start();
		thread4.setPriority(4);
		
	}

}
