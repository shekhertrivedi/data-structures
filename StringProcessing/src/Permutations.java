import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Permutations {

	static List<String> perms = new ArrayList();
	
	public static void main(String[] args) {
		Map<String, Integer> wordCounts = new HashMap<>();
        wordCounts.put("USA", 100);
        wordCounts.put("jobs", 200);
        wordCounts.put("software", 50);
        wordCounts.put("technology", 70);
        wordCounts.put("opportunity", 200);
		System.out.println(sortByValue(wordCounts));
	}
	
	public static Map getSortingByValue(Map m1){
		
		
		return null;
	}
	
	public static Map<String, Integer> sortByValue(final Map<String, Integer> wordCounts) {
        return wordCounts.entrySet()
                .stream()
                .sorted((Map.Entry.<String, Integer>comparingByValue().reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		//perrec("abc");
		//System.out.println(perms);
		//System.out.println(getRemainingString('a', "abc"));
		permute("abc", 0, 2);
	}*/
	
	/*public static List<String> getAllPermutations(String s) {
		List returnList = new ArrayList();
		if(s.length() == 1) {
			returnList.add(s);
			return returnList;
		}
		char[] carr = s.toCharArray();
		String output = "";
		for(char c:carr) {
			String tempPer = c + perrec(getRemainingString(c, s));
			System.out.println(tempPer);
		}
		System.out.println(output);
		return null;
	}*/
	
	public static String perrec(String s) {
		String result = "";
		if(s.length() == 1) {
			return s;
		}

		for(char ch:s.toCharArray()) {
			result = ch + perrec(getRemainingString(ch, s));
			
			//perms.add(result);
			//return result;
		}
		perms.add(result);
		return result;
	}
	
	public static String getRemainingString(char remove, String s) {
		int count = 0;
		char[] carr = s.toCharArray();
		char[] result = new char[carr.length -1];
		for(int i=0;i<carr.length;i++) {
			if(carr[i] != remove) {
				result[count] = carr[i];
				count++;
			}
		}
		return new String(result);
	}
	
	public static void permute(String str, int l, int r) 
    { 
        if (l == r) 
            System.out.println(str); 
        else
        { 
            for (int i = l; i <= r; i++) 
            { 
                str = swap(str,l,i); 
                permute(str, l+1, r); 
                str = swap(str,l,i); 
            } 
        } 
    }
	
	public static String swap(String a, int i, int j) 
    { 
        char temp; 
        char[] charArray = a.toCharArray(); 
        temp = charArray[i] ; 
        charArray[i] = charArray[j]; 
        charArray[j] = temp; 
        return String.valueOf(charArray); 
    } 

}
