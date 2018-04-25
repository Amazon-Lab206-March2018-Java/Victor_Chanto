
public class Main {

	public static void main(String[] args) {
		Gorilla George = new Gorilla();
		System.out.print(George.getEnergyLevel());
		George.throwSomething();
		George.climb();
		George.eatBananas();
		System.out.print(George.getEnergyLevel());
	}

}
