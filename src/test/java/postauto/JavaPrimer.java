package postauto;

public class JavaPrimer {

	public static void main(String[] args) {
		
		System.out.println("Hello World");
		
		Utils myUtil=new Utils();
		myUtil.superComplexCalculations(1, 2, 3);

	}
	
	public void sayHello() {
		System.out.println("Hello World 2");
	}
	
	public void saySomething(String s) {
		System.out.println(s);
	}
	
	public int addTwoNumbers(int a, int b) {
		int c = a + b;
		return c;
	}
	
	

}
