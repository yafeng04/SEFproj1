package marketsss;
import java.util.*;

public class Market {
	Scanner scan=new Scanner(System.in);
	private ArrayList<Customer> custs=new ArrayList<Customer>();
	private ArrayList<Employee> emps=new ArrayList<Employee>();
	private ArrayList<Product> prods=new ArrayList<Product>();
	private ArrayList<Sale> sales=new ArrayList<Sale>();
	private Employee employee=null;
	private Product product=null;
	private Customer customer=null;
	private Sale sale=null;
	private double max=0;

	
	Market(){
		custs.add(new Customer("Ashley",1,100));
		custs.add(new Customer("Oliver",2,0));
		custs.add(new Customer("Bob",3,0));
		custs.add(new Customer("Charlie",4,0));
		emps.add(new Manager("Shaun","1","pass"));
		emps.add(new WarehouseStaff("Ray","007","pass"));
		emps.add(new SalesStaff("David","3","pass"));
		
		prods.add(new Product(1,"Apple",5000,2.0));
		prods.add(new Product(2,"Banana",5000,1.5));
		prods.add(new Product(3,"Coke",5000,1.8));
		prods.add(new Product(4,"Donut",5000,3));
		prods.add(new Product(5,"Egg",5000, 4));
		prods.add(new Product(6,"Chips",5000,3.5));
		
		for(int i=0;i<prods.size();i++){

			prods.get(i).setShelfQty(2000);
			prods.get(i).setWholesaleItemQty(2000);
			prods.get(i).totalOrder=prods.get(i).getShelfQty()+prods.get(i).getStockQty();
		}
	}
	
	public ArrayList<Customer> getCusts() {
		return custs;
	}

	public void setCusts(ArrayList<Customer> custs) {
		this.custs = custs;
	}

	public ArrayList<Employee> getEmps() {
		return emps;
	}

	public void setEmps(ArrayList<Employee> emps) {
		this.emps = emps;
	}

	public ArrayList<Product> getProds() {
		return prods;
	}

	public void setProds(ArrayList<Product> prods) {
		this.prods = prods;
	}

	public void menu(){
		System.out.println("\t===Mini Market Self-Checkout System===");
		System.out.println("\t1.Show All Products currently available");
		System.out.println("\t2.Search Product");
		System.out.println("\t3.Search Bulk purchasing price");
		System.out.println("\t4.Purchase Products(Shopping)");
		System.out.println("\t5.Show Shopping cart");
		System.out.println("\t6.Customer Login And Recharge Account");
		System.out.println("\t7.Staff Options");
		System.out.println("\t8.Confirm shopping");
		System.out.println("\t9.Show Your Current Points and Balance");
		System.out.println("\t10.Log off");
		System.out.println("\t0.Exit");
	}
	
	public void staffMenu(){
		System.out.println("\t========Staff Operation System========");
		System.out.println("\t1.Check Shelf Level");
		System.out.println("\t2.Check Stock Level");
		System.out.println("\t3.Remove Item");
		System.out.println("\t4.Cancel Sale");
		System.out.println("\t6.Print Supply Report");
		System.out.println("\t7.Print Current Sales Report");
		System.out.println("\t8.Print product generating most revenue");
		System.out.println("\t9.Set Product Details");
		System.out.println("\t10.Add New Product To Warehouse");
		System.out.println("\t11.Show Shopping cart");
		System.out.println("\t0.Back To Last Menu");
	}
	
	public void custInfo(){
		if(customer!=null){
			System.out.println("Your current points: "+customer.getLoyaltyPoint());
			System.out.println("Your current balance: "+customer.getBalance());
		}
		else System.out.println("Please login as customer first!");
	}
	
	public void recharge(){
			System.out.print("Please enter the amount you want to recharge: ");
			double amt=scan.nextDouble();
			customer.setBalance(customer.getBalance()+amt);
	}
	
	public void showAllProduct(){
		System.out.println("\tProduct ID\tProduct Name\tUnit Price\tQuantity Left\tDiscount");
		for(int i=0;i<prods.size();i++){
			System.out.println("\t"+prods.get(i).getID()+"\t\t"+prods.get(i).getName()+"\t\t"+prods.get(i).getItemPrice()+"\t\t"+prods.get(i).getShelfQty()+"\t\t"+prods.get(i).getDisc()+"% off");
		}
	}
	
