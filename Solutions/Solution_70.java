import java.math.BigInteger;

class Solution {

   public static BigInteger comb(int up, int down) {
        if (down > up / 2)
            down = up - down;
        if (down == 0)
            return BigInteger.ONE;
        else if (down == 1)
            return BigInteger.valueOf(up);
        
        BigInteger ans = BigInteger.ONE;
        for (int i = up; i > up - down; i--) {
            ans = ans.multiply(BigInteger.valueOf(i));
        }
        for (int i = 2; i <= down; i++) {
            ans = ans.divide(BigInteger.valueOf(i));
        }
        return ans;
    }
    public int climbStairs(int n) {
        long sum=0;
        for(int i=n,j=0;i>=j;i--,j++) {
            sum=sum + comb(i,j).intValue();
        }
        return (int)sum;
    }
}