
public abstract class Upgrade {

	Ability upgradedAbility;
	
	Upgrade(Ability upgrade) {
		upgradedAbility = upgrade;
	}
	
	public abstract void runBehavior();

}
