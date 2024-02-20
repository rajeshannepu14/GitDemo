package Inheritance;

public class PS2 extends PS3 {
	int a;
	public PS2(int a)
	{
		 
	    super(a);
	    int b=4;
		this.a=a;
	}
	public void multiplywith2()
	{
		System.out.println(a*2);
	}
	public void multiplywith3()
	{
		System.out.println(a*3);
	}

}
