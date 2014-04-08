import java.util.*;
public class KDiff {
   
    public static long [] readNumsFromCommandLine(int n) {
        int count = n;
        long [] numbers = new long[count];
        Scanner numScanner = new Scanner(System.in);
        for (int i = 0; i < count; i++) {
            if (numScanner.hasNextLong()) {
                numbers[i] = numScanner.nextLong();
            } else {
                System.out.println("Enough numbers not provided");
                break;
            }
        }
        return numbers;
    }
   
   
    public static void main(String[] args) {
        Scanner scanInts = new Scanner(System.in);
        
        Integer n = scanInts.nextInt(); // no of inputs
        Long k = scanInts.nextLong(); // diff
        
        long[] numberArray = readNumsFromCommandLine(n);
        
        int count = 0;
        
        Arrays.sort(numberArray);
        
        if(numberArray[n-1] - numberArray[0] < k)
            System.out.println(count);
        else {
            for (int i = n-1; i>=0 ; i--) {
                for(int j = i-1; j>=0; j--) {
                    if(numberArray[i] - numberArray[j] > k)
                        break;
                    else if((numberArray[i]-numberArray[j]) == k)
                        count++;
                }
            }
            System.out.println(count);   
        }            

        
    }
}
