//Dheric Seney
//COMP1150-01
//Final Project
//6 December 2017

package application;
//socket imports
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

// sql statement imports
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Server{

	 public static void main(String args[]) throws IOException{
		int port = 7000;
		
		 DataInputStream inbuffer;
		 DataOutputStream outbuffer;
		 Socket socket;
		 
		 try{
			 ServerSocket serverSocket = new ServerSocket(port);
			 socket = serverSocket.accept();
			 inbuffer = new DataInputStream(socket.getInputStream());
			 outbuffer = new DataOutputStream(socket.getOutputStream()); 
			 BufferedReader SBuffer = new BufferedReader(new InputStreamReader(System.in));	
		
			 String inServer= "";
			 //String outServer = "";
			 String CLientFName = "What is your First Name";
			 String CLientLName = "What is your Last Name";
			 String CLientcontact = "What is your phone or email";
			 String CLientproduct = "What are you selling";
			 String Clientdelete = "What item do you want to delete?";
			 String Clientprice = "How much are you selling it for?";
			 String Clientrun = "Do you want to keep going? [end] to stop";
			 String insert;
			 String error = "You did not enter the right letter!";
			 String FName = "";
			 String LName = "";
			 String contact = "";
			 String product = "";
			 String price ="";
			 	//get Connected
			 Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","username","password"); //insert your username and password in the spaces
			 	//statement
			 Statement statement = connect.createStatement();
			 	//execute sql qry
			 while(!inServer.equals("end")){
				insert = inbuffer.readUTF();
				System.out.println(insert);
				
				if(insert.equals("S")){
				outbuffer.writeUTF(CLientFName);
				FName = inbuffer.readUTF();
				outbuffer.writeUTF(CLientLName);
				LName = inbuffer.readUTF();
				outbuffer.writeUTF(CLientcontact);
				contact = inbuffer.readUTF();
				outbuffer.writeUTF(CLientproduct);
				product = inbuffer.readUTF();
				outbuffer.writeUTF(Clientprice);
				price = inbuffer.readUTF();
				String sqlinsert = "insert into products"
						+ "(FName, LName, Contact, Product, Price)"
						+"values ('" + FName + "' , '" + LName + "' , '" + contact + "' , '" + product + "' , '" + price + "')";
				statement.executeUpdate(sqlinsert);
				}
				else if(insert.equals("D")){
					outbuffer.writeUTF(CLientFName);
					FName = inbuffer.readUTF();
					outbuffer.writeUTF(CLientLName);
					LName = inbuffer.readUTF();
					outbuffer.writeUTF(Clientdelete);
					product = inbuffer.readUTF();

					String sqlDelete = "DELETE FROM products WHERE FNAME = '"
							+ FName + "' && LNAME = '" 
							+ LName + "' && Product = '" 
							+ product+ "'";
					statement.executeUpdate(sqlDelete);
				}
					
				else if(insert.equals("V")){
					outbuffer.writeUTF("Launching Program");
					inServer = inbuffer.readUTF();
					if(inServer.equals("end")){
						outbuffer.writeUTF(inServer);
						System.out.println("Server Shut Down");
						inbuffer.close();
						outbuffer.close();
						socket.close();
						System.exit(0);
					}
				}else{
					outbuffer.writeUTF(error);
					System.out.println("Server Shut Down");
					inbuffer.close();
					outbuffer.close();
					socket.close();
					System.exit(0);
				}
				outbuffer.writeUTF(Clientrun);
				inServer = inbuffer.readUTF();
				//System.out.println(inServer);
				if(inServer.equals("end")){
					outbuffer.writeUTF(inServer);
					System.out.println("Server Shut Down");
					inbuffer.close();
					outbuffer.close();
					socket.close();
					System.exit(0);
				}
                //inServer = inbuffer.readUTF(); reads clients input
                //System.out.println(inServer);   writes it down
                //outServer = SBuffer.readLine();  reads servers input
                //outbuffer.writeUTF(outServer);	sends it to client
              
           
		 
				
		}
			 	System.out.println("Server Shut Down");
			 	inbuffer.close();
				outbuffer.close();
				socket.close();
	 }catch(IOException e){
        	  System.out.println(e.getMessage());
        	  System.out.println("HELP ME");
        	  System.exit(0);;
     } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	 }

	 }	 	 
}


