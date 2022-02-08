package zookeeper1;

public class Mammal {
	private int energyLevel;
	
	public Mammal() {
		this.energyLevel = 100;
	}
	
	public int getEnergyLevel() {
		return energyLevel;
	}
	
	public void setEnergyLevel(int energy) {
		this.energyLevel = this.energyLevel + energy;
	}
	
	public int displayEnergy() {
		System.out.println("Current energy level: " + this.energyLevel);
		return energyLevel;
	}

}
