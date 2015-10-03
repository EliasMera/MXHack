public class User{
	private String id; //The id is the phone number
	private String name;
	public void setID(String i){
		this.id = i;
	}
	public String getID(){
		return this.id;
	}
	public User(String i, String n){
		this.id = i;
		this.name = n;
	}
}