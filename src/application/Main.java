//Dheric Seney
//COMP1150-01
//Final Project
//6 December 2017

package application;
////javaFX
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
//client
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/application/view.fxml"));
			Scene scene = new Scene(root,900,450);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		DataInputStream in;
		DataOutputStream out;
		int port = 7000;
		Socket socket;
		
		String FName, LName, contact, product;
		String price;
		String insert;
		try{
			socket = new Socket("", port); //insert your the servers ipaddress here
			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());
			BufferedReader SBuffer = new BufferedReader(new InputStreamReader(System.in));	
			String inClient= "";
			String outClient="";
			String terminate = "end";
//			System.out.println("What would you like to do? [S] Sell [D] Delete [V] View");
//			insert = SBuffer.readLine();
//			out.writeUTF(insert);		
			while(!inClient.equals("end")){
				System.out.println("What would you like to do? [S] Sell [D] Delete [V] View");
				insert = SBuffer.readLine();
				out.writeUTF(insert);		
				if((insert.equals("S"))){
					//first name input
					inClient=in.readUTF();						//gets servers response
					System.out.println(inClient);	 			//prints the response
					FName = SBuffer.readLine(); 				//gets users input
					out.writeUTF(FName);						//sends it to server
					//last name input
					inClient=in.readUTF();						
					System.out.println(inClient);	 			
					LName = SBuffer.readLine(); 			
					out.writeUTF(LName);	
					//contact input
					inClient=in.readUTF();						
					System.out.println(inClient);	 			
					contact = SBuffer.readLine(); 			
					out.writeUTF(contact);	
					//product input
					inClient=in.readUTF();						
					System.out.println(inClient);	 			
					product = SBuffer.readLine(); 			
					out.writeUTF(product);
					//price input
					inClient=in.readUTF();						
					System.out.println(inClient);	 			
					price = SBuffer.readLine(); 			
					out.writeUTF(price);	
					
				}
				else if(insert.equals("D")){
					//first name input
					inClient=in.readUTF();						//gets servers response
					System.out.println(inClient);	 			//prints the response
					FName = SBuffer.readLine(); 			//gets users input
					out.writeUTF(FName);					//sends it to server
					//last name input
					inClient=in.readUTF();						
					System.out.println(inClient);	 			
					LName = SBuffer.readLine(); 			
					out.writeUTF(LName);
					//product input
					inClient=in.readUTF();						
					System.out.println(inClient);	 			
					product = SBuffer.readLine(); 			
					out.writeUTF(product);
				}
				else if(insert.equals("V")){
					launch(args);
					out.writeUTF(terminate);
					System.out.println("Client Shut Down");
					in.close();
					out.close();
					socket.close();
					System.exit(0);
				}
				else{
					System.out.println("Client Shut Down");
					System.exit(0);
				}
				inClient = in.readUTF();
				System.out.println(inClient);
				outClient = SBuffer.readLine();
				out.writeUTF(outClient);
				
//			System.out.println("Write Something");
//			outClient = SBuffer.readLine(); gets users input
//			out.writeUTF(outClient);		sends it to server
//			inClient=in.readUTF();			gets servers respose
//			System.out.println(inClient);	prints the respomse
			}
		System.out.println("Client Shut Down");
		in.close();
		out.close();
		socket.close();
		System.exit(0);		
		}catch(Exception exc){
			exc.printStackTrace();
		}	
		
	}
}

