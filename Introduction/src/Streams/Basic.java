package Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class Basic {
	//@Test
	public void Filter()
	{
		
		ArrayList<String> names= new ArrayList<String>();
		names.add("Axar");
		names.add("Rajesh");
		names.add("Anuj");
		names.add("Maheswari");
		names.add("Amul");
		
		Long c=names.stream().filter(s->s.startsWith("A")).count();
		System.out.println(c);
		
		Long d=Stream.of("Axar","Rajesh","Anuj","Maheswari","Amul").filter(s->s.startsWith("A")).count();
		System.out.println(d);
		
		Long e=Stream.of("Axar","Rajesh","Anuj","Maheswari","Amul").filter(s->
		{
			return s.startsWith("A");
			
		}).count();
		System.out.println(e);
		
		names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));//print values length>4
		names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s)); //print values>4 but 1 value
		names.stream().forEach(s->System.out.println(s));
	
	}
	
	//@Test
	public void maps()
	{
		ArrayList<String> names= new ArrayList<String>();
		names.add("Amar");
		names.add("Karthik");
		names.add("Arjun");
		names.add("Rajeswari");
		names.add("Amulya");
		//print letter end with letter A uppercase
		Stream.of("Axara","Rajesh","Anuj","Maheswari","Amulya").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		//print letter start with A sorted and uppercase
		List<String> names1 = Arrays.asList("Axara","Rajesh","Anuj","Maheswara","Amulya");
		names1.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		//concat 2 lists
		 Stream<String> newname =  Stream.concat(names.stream(),names1.stream());
		// newname.sorted().forEach(s->System.out.println("1"+s));
		//matching
		 boolean flag=newname.anyMatch(s->s.equalsIgnoreCase("Rajesh"));
		 System.out.println(flag);
	    
		
	}
	@Test
	public void Collect()
	{
		List<String> ls = Stream.of("Axara","Rajesh","Anuj","Maheswari","Amulya").filter(s->s.endsWith("a")).map(s->s.toUpperCase())
				.collect(Collectors.toList());
		System.out.println(ls.get(0));
		
		List<Integer>values=Arrays.asList(4,5,2,3,1,1,5,4,4,7,8,7);
		List<Integer> li = values.stream().distinct().sorted().collect(Collectors.toList());
		li.forEach(s->System.out.println(s));
		System.out.println(li.get(3));
	
	}
	

}
