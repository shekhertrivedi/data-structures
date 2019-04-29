
public class ReverseStringInPlace {

	public static void main(String[] args) {
		//char[] input = {'h','e','l','l','o','p'};
		char[] input = {'A',' ','m','a','n',',',' ','a',' ','p','l','a','n',',',' ','a',' ','c','a','n','a','l',':',' ','P','a','n','a','m','a'};
		reverseString(input);
	}
	
	public static void reverseString(char[] s) {
        if(s.length>1) {
        	int start = 0;
            int end = s.length-1;
            int limit = s.length/2;
            while(start < limit) {
            	char temp = s[start];
            	s[start] = s[end];
            	s[end] = temp;
            	start = start + 1;
            	end = end - 1;
            }
            System.out.println(s);
        }
    }

}
