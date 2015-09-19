import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class magnets {

	public static void main(String[] args) {
		File file = new File("magnets_input.txt");
		try{  
			Scanner sc = new Scanner(file);
			String line = null;
			while(sc.hasNextLine()){
				line = sc.nextLine();
				if(line.equals("END"))
					break;
				boolean good = true;
				for(int i = 0; i < line.length(); i++){
					if(line.charAt(i) != ' '){
						char c = line.charAt(i);
						for(int j = 0; j < line.length() && j!=i; j++){
							if(line.charAt(i) != ' ' ){
								if(c == line.charAt(j)){
									good = false; 
									break;
								}
							}
						}
					}
				}
				if(good){
					System.out.println(line);
				}
			}
		}catch(IOException e){System.err.println(e.getMessage());}
	}

}
