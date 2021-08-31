package automateOfficeWork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class Method {

	public static String retlargelement()
	{
	int a[]= {2,20,24,6,8};
	String[] split = Arrays.toString(a).split("[\\[\\]]")[1].split(", "); 
	List<String> listStr = new ArrayList<String>();
	for(int i=0;i<split.length;i++)
	{
		listStr.add(split[i]);
	}
	System.out.println(listStr);
	Collections.sort(listStr, new Comparator<String>()
	{
		public int compare(String X, String Y) {
		System.out.println("X value is " +X+ " Y value is " +Y);
		String XY=X + Y;
		System.out.println("XY value is : " +XY);
		String YX=Y + X;
		System.out.println("YX value is : " +YX);
		int b=XY.compareTo(YX) > 0 ? -1:1;
		System.out.println(b);
		return XY.compareTo(YX) > 0 ? -1:1; 
		}});
	System.out.println(listStr);
	 Iterator it = listStr.iterator(); 
	 String concat = "";
	 while(it.hasNext()) {
		 concat=concat+it.next();
		 System.out.println(concat);
	 }
	 return concat;     
	    } 

	public static void main(String[] args) {

		String retlargelement = retlargelement();
		System.out.println(retlargelement);
		
	}

}
