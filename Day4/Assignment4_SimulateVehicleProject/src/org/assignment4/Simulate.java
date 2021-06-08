package org.assignment4;

class DisplayMethod
{
  public void display1(String msg)
  {
    System.out.println (msg+" crossed bridge");
    try
    {
      Thread.sleep(1000);
    }
    catch(InterruptedException e)
    {
      e.printStackTrace();
    }
    System.out.println(msg+" reached tollbooth");
  }
}


class Vehicle extends Thread
{
  String msg1;
  DisplayMethod temp;
  public Vehicle(DisplayMethod dm,String str1)
  {
    temp = dm;
    msg1 = str1;
   
    start();
    try {
		join();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
  }
  public void run()
  {
    synchronized(temp)     
    {
      temp.display1(msg1);
      
    }
  }
}

public class Simulate
{
  public static void main (String[] args)
  {
   DisplayMethod firstobject = new DisplayMethod();
   Vehicle vehicle1 = new Vehicle(firstobject, "Vehicle1");
   Vehicle vehicle2= new  Vehicle(firstobject,"Vehicle2");
   Vehicle vehicle3 = new Vehicle(firstobject, "Vehicle3");
   Vehicle vehicle4 = new Vehicle(firstobject, "Vehicle4");
   Vehicle vehicle5 = new Vehicle(firstobject, "Vehicle5");
  }
}
  