package log.pack1;

import log.pack2.pack2Main;

import org.apache.log4j.Logger;

public class pack1Main {
	
	static Logger log = Logger.getLogger(
			pack1Main.class);

	public static void main(String[] args) {
		 log.debug("Debug Message! from pack1");
	}

}
