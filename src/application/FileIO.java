package application;
import java.io.*;

//auses TwinPrimes and is used in Driver (aka Main)
public class FileIO {
	
	//function makes a text file of hexagon crosses
	public static void MakeFile(int N) {
		try {
			//create file
			FileWriter result = new FileWriter("result.txt");
			
			//Hexagon Cross function
			//this boolean will be used for the while loop, will return true and end the loop once count = N
			boolean check = false;
			//i starts at 6 because the first hexagon cross is 6 and 12
	        int i = 6;
	        //count serves as a variable for making sure we find N number of crosses
	        int count = 0;
	        //string that we'll put the hexagon crosses and format for each line in the .txt file as
	        String output = null;
	        
			while (!check) {
	            int j = i*2;
	            //if i-1 and i+2 are twin primes and 2i-1 and 2i+1 are twin primes, then this is a hexagon cross
	            if ((TwinPrimes.isTwinPrimes(i-1, i+1)) && (TwinPrimes.isTwinPrimes(j-1, j+1))) {
	            	//formatting for the .txt file -- written as a string
	            	output = Integer.toString(i) + ", " + Integer.toString(j) + " \n";
	                //put Hexagon Cross in result.txt
	            	result.write(output);
	            	//every time we find a hexagon cross count is incremented
	                count++;
	            }
	            i++;
	            //once we have found N hexagon crosses, check is true and, therefore, there is no need to keep checking for hexagon crosses
	            if (count == N) {
	            	check = true;
	            }
	        }
			//end of file
			result.close();
		}
		catch (IOException e) { 
			System.out.println("Error");    
			e.printStackTrace();
		}
	}
	
}
//in Driver, you're going to tell them input N (that's ur input/done)
//afterwards, Driver calls FileIO which only does the output to a text file (result.txt)
//then, Driver will read result.txt to output the hexagon crosses in the GUI
