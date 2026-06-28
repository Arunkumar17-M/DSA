package dsa_question;

public class SetMatrixZeros {

    public static void bruteForceSolutuion(int[][] matrix){
        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == 0){
                    //row marking to -1
                    for(int k = 0; k < matrix.length; k++){
                        if(matrix[k][j] == 1)
                            matrix[k][j] = -1;
                    }

                    // for column we are marking as -1
                    for(int k = 0; k < matrix[i].length; k++){
                        if(matrix[i][k] == 1)
                            matrix[i][k] = -1;
                    }
                }
            }
        }

        for(int i = 0; i<matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == -1)
                    matrix[i][j] = 0;
            }
        }

        display(matrix);
    }

    public static void betterSolution(int[][] matrix){
        int size = matrix.length;
        int[] row = new int[size];
        int[] col = new int[size];

        for(int i = 0 ; i < size; i++){
            for(int j = 0; j < size; j++){
                if(matrix[i][j] == 0){
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(row[i]==1 || col[j] == 1)
                    matrix[i][j] = 0;
            }
        }

        display(matrix);
    }

    public static void optimalSolution(int[][] matrix){
        int size = matrix.length;
        int col0 = matrix[0][0];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size ; j++){
                if(matrix[i][j] == 0){
                    if(j != 0)
                        matrix[i][0] = 0;
                    else
                        col0 = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i = 1; i < size; i++){
            for(int j = 1; j < size; j++){
                if(matrix[0][j] == 0 || matrix[i][0] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        if(matrix[0][0] == 0){
            for(int i = 0; i < size; i++){
                matrix[0][i] = 0;
            }
        }

        if(col0 == 0){
            for(int i = 0; i < size; i++){
                matrix[i][0] = 0;
            }
        }

        display(matrix);
    }

    public static void display(int[][] matrix){
        for(int i = 0; i< matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[4][4];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = 1;
            }
        }
        matrix[1][1] = 0;
        matrix[2][2] = 0;
        matrix[3][0] = 0;

//        display(matrix);
//        bruteForceSolutuion(matrix);
//        betterSolution(matrix);
        optimalSolution(matrix);
    }
}
