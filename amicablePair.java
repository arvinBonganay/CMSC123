import java.util.*;
import java.lang.*;
import java.io.*;

/*
*	September 29, 2016
*
* 	Amicable numbers are two different numbers whose sum of factors of one number excluding itself is equal to the other number.
*
*	Input : First line contains the number of testcases. Next n lines contains 2 space-separated integers.
*	Output : Sum of the factors of each number and then determines whether the two numbers are amicable pair.
*		
*/

class amicablePair {
	// sum of the factors a number x excluding the number itself
    public static int factorSum(int x){
        int sum = 1;
        for(int i = 2; i <= Math.sqrt(x); i++){
            if (x % i == 0){
                if (x / i == i){
                    sum += i;
                } else {
                    sum += i + x/i;
                }
            }
        }
        return sum;
    }
    
	// determines if two numbers x and y are an amicable pair
    public static boolean amicablePair(int x, int y){
        if (factorSum(x) == y && factorSum(y) == x){
            return true;
        } else {
            return false;
        }
    }
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x, y;
        for (int i = 0; i < n; i++){
            x = sc.nextInt();
            y = sc.nextInt();
            System.out.printf("Sum of the factors of %d: %d\n", x, factorSum(x));
            System.out.printf("Sum of the factors of %d: %d\n", y, factorSum(y));
            System.out.printf("%d and %d are amicable pairs: %b\n", x, y, amicablePair(x, y));
        }
    }
}
