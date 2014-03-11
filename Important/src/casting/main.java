package casting;

public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	 Car c = new Car();
	 Vehicle v= new Vehicle();
	 Vehicle vc=new Car();
	 c.doDrive();
	 v.doDrive();
	 vc.doDrive();
	}

}
