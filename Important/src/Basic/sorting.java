/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Basic;

/**
 *
 * @author ganesan
 */
public class sorting {

    sorting(){
        System.out.println("Default");
    }
    sorting( int i){
        System.out.println("Default "+ i);
    }
    static void method(){
        System.out.println("metod");
    }
    public static void main(String a[]){

        a A= new a();
        //this.method();Instance ref
        sorting.method();//class ref
        
    }
}
class a extends sorting{
    a(){
        super(6);
       
    }
}
