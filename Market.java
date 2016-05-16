package market2;
import java.util.*;

public class Market {
	Scanner scan=new Scanner(System.in);
	private ArrayList<Customer> custs=new ArrayList<Customer>();
	private ArrayList<Employee> emps=new ArrayList<Employee>();
	private ArrayList<Product> prods=new ArrayList<Product>();
	private Employee employee=null;
	private Product product=null;
	private Customer customer=null;
	
	Market(){
		emps.add(new Manager("Shuan","1","pass"));
		prods.add(new Product(1,"Apple",100,2.0));
		prods.add(new Product(2,"Banana",100,1.5));
	}
	
	public void login(){
		int i;
		System.out.print("Please enter user name: ");
		String name=scan.next();
		System.out.print("Please enter user password: ");
		String password=scan.next();
		for(i=0;i<emps.size();i++){
			if(emps.get(i).getName().compareTo(name)==0&&emps.get(i).getPassword().compareTo(password)==0){
				System.out.println("Welcome "+emps.get(i).getName()+"! Current level is: "+emps.get(i).getClass());
			}
			else System.out.println("User name or password wrong!");
		}
		System.out.println("Please enter to continue.");
		scan.nextLine();
	}
	
	public static void main(String[] args){
		Market s = new Market();
		s.login();
	}
}
