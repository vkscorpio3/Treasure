/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Basic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ganesan
 */
public class validatiion {

    public static void main(String f[]) {
        String field = "ganesan/***-";
        Pattern pattern = Pattern.compile("[/:<>!~@$%^&()+=?()\"|!\\[#$-]");
        Matcher patternMatcher = pattern.matcher(field.subSequence(0, field.length()));
        System.out.println(field.subSequence(0, 4));
        if (patternMatcher.find() == true) {
            System.out.println("gioutyrt");
        } else {
            System.out.println(" no");
        }


        String email = "ganesan@gmailr.c0";
        Pattern p = Pattern.compile("[a-zA-Z]*[0-9]*@[a-zA-Z]*.[a-zA-Z]*");
        Matcher m = p.matcher(email);
        boolean b = m.matches();

        if (b) {
            System.out.println("email is rigth");
        } else {
            System.out.println("email is wrong");

        }

        String no = "+9678452136689955";
        Pattern p1 = Pattern.compile("[+-]?[\\d,]+\\.?\\d+");
        Matcher m1 = p1.matcher(no);
        boolean b1 = m1.matches();

        if (b1) {
            System.out.println("No is rigth");
        } else {
            System.out.println("No is wrong");

        }

        // String sPhoneNumber = "605-8889999";
        //String sPhoneNumber = "vbjmnill";
        String sPhoneNumber = "6058889990";

        //Pattern patternnum = Pattern.compile("\\d{3}-\\d{7}");
        Pattern patternnum = Pattern.compile("\\d{10}");
        Matcher matcher = patternnum.matcher(sPhoneNumber);

        if (matcher.matches()) {
            System.out.println("Phone Number Valid");
        } else {
            System.out.println("Phone Number must be in the form XXX-XXXXXXX");
        }
    }

    public boolean containsOnlyNumbers(String str) {


        if (str == null || str.length() == 0) {
            return true;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }
}



