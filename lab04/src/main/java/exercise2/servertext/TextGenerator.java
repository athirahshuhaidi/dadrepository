package exercise2.servertext;


public class TextGenerator {
	
	/**
	 * This method generates current date
	 * 
	 * @return current date
	 */
	
	public int countWordsUsingSplit() 
	{
		String input = "Distributed Application Development";
		
		String[] words = input.split("\\s+"); 
		
		return words.length; 
	}
	
	public String words()
	{
		String input = "Distributed Application Development";
		
		return input; 
	}


}
