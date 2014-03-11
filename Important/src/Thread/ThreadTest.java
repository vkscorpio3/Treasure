package Thread;

public class ThreadTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyThread t1 = new MyThread(0, 3, 300);
		MyThread t2 = new MyThread(1, 3, 300);
		MyThread t3 = new MyThread(2, 3, 300);

		t1.setName("Sachin");
		t2.setName("Dhoni");
		t3.setName("Kohli");
		//t1.setDaemon(true);
		t1.start();
		t2.start();
		t3.start();

	}

}

class MyThread extends Thread {
	private int startIdx, nThreads, maxIdx;

	public MyThread(int s, int n, int m) {
		this.startIdx = s;
		this.nThreads = n;
		this.maxIdx = m;
	}

	@Override
	public void run() {
		for (int i = this.startIdx; i < this.maxIdx; i += this.nThreads) {
			System.out.println("[ID " + this.startIdx + "] " + i);
			meth();
			
		}
		
		
	}
	synchronized void meth(){
		try {
			Thread.sleep(100);
			wait(100);
			//notify();
		} catch (Exception e) {				
			e.printStackTrace();
		}
	}
}
