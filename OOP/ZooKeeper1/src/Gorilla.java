public class Gorilla extends Mammal {
	
	public Gorilla() {
		super();
	}
	public void throwSomething(){
		System.out.println("The gorilla has thrown something");
		super.setEnergyLevel(super.getEnergyLevel()-5);
	}
	public void eatBananas(){
		System.out.println("The gorilla is happy eating");
		super.setEnergyLevel(super.getEnergyLevel()+10);
	}
	public void climb(){
		System.out.println("The gorilla has climbed a tree");
		super.setEnergyLevel(super.getEnergyLevel()-10);
	}

}