	public void checkProduct(){
		System.out.println("\tProduct ID\tProduct Name\tUnit Price\tQuantity Left");
		for(int i=0;i<prods.size();i++){
			System.out.println("\t"+prods.get(i).getID()+"\t\t"+prods.get(i).getName()+"\t\t"+prods.get(i).getItemPrice()+"\t\t"+prods.get(i).getStockQty());
		}
	}
	
	public void searchProduct(){
		if(customer!=null){
			System.out.print("Which type do you want to search by?\n");
			System.out.print("1.Product ID\n");
			System.out.print("2.Product Name\n");
			System.out.print("Please enter your choice: ");
			int n=scan.nextInt();
			switch(n){
			case 1 : 
				System.out.print("Enter the product ID: ");
				int i=scan.nextInt();
				for(int j=0;j<prods.size();j++){
					if(prods.get(j).getID()==i){
						System.out.println("\tProduct ID\tProduct Name\tUnit Price\tQuantity Left\tDiscount");
						System.out.println("\t"+prods.get(i-1).getID()+"\t\t"+prods.get(i-1).getName()+"\t\t"+prods.get(i-1).getItemPrice()+"\t\t"+prods.get(i-1).getShelfQty()+"\t\t"+prods.get(i).getDisc()+"% off");
					}
				}
				break;
			case 2 :
				System.out.print("Enter the product Name: ");
				String nm=scan.next();
				for(int j=0;j<prods.size();j++){
					if(prods.get(j).getName().compareTo(nm)==0){
						System.out.println("\tProduct ID\tProduct Name\tUnit Price\tQuantity Left\tDiscount");
						System.out.println("\t"+prods.get(j).getID()+"\t\t"+prods.get(j).getName()+"\t\t"+prods.get(j).getItemPrice()+"\t\t"+prods.get(j).getShelfQty()+"\t\t"+prods.get(j).getDisc()+"% off");
					}
				}
				break;
				
			}
			
		}
		else System.out.println("Please Login in first dear customer.");
	}
	
	public void searchBulkDiscount(){
		if(customer!=null){
			System.out.print("Enter the product ID: ");
			int i=scan.nextInt();
			for(int j=0;j<prods.size();j++){
				if(prods.get(j).getID()==i){
					System.out.println("If your purchasing quantities greater than "+prods.get(i-1).getWholesaleItemQty()+" : ");
					System.out.print("The product "+prods.get(i-1).getName()+" will have a "+(prods.get(i-1).getItemPrice()-prods.get(i-1).getWholesaleItemPrice())/prods.get(i-1).getItemPrice()*100+ "% discount.");
				}else if(i>prods.size()){
					System.out.println("Product ID "+(i-1)+" doesn't exsit. Please enter again.");
				}
			}
		}
		else System.out.println("Please Login in first dear customer.");
	}
	
	public void purchase(){
		if(customer!=null&&sale==null){
			sales.add(new Sale(customer,prods));
				this.sale=sales.get(sales.size()-1);
				System.out.println("enter date yy/mm/dd");
				int dateID=scan.nextInt();
				this.sale.ID=dateID*1000+sales.size();
		}
	}
	
	public void showShoppingCart(){
		if(customer!=null){
			if(sale==null) System.out.println("Nothing in your shopping cart");
			else {System.out.println("Customer "+customer.getName()+"'s list: ");

			for(int i=0;i<sale.list.size();i++){
//				for(int j=0;j<sales.get(i).list.size();j++){

					System.out.print("Sale "+sale.getID());
//					sales.get(i).list.get(j).print();
					sale.list.get(i).print();
				
			}
			}
		}
		else{System.out.println("login first !!");}
	}
	
	
	public void remove(){
		if(sale!=null){
		if(employee instanceof SalesStaff||employee instanceof Manager ){
			System.out.print("Please enter the product name you want to remove from this shopping: ");
			String name=scan.nextLine();
			int i;
			for (i=0;i<sale.list.size();i++){
				if(sale.list.get(i).getProduct().getName().compareTo(name)==0)
				this.sale.list.remove(i);
			}
			if(i==sale.list.size()+1){
				System.out.println("Invalid name, please enter again");
				remove();
			}
		}
		else System.out.println("log in as staff first");
		}
		else System.out.println("invalid option");
	}
	
