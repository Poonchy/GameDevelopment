
public class Utility {

	public static boolean checkCollision(int onexPoS, int oneyPoS, int oneWidth, int oneHeight, int twoxPoS, int twoyPoS, int twoWidth, int twoHeight) {
		if(((( onexPoS + oneWidth >= twoxPoS)
				&&(onexPoS  <= (twoxPoS + twoWidth)))
				&&((oneyPoS + oneHeight >= twoyPoS) 
				&&(oneyPoS  <= (twoyPoS + twoHeight))))) 
			{
				return true;
			}
				return false;
	}
	
}
