/*

Implement a method to perform basic string compression using counts of repeated characters.

Eg: aabcccccaaa would become a2b1c5a3 and if the compressed string would not become smaller than the original string,
your method should return the original string.

*/
public class CompressString {
    
    public String compressStr(String str) {
        StringBuffer resultString = new StringBuffer();
        
        if(str.length() > 0){
            
            char character = str.charAt(0);
            
            int count=1;
            
            for(int i=1; i<str.length(); i++) {
                
                if(character == str.charAt(i))
                {
                    count++;
                }
                else
                {
                    resultString.append(character);
                    resultString.append(count);
                    character = str.charAt(i);
                    count=1;
                }   
                    
            }
            resultString.append(character);
            resultString.append(count);
            
            if(resultString.length() > str.length())
                return str;
            
            return resultString.toString();    
        }
        
        return null;
            
    }
    
    public static void main(String[] args) {

        CompressString obj = new CompressString();
        System.out.print(obj.compressStr("aabcccccaaa"));
        
    }
} 