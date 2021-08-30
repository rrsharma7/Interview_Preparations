package string;

public class AmazingSubarrays {

	public int solve(String A) {
		
		int len=A.length();
        int count=0;

        for (int i = 0; i <len ; i++) {

            char s=A.charAt(i);
            if(s=='a'||s=='e'||s=='i'||s=='o'||s=='u'||s=='A'||s=='E'||s=='I' || s=='O'||s=='U'){
                count+=len-i;
            }
        }

        return count%10003;
	}

	public static void main(String[] args) {
		AmazingSubarrays test1 = new AmazingSubarrays();
		test1.solve("ABEC");
		
	}

}
