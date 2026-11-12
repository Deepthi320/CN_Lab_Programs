import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
public class TCPServer
{
public static void main(String args[]) throws Exception
{
ServerSocket sersock = new ServerSocket(4000);
System.out.println("Sever ready for Connection");
Socket sock = sersock.accept();
System.out.println("Waiting for filename");
InputStream istream = sock.getInputStream();
BufferedReader br = new BufferedReader(new InputStreamReader(istream));
String fname = br.readLine();
OutputStream ostream = sock.getOutputStream();
PrintWriter pwrite = new PrintWriter(ostream,true);
String str;
try{
BufferedReader contentRead = new BufferedReader(new FileReader(fname));
while((str= contentRead.readLine())!=null)
{
pwrite.println(str);
}
contentRead.close();
System.out.println("File Contents sent Successfully");
}
catch (FileNotFoundException e){
pwrite.println("File Not Found at the Server");
System.out.println("File Not Found");
}
pwrite.close();
sock.close();
sersock.close();
}
}
