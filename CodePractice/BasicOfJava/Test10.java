package test;

// Java program to find the length
// of the longest alternative parity
// subsequence
class Test10
{

// Function to find the longest
static int longestAlternativeSequence(int a[], int n)
{
	int maxi1 = 0;

	// Marks the starting of odd
	// number as sequence and
	// alternatively changes
	int f1 = 0;

	// Finding the longest odd/even sequence
	for (int i = 0; i < n; i++)
	{

		// Find odd number
		if (f1 % 2 != 0)
		{
			if (a[i] % 2 == 1)
			{
				f1 = 1;
				maxi1++;
			}
		}

		// Find even number
		else
		{
			if (a[i] % 2 == 0)
			{
				maxi1++;
				f1 = 0;
			}
		}
	}

	int maxi2 = 0;
	int f2 = 0;

	// Length of the longest even/odd sequence
	for (int i = 0; i < n; i++)
	{

		// Find odd number
		if (f2 % 2 != 0)
		{
			if (a[i] % 2 == 1)
			{
				f2 = 1;
				maxi2++;
			}
		}

		// Find even number
		else
		{
			if (a[i] % 2 == 0)
			{
				maxi2++;
				f2 = 0;
			}
		}
	}

	// Answer is maximum of both
	// odd/even or even/odd subsequence
	return Math.max(maxi1, maxi2);
}

// Driver Code
public static void main(String[] args)
{
	int a[] = { 1,2,2,5,6 };
	int n = a.length;
	System.out.println(longestAlternativeSequence(a, n));
}
}

// This code is contributed by 29AjayKumar
