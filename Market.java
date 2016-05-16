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
		emps.add(new Manager("Shaun","1","pass"));
		prods.add(new Product(1,"Apple",100,2.0));
		prods.add(new Product(2,"Banana",100,1.5));
	}
	
	public void menu(){
		System.out.println("\t===Mini Market Self-Checkout System===");
		System.out.println("\t1.Show All Products");
		System.out.println("\t2.Edit Product Details(Manager Only)");
		System.out.println("\t3.Login");
		System.out.println("\t0.Exit");
	}
	
	public void showProduct(){
		System.out.println("\tProduct Name\tUnit Price\tQuantity Left");
		for(int i=0;i<prods.size();i++){
			System.out.println("\t"+prods.get(i).getName()+"\t"+prods.get(i).getUnitPrice()+"\t"+prods.get(i).getQty());
		}
	}
	
	public void edit(){
		if(employee instanceof Manager){
			System.out.println("Please choose what you want to edit");
			System.out.println("1.Edit Product Price");
			System.out.println("2.Edit Product Discount Rate");
			System.out.print("Enter your choice");
			int a=scan.nextInt();
			switch (a){
			case 1 : 
				System.out.println("Please enter product name: ");
				String name=scan.next();
				for(int i=0;i<prods.size();i++){
					if(prods.get(i).getName().compareTo(name)==0){
						this.product=prods.get(i);
					}
				}
				((Manager) employee).editPrice(product);
				break;
			case 2 :
				System.out.println("Please enter product name: ");
				name=scan.next();
				for(int i=0;i<prods.size();i++){
					if(prods.get(i).getName().compareTo(name)==0){
						this.product=prods.get(i);
					}
				}
				((Manager) employee).editRate(product);
				break;
			}
		}
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
				this.employee=emps.get(i);
			}
			else System.out.println("User name or password wrong!");
		}
		System.out.println("Please enter to continue.");
		scan.nextLine();
	}
	
	public void start(){
		int m;
		menu();
		do{
			m=scan.nextInt();
			switch(m){
			case 1 : showProduct();break;
			case 2 : edit();break;
			case 3 : login();break;
			case 0 : break;
			}
		}while(m!=0);
	}
	
	public static void main(String[] args){
		Market s = new Market();
		s.start();
	}
}
