/*

How to find the only two different numbers in two unsorted arrays? 

findDiff -----> doesn't create extra space, takes Theta(nlogn) time
findDiffExtraSpace --> uses extra space but runs in Theta(n) time


*/


import java.util.*;

public class FindDiffElements {
    
    public int[] findDiff(int[] array1, int[] array2) {
        
        
        Arrays.sort(array1);
        Arrays.sort(array2);
        
        int[] resultArray = new int[2];
        
        for(int i = 0; i<array1.length;i++) {
            if(array1[i] != array2[i])
            {
                resultArray[0] = array1[i];
                resultArray[1] = array2[i];
            }
        }
        return resultArray;
    }
    
    public int[] findDiffExtraSpace(int[] array1, int[] array2) {
        
        Map<Integer, Integer> storeMap = new HashMap<>();
        
        for (int i=0;i<array1.length;i++) {
            if(storeMap.containsKey(array1[i]))
            {    
                int value = storeMap.get(array1[i]);
                value++;
            }
            else
                storeMap.put(array1[i], 1);
        }

        for (int i=0;i<array2.length;i++) {
            if(storeMap.containsKey(array2[i])){
                int value = storeMap.get(array2[i]);
                value--;
                storeMap.put(array2[i],value);
            }
            else
                storeMap.put(array2[i], 1);
        }
        
        int[] result = new int[(storeMap.size() - array1.length)+1];
        int elementIndex =0;
        for(int i : storeMap.keySet()) {
            int element = storeMap.get(i);
            if(element != 0) {
                result[elementIndex] = i;
                elementIndex++;
            }
        }
        
        return result;
        
    }
    
    public static void main(String[] args) {
        
        FindDiffElements obj = new FindDiffElements();
        int[] a1 = new int[]{2,3,1,4,5};
        int[] a2 = new int[]{1,3,2,6,4};
        
        int[] res = obj.findDiff(a1,a2);
        
        System.out.println("Different elements are "+res[0]+" and "+ res[1]);
        
        int[] res1 = obj.findDiffExtraSpace(a1,a2);
        System.out.println("Different elements with extra space are "+res1[0]+" and "+ res1[1]);
        
    }
    
}