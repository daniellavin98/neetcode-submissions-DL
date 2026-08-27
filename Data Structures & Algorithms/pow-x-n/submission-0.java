class Solution {
    public double myPow(double x, int n) {
        long N = n; 

        if(N < 0){
            x = 1/x; 
            N = -N; 
        }

        return squareHelper(x, N); 
    }

    private double squareHelper(double base, long exponent){
        if (exponent == 0) return 1.0; 

        double half = squareHelper(base, exponent/2); 

        if(exponent % 2 == 0){
            return half * half; 
        }
        else{
            return half * half * base; 
        }
    }
}
