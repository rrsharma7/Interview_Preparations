package GCD;

public class EnumeratingGCD {

	  public String solve(String A, String B) {
	        if(A.equals(B))
	        return A;
	    else
	        return "1";
	    }

	public static void main(String[] args) {
		EnumeratingGCD egcd = new EnumeratingGCD();
		egcd.solve("1","3");
		
	}

}
