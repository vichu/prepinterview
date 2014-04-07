public class SelectionSort {
    
    int[] selectionSort(int[] elements) {
        int minIndex = 0;
        for (int i=0; i<elements.length-1; i++) {
            minIndex = i;
            
            for (int j=i+1; j<elements.length; j++) {
                if(elements[minIndex] >= elements[j]) {
                    minIndex = j;                
                }
            
                if(minIndex != i) {
                    int temp = elements[i];
                    elements[i] = elements[minIndex];
                    elements[minIndex] = temp;
                }   
            }    
        }
        
        return elements;
    }
    
    public static void main(String[] args) {
        SelectionSort obj = new SelectionSort();
        int[] input = new int[]{2,2, 3, 6, 9, 8, 1};
        int[] output = obj.selectionSort(input);
        
        for (int element : output) {
            System.out.print(" "+element);
        }
    }
    
}