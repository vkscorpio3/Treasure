package Thread;

public class finalizerExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		finalizerExample  ff = new finalizerExample();
		test34 tt = new test34();
		tt.setA("FFFF");

	}
	
	

}

class test34 {
	String a;

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}
	
	 protected void finalize()  {
		System.out.println("555555");
		
	}
	
	
}
