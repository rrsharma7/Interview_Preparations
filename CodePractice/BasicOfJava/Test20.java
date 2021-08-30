// First sort Aay
package test;

public class Test20 {

	public int[][] solve(int A) {  
		        if(A<=0) return new int[0][];
		        int[][] result=new int[A][A];
		        int xBeg=0,xEnd=A-1;
		        int yBeg=0,yEnd=A-1;
		        int cur=1;
		        while(true){
		            for(int i=yBeg;i<=yEnd;i++) result[xBeg][i]=cur++;
		            if(++xBeg>xEnd) break;
		            for(int i=xBeg;i<=xEnd;i++) result[i][yEnd]=cur++;
		            if(--yEnd<yBeg) break;
		            for(int i=yEnd;i>=yBeg;i--) result[xEnd][i]=cur++;
		            if(--xEnd<xBeg) break;
		            for(int i=xEnd;i>=xBeg;i--) result[i][yBeg]=cur++;
		            if(++yBeg>yEnd) break;
		        }
		        return result;    
		    
	}

	public static void main(String[] args) {
		Test20 test9 = new Test20();
		test9.solve(5);
	}
}

//1  2  3
//4  5  6
//7  8  9
//
//
//3  6  9 
//2  5  8 
//1  4  7
