import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * MorseCodeConverter Utility class
 * Uses the MorseCodeTree
 * Static method convertToEnglish that takes a String object of morse code and  returns a String object of corresponding English characters
 * Static method convertToEnglish that takes a File object of morse code and  returns a String object of corresponding English characters
 * Static method to print the tree
 *
 */
public class MorseCodeConverter {

	private static MorseCodeTree o = new MorseCodeTree(); 
	
	/**
	 * constructor call the MorseCodeTree
	 */
	public MorseCodeConverter()
	{
		o = new MorseCodeTree();
	}
	/**
	 * Use the morseCompare method of the MorseTree to compare the morse code and English alphabet
	 * @param code
	 * @return the English translation
	 */
	public static String convertToEnglish(String code)
	{
		return o.morseCompare(code);
		
	}
	/** 
	 * @param codFile
	 * @return the English translation of the File
	 */
	public static String convertToEnglish(File codFile) throws FileNotFoundException
	{
		Scanner input = new Scanner(codFile);
		String result = "";
		String line = "";
		while(input.hasNextLine()) 
		{
			line = input.nextLine();
			result += convertToEnglish(line);
		}
		return result;
	}
	
	/**
	 * Uses the toArrayList method in MorseCodeTree 
	 * @return returns a string with all the data in the tree in LNR order with an space in between them. 
	 */
	@SuppressWarnings("unchecked")
	public static String printTree()
	{
		ArrayList<String> data = new ArrayList<String>();
		
		data = o.toArrayList();
		String str = "";
		for(int i=0; i<data.size();i++)
		{
			str += data.get(i)+" ";
		}
		
		return str;
	}

	
	
}
