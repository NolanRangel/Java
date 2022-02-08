package zookeeper1;

public class MammalTest {

	public static void main(String[] args) {

		Gorilla harambe = new Gorilla();
		Bat lucky = new Bat();
		Bat charles = new Bat();
		
		harambe.throwItem();
		harambe.throwItem();
		harambe.throwItem();
		harambe.eatBanana();
		harambe.eatBanana();
		harambe.climb();
		
		charles.attackTown();
		charles.attackTown();
		charles.attackTown();
		charles.eatHuman();
		charles.eatHuman();
		charles.fly();
		charles.fly();
		
		harambe.displayEnergy();
		lucky.displayEnergy();
		charles.displayEnergy();

	}

}
