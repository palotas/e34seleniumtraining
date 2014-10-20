package postauto;

public class Utils {
	
	private String firstname;
	private String lastname;
	private int age;
	
	public Utils() {
		//standard constructor goes here
		firstname="Michael";
		lastname="Palotas";
		age=42;
	}
	
	public int superComplexCalculations(int a, int b, int c) {
		int result=a+b+c;
		System.out.println("The result is: " + result);
		return result;
	}
	
	public void printMyVariables() {
		System.out.println("Firstname: " + firstname + "   Lastname: " + lastname + "   Age: " + age);
	}

}
