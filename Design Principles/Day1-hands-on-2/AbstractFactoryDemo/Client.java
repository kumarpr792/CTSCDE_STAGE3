package AbstractFactoryDemo;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Factory f=FactoryGetter.createCar("Audi");
		Headlight h=f.makeHeadLight();
		Tire t=f.makeTire();
		h.makeHeadLight();
		t.makeTire();
		Factory f1=FactoryGetter.createCar("Mercedes");
		Headlight h1=f1.makeHeadLight();
		Tire t1=f1.makeTire();
		h1.makeHeadLight();
		t1.makeTire();
	}

}
