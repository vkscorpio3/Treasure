package clone;

public class subClass extends superClass implements Cloneable{

	private subClass(){		
	}
	private static subClass s;
	
	public static void main(String[] args) throws CloneNotSupportedException {
		

		subClass sub=new subClass();
		System.out.println(sub.clone());
		
		
	}

 public static subClass getInstance(){
	 
	 if(s==null){
		 s= new subClass();
	 }
	 return s;
 }
 @Override
protected Object clone() throws CloneNotSupportedException {

	return super.clone();
}
	
}
