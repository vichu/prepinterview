public class GenerateAllCases  {
	
	public void generateAllTheCase(String word)  {
		int noOfTimes = 1 << word.length();
		
		for (int i=0; i<noOfTimes; i++) {
			String paddedBinary = getPaddedBinary(i, word.length());
			
			for (int j=0;j<word.length() ;j++ ) {
			
				if(paddedBinary.charAt(j) == '0')
					System.out.print((""+word.charAt(j)).toLowerCase());
				else
					System.out.print((""+word.charAt(j)).toUpperCase());
			}
			System.out.println("");
		}
	}
	
	public String getPaddedBinary(int no, int lengthOfWord)  {
		String appendString = "";
		for (int j=0; j<lengthOfWord-1 ; j++) {
			appendString+="0";
		}
		appendString +=appendString+Integer.toBinaryString(no);
		return appendString.substring(appendString.length()-lengthOfWord);
	}
	
	
	
	public static void main(String[] args) {
		GenerateAllCases obj = new GenerateAllCases();
		obj.generateAllTheCase("abc");
	}
}