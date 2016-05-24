
package marketsss;
import java.util.*;

public class SalesStaff extends Employee{
	Scanner scan=new Scanner(System.in);
	SalesStaff(String name,String ID,String password){
		super(name,ID,password);
	}
	
	public void cancel(Product p){
		System.out.println("Do you want to cancle your order? : Y/N ");
		String n=scan.next();
		if(n.compareTo("Y")==0||n.compareTo("y")==0){
			
		}
	}
}