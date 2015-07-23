import java.util.*;
import java.io.*;

public class WordScore{

    private static TreeMap<Integer, String> wordMap = new TreeMap<>();
    	
    public static void main(String []args){
        
		String file = args[0];
		
		constructWordMap(file);
		writeToFile(wordMap);
		
		
     }
	private static void constructWordMap(String fileName){
		
		BufferedReader fileReader = null;
		String nextWord = "";
		int wordScore = 0;
		try {
		   
			fileReader = new BufferedReader(new FileReader(fileName));
			while ( (nextWord = fileReader.readLine()) != null ) {
				wordScore = calculateScore(nextWord);
				addToWordMap(wordScore, nextWord);
			}
			
		} 
		catch (Exception exp) {
			System.err.println(exp.getMessage());
		}
	}
	
	private static int calculateScore(String word){
         
        word = word.toLowerCase();
        int wordScore = 0;
        for(int i = 0; i < word.length(); i++){
         wordScore += word.charAt(i) - 'a' + 1;
        }
        return wordScore;
    }
	
    private static void addToWordMap(int score, String word){
        String value = "" ;
        if(wordMap.containsKey(score)){
            value = wordMap.get(score);
        }
        value = value + " " + word;
        wordMap.put(score, value);
    }
    
	private static void writeToFile(Map<Integer, String> sortedWordMap){
		
		try {
		   
			PrintWriter writer = new PrintWriter("Output.txt", "UTF-8");
			for ( Map.Entry<Integer, String> entry : sortedWordMap.entrySet() ) {
					
					writer.println(entry.getKey() + " " + entry.getValue());
			}
			writer.close();
			
		} 
		catch (Exception exp) {
			System.err.println(exp.getMessage());
		}
		
	}
    
}
