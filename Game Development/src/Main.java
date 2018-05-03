public class Main {
	static Enemy enemy;
	
	public static void main (String[] args) {
		System.out.println("Let's start working!");
		System.out.println("Ready to start coding, Luigi?"); // Yes!
		System.out.println("It shouldn't be this bad...");
		System.out.println("Yes. It shouldn't...");
		System.out.println("Programming robot... beep boop!");
		//System.out.println("This is called merging!");
		//Commenting is fun, so much fun!
		System.out.println("It shouldn't be thIS                      As bad...");
		/* System.out.println("Yes. It shouldn't...");
		System.out.println("Programming robot... beep   boom!");
		System.out.println("This is called merging!"); */
		//Testing thing
		System.out.println("Enemy has attacked!");
		enemy = new Enemy();
		enemy.doda();
		enemy.attack();
	}
}
