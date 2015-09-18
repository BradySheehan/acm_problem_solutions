package mad_scientist;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//Solution written by Brady Sheehan

public class madScientist {

	static void findMeasurements(String line){
		String[] input = line.split(" ");
		int outputNums = 0;
		for(int i = 1; i <= Integer.parseInt(input[0]); i++){
			//each entry in input[i] represents the number of values less than or equal to input[i] 
			int num = Integer.parseInt(input[i]);	
			//depending on how many entries are already outputted, I need num more entries that are less than or equal to num
			while(outputNums < num){
				outputNums++;
				System.out.print(i + " ");
			}
		}
		System.out.println("");
	}
	public static void main(String[] args) {
		File file = new File("/Users/BradySheehan/Documents/Development/java/problem_solving/mad_scientist/src/mad_scientist/mad_input.txt");
		try{
			Scanner sc = new Scanner(file);
			while(sc.hasNextLine()){
				String line = sc.nextLine();
				if(line.equals("0")){
					break;
				}
				findMeasurements(line);
			}
			sc.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
	}
}

