/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TLD;

/**
 *
 * @author root
 */
import java.io.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class My implements Tag, Serializable {

    private PageContext pc = null;
    private Tag parent = null;
    private int var1 = 0;
    private int var2 = 0;
    private int out = 0;
    private String name = null;

    public void setPageContext(PageContext p) {
        pc = p;
    }

    public void setParent(Tag t) {
        parent = t;
    }

    public Tag getParent() {
        return parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
       
        this.name = name;
    }

 

    public int getVar1() {
        return var1;
    }

    public void setVar1(int var1) {
        this.var1 = var1;
    }

    public int getVar2() {
        return var2;
    }

    public void setVar2(int var2) {
        this.var2 = var2;
    }

    public int doStartTag() throws JspException {
        try {

            System.out.println("var1   " + var1);
            System.out.println("var2   " + var2);
            System.out.println("name   "+name);
            out = var1 + var2;
			if (out != 0) {
				pc.getOut().write("<h2> Answer is addition of var1 and var2 </h2> " + out + "<br>");
			}
			if (name != null) {
				pc.getOut().write("<h2>Reverse The String is </h2>" + reverseString(name) + "");
			}


        } catch (IOException e) {
            throw new JspTagException("An IOException occurred.");
        }
        return SKIP_BODY;
    }

    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }

    public void release() {
        pc = null;
        parent = null;
        name = null;

    }

    String reverseString(String a) {
        String c="";
       
        int b = a.length();
      
        for (int i =(b-1) ; i >=0; i--) {
            
            c=c+a.charAt(i);
            
        }

        return c;
    }
}
