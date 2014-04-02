/*

    Rotate a matrix

*/

public class RotateImage {
    
    public int[][] rotateMatrix(int[][] matrix) {
        
        int orderOfMatrix = 0;
        if(matrix[0].length == matrix.length)
            orderOfMatrix = matrix[0].length;
        
        int[][] resultMatrix = new int[orderOfMatrix][orderOfMatrix];
        
        for(int i = 0; i<orderOfMatrix; i++) {
            int[] buffer = matrix[i];
            
            for(int j=0; j<orderOfMatrix; j++) {
                resultMatrix[j][(orderOfMatrix-i)-1] = buffer[j];
            }
        }
        return resultMatrix; 
    }
    
    public int[][] rotateInPlace(int[][] image, int n) {
        
        for (int layer=0; layer<n/2; layer++) {
            int first = layer;
            int last = n-layer-1;
            int offset = 0;
            for (int i=first; i<last; i++) {
                
                int top = image[first][i];
                image[first][i] = image[last-offset][first];
                image[last-offset][first] = image[last][last-offset];
                image[last][last-offset] = image[i][last];
                image[i][last] = top;
                offset++;
            }
        }
        
        return image;
        
    }
    
    
    public static void main(String[] args) {
        RotateImage rotMat = new RotateImage();
        int[][] imageMatrix = new int[][]{ 
                                {1,2,3,4},
                                {5,6,7,8},
                                {9,10,11,12},
                            {13,14,15,16} };

        int[][] result = rotMat.rotateMatrix(imageMatrix);                        
        for(int k=0;k<imageMatrix.length;k++){
            for(int l=0;l<imageMatrix.length;l++)
            {
                System.out.print(" "+result[k][l]);
            } 
            System.out.println("" );
        }
        
        System.out.println("");
        int[][] resultinPlace = rotMat.rotateInPlace(imageMatrix, 4);
        for(int k=0;k<imageMatrix.length;k++){
            for(int l=0;l<imageMatrix.length;l++)
            {
                System.out.print(" "+resultinPlace[k][l]);
            } 
            System.out.println("" );
        }                       
        
    }
    
}