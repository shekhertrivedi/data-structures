import java.util.ArrayList;
import java.util.List;

public class SqareOfSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*int[] A = { -4, -1, 0, 3, 10 };
		// int[] A = {-1,1};
		int[] B = sortedSquares1(A);
		for (int a : B) {
			System.out.println(a);
		}*/

//		int [][] X = {{1,2,3},{4,5,6},{7,8,9}};
//		spiralPrint(3, 3, X);
		
		/*String[] sarr = {"abc","xyz"};
		String s = "abcxyzfsdkjabcdefgxyzsygdgabcxyz";*/
		String[] sarr = {"foo","bar"};
		String s = "barfoothefoobarman";
		System.out.println(findSubstring(s, sarr));
		
		/*"barfoothefoobarman"
		["foo","bar"]*/

	}
	
	public static String getOnes(String word) {
		int i = 0;
		String ret ="";
		while(i<word.length()) {
			ret = ret + "1";
			i = i+1;
		}
		return ret;
	}
	
	public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        String test = "";
        for(String word:words) {
        	s = s.replaceAll(word, getOnes(word));
        	test = test +getOnes(word);
        }
        
        System.out.println(test);
        System.out.println(s);
        
        int first = s.indexOf(test);
                
        while(first >= 0) {
        	System.out.println(first);
        	result.add(first);
        	first = s.indexOf(test, first+1);
        }
        
        return result;
    }

	public static int[] sortedSquares1(int[] A) {

		int[] B = new int[A.length];
		int positivePointer = 0;
		boolean flag = true;
		for (int i = 0; i < A.length; i++) {
			if (flag && A[i] >= 0) {
				flag = false;
				positivePointer = i;
			}
			A[i] = A[i] * A[i];
		}

		int positiveStart = positivePointer;
		int negativeStart = positivePointer - 1;
		int i = 0;
		while (i < B.length) {
			if (positiveStart < A.length && negativeStart >= 0) {
				if (A[positiveStart] > A[negativeStart]) {
					B[i] = A[negativeStart];
					negativeStart = negativeStart - 1;
				} else {
					B[i] = A[positiveStart];
					positiveStart = positiveStart + 1;
				}
			} else if (positiveStart < A.length) {
				B[i] = A[positiveStart];
				positiveStart = positiveStart + 1;
			} else {
				B[i] = A[negativeStart];
				negativeStart = negativeStart - 1;
			}
			i = i + 1;
		}
		return B;

	}

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		for(int x:nums2) {
			
		}
	}

	public static int[] sortedSquares(int[] A) {

		int[] B = new int[A.length];
		int positivePointer = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] >= 0) {
				positivePointer = i;
				break;
			}
		}

		for (int i = 0; i < A.length; i++) {
			A[i] = A[i] * A[i];
		}

		int positiveStart = positivePointer;
		int negativeStart = positivePointer - 1;
		int i = 0;
		while (positiveStart < A.length || negativeStart >= 0) {
			if (positiveStart == A.length) {
				B[i] = A[negativeStart];
				negativeStart = negativeStart - 1;
				i = i + 1;
				continue;
			} else if (negativeStart < 0) {
				B[i] = A[positivePointer];
				positiveStart = positiveStart + 1;
				i = i + 1;
				continue;
			}

			if (A[positiveStart] > A[negativeStart]) {
				B[i] = A[negativeStart];
				if (negativeStart != 0)
					negativeStart = negativeStart - 1;
			} else {
				B[i] = A[positivePointer];

				positiveStart = positiveStart + 1;
			}
			i = i + 1;
		}

//		int z = 0;
//		//while((z < B.length) && (positiveStart < B.length) && (negativeStart > -1)){
//		while((z < B.length)){
//			if((negativeStart > -1) && (A[positiveStart] > A[negativeStart])) {
//				B[z] = A[negativeStart];
//				negativeStart = negativeStart -1;
//			}
//			else {
//				B[z] = A[positiveStart];
//				positiveStart = positiveStart+1;
//			}
//			z = z+1;
//		}
		return B;
	}

	static void spiralPrint(int m, int n, int a[][]) {
		int i, k = 0, l = 0;
		/*
		 * k - starting row index m - ending row index l - starting column index n -
		 * ending column index i - iterator
		 */

		while (k < m && l < n) {
			// Print the first row from the remaining rows
			for (i = l; i < n; ++i) {
				System.out.print(a[k][i] + " ");
			}
			k++;

			// Print the last column from the remaining columns
			for (i = k; i < m; ++i) {
				System.out.print(a[i][n - 1] + " ");
			}
			n--;

			// Print the last row from the remaining rows */
			if (k < m) {
				for (i = n - 1; i >= l; --i) {
					System.out.print(a[m - 1][i] + " ");
				}
				m--;
			}

			// Print the first column from the remaining columns */
			if (l < n) {
				for (i = m - 1; i >= k; --i) {
					System.out.print(a[i][l] + " ");
				}
				l++;
			}
		}
	}

}

class Node {
	Node next;
	int data;

	public Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
}
