import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static int factorSum(int x){
        int sum = 1;
        for(int i = 2; i <= Math.sqrt(x); i++){
            if (x % i == 0){
                if (x / i == i){
                    sum+=i;
                } else {
                    sum+=i+x/i;
                }
            }
        }
        return sum;
    }
    
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
		    System.out.println(factorSum(x));
		    System.out.println(factorSum(y));
		    System.out.println(amicablePair(x, y));
		}
	}
}