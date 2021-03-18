package DependencyPrinciple;


public class Main {
	public static void main(String args[])
	{
	Phone phone=new Samsung();	
	Phone phone1=new Redmi();
	PhoneRepair process=new PhoneRepair();
	process.repairSteps(phone);
	process.repairSteps(phone1);
	}


}