	public void cancel(){
		if(sale!=null){
		if(employee instanceof SalesStaff||employee instanceof Manager){
		System.out.print("DO YOU WANT TO CANCEL YOUR ORDER? Y/N : ");
		String ch=scan.next();
			if(ch.compareTo("Y")==0||ch.compareTo("y")==0){
				for(int i=0;i<sale.list.size();i++){
					sale.list.get(i).getProduct().setShelfQty(sale.list.get(i).getProduct().getShelfQty()+sale.list.get(i).quantity);
				} //if stocklevel less than reorder limit, will reorder even if canceled
				sales.remove(sales.size()-1);
				this.sale=null;
			}
		}
		else System.out.println("log in as staff first");
		}
		else System.out.println("invalid option");
		}
	public void confirm(){
		if(customer!=null&&sale!=null){
			System.out.println("Would you confirm to pay your order? Y/N :");
			String ch=scan.next();
			if(ch.compareTo("Y")==0||ch.compareTo("y")==0){
				this.sale.realTotalPrice(customer);
				if(customer.getBalance()>=this.sale.realTP){
					System.out.println("Total price: "+sale.getTotalPrice());
					customer.setBalance(customer.getBalance()-this.sale.realTP);
					customer.setLoyaltyPoint(sale);
					for(int j=0;j<this.sale.list.size();j++){
						int before=this.sale.list.get(j).getProduct().getShelfQty();
						this.sale.list.get(j).getProduct().setStock();
						int after=this.sale.list.get(j).getProduct().getShelfQty();
						if(before!=after){System.out.println("shelf replenishment finished by warehouse staff");}
					}
					this.sale=null;
					
				}
				else{
					System.out.println("Your balance is not enough, please recharge first.");
				}
			}else{
				System.out.println("Please Login and make purchase.");
				sales.remove(sales.get(sales.size()-1));
				this.sale=null;
			}
		}
	}// not enough balance should change to customer login menu; Total price should be getrealtotalprice
	

	
	public void addProduct(){
		if(employee instanceof Manager||employee instanceof WarehouseStaff){
			System.out.print("Please enter new item name: ");
			String name=scan.next();
			System.out.print("Please enter new item quantity: ");
			int qty=scan.nextInt();
			System.out.print("Please enter new item unit price: ");
			double unitPrice=scan.nextDouble();
			int id=prods.size()+1;
			prods.add(new Product(id,name,qty,unitPrice));
		}else System.out.println("Invalid employee level! Please login as Manager or Warehouse Staff!");
	}
	
