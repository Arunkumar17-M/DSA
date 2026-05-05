package patterns;

public class PatternProgram {

    static void pattern1(int n){
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void pattern2(int n){
        for(int i = 0; i<n; i++){
            for(int j =0; j <=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void pattern3(int n){
        for(int i = 0; i < n; i++){
            for(int j =1; j <=i+1; j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }

    static void pattern4(int n){
        for(int i = 1; i <= 5; i++){
            for(int j =0; j < i; j++){
                System.out.print(i);
            }
            System.out.println();
        }
    }

    static void pattern5(int n){
        for(int i= 0; i < n; i++) {
            for (int j = n; j > i; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void pattern6(int n){
        for(int i = n; i > 0; i--){
            for(int j = 1; j <= i; j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }

    static void pattern7(int n){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < (n-i-1) ; j++){
                System.out.print(" ");
            }
            for(int j = 0; j < (2*i+1); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void pattern8(int n){
        for(int i = n-1; i >= 0; i--){
            for(int j = n-1; j > i; j--){
                System.out.print(" ");
            }
            for(int j = 2*i+1; j > 0; j--){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void pattern10(int n){
        for(int i = 1; i <= 2*n-1; i++){
            int stars = (i > n)? 2*n-i : i;
            for(int j = 0; j < stars; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void pattern11(int n){
        int star;
        for(int i = 1; i <= n ; i++){
            star = (i % 2 == 0)? 0 : 1;
            for(int j = 1; j <= i; j++){
                System.out.print(star);
                star = 1 - star;
            }
            System.out.println();
        }
    }

    static void pattern12(int n){
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                System.out.print(j);
            }
            for(int j = 0; j <= 2*(n-i-1); j++){
                System.out.print(" ");
            }
            for(int j = i; j >= 1; j--){
                System.out.print(j);
            }
            System.out.println();
        }
    }

    static void pattern13(int n){
        int num = 1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                System.out.print(num++ + " ");
            }
            System.out.println();
        }
    }

    static void pattern14(int n){
        for(int i = 0; i < n; i++){
            for(char j = 'A'; j <= 'A'+i; j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }

    static void pattern15(int n){
        for(int i = n; i >= 1; i--){
            for(char j = 'A'; j < 'A'+i; j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }

    static void pattern16(int n){
        for(int i = 0; i < n; i++){
            for(int j =0; j <= i; j++){
                System.out.print((char)('A'+i));
            }
            System.out.println();
        }
    }

    static void pattern17(int n){
        for(int i = 0; i < n ; i++){
            char ch = 64;
            for(int j = 0; j < n-i-1; j++){
                System.out.print(" ");
            }
            for(int j = 0; j < 2*i+1; j++){
                if(j <= i)
                    System.out.print(++ch);
                else
                    System.out.print(--ch);
            }
            System.out.println();
        }
    }

    static void pattern18(int n){
        for(int i = n; i > 0; i--){
            for(char j = (char)(64+i); j <= (char)(64+n); j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }

    static void pattern22(int n){
        for(int i = 0; i < 2*n-1 ; i++){
            for(int j = 0; j < 2*n-1; j++){
                int top = i;
                int left = j;
                int down = (2*n-2)-i;
                int right = (2*n-2)-j;
                System.out.print(n-Math.min(Math.min(top, down), Math.min(left, right)));
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {

        pattern22(4);
    }
}
