class BinarySearch {
    
    public boolean searchBinary(int[] inputArray,int searchElement) {
        
        int mid = inputArray.length/2;
        
        if(mid == 0)
            return inputArray[mid] == searchElement;
        
        if(searchElement < inputArray[mid]) {
            int[] leftArray = new int[mid];
            
            for (int i = 0; i<mid; i++) {
                leftArray[i] = inputArray[i];
            }
            return searchBinary(leftArray, searchElement);
        }
        
        else if(searchElement > inputArray[mid]){
            int[] rightArray = new int[inputArray.length-mid];
            
            for (int i = 0; i<(inputArray.length-mid) ; i++) {
                rightArray[i] = inputArray[mid+i];
            }
            
            return searchBinary(rightArray, searchElement);
        }
        
        else {
            if(inputArray[mid] == searchElement)
                return true;
            else
                return false;
        }

    }
    
    public static void main(String[] args) {
        
        int[] searchArray = new int[]{1,2,3,5,8,19};
        BinarySearch obj = new BinarySearch();
        System.out.println(obj.searchBinary(searchArray, 17));
        System.out.println(obj.searchBinary(searchArray, 19));
    }
    
}