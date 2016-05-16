package market2;

public class Product {
	private int ID;
	private String name;
	private int qty;
	private double unitPrice;
	private double rate;
	
	Product(int ID,String name,int qty,double price){
		this.ID=ID;
		this.name=name;
		this.qty=qty;
		this.unitPrice=price;
	}

	public int getID() {
		return ID;
	}

	public String getName() {
		return name;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public void setRate(double rate){
		this.rate=rate;
	}
	
	public double getRate(){
		return rate;
	}
	
	
}
