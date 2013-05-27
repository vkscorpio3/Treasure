package weakHashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Map hashMap = new HashMap();

		Map weakHashMap = new WeakHashMap();

		String keyHashMap = new String("keyHashMap");
		String WeakkeyHashMap = new String("keyWeakHashMap");

		
		hashMap.put(keyHashMap, "Ankita");
		weakHashMap.put(WeakkeyHashMap, "Atul");
		System.gc();
		System.out.println("Before: hash map value:"
				+ hashMap.get("keyHashMap") + " and weak hash map value:"
				+ weakHashMap.get("keyWeakHashMap"));

		keyHashMap = null;
		WeakkeyHashMap = null;

		System.gc();

		System.out.println("After: hash map value:" + hashMap.get("keyHashMap")
				+ " and weak hash map value:"
				+ weakHashMap.get("keyWeakHashMap"));

	}

}
