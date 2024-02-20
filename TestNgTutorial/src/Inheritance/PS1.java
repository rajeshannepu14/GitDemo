package Inheritance;

import org.testng.annotations.Test;

public class PS1 extends PS {
	
	@Test
	public void Demo()
	{
		PS2 ps2=new PS2(8);
		run(3);
		increment();
		decrement();
		ps2.multiplywith2();
		ps2.multiplywith3();
	}

}
