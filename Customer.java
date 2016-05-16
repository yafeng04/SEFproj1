package market2;

public class Customer {
	private String name;
	private int ID;
	private int point;
	private double balance;
	
	Customer(){	
	}
	Customer(String name, int ID){
		this.name=name;
		this.ID=ID;
		this.point=0;
		this.balance=0;
	}
	
	Customer(String name, int ID, int point){
		this.name=name;
		this.ID=ID;
		this.point=point;
	}
	public String getName() {
		return name;
	}
	public int getID() {
		return ID;
	}
	public int getPoint() {
		return point;
	}
	public double getBalance(){
		return balance;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
}
