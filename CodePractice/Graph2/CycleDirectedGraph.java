/**
Q1. Cycle in Directed Graph
Problem Description

Given an directed graph having A nodes. A matrix B of size M x 2 is given which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].

Find whether the graph contains a cycle or not, return 1 if cycle is present else return 0.

NOTE:

The cycle must contain atleast two nodes.
There are no self-loops in the graph.
There are no multiple edges between two nodes.
The graph may or may not be connected.
Nodes are numbered from 1 to A.
Your solution will run on multiple test cases. If you are using global variables make sure to clear them.


Problem Constraints

2 <= A <= 105

1 <= M <= min(200000,A*(A-1))

1 <= B[i][0], B[i][1] <= A



Input Format

The first argument given is an integer A representing the number of nodes in the graph.

The second argument given a matrix B of size M x 2 which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].



Output Format

Return 1 if cycle is present else return 0.



Example Input

Input 1:

 A = 5
 B = [  [1, 2] 
        [4, 1] 
        [2, 4] 
        [3, 4] 
        [5, 2] 
        [1, 3] ]
Input 2:

 A = 5
 B = [  [1, 2]
        [2, 3] 
        [3, 4] 
        [4, 5] ]


Example Output

Output 1:

 1
Output 2:

 0


Example Explanation

Explanation 1:

 The given graph contain cycle 1 -> 3 -> 4 -> 1 or the cycle 1 -> 2 -> 4 -> 1
Explanation 2:

 The given graph doesn't contain any cycle.


See Expected Output

*/

package Graph2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
class CycleDirectedGraph {

	Map<Integer, List<Integer>> map =  new HashMap<>();
    Set<Integer> isVisited = new HashSet<>();
    public int solve(int A, int[][] B) {
        
        for(int i=1; i<=A; i++){
            map.put(i, new ArrayList<>());
        }
        for(int i=0; i<B.length; i++){
            map.get(B[i][0]).add(B[i][1]);
        }        
        
        for(int i=1; i<=A; i++){
            if(DFS(map.get(i)) == 1){
                return 1;
            }
            isVisited = new HashSet<>();
        }

        return 0;
    }
    public int DFS(List<Integer> list){
        for(int i=0; i<list.size(); i++){
            if(isVisited.add(list.get(i))){
                if(DFS(map.get(list.get(i)))==1){
                    return 1;
                }
                isVisited.remove(list.get(i));
            }else{
                return 1;
            }
        }
        return 0;
    }
	public static void main(String[] args) {
		CycleDirectedGraph cdp = new CycleDirectedGraph();
		int[][] B = { {1,2}, {2,3}, {3,4},{4,5}};
		int ans=cdp.solve(5, B);
		System.out.println(ans);
	}
}