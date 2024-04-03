package Normal;

public class Interface implements GlobalRules,ContinentalRules {
	
	public static void main(String[] args) {
		Interface a = new Interface();
		GlobalRules at = new Interface();
		ContinentalRules ct = new Interface();
		at.FlashYellow();
		ct.Trainsymbol();
	}

	@Override
	public void Trainsymbol() {
		// TODO Auto-generated method stub
		System.out.println("Stop and lookover");	}

	@Override
	public void greenGo() {
		// TODO Auto-generated method stub
		System.out.println("Go");
	}

	@Override
	public void redStop() {
		// TODO Auto-generated method stub
		System.out.println("Stop");
	}

	@Override
	public void FlashYellow() {
		// TODO Auto-generated method stub
		System.out.println("Ready to stop");
	}

}