	public void edit(){
		if(employee instanceof Manager){
			System.out.println("Please choose what you want to edit");
			System.out.println("1.Edit Product Item Price");
			System.out.println("2.Edit Product Discount Rate");
			System.out.println("3.Set Product Whole Sale Quantity");
			System.out.println("4.Set Product Whole Sale Price");
			System.out.println("5.Set Replenish Level");
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
			case 3 :
				System.out.print("Please enter product name: ");
				name=scan.next();
				for(int i=0;i<prods.size();i++){
					if(prods.get(i).getName().compareTo(name)==0){
						this.product=prods.get(i);
					}
				}
				setWholeSaleQty();
				break;
			case 4 :
				System.out.print("Please enter product name: ");
				name=scan.next();
				for(int i=0;i<prods.size();i++){
					if(prods.get(i).getName().compareTo(name)==0){
						this.product=prods.get(i);
					}
				}
				setWholeSalePrice();
				break;
			case 5 : 
				System.out.println("Please enter product name: ");
				name=scan.next();
				for(int i=0;i<prods.size();i++){
					if(prods.get(i).getName().compareTo(name)==0){
						this.product=prods.get(i);
					}
				}
				((Manager) employee).setReplenishLevel(product);
				break;
			}
		}
		else System.out.println("Not Login Yet Or Invalid User Level.");
	}
	
	public void setWholeSaleQty(){
		System.out.print("Please enter the whole sale quantity: ");
		int n=scan.nextInt();
		product.setWholesaleItemQty(n);
	}
	
	public void setWholeSalePrice(){
		System.out.print("Please enter the whole sale price: ");
		double n=scan.nextDouble();
		product.setWholesaleItemPrice(n);
	}
	
	public void findMostRevenue(){
		for(int i=0;i<prods.size();i++){
			if(prods.get(i).totalRevenue>=max)
			max=prods.get(i).totalRevenue;
		}
		for(int i=0;i<prods.size();i++){
			if(prods.get(i).totalRevenue==max){
					System.out.println("The product that generated most revenue is "+ prods.get(i).getName()+" and the total revenue is " +max);
			}
		}
	}
	
	public void salesReport(double startdate, double enddate){
		double partialRevenue=0;
		double salesnum=0;
		if ( sales.size() == 0)
	         System.out.println("No current sales");
	    else {
		for(int i=0;i<sales.size();i++){
			if((Math.floor(sales.get(i).ID)>=startdate)&&(Math.floor(sales.get(i).ID)<=enddate+1000))
		{
			System.out.println("Sale " + sales.get(i).ID);
	          sales.get(i).print();
	         partialRevenue+=sales.get(i).realTP;
			salesnum+=1;
		}
		}
		if(salesnum==0){System.out.println("No sale in between those dates");}
  		System.out.println("total number of sale during this period is "+salesnum);
		System.out.println("the total revenue during this period is "+partialRevenue);
		}
	}
	public void supplyReport(){
		if ( prods.size() == 0)
	         System.out.println("No current products");
	    else {
	    	for(int i=0;i<prods.size();i++){
	    		System.out.println(prods.get(i).getName()+"   "+prods.get(i).totalOrder);
	    	}
	    }
	}
	
	public void custLogin(){
		int i;
		System.out.print("Please enter your name: ");
		String name=scan.next();
		System.out.print("Please enter your customer ID: ");
		int ID=scan.nextInt();
		for(i=0;i<custs.size();i++){
			if(custs.get(i).getName().compareTo(name)==0&&custs.get(i).getID()==ID){
				System.out.println("Welcome "+custs.get(i).getName()+"! Enjoy your shopping!");
				this.customer=custs.get(i);
				break;
			}
		}
		if(i==custs.size()){
			System.out.println("Username or ID Wrong!");
		}
		System.out.println("Please enter to continue.");
		scan.nextLine();
	}
	
	public void stafflogin(){
		int i;
		System.out.print("Please enter staff username: ");
		String name=scan.next();
		System.out.print("Please enter staff password: ");
		String password=scan.next();
		for(i=0;i<emps.size();i++){
			if(emps.get(i).getName().compareTo(name)==0&&emps.get(i).getPassword().compareTo(password)==0){
				System.out.println("Welcome "+emps.get(i).getName()+"! Current level is: "+emps.get(i).getClass());
				this.employee=emps.get(i);
				break;
			}
		}
		if(i==emps.size()){
			System.out.println("Username or Password Wrong!");
		}
	}
	
	public void logout(){
		this.customer=null;
		start();
	}
	public void start(){
		int m,n1 = 0;
		do{
			System.out.println();
			menu();
			System.out.print("Please enter your choice : ");
			m=scan.nextInt();
			switch(m){
			case 1 : showAllProduct();break;
			case 2 : searchProduct();break;
			case 3 : searchBulkDiscount();break;
			case 4 : purchase();break;
			case 5 : showShoppingCart();break;
			case 6 :
				custLogin();
				if(customer!=null){
					System.out.println("Your current balance is: $"+customer.getBalance());
					System.out.print("Do you want to recharge your balance? Y/N :");
					String ch=scan.next();
					if(ch.compareTo("y")==0||ch.compareTo("Y")==0){
						recharge();
					}
				}
				break;
			case 7 : 
				do{
					if(employee==null){
					System.out.println();
					stafflogin();}
					if(employee==null){
						System.out.println("Please login as a staff!");
					}
					if(employee instanceof Manager || employee instanceof WarehouseStaff || employee instanceof SalesStaff)
					{	staffMenu();
					System.out.print("Please enter your choice : ");
					n1=scan.nextInt();
					switch(n1){
					case 1 : showAllProduct();break;
					case 2 : checkProduct();break;
					case 3 : remove();break;
					case 4 : cancel();break;
					case 6 : supplyReport();break;
					case 7 : 
						System.out.print("Enter startdate (YY/MM/DD):");
						double sd=scan.nextDouble();
						System.out.print("Enter enddate (YY/MM/DD):");
						double ed=scan.nextDouble();
						salesReport(sd *1000,ed *1000);
						break;
					case 8 : findMostRevenue();break;
					case 9 : edit();break;
					case 10: addProduct();break;
					case 11: showShoppingCart();break;
					case 0 : 
						this.employee=null;
						break;
					}
					}
					System.out.println();
				}while(n1!=0);
				break;
			case 8 : confirm();break;
			case 9 : custInfo();break;
			case 10: logout(); break;
				case 0 : break;
				}
			System.out.println();
		}while(m!=0);
	}
	
	public static void main(String[] args){
		Market s = new Market();
		s.start();
	}
}
