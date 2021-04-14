
public class MethodChaining {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MethodChaining methodchaining = new MethodChaining();
		methodchaining.a1().a2().a3();
		

	}

	public MethodChaining a1() {
		System.out.println("This is a1");
		return this;
	}
	public MethodChaining a2() {
		System.out.println("This is a2");
		return this;
	}
	public MethodChaining a3() {
		System.out.println("This is a3");
		return this;
	}
}
