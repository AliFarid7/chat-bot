
package chatbot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;


public class Server {
    public static void main (String argv[]) throws IOException {
        String reply = " ";
        String txtFromClient = " ";
         //listen & Acccept   
         ServerSocket listner =  new ServerSocket(9090);
         Socket sc = listner.accept();
        //writer and reader Decorators
        BufferedReader in = new  BufferedReader (new InputStreamReader(sc.getInputStream()));
        PrintWriter out = new PrintWriter(sc.getOutputStream());
        
        //Get host IP Address         
       InetAddress ip = InetAddress.getLocalHost(); 
       String hostname = ip.getHostName();
        //Get date 
        Date date;  
       //Communiate
       while (true ) {
        //read from Socket 
         txtFromClient = in.readLine(); // concert it to lower case to avoid miss-writing 
         if (txtFromClient == null) {
             break;
         }
      switch(txtFromClient) {
          case "Who are you?":
              reply = "I am FUE Bot! here to help you navigte our online services";
           break;
        case "How can I see the calander?":
              reply = "http://www.fue.edu.eg/Calendar.aspx";
             break;
        case "How can I see my inbox?":
           reply =  "https://services.fue.edu.eg/fuestudentportal/messaging-inbox.aspx";
           break;
        case "How can I see my attendence?":
            reply = "https://services.fue.edu.eg/fuestudentportal/MyAttendence.aspx";
            break;
            case "How can I see my result?":
            reply ="https://services.fue.edu.eg/fuestudentportal/StudentResult.aspx";
            break;
            case "How can I see the moodle?":
            reply ="https://moodle.fue.edu.eg/my/";
           break;
            case "How do I log in?":
            reply = "https://services.fue.edu.eg/";
           break;
            case "How do I know my financial info?":
            reply ="https://services.fue.edu.eg/fuestudentportal/Financial.aspx";
                 break;
                    case "How do I see my notifications?":            
            reply ="https://services.fue.edu.eg/fuestudentportal/Announcemnets.aspx";
                break;
                    case "How do I see my profile?":            
            reply ="https://services.fue.edu.eg/fuestudentportal/ProfileMainData.aspx";
                   break;
                    case "How do I see my contact info?":            
            reply ="https://services.fue.edu.eg/fuestudentportal/ProfileContactInfo.aspx";
                   break;
          default:
              reply="You did not enter a valid question. Please try again";
              break;
          }
        
        ///write to socket   
         out.println(reply);
         out.flush();    
       }  
           
        sc.close();
        listner.close();

     
  }
         
       
}
