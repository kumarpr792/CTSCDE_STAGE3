package MediatorPattern;
public class Client {
	
	public static void main(String[] args) {
		ChatMediator chatMediator=new ChatMediator();
		BasicUser bu=new BasicUser("ramesh", chatMediator);
		PremiumUser pu=new PremiumUser("kumar", chatMediator);
		PremiumUser pu2=new PremiumUser("Abc", chatMediator);
		BasicUser bu1=new BasicUser("ramesh1", chatMediator);
		
		chatMediator.AddUser(pu);
		chatMediator.AddUser(pu2);
		String name=bu.getName();
		
		bu.SendMessage(name, "Hi All");
	}
}