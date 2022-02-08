package zookeeper1;

public class Mammal {
	private int energyLevel;
	
	public Mammal() {
		this.energyLevel = 100;
	}
	
	public int getEnergyLevel() {
		return energyLevel;
	}
	
	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = this.energyLevel + energyLevel;
	}
	
	public int displayEnergy() {
		System.out.println("Current energy level: " + this.energyLevel);
		return energyLevel;
	}

}
