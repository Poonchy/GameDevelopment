import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
	
	public static String loadFileAsString(String path){
		StringBuilder builder = new StringBuilder();
		
		try{
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			while((line = br.readLine()) != null){
				builder.append(line + "\n");
			}
			br.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		return builder.toString();
		
	}
	
	public static int parseInt(String number){
		try{
			return Integer.parseInt(number);
		}catch(NumberFormatException e){
			e.printStackTrace();
			return 0;
		}
	}
	
}
