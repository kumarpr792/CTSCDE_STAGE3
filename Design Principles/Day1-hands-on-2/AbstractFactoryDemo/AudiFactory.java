package AbstractFactoryDemo;

public class AudiFactory implements Factory{

	@Override
	public Headlight makeHeadLight() {
		// TODO Auto-generated method stub
		return new AudiHeadLight();
	}

	@Override
	public Tire makeTire() {
		// TODO Auto-generated method stub
		return new AudiTire();
	}

}
