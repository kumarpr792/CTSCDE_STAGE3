package AbstractFactoryDemo;

public class FactoryGetter {

	public static Factory createCar(String carName) {
		if(carName.equals("Audi")) 
			return new AudiFactory();
		else if(carName.equals("Mercedes"))
			return new MercedesFactory();
		else 
			return null;
	}
}
