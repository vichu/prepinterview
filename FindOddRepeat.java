/*

Given a list of integers in which only one integer repeats odd number of times. 

Write a function to calculate the odd number repeated integer and return it. 

Make sure you use very less memory.

*/

public class FindOddRepeat
{
    public int getRepeatedValues( int[] nos) {
        if(nos == null || nos.length == 0)
            return -1;
        else {
            
            int result = 0;
            for (int no : nos)
                result = result^no;
            
            return result;
        }
    }
    
    public static void main(String[] args) {
        FindOddRepeat obj = new FindOddRepeat();
        int[] inputArray = {1,2,3,2,2,3,1};
        System.out.println(obj.getRepeatedValues(inputArray));
    }
}