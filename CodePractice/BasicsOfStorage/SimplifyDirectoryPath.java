package basicsofstorage;

import java.util.Stack;

public class SimplifyDirectoryPath {

	public String simplifyPath(String A) {
		 Stack<String> stack = new Stack<String>();
	        String[] args = A.trim().split("/");
	        for (String s : args) {
	            if (s.equals("..")) {
	                if (!stack.isEmpty()) {
	                    stack.pop();
	                }
	            }
	            else if(!s.isEmpty() && !s.equals(".")) {
	                stack.push(s);
	            }
	        }
	        
	        StringBuilder sb = new StringBuilder("");
	        while(!stack.isEmpty()) {
	            sb.insert(0,stack.pop());
	            sb.insert(0, "/");
	        }
	        
	        return sb.length() != 0 ? sb.toString() : "/";
	    }
	

	public static void main(String[] args) {
		SimplifyDirectoryPath sp = new SimplifyDirectoryPath();
		String A = "/a/./b/../../c/";
		String sre = sp.simplifyPath(A);
		System.out.println(sre);

	}

}
