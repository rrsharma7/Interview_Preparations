package MathsModularArithmetic;

//(A ^ (B!)) % (1e9 + 7)
public class VeryLargePower {

	int fast_power(long A, long B, long mod) {
        long ans = 1;
        while(B > 0) {
            if((B & 1) == 1) {
                ans = (ans * A) % mod;
            }
            A = (A % mod * A % mod) % mod;
            B = B >> 1;
        }
        return (int)(ans % mod);
    }
    
    public int solve(int A, int B) {
        long fact = 1;
        long mod = (long)(1e9 + 7);
        // calculating factorial of B
        for(long i = 2; i <= B; i += 1) {
            fact = (fact * i) % (mod - 1);
        }
        int ans = fast_power(A, fact, mod);   
        return ans;
    }

	public static void main(String[] args) {
		VeryLargePower vlp = new VeryLargePower();
		int x = vlp.solve(2, 2);
		System.out.println("x=" + x);
	}
}
