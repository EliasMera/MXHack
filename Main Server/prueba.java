import java.util.*;
import java.io.*;
import java.net.*;
public class prueba{
	public static void main(String[] args)throws IOException{
		Socket con = new Socket("127.0.0.1",12345);
		 PrintWriter out =
        new PrintWriter(con.getOutputStream(), true);
    BufferedReader in =
        new BufferedReader(
            new InputStreamReader(con.getInputStream()));
    BufferedReader stdIn =
        new BufferedReader(
            new InputStreamReader(System.in));
	String mensaje = stdIn.readLine();
	out.println(mensaje);
	mensaje = stdIn.readLine();
	out.println(mensaje);
	mensaje = stdIn.readLine();
	out.println(mensaje);
	con.close();
	}
}