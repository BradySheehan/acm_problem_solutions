package lru_caching;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.Deque;

public class lruCaching {
	//Program written by Brady Sheehan as a solution to the ACM problem

		public static void printCache(ArrayDeque<Character> stack){ //print this stack, which doesn't
			Object[] array = stack.toArray();
			for(int i = stack.size() -1 ; i >= 0; i--){
				System.out.print(array[i].toString() + "");
			}
			System.out.print("\n");
		}
		
		public static ArrayDeque<Character> addToStack(ArrayDeque<Character> stack, char el, int size){
			//whether the stack is empty or not, we should check to make sure this element is not already in the stack,
			// if it is, we need to remove it before re-adding it
				if(stack.contains(el)){
					stack.remove(el);
					stack.addFirst(el);
				}
				else if(stack.size() >= size){ //the stack is full, 
					stack.removeLast();
					stack.addFirst(el);
				}else{
					stack.addFirst(el);
				}
			
			return stack;
		}
		public static void processData(String dataSet){ 
			//first get size of cache
			String[] parts = dataSet.split(" ");
			ArrayDeque<Character> stack = new ArrayDeque<Character>();
			int size = Integer.parseInt(parts[0]);
			for(int i = 2; i < dataSet.length(); i++){
				char el = dataSet.charAt(i);
				if(el == ('!')){
					printCache(stack);
				}else{ //found an element for the stack
					stack = addToStack(stack, el, size);
				}
			}
			
		}
		
		public static void main(String[] args) {
			File file = new File("/Users/BradySheehan/Documents/Development/java/problem_solving/lru_caching/src/lru_caching/lru_input.txt");
			try{
				Scanner sc = new Scanner(file);
				int simulationNum = 1;
				while(sc.hasNextLine()){
					String dataSet = sc.nextLine(); //one data set for processing
					if(dataSet.equals("0")){
						break;
					}
					System.out.println("Simulation " + simulationNum);
					processData(dataSet);
					simulationNum++;
				}
				sc.close();
			}catch(FileNotFoundException e){
				e.printStackTrace();
				System.err.println(e.getMessage());
			}
		}

	}

