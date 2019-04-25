import java.io.*;
import java.util.*;

public class TestClass {
	public static void main(String[] args) throws IOException {
		/*
		 * BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 * PrintWriter wr = new PrintWriter(System.out); int N =
		 * Integer.parseInt(br.readLine().trim()); int[] A = new int[N]; String[] inp =
		 * br.readLine().split(" "); for (int i = 0; i < N; i++) { A[i] =
		 * Integer.parseInt(inp[i]); } int out_ = solve(N, A); System.out.println(out_);
		 * wr.close(); br.close();
		 */
		/*int[] A = { 2, 3, 4, 5, 14 };
		divisibilityCheck1(A);*/
		int[] A = { 2, 3, 4, 5, 14 };
		solution(A);
		
	}

	static int solve(int N, int[] A) {
		Integer[] arr = Arrays.stream(A).boxed().toArray(Integer[]::new);
		return divisibilityCheck(Arrays.asList(arr), N);
	}

	static int divisibilityCheck1(int[] A) {
		Map<Integer, List<Integer>> m1 = new HashMap<>();
		for (int i : A) {
			m1.put(i, printDivisors(i));
			// printDivisors(i);
		}
		System.out.println(m1);
		List<int[]> l2 = Arrays.asList(A);
		// for(int i=0;i<A.length;i++) {
		for (int[] i : l2) {
			List l1 = m1.get(i);
		}

		return 0;
	}

	static List printDivisors(int n) {
		// int[] result = new int[n/2];
		List<Integer> l1 = new ArrayList<>();
		int count = 0;
		for (int i = 1; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				// If divisors are equal, print only one
				if (n / i == i) {
					l1.add(i);
					// System.out.printf("%d ", i);
				} else {
					// Otherwise print both

					l1.add(i);
					l1.add(n / i);
					// System.out.printf("%d %d ", i, n / i);
				}

			}
		}
		Collections.sort(l1);
		l1.remove(0);
		l1.remove(l1.size() - 1);
		return l1;
	}

	static int divisibilityCheck(List<Integer> arr, int n) {

		List<Integer> s = new ArrayList<Integer>();
		int max_ele = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			s.add(arr.get(i));
			max_ele = Math.max(max_ele, arr.get(i));
		}

		LinkedHashSet<Integer> res = new LinkedHashSet<Integer>();
		for (int i = 0; i < n; i++) {
			if (arr.get(i) != 0)
				for (int j = arr.get(i) * 2; j <= max_ele; j += arr.get(i)) {

					if (s.contains(j))
						res.add(j);
				}
		}
		return res.size();
	}

	// you can also use imports, for example:
	// import java.util.*;

	// you can write to stdout for debugging purposes, e.g.
	// System.out.println("this is a debug message");

	public static int solution(int[] A) {
		int max = A[0];
		List l1 = Arrays.asList(A);
		Collections.sort(l1);
		for (int a : A) {
			if (a > max) {
				max = a;
			}
		}
		System.out.println(l1);
		return 0;
	}	

	public static boolean checkIfPresent(int[] A, int n) {
		for (int a : A) {
			if (a == n)
				return true;
		}
		return false;
	}

}
