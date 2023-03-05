
package chatbot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
   public static void main (String argv[]) throws IOException {
       
      String fromServer = " "; 
      String fromUser = " "; 
    //request 
        Socket sc =  new Socket ("127.0.0.1" , 9090);
    //Communicate 
        //Reader & Writer 
        BufferedReader in = new  BufferedReader (new InputStreamReader(sc.getInputStream()));
        PrintWriter out = new PrintWriter(sc.getOutputStream());
        Scanner scnr = new Scanner (System.in);
        //display msg 
        System.out.println("Enter a You Question and then press enter\nplease start with an upper-case letter and end with a question mark\nHave a nice day!");
        //loop until the user enter the tring bye
    while (!"bye".equals(fromUser = scnr.nextLine()) ) {
     //Write to socket       
        out.println(fromUser);   
        out.flush(); 
     // read from sokcet 
       fromServer = in.readLine();
     System.out.println(fromServer);  
    }      
     sc.close();
       
   }
}
