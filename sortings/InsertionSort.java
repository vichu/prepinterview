public class InsertionSort {
    
    
    public int[] insertionSort(int[] inputArray) {
        
        int size = inputArray.length;
        
        if(size == 1) 
            return inputArray;
        
        for (int key = 1; key<size; key++) {
            int current = key;
            
            for (int prev = key-1; prev >= 0; prev--) {
                if(inputArray[prev] >= inputArray[current])
                {
                    inputArray = swap(inputArray, prev, current);
                    current = prev;
                }
            }
        }
        
        return inputArray;
    }
    
    private int[] swap(int[] inputArray, int prev, int current) {
        int temp = inputArray[prev];
        inputArray[prev] = inputArray[current];
        inputArray[current] = temp;
        
        return inputArray;
    }
    
    
    public static void main(String[] args) {
        int[] input = new int[]{
            8, 2, 9, 4, 3, 6
        };
        
        InsertionSort obj = new InsertionSort();
        int[] output = obj.insertionSort(input);
        
        for (int i = 0; i<output.length; i++) {
            System.out.println(output[i]);
        }
    }
    
}