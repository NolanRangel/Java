package zookeeper1;

public class Bat extends Mammal {
	public Bat() {
		super.setEnergyLevel(200);
	}

	public void fly() {
		System.out.println("*Fluttering Noises*");
		super.setEnergyLevel(-50);
	}
	public void eatHuman() {
		System.out.println("OMG THAT BAT IS EATING THAT DUDES FACE!");
		super.setEnergyLevel(25);
	}
	public void attackTown() {
		System.out.print("*Sounds of a town on fire...*");
		super.setEnergyLevel(-100);
	}
	

}
