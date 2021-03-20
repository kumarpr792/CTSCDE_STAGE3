package AdaptorDemo;

public class Main {
	public static void main(String[] args) {
		Movable bugattiVeyron = new BugattiVeyron(); 
		MovableAdapter bugattiVeyronAdapter = new MovableAdapterImpl(bugattiVeyron);
		System.out.println(bugattiVeyron.getSpeed());
		System.out.println(bugattiVeyronAdapter.getSpeed());
	}
}
