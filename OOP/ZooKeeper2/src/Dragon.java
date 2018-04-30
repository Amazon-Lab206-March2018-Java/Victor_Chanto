
public class Dragon {
	private int energyLevel;

	public Dragon() {
		this.energyLevel = 300;
	}
	public void fly() {
		System.out.println("Suoshhhh, Dragon taking off");
		this.energyLevel= this.energyLevel-50;
	}
	public void eatHumans() {
		System.out.println("never mind, the Dragon ate a Human X.X");
		this.energyLevel= this.energyLevel+25;
	}
	public void attackTown() {
		System.out.println("Fire Fire Help, the Dragon is burning everything x.x");
		this.energyLevel= this.energyLevel-100;
	}
	public int getEnergyLevel() {
		return energyLevel;
	}

}
