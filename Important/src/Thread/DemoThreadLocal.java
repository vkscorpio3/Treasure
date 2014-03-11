package Thread;

public class DemoThreadLocal extends Thread {

	public static void main(String args[]) {

		Thread threadOne = new DemoThreadLocal();
		threadOne.start();

		Thread threadTwo = new DemoThreadLocal();
		threadTwo.start();
	}

	@Override
	public void run() {
		// sample code to simulate transaction id
		Context context = new Context();
		context.setTransactionId(getName());

		// set the context object in thread local to access it somewhere else
		MyThreadLocal.set(context);

		/* note that we are not explicitly passing the transaction id */
		new BusinessService().businessMethod();
		MyThreadLocal.unset();

	}
}

class Context {

	private String transactionId = null;

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

}

class MyThreadLocal {

	public static final ThreadLocal userThreadLocal = new ThreadLocal();

	public static void set(Context user) {
		userThreadLocal.set(user);
	}

	public static void unset() {
		userThreadLocal.remove();
	}

	public static Context get() {
		return (Context) userThreadLocal.get();
	}
}

class BusinessService {

	public void businessMethod() {
		// get the context from thread local
		Context context = MyThreadLocal.get();
		System.out.println(context.getTransactionId());
	}
}