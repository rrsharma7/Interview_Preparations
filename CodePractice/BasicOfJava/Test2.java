package test;
import java.util.ArrayList;

public class Test2 {
	public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int N = A.size();
        int firstGreatest = Integer.MIN_VALUE;
        int secondGreatest = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++){
            if(A.get(i) > firstGreatest){
                secondGreatest = firstGreatest;
                firstGreatest = A.get(i);
            }
            else if(A.get(i) > secondGreatest){
                secondGreatest = A.get(i);
            }
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i < N; i++){
            if(A.get(i) != secondGreatest && A.get(i) != firstGreatest){
                res.add(A.get(i));
            }
        }
        return res;
    }
}
