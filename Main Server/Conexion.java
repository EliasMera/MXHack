import java.net.*;
import java.io.*;
import java.util.*;
public class Conexion extends Thread{
	private Socket con = null;
	private PrintWriter out;
	private BufferedReader in;
	private ArrayList<String> sessions = null;
	private String id  = null;
	private int num;
	public Conexion(Socket c, ArrayList<String> s)throws IOException{
		this.con = c;
		this.sessions = s;
		out = new PrintWriter(con.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(con.getInputStream()));
	}
	public void run(){
		if(con == null || sessions == null)
			return;
		String name,number;
		try{
		name = in.readLine();
		number = in.readLine();
		id = name+"_"+number;
		num = sessions.size();
		sessions.add(id);
		String entrada = "";
		while(entrada != null){
			entrada = in.readLine();
			if(entrada != null)
			System.out.println(entrada);
		}
		sessions.remove(num);
		}catch(IOException e){
			System.out.println("IO: "+e);
		}
		}
	}
