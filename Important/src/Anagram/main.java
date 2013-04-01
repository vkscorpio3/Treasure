package Anagram;

import java.util.Arrays;

public class main {
    //examples 
	//pots is an anagram of stop
	//Wilma is an anagram of ilWma
	public static void main(String[] args) {
		
		System.out.println(areAnagrams(new StringBuffer("stop"),new StringBuffer("pots")));
		
	}


	public static boolean areAnagrams(StringBuffer s1b, StringBuffer s2b) {
		
		
		//will works properly
		    char[] ch1 = s1b.toString().toCharArray();
		    char[] ch2 = s2b.toString().toCharArray();
		    Arrays.sort(ch1);
		    Arrays.sort(ch2);
		    
		     System.out.println(Arrays.equals(ch1,ch2));
		

				//will not works properly
		     
	    for (int i=0; i<s1b.length(); ++i) {
	        for (int j=0; j<s2b.length(); ++j) {

	            if (s1b.charAt(i) == s2b.charAt(j)) {

	                s1b.deleteCharAt(i);
	                s2b.deleteCharAt(j);

	                i=0;
	                j=0;
	            }
	        }
	    }

	    System.out.println(s1b.toString());
	    System.out.println(s2b.toString());
	    if (s1b.equals(s2b)) {
	        return true;
	    } else
	        return false;

	}
}
