package test;

import java.util.HashSet;

public class Test29 {

	 public int isValidSudoku(final String[] A) {
	        HashSet seen = new HashSet();
	        int len = A.length;
	        for(int i=0;i<len;i++) {
	        for(int j=0;j<len;j++) 
	        {
	            char ch = A[i].charAt(j);
	            if(ch!='.') {
	            if( !seen.add(ch + "found in row" + i) ||
	            !seen.add(ch + "found in col" + j) ||
	            !seen.add(ch + "found in box" + i/3 + "-" + j/3) ) 
	            return 0;
	            }
	        }
	    }
	    
	    return 1;
	}

	public static void main(String[] args) {
		Test29 test26 = new Test29();
		String arr[]= {"53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"};
		int t=test26.isValidSudoku(arr);
		System.out.println(t);
	}



}
