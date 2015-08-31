import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.Character;
//Program written by Brady Sheehan as a solution to the ACM problem
public class Digit_Solitaire {
	
	public static void computeProduct(String num){
		if(num.length() == 1){ //we are done
			System.out.println(" ");
		}
		else{ //find the product of the number's digits
			int[] nums = new int[num.length()];
			int product = 1;
			for(int i = 0; i < num.length(); i++){
				char n = num.charAt(i);
				nums[i] = (int)Character.getNumericValue(n);
				product =  product*nums[i];
			}
			System.out.print(product + " ");
			String strProduct = product + "";
			computeProduct(strProduct);
		}
	}
	
	public static void main(String[] args){
		File file = new File("digit_input.txt");
		try{
			Scanner sc = new Scanner(file);
			while(sc.hasNextLine()){
				String num = sc.next();
				if(num.length() == 1){
					if(num.equals("0")){ //reached the end of input
						break;
					}
					System.out.println(num); //if string is 1 long, the number must be less than 10 
											 //and therefore can be printed as is
					continue;
				}
				System.out.print(num + " ");
				computeProduct(num);
			}
			sc.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
	}
}
