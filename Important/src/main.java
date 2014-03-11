import java.util.ArrayList;
import java.util.List;

public class main {
	public static void main(String a[]) {

		ArrayList<Member> l = new ArrayList<Member>();

		l.add(new Member());
		l.add(new Member());

		for (Member m : l) {
			m.setName("a");
			System.out.println("y");

		}

		System.out.println(l.get(0).getName());
	}

}
