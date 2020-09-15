// Shane Cranor and Louis Miller

class Main {
public static void main(String[] args) {
		Stove stove = new Stove();
		
		System.out.println("Beginning stove state ");
		// trun the burners up
		stove.displayStove();
		stove.turnBurnersUp();
		stove.timePassing(6);
		System.out.println("\nStove after burners turned up ");
		
		// adjust the burners
		stove.displayStove();
		stove.adjustBurners();
		stove.timePassing(2);
		System.out.println("\nStove after burners adjusted ");
		
		// some more adjustment test
		stove.displayStove();
		stove.moreBurnerAdjustments();
		stove.timePassing(1);
		
		// Ensure temperatures don't update till time has passed
		System.out.println("\nStove waiting for time to elapse ");
		stove.displayStove();
		stove.timePassing(69);
		System.out.println("\nStove in final state ");
		stove.displayStove();	
	}
}