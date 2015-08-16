import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class testmain {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		
		File f = new File("/home/ganesh/Desktop/1372938627830-MSB-TBM - PTT JULY -12-13  WEEK DAYS.pdf");
		
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i=0;
		FileOutputStream fout = new FileOutputStream(new File("/home/ganesh/Desktop/1r.txt"));
		while((i=fis.read())!=-1 ){
			
			fout.write(i);
			
		}
		
	}

}
