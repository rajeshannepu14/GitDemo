package Learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Javabasics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String arr[]= new String[4];
		String arr1[]= {"ab","bc","cd"};
		ArrayList<String> a = new ArrayList<String>();
		a.add("Rajesh");
		a.add("Annepu");
		a.add(2, "hi");
		for(var val:a)
		{
			System.out.println(val);
		}
		List<String> ar =Arrays.asList(arr1);
		for(String s: ar)
		{
			System.out.println(s);
		}
		String new1= "A'Rami'B";
		String new2="Rami";
		if("  Tajesh  ".contains("Tajesh"))
			System.out.println("Sucess");
		System.out.println(new2);
		System.out.println(new1);
		String new3 []= new1.split("'");	
		System.out.println(new3[1]+"This is the one");
		
	}

}
