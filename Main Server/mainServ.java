import java.net.*;
import java.io.*;
import java.util.*;
public class mainServ{
	private static ArrayList<String> sessions = null;
	private static BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException{
		sessions = new ArrayList<String>();
		ServerSocket sock = new ServerSocket(12345);
		listener serv = new listener(sock,sessions);
		serv.start();
		System.out.println("A la escucha");
		String opcion = "";
		do{
			System.out.println("A) mostrar sesiones activas");
			System.out.println("E) salir");
			opcion = stdIn.readLine();
			
			if(opcion.equals("A")|| opcion.equals("a")){
				
				Iterator<String> it = sessions.iterator();
				while(it.hasNext()){
					String s = it.next();
					System.out.println(s);
				}
			}
		}while(!opcion.equals("E"));
		sock.close();
		serv.stop();
	}

}