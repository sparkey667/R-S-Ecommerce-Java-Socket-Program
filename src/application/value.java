//Dheric Seney
//COMP1150-01
//Final Project
//6 December 2017

package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class value {
	private final SimpleStringProperty FName;
	private final SimpleStringProperty LName;
	private final SimpleStringProperty product;
	private final SimpleStringProperty contact;
	private final SimpleStringProperty price;
	
	value(String FName, String LName, String product, String contact, String price){
			this.FName = new SimpleStringProperty(FName);
			this.LName = new SimpleStringProperty(LName);
			this.product = new SimpleStringProperty(product);
			this.contact = new SimpleStringProperty(contact);
			this.price = new SimpleStringProperty(price);
	}
	public String getFName(){
		return FName.get();
	}
	public void setFName(String FirstName){
		FName.set(FirstName);	
	}
	public StringProperty propertyFName(){
		return FName;
	}
	public String getLName(){
		return LName.get();
	}
	public void setLName(String LastName){
		LName.set(LastName);	
	}
	public StringProperty propertyLName(){
		return LName;
	}
	public String getProduct(){
		return product.get();
	}
	public void setProduct(String value){
		product.set(value);	
	}
	public StringProperty propertyProduct(){
		return product;
	}
	public String getContact(){
		return contact.get();
	}
	public void setContact(String number){
		contact.set(number);	
	}
	public StringProperty propertyContact(){
		return contact;
	}
	public String getPrice(){
		return price.get();
	}
	public void setPrice(String money){
		price.set(money);	
	}
	public StringProperty propertyPrice(){
		return price;
	}
	
}
