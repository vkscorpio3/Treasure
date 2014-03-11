/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package comparator;

import java.util.Comparator;

/**
 *
 * @author ganesan
 */
public class EmpDeptComparator implements Comparator {

	public int compare(Object obj1, Object obj2) {
		String empDept1 = ((EmpVo)obj1).getEmpDept();
		String empDept2 = ((EmpVo)obj2).getEmpDept();

		return empDept1.compareTo(empDept2);
	}
}
