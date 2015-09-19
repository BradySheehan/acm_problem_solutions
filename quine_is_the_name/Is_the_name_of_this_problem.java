import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
//Program written by Brady Sheehan as a solution to the ACM problem

public class Is_the_name_of_this_problem {

	public static void main(String[] args) {
		File file = new File("quine_input.txt");
		try{
			Scanner sc = new Scanner(file);
			while(sc.hasNextLine()){
				String line = sc.nextLine();
				//System.out.println(line);
				if(line.equals("END")){
					break;
				}
				if(line.startsWith("\"")){
					// if the line starts with a quotation, possible quine
					//split it, if it splits at one matching of a quote and then a space,
					//with two pieces left, possible quine
					String[] pieces = line.split("\"\\s");
					if(pieces.length == 2 && pieces[0] != null){
						pieces[0] = pieces[0].replaceAll("\"", "");
						if(pieces[0].equals(pieces[1])){
							//if the pieces of the string match after removing quotes, it is definitely
							//a quine
							System.out.println("Quine(" + pieces[1]+")");
							continue;
						}else{
							System.out.println("not a quine");
							continue;
						}
					}else{
						System.out.println("not a quine");
						continue;
					}
				}else{
					System.out.println("not a quine"); 
					continue;
				}	
			}
			sc.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
	}
}