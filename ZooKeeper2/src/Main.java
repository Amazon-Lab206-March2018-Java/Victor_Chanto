
public class Main {

	public static void main(String[] args) {
		Dragon Bob =new Dragon();
		Bob.fly();
		System.out.println(Bob.getEnergyLevel());
		Bob.eatHumans();
		System.out.println(Bob.getEnergyLevel());
		Bob.attackTown();
		System.out.println(Bob.getEnergyLevel());
	}

}
