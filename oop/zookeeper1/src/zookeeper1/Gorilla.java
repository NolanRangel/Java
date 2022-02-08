package zookeeper1;

public class Gorilla extends Mammal {

	public void throwItem() {
		System.out.println("Gorilla has thrown something! Energy reduced by 5");
		super.setEnergyLevel(-5);
	}
	
	public void eatBanana() {
		System.out.println("Gorilla eaten a banana! Energy increased by 10");
		super.setEnergyLevel(10);
	}
	
	public void climb() {
		System.out.println("Gorilla is climbing! Energy reduced by 10");
		super.setEnergyLevel(-10);
	}

}
