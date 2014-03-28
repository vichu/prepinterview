public class MergeSort {
    
    public int[] mergeSort(int[] inputArray) {
        
        int mid = inputArray.length/2;
        
        if(inputArray.length <= 1) {
            return inputArray;
        }
        
        int[] leftArray = constructLeftArray(inputArray, mid);
        int[] rightArray = constructRightArray(inputArray, mid, inputArray.length);
        
        int[] leftResult = mergeSort(leftArray);
        int[] rightResult = mergeSort(rightArray);
                  
        int[] result = merge(leftResult, rightResult);
        return result;
    }
    
    private int[] constructLeftArray(int[] inputArray, int mid) {
        int left[] = new int[mid];
        for (int i=0; i<mid; i++) {
            left[i] = inputArray[i];
        }
        return left;
    }
    
    private int[] constructRightArray(int[] inputArray, int mid, int length) {
        int[] right = new int[(length-mid)];
        for (int i = 0; i<(length-mid); i++) {
            right[i] = inputArray[(mid+i)];
        }
        return right;
    }
    
    private int[] merge(int[] left, int[] right) {
        int rightCounter = 0;
        int leftCounter = 0;
        int leftSize = left.length;
        int rightSize = right.length;
        int mergeArray[] = new int[leftSize+rightSize];
        int counter = 0;
        
        while( (leftCounter < leftSize) && (rightCounter < rightSize) ) {

            if(left[leftCounter] <= right[rightCounter]) {
                mergeArray[counter] = left[leftCounter];                
                leftCounter++;
            }
            else if( left[leftCounter] > right[rightCounter] ) {
                mergeArray[counter] = right[rightCounter];                
                rightCounter++;
            }
            counter++;
        }
        
        if(rightCounter < rightSize) {
            for (int i=rightCounter; i<rightSize; i++) {
                mergeArray[counter] = right[i];
                counter++;
            }
        }
        
        else {
            for (int i=leftCounter; i<leftSize; i++) {
                mergeArray[counter] = left[i];
                counter++;
            }
        }
        
        return mergeArray;
    }
    
    public static void main(String[] args) {
        MergeSort obj = new MergeSort();
        
        int[] inputArray = new int[]{3, 2, 4, 5, 1, 54};
        int[] res = obj.mergeSort(inputArray);
        
        for (int i=0; i<res.length; i++) {
            System.out.print(" "+res[i]);
        }
    }
}