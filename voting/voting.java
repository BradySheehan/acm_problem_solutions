import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class voting {

	public static void main(String[] args) {
		File file = new File("voting_input.txt");
		try{
			Scanner sc = new Scanner(file);
			while(sc.hasNextLine()){
				int numYes = 0;
				int numNo = 0;
				int numAbsent = 0;
				int present = 0;
				String line = sc.nextLine();
				//System.out.println(line);
				if(line.equals("#")){
					break;
				}
				for(int i = 0; i< line.length(); i++){
					if (line.charAt(i) == 'A'){
						numAbsent++;
					}else{
						present++;
					}
					if(line.charAt(i) == 'Y'){
						numYes++;
					}
					if(line.charAt(i) == 'N'){
						numNo++;
					}
				}
				if(numAbsent >= present){
					System.out.println("need quorum");
				}else if(numYes == numNo){
					System.out.println("tie");
				}else if(numNo > numYes){
					System.out.println("no");
				}else{
					System.out.println("yes");
				}
			}
			sc.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
	}

}
