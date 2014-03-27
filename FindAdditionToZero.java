/*

Given an array of numbers, find out if 3 of them add up to 0.

Really liked the approach given by Charles Ma in Stackoverflow.
Link: http://stackoverflow.com/questions/1283231/given-an-array-of-numbers-find-out-if-3-of-them-add-up-to-0

*/

import java.util.*;

public class FindAdditionToZero {
    
    public boolean findAdditionOf3ValuesGivesZero(int[] inputArray) {
        
        Arrays.sort(inputArray);
        int lengthOfArray = inputArray.length;
        
        for (int i=0; i<lengthOfArray; i++) {
            
            int iterIndex = i+1;
            int reverseIterIndex = lengthOfArray-1;
            
            while(iterIndex < reverseIterIndex) {
                int sum = inputArray[iterIndex] + inputArray[reverseIterIndex] +inputArray[i];
                
                if(sum > 0)
                    reverseIterIndex--;
                else if(sum < 0)
                    iterIndex++;
                else
                    return true;
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        FindAdditionToZero obj = new FindAdditionToZero();
        int[] input = new int[]{1,0,-3,-9,5,7};
        System.out.println(obj.findAdditionOf3ValuesGivesZero(input));
        input = new int[]{1,0,-3,-2,5,7};
        System.out.println(obj.findAdditionOf3ValuesGivesZero(input));
    }
    
}