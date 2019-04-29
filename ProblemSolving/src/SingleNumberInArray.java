import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SingleNumberInArray {

	public static void main(String[] args) {
		int[] input = {2,2,1};
		singleNumber(input);
	}
	
	public static int singleNumber(int[] nums) {
		Map<Integer, Integer> m1 = new HashMap<>();
		for(int n:nums) {
			if(m1.containsKey(n)){
				m1.put(n, m1.get(n)+1);
			}else {
				m1.put(n, 1);
			}
		}
		for(Entry<Integer, Integer> e1 : m1.entrySet()) {
			if(e1.getValue() == 1) {
				return e1.getKey();
			}
		}
        return 0;
    }
	
	public static int singleNumber1(int[] nums) {
		int singleNumber = 0;
		for(int n:nums) {
			singleNumber = singleNumber ^ n;
		}
		
        return singleNumber;
    }

}
