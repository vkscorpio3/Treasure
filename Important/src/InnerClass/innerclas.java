package InnerClass;

public class innerclas {

    public static void main(String args[]) {
        System.out.println("Inner");

        sample s = new sample();
        //s.main(args);
        sample.string r = s.new string();
        String f = r.name();
        String d = new String();
        System.out.println(f);

        String st = new String();

        //       System ss= new System();
        Integer k;
        // Another wat of creating a object
        sample.string s1 = new sample().new string();

        sample.inte dd = new sample.inte();
        dd.name1();
//        System.out.println(s2.name());
    //dd.name1();

    //new aa(); Static problem
    }

    class aa {

        aa() {
            System.out.println("Inner class");
        }
    }
}

class sample {

    sample.inte tt = new sample.inte();

    class string {

        inte nn = new inte();
        String dd = new inte().name1();

        String name() {
            System.out.println(dd);
            return "hi";
        }
    }

    static class inte {

        String name1() {

            return "hiiiii68";
        }
    }
}