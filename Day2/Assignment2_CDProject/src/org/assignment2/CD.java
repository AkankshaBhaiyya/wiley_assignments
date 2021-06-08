package org.assignment2;
import java.util.*;
public class CD {
	
    private String name,title;
	private static TreeMap<String,String> cdMap=new TreeMap<String,String>();
	public CD(String name, String title) {
		super();
		this.name=name;
		this.title=title;
		cdMap.put(name,title);
	}
	public void displayCD()
	{
		System.out.println("Singer|||||| Title");
		Set<String> cdKeySet= cdMap.keySet();
		for(String name: cdKeySet)
		{
			System.out.println(name+"|||||"+cdMap.get(name));
		}
	}
	
}
