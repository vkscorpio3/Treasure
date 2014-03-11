package InnerClass;

public class innerclas {

    public static void main(String args[]) {
        System.out.println("Inner");

        sample s = new sample();
        //s.main(args);
        sample.InnerSample r = s.new InnerSample();
        String f = r.name();
        String d = new String();
        System.out.println(f);

            
      sample.InnerSample s1 = new sample().new InnerSample();

        sample.inte dd = new sample.inte();
        dd.name1();

        
        new innerclas().new aa(); 
        new bb();
       //new aa(); //not possible Static problem
    }

    class aa {

        aa() {
            System.out.println("Inner class");
            
        }
    }
    
    
static class bb {

        bb() {
            System.out.println("static Inner class");
        }
    }
}

class sample {

    sample.inte tt = new sample.inte();

    class InnerSample {

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