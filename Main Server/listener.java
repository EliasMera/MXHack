import java.net.*;
import java.io.*;
import java.util.*;
public class listener extends Thread{
	private ServerSocket serv=null;
	private ArrayList<String> sessions=null;
	private ArrayList<Conexion> conexiones;
	public listener(ServerSocket se,ArrayList<String> s)throws IOException{
		this.serv = se;
		this.sessions = s;
		conexiones = new ArrayList<Conexion>();
	}
	public void run(){
		try{
		if (serv == null)
			return;
		while(!serv.isClosed()){
			Socket cliente = serv.accept();
			Conexion c = new Conexion(cliente,sessions);
			c.start();
			conexiones.add(c);
		}
		}catch(IOException e){
			System.out.println("IO: "+e);
		}
		Iterator<Conexion> it = conexiones.iterator();
		while(it.hasNext()){
			Conexion c = it.next();
			c.stop();
		}
	}

}