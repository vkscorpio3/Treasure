package clone;

public class main {

	/**
	 * @param args
	 * @throws CloneNotSupportedException 
	 */
	public static void main(String[] args) throws CloneNotSupportedException {
	
		subClass s=subClass.getInstance();
		
		System.out.println(s.clone());

	}

}
