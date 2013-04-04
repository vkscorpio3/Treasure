package clone;

public class mainClone {

	/**
	 * @param args
	 * @throws CloneNotSupportedException 
	 */
	public static void main(String[] args) throws CloneNotSupportedException {
	
		bean b = bean.getInstance();
		b.setAge("10");
		b.setName("ganesan");
	
		System.out.println(b.getAge());
		bean c=(bean)b.clone();
		c.setAge("12");
		System.out.println(c.getAge());
		System.out.println(b.getAge());
	}

}
class bean implements Cloneable{
	String name;
	String age;
	static bean obj=new bean();
	
	private bean (){
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {	
		return super.clone();
	}
	
	static	bean getInstance(){
		return obj;
	}
}
