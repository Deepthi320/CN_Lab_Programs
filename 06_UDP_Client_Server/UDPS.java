import java.io.*;
import java.net.*;
class UDPS
{
public static void main(String args[]) throws Exception
{
DatagramSocket serversocket=new DatagramSocket(9876);
byte[] sendbuffer=new byte[1024];
byte[] receivebuffer=new byte[1024];
while(true)
{
DatagramPacket receivepacket=new
DatagramPacket(receivebuffer,receivebuffer.length);
serversocket.receive(receivepacket);
InetAddress ip=receivepacket.getAddress();
int portno=receivepacket.getPort();
String clientdata=new String(receivepacket.getData(),0,receivepacket.getLength());
System.out.println("clientmsg"+clientdata);
System.out.println("Server\n");
BufferedReader serverread=new BufferedReader(new
InputStreamReader(System.in));
String serverdata=serverread.readLine();
sendbuffer=serverdata.getBytes();
DatagramPacket sendpacket=new
DatagramPacket(sendbuffer,sendbuffer.length,ip,portno);
serversocket.send(sendpacket);
}
}
}
