import java.net.*;
import java.io.*;
public class TCPClient
{
public static void main(String args[]) throws Exception
{
Socket clientsock=new Socket("127.0.0.1",4000);
System.out.println("Connection Successfull");
System.out.println("Enter the File Name\n");
BufferedReader br = new BufferedReader(new
InputStreamReader(System.in));
String fname = br.readLine();
OutputStream ostream =clientsock.getOutputStream();
PrintWriter pwrite = new PrintWriter(ostream,true);
pwrite.println(fname);
InputStream istream = clientsock.getInputStream();
BufferedReader socketRead = new BufferedReader(new
InputStreamReader(istream));
String str;
while((str=socketRead.readLine())!=null)
{
System.out.println(str);
}
}
}
