package automateOfficeWork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hpsf.Array;
import org.apache.tools.ant.types.CommandlineJava.SysProperties;

public class Flames {

	public static void main(String[] args) {

		String yourname ="SWATISH";
		char[] namearray = yourname.toCharArray();
		List<Character> listyourname = new ArrayList<Character>();
		for(int i=0;i<namearray.length;i++)
		{
			listyourname.add(namearray[i]);
		}
		String Partnername = "VANIKAPOOR";
		char[] Partnerarray = Partnername.toCharArray();
		List<Character> listpartnername = new ArrayList<Character>();
		for(int i=0;i<Partnerarray.length;i++)
		{
			listpartnername.add(Partnerarray[i]);
		}
		List<String> listofflames = new ArrayList<String>();
		listofflames.add(0, "FREINDS");
		listofflames.add(1, "LOVER");
		listofflames.add(2, "AFFECTION");
		listofflames.add(3, "MARRIAGE");
		listofflames.add(4, "ENEMY");
		listofflames.add(5, "SISTER");
		
		int namelength = namearray.length;
		int Partnerlength = Partnername.length();
		
		for(int i=0;i<namelength;i++)
		{
			for(int j=0;j<Partnerlength;j++)
			{
				if(namearray[i]==Partnerarray[j])
				{
					listpartnername.remove(Character.valueOf(namearray[i]));
					listyourname.remove(Character.valueOf(namearray[i]));
				}
			}
		}
		System.out.println(listpartnername);
		System.out.println(listyourname);
		int size111 = listpartnername.size();
		int size222 = listyourname.size();
		int add11 = size111+size222;
		int FLAMESIZE = listofflames.size();
		int DynamicFlameSize=0;
		for(int i=0;i<add11;i++)
		{
			System.out.println("Flame size is : " +FLAMESIZE);
			System.out.println("OVerallnumbersize is : " +add11);
			System.out.println("Dynamic Flame size is : " +DynamicFlameSize);
			DynamicFlameSize =FLAMESIZE-add11;
			while(Math.abs(DynamicFlameSize)>FLAMESIZE)
			{
				DynamicFlameSize =Math.abs(DynamicFlameSize)-FLAMESIZE;
				if(DynamicFlameSize==FLAMESIZE)
				{
					listofflames.remove(listofflames.size()-1);
				}
			}
			System.out.println(listofflames);
			System.out.println("Dynamic fie size is : " +DynamicFlameSize);
			System.out.println("current listofflames size is : " +listofflames.size());
			try {
				listofflames.remove(Math.abs(DynamicFlameSize)-1);
			} catch (Exception e) {
				//listofflames.remove(Math.abs(DynamicFlameSize));
			}
			FLAMESIZE=FLAMESIZE-1;
			System.out.println(listofflames);
			if(FLAMESIZE==1)
			{
				System.out.println(listofflames);
				break;
			}
		}
	}

}
