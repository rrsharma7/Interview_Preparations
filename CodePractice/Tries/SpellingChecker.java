/**
Q2. Spelling Checker

Problem Description

Given an array of words A (dictionary) and another array B (which contain some words).

You have to return the binary array (of length |B|) as the answer where 1 denotes that the word is present in the dictionary and 0 denotes it is not present.

Formally, for each word in B, you need to return 1 if it is present in Dictionary and 0 if it is not.

Such problems can be seen in real life when we work on any online editor (like Google Documnet), if the word is not valid it is underlined by a red line.

NOTE: Try to do this in O(n) time complexity.



Problem Constraints

1 <= |A| <= 1000

1 <= sum of all strings in A <= 50000

1 <= |B| <= 1000



Input Format

First argument is array of strings A.

First argument is array of strings B.



Output Format

Return the binary array of integers according to the given format.



Example Input

Input 1:

A = [ "hat", "cat", "rat" ]
B = [ "cat", "ball" ]
Input 2:

A = [ "tape", "bcci" ]
B = [ "table", "cci" ]


Example Output

Output 1:

[1, 0]
Output 2:

[0, 0]


Example Explanation

Explanation 1:

Only "cat" is present in the dictionary.
Explanation 2:

None of the words are present in the dictionary.

*/

package Tries;

class SpellingChecker {
	static final int ALPHABET_SIZE = 26;

	static class TrieNode {
		TrieNode[] children = new TrieNode[ALPHABET_SIZE];
		// isEndOfWord is true if the node represents
		// end of a word
		boolean isEndOfWord;
		// count of words this letter can make
		int count;

		TrieNode() {
			isEndOfWord = false;
			count = 0;
			for (int i = 0; i < ALPHABET_SIZE; i++)
				children[i] = null;
		}
	}

	static TrieNode root;

	// If not present, inserts key into trie
	// If the key is prefix of trie node,
	// just marks leaf node
	static void insert(String key) {
		int level;
		int length = key.length();
		int index;
		TrieNode pCrawl = root;
		for (level = 0; level < length; level++) {
			index = key.charAt(level) - 'a';
			if (pCrawl.children[index] == null) {
				pCrawl.children[index] = new TrieNode();
			}
			pCrawl = pCrawl.children[index];
			pCrawl.count++;
		}
		// mark last node as leaf
		pCrawl.isEndOfWord = true;

	}

	// Returns true if key presents in trie, else false
	static int isWordPresent(String key) {
		int level;
		int length = key.length();
		int index;
		TrieNode pCrawl = root;
		for (level = 0; level < length; level++) {
			index = key.charAt(level) - 'a';

			if (pCrawl.children[index] == null)
				return 0;

			pCrawl = pCrawl.children[index];
		}

		return (pCrawl.isEndOfWord) ? 1 : 0;

	}

	public int[] solve(String[] A, String[] B) {
		int present[] = new int[B.length];
		root = new TrieNode();
		for (int i = 0; i < A.length; i++)
			insert(A[i]);
		for (int i = 0; i < B.length; i++) {
			present[i] = isWordPresent(B[i]);
		}
		return present;
	}

	public static void main(String[] args) {
		SpellingChecker sc = new SpellingChecker();
		String[] A = {"hat", "cat", "rat"};
		String[] B = {"cat", "ball"};
		int ansArr[] = sc.solve(A, B);
		for (int i = 0; i < ansArr.length; i++) {
			System.out.println("ansL  =  "+ansArr[i]);
		}
	}

}
