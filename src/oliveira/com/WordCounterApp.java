//Maria Waleska Marinho de Oliveira 

package oliveira.com;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class WordCounterApp {

	public static void main(String[] args) throws FileNotFoundException {
		//Try and catch block 
		try {
		
			//here I ask for the file name 
			Scanner readFilePath = new Scanner(System.in);
	
		    System.out.println("Enter file name:");
	
		    // String input
		    String name = readFilePath.nextLine();
		    
		    //creating File instance to reference text file in Java
	        File text = new File(name); 
	     
	        //Creating Scanner instance to read File in Java
	        Scanner scnr = new Scanner(text);
	        
	        System.out.println("----------------------------");
	        System.out.println("Words from file");
	        System.out.println("----------------------------");
	     
	        //Reading each line of the file using Scanner class
	        String line;
	        StringTokenizer st;
	        String result;
	        while(scnr.hasNextLine()){
	            line = scnr.nextLine();
	            //System.out.println("line " + lineNumber + " :" + line);
	            st = new StringTokenizer(line);
	            while (st.hasMoreTokens()) {
	            	result = st.nextToken();
	            	if(result.length()>0) {
	            		System.out.println(result);
	            	}
	            }
	        }
	        
	        System.out.println("----------------------------");
	        System.out.println("Words after removing special characters");
	        System.out.println("----------------------------");
	        
	        scnr.close();
	        
	        scnr = new Scanner(text);
	        
	        ArrayList<Integer> wordList = new ArrayList<Integer>();
	        wordList.add(0);
	        while(scnr.hasNextLine()){
	            line = scnr.nextLine();
	            //System.out.println("line " + lineNumber + " :" + line);
	            st = new StringTokenizer(line);
	            while (st.hasMoreTokens()) {
	            	result = st.nextToken().replaceAll("([\\d]|[-&,./'])", "");
	            	if(result.length()>0) {
	            		System.out.println(result);
	            	}
	            	int countWords = 0;
	            	while(countWords<=result.length()) {
	            		if(wordList.size()>result.length()) {
	            			if(countWords==result.length()) {
	            				int tempQty = wordList.get(result.length());
	            				wordList.set(result.length(), tempQty+1);
	            			}
	            			countWords++;
	            		}
	            		else {
	           				wordList.add(0);
	            		}
	            	}
	            }
	        }
	        
	        System.out.println("----------------------------");
	        System.out.println("Length -- number of words");
	        System.out.println("----------------------------");
	                
	        int val = 1;
	        
	        while (wordList.size() > val) {
	        	System.out.println(val+" letters -- "+wordList.get(val)+" words");
	        	val++;
	        }
	        
	        readFilePath.close();
	        scnr.close();
	        
		} catch (FileNotFoundException ex) {
			System.out.println("Error: Error in file Open: "+ ex.getMessage());
	    }

	}

}
