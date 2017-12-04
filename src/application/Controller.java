//Dheric Seney
//COMP1150-01
//Final Project
//6 December 2017

package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller implements Initializable {
	@FXML
	private Button Submit;
	
	@FXML
	private Button FilterProduct;
	@FXML
	private Button FilterFName;
	@FXML
	private Button FilterLName;
	@FXML
	private Button FilterMaxPrice;
	@FXML
	private Button FilterMinPrice;
	@FXML
	private Button FilterContact;
	
	@FXML
	private TextField filterProduct;
	@FXML
	private TextField filterFName;
	@FXML
	private TextField filterLName;
	@FXML
	private TextField filterContact;
	@FXML
	private TextField filterPrice;

	@FXML 
	private TableView<value> columnName;
	@FXML
	private TableColumn<value, String> ColFName;
	@FXML
	private TableColumn<value, String> ColLName;
	@FXML
	private TableColumn<value, String> ColContact;
	@FXML
	private TableColumn<value, String> ColProduct;
	@FXML
	private TableColumn<value, String> ColPrice;
	
	private ObservableList<value> columnValues;
	private EcommerceConnection EC;
	
	@Override
	public void initialize(URL url, ResourceBundle rb){
		EC = new EcommerceConnection();
	}
	@FXML
	private void getData(ActionEvent event){
		try{
			Connection conn = EC.Connect();
			columnValues = FXCollections.observableArrayList();
			ResultSet myRs = conn.createStatement().executeQuery("SELECT * FROM products");
			//process results
			while(myRs.next()){
				columnValues.add(new value(myRs.getString(1), myRs.getString(2), myRs.getString(4), myRs.getString(3), myRs.getString(5) )); //index represents the column number within the sql database
			}
		}catch(SQLException ex){
			//System.out.println(ex);
			System.out.println("SQL EXCEPTION ERROR" + ex);
		}
		ColFName.setCellValueFactory(new PropertyValueFactory<>("FName"));
		ColLName.setCellValueFactory(new PropertyValueFactory<>("LName"));
		ColContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
		ColProduct.setCellValueFactory(new PropertyValueFactory<>("product"));
		ColPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
		
		columnName.setItems(null);
		columnName.setItems(columnValues);
	}
	
	@FXML
	private void filterProduct(ActionEvent event){
		try{
			Connection conn = EC.Connect();
			columnValues = FXCollections.observableArrayList();
			String product = filterProduct.getText();
			ResultSet myRs = conn.createStatement().executeQuery("SELECT * FROM products WHERE product LIKE '%" + product+ "%'");
			//process results
			while(myRs.next()){
				columnValues.add(new value(myRs.getString(1), myRs.getString(2), myRs.getString(4), myRs.getString(3), myRs.getString(5) )); //index represents the column number within the sql database
			}
		}catch(SQLException ex){
			//System.out.println(ex);
			System.out.println("SQL EXCEPTION ERROR" + ex);
		}
		ColFName.setCellValueFactory(new PropertyValueFactory<>("FName"));
		ColLName.setCellValueFactory(new PropertyValueFactory<>("LName"));
		ColContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
		ColProduct.setCellValueFactory(new PropertyValueFactory<>("product"));
		ColPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
		
		columnName.setItems(null);
		columnName.setItems(columnValues);
	}
	
	@FXML
	private void filterFName(ActionEvent event){
		try{
			Connection conn = EC.Connect();
			columnValues = FXCollections.observableArrayList();
			String FirstName = filterFName.getText();
			ResultSet myRs = conn.createStatement().executeQuery("SELECT * FROM products WHERE FName LIKE '%"+ FirstName + "%'");
			//process results
			while(myRs.next()){
				columnValues.add(new value(myRs.getString(1), myRs.getString(2), myRs.getString(4), myRs.getString(3), myRs.getString(5) )); //index represents the column number within the sql database
			}
		}catch(SQLException ex){
			//System.out.println(ex);
			System.out.println("SQL EXCEPTION ERROR" + ex);
		}
		ColFName.setCellValueFactory(new PropertyValueFactory<>("FName"));
		ColLName.setCellValueFactory(new PropertyValueFactory<>("LName"));
		ColContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
		ColProduct.setCellValueFactory(new PropertyValueFactory<>("product"));
		ColPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
		
		columnName.setItems(null);
		columnName.setItems(columnValues);
	}
	@FXML
	private void filterLName(ActionEvent event){
		try{
			Connection conn = EC.Connect();
			columnValues = FXCollections.observableArrayList();
			String LastName = filterLName.getText();
			ResultSet myRs = conn.createStatement().executeQuery("SELECT * FROM products WHERE LName LIKE '%"+ LastName +"%'");
			//process results
			while(myRs.next()){
				columnValues.add(new value(myRs.getString(1), myRs.getString(2), myRs.getString(4), myRs.getString(3), myRs.getString(5) )); //index represents the column number within the sql database
			}
		}catch(SQLException ex){
			//System.out.println(ex);
			System.out.println("SQL EXCEPTION ERROR" + ex);
		}
		ColFName.setCellValueFactory(new PropertyValueFactory<>("FName"));
		ColLName.setCellValueFactory(new PropertyValueFactory<>("LName"));
		ColContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
		ColProduct.setCellValueFactory(new PropertyValueFactory<>("product"));
		ColPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
		
		columnName.setItems(null);
		columnName.setItems(columnValues);
	}
	@FXML
	private void filterContact(ActionEvent event){
		try{
			Connection conn = EC.Connect();
			columnValues = FXCollections.observableArrayList();
			String contact = filterContact.getText();
			ResultSet myRs = conn.createStatement().executeQuery("SELECT * FROM products WHERE contact LIKE '%"+ contact +"%'");
			//process results
			while(myRs.next()){
				columnValues.add(new value(myRs.getString(1), myRs.getString(2), myRs.getString(4), myRs.getString(3), myRs.getString(5) )); //index represents the column number within the sql database
			}
		}catch(SQLException ex){
			//System.out.println(ex);
			System.out.println("SQL EXCEPTION ERROR" + ex);
		}
		ColFName.setCellValueFactory(new PropertyValueFactory<>("FName"));
		ColLName.setCellValueFactory(new PropertyValueFactory<>("LName"));
		ColContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
		ColProduct.setCellValueFactory(new PropertyValueFactory<>("product"));
		ColPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
		
		columnName.setItems(null);
		columnName.setItems(columnValues);
	}
	@FXML
	private void filterMinPrice(ActionEvent event){
		try{
			Connection conn = EC.Connect();
			columnValues = FXCollections.observableArrayList();
			String price = filterPrice.getText();
			ResultSet myRs = conn.createStatement().executeQuery("SELECT * FROM products WHERE price > '"+ price + "'");
			//process results
			while(myRs.next()){
				columnValues.add(new value(myRs.getString(1), myRs.getString(2), myRs.getString(4), myRs.getString(3), myRs.getString(5) )); //index represents the column number within the sql database
			}
		}catch(SQLException ex){
			//System.out.println(ex);
			System.out.println("SQL EXCEPTION ERROR" + ex);
		}
		ColFName.setCellValueFactory(new PropertyValueFactory<>("FName"));
		ColLName.setCellValueFactory(new PropertyValueFactory<>("LName"));
		ColContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
		ColProduct.setCellValueFactory(new PropertyValueFactory<>("product"));
		ColPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
		
		columnName.setItems(null);
		columnName.setItems(columnValues);
	}
	@FXML
	private void filterMaxPrice(ActionEvent event){
		try{
			Connection conn = EC.Connect();
			columnValues = FXCollections.observableArrayList();
			String price = filterPrice.getText();
			ResultSet myRs = conn.createStatement().executeQuery("SELECT * FROM products WHERE price < '"+ price + "'");
			//process results
			while(myRs.next()){
				columnValues.add(new value(myRs.getString(1), myRs.getString(2), myRs.getString(4), myRs.getString(3), myRs.getString(5) )); //index represents the column number within the sql database
			}
		}catch(SQLException ex){
			//System.out.println(ex);
			System.out.println("SQL EXCEPTION ERROR" + ex);
		}
		ColFName.setCellValueFactory(new PropertyValueFactory<>("FName"));
		ColLName.setCellValueFactory(new PropertyValueFactory<>("LName"));
		ColContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
		ColProduct.setCellValueFactory(new PropertyValueFactory<>("product"));
		ColPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
		
		columnName.setItems(null);
		columnName.setItems(columnValues);
	}
}
