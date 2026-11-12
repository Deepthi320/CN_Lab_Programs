import java.io.*;
import java.net.InetAddress;

public class GFG {
    public static void main(String[] args) throws Exception
    {
        // a variable of type InetAddress to store
        // the address of the local host
        InetAddress addr = InetAddress.getLocalHost();
        
        // Returns the IP address string in
        // textual presentation.
        System.out.println("Local HostAddress: " 
                + addr.getHostAddress());
                
        // Gets the host name for this IP address.
        System.out.println("Local host name: " 
                + addr.getHostName());
    }
}
