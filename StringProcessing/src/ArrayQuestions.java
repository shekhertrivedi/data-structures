import java.util.HashMap;
import java.util.Map;

public class ArrayQuestions {

	public static void main(String[] args) {
//		ArrayQuestions aq = new ArrayQuestions();
//		int[] A = {1,2,3,4,5,8,4,0};
//		//A = aq.sortArrayByParity(A);
//		A = aq.sortArrayByParityInPlace(A);
//		for(int i : A) {
//			System.out.println(i);
//		}
		Map m1 = new HashMap<>();
		Integer i1 = 1000000;
		String s = "shekhar";
		
		System.out.println("ABC hashcode: => "+"ABCD".hashCode());
		System.out.println("XYZ hashcode: => "+"xyz".hashCode());
		System.out.println("ABCD hashcode: => "+"ABCD".hashCode());
		//System.out.println(hash(s));
		testShiftOperator();
		/*System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.SIZE);
		System.out.println(Integer.TYPE);
		int num = 10;
		if(num == (num & Integer.MAX_VALUE))
			System.out.println("Even number");*/
		
	}
	
	static final int hash(Object key) {
        int h;
        //return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
        h = key.hashCode();
        int x = h >>> 16;
        h = h ^ (x);
        return h;
        		
    }
	
	static final void testShiftOperator() {
		int number = 3; 
		System.out.println(number); 
		System.out.println("Before shift : " + Integer.toBinaryString(number));
		
		number = number >> 1; //shifting 1 right bit

		System.out.println(number);
		System.out.println("After shift : " + Integer.toBinaryString(number));
		
		// Using unsigned right shift with negative number in Java
        // we can use binary literals from JDK 1.7 to assign 
        // binary values to an integer, 0b is for binary, similar to 0x of hexadecimal
        number = 0b1111_1000_1111_1010_1111_1000_1111_1010;
       
        System.out.println("Before unsigned right shift : " + Integer.toBinaryString(number));
        System.out.println("number in decimal format : " + number);
                               
        number = number >>> 1; //shift 1 bit using right shift without sign

        System.out.println("After unsigned right shift : " + Integer.toBinaryString(number));
        System.out.println("number in decimal format : " + number);
	}
	
	public int[] sortArrayByParity(int[] A) {
		int[] returnArray = new int[A.length];
        int start = 0;
        int end = A.length - 1;
        for(int i=0;i<A.length;i++) {
        	if(A[i]%2 == 0) returnArray[start++] = A[i];
        	else returnArray[end--] = A[i];
        }
        return returnArray;
    }
	
	public int[] sortArrayByParityInPlace(int[] A) {
		
		int evenCount = 0;
		int oddCount = 0;
		for(int i=0;i<A.length;i++) {
			if(A[i]%2 == 0)
				evenCount++;
			else
				oddCount++;
		}
		
		if(evenCount == 0 || oddCount == 0)
			return A;
		
		
        int start = 0;
        int end = A.length - 1;
        for(int i=0;i<A.length;i++) {
        	if(A[i]%2 == 0) {
        		int temp = 0;
        		temp = A[start];
        		A[start] = A[i];
        		A[i] = temp;
        		start++;
        	}else {
        		for(int j=i+1;j<A.length;j++) {
        			if(A[j]%2==0) {
        				int temp = 0;
                		temp = A[j];
                		A[j] = A[i];
                		A[i] = temp;
                		end--;
                		break;
        			}
        		}
        	}
        }
        return A;
    }

}
