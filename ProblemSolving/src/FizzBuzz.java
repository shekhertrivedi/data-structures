import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<String> fizzBuzz(int n) {
        List<String> returnList = new ArrayList<>();
        int i = 1;
        if(n > 0) {
        	while(i<=n) {
        		if(i%15 == 0) {
        			returnList.add("FizzBuzz");
        			//continue;
        		}else if(i%5 == 0) {
        			returnList.add("Buzz");
        			//continue;
        		}else if(i%3 == 0) {
        			returnList.add("Fizz");
        			//continue;
        		}else {
        			returnList.add(i+"");
        			//continue;
        		}
        		i = i + 1;
        	}
        }
        return returnList;
    }

}
