package market2;

public class Customer {
	private String name;
	private int ID;
	private int loyaltyPoint;
	private int validPoint;
	private double balance;
	
	Customer(){	
	}
	Customer(String name, int ID){
		this.name=name;
		this.ID=ID;
		this.loyaltyPoint=0;
		this.balance=0;
	}
	
	Customer(String name, int ID, int point){
		this.name=name;
		this.ID=ID;
		this.loyaltyPoint=point;
		this.balance=0;
	}
	public String getName() {
		return name;
	}
	public int getID() {
		return ID;
	}
	public int getLoyaltyPoint() {
		return loyaltyPoint;
	}
	public int getValidPoint(){
		return validPoint;
	}
	public double getBalance(){
		return balance;
	}
	public double recharge(double amount){
		return balance+=amount;
	}
	public void setLoyaltyPoint(int point) {
		this.loyaltyPoint = point;
	}
	public void setValidPoint(int point){
		this.validPoint=point;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void cost(Sale s) {
		this.balance = balance-s.realTP;
	}
	
	public void setLoyaltyPoint(Sale s) {
//		s.computeTotalPrice();
		int minusPoint;
		if(this.getLoyaltyPoint()>=20){
				minusPoint=(int)(s.getRealTP()/5)*20;
		}
		else minusPoint =0;
		int postLoyalPoint=(int) (this.getLoyaltyPoint()+(int)(s.getRealTP()/10)-minusPoint);		
		if(validPoint-minusPoint>=0)
			this.loyaltyPoint=postLoyalPoint-(minusPoint/4)/10;//minus the part incurred by the part already deducted
		else
			this.loyaltyPoint=this.getLoyaltyPoint()+(int)(s.getRealTP()/10)-validPoint-(validPoint/4)/10;
		
		 this.validPoint=(int)((this.getLoyaltyPoint())/20)*20;
//	return validPoint;
	}
}
