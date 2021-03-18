package DependencyPrinciple;

public class PhoneRepair {
	
	public void repairSteps(Phone phone)
	{
		String part1=phone.getPhonePart1();
		System.out.println("Repaired " +part1);
		
		double partCost=phone.getPart1Cost();
		System.out.println("Repaire cost " +partCost*0.5);
	}

}
