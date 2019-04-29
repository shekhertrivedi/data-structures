import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MoveZeroesAtLastInPlace {

	public static void main(String[] args) {
		// int[] nums = {1,2,0,3,4};
		int[] nums = { 0, 0, 1 };
		MoveZeroesAtLastInPlace m = new MoveZeroesAtLastInPlace();
		m.moveZeroes(nums);
		for (int n : nums) {
			System.out.print(n);
		}

	}

	public void moveZeroes(int[] nums) {
		int countOfZero = 0;
		for (int n : nums) {
			if (n == 0)
				countOfZero++;
		}

		int movedZeroes = 0;

		int i = 0;
		while (movedZeroes != countOfZero) {
			if (nums[i] == 0) {
				movedZeroes++;
				int pointer = i;
				while (pointer + 1 < nums.length) {
					nums[pointer] = nums[pointer + 1];
					pointer++;
				}
				nums[nums.length - 1] = 0;
				i = 0;
				continue;
			}
			i++;
		}
	}
	
//	public static void main(String args[]) throws Exception {
//
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		String number = reader.readLine();
//		int N = Integer.parseInt(number);
//		System.out.println(fact(N));
//
//	}
//
//	public static int fact(int N) {
//		if (N == 0 || N == 1)
//			return 1;
//		else
//			return N * fact(N - 1);
//	}
	
//	public static void main(String args[]) throws Exception {
//
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		String str1 = reader.readLine();
//		String str2 = reader.readLine();
//		char[] carr = str1.toCharArray();
//		char[] duplicates = new char[carr.length];
//		Set<Character> s1 = new HashSet<>();
//		int  i = 0;
//		boolean flag = true;
//		for(char c:carr) {
//			Character c1 = (Character)c;
//			flag = s1.add(c1);
//			if(!flag) {
//				duplicates[i] = c;
//				i++;
//			}
//		}
//		
//		for(char duplicate:duplicates) {
//			str2 = str2.replaceAll(Character.toString(duplicate), "");
//		}
//		System.out.println(str2);
//		
//	}
	
//	public static void main(String args[]) throws Exception {
//
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		String str1 = reader.readLine();
//		String str2 = reader.readLine();
//		int noOfElements = Integer.parseInt(str1);
//		String[] sarr = str2.split(",");
//		if(noOfElements == 0 || noOfElements == 1)
//			System.out.println("-1");
//		else {
//			List<Integer> duplicates = new ArrayList<>();
//			Set<Integer> s1 = new HashSet<>();
//			Integer n = 0;
//			boolean flag = true;
//			for(String s:sarr) {
//				n = Integer.parseInt(s);
//				flag = s1.add(n);
//				if(!flag) {
//					duplicates.add(n);
//				}
//			}
//			String result = "";
//			for(Integer n1:duplicates) {
//				result = result+","+n1;
//			}
//			if(result.length() > 1) {
//				result = result.substring(1);
//				System.out.println(result);
//			}else {
//				System.out.println("-1");
//			}
//			
//		}
//	}
	
	
}
