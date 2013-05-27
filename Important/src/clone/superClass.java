package clone;

public class superClass  implements Cloneable{


	public String a="super";
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
	
		return super.clone();
	}
}
