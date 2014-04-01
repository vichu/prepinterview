public class AddTwoStrings {
    
    public String add(String no1, String no2) {
        
        int[] largerArray, smallerArray;
        StringBuffer resultString = new StringBuffer("");
        
        if(no1.length() > no2.length()) {
          largerArray = getNumArray(no1);
          smallerArray = getNumArray(no2);
        }
        else {
            largerArray = getNumArray(no2);
            smallerArray = getNumArray(no1);
        }
                
        int carry = 0;
        
        for (int i=0; i<smallerArray.length; i++) {
            int result = largerArray[i]+smallerArray[i]+carry;
            carry = result / 10;
            result = result % 10;
            resultString.append( result );
        }
        
        for(int i = smallerArray.length;i<largerArray.length;i++) {
            int result = largerArray[i]+carry;
            carry = result / 10;
            result = result % 10;
            resultString.append( result ); 
        }
        
        return resultString.reverse().toString();
        
    }
    
    private int[] getNumArray(String number) {
        
        int[] resultInt = new int[number.length()];
        char[] numbers = number.toCharArray();
        
        for (int i=(number.length()-1); i>=0; i--) {
            resultInt[(number.length()-1) - i] = Integer.parseInt(""+numbers[i]);
        }
        
        return resultInt;
        
    }
    
    
    public static void main(String[] args) {
        
        AddTwoStrings obj = new AddTwoStrings();
        System.out.println(obj.add("123636636663828388823838838388832", "8"));
    }
}