import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


class Student {
	private String name;
	private String id;
	
	public Student(String name, String id) {
		this.name = name;
		this.id = id;
	}
	
	public boolean equals(Object obj) {
		return true;
	}
	
	public int hashCode() {
		return this.name.length();
	}
	
	public String toString() {
		return this.name+"  "+this.id;
	}
	
}
@SuppressWarnings("all")
public class ToggleLockerDoors {

	public static void main(String[] args) {
		
		int[] arr = new int[10];
		for(int i=0;i<arr.length;i++) {
			arr[i]=i+1;
		}
		System.out.println("Missing No is => "+findMissingNo(arr));
		
	}
	
	public static int findMissingNo(int[] arr) {
		int idealSum = (12*11)/2;
		int actualSum = 0;
		for(int i=0;i<arr.length;i++) {
			actualSum = actualSum + arr[i];
		}
		return idealSum - actualSum;
	}
	
	/*public static void main(String[] args) {
		Map m1 = new HashMap();
		Student s1 = new Student("abc", "100");
		Student s2 = new Student("xyz", "200");
		Student s3 = new Student("abcd", "100");
		m1.put(s1, 100);
		m1.put(s2, 100);
		m1.put(s3, 100);
		System.out.println(m1);
		
	}*/
	/*public static void main(String[] args) {
		
		//int[][] arr = new int[3][3];
		int[][] arr = {{1,1,0},{1,0,1},{0,0,0}};
		//int[][] arr = {{1,1,0},{1,0,1}};
		System.out.println(flipAndInvertImage(arr));
		
		
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("My run method");
				
			}
			
		});
		
		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				System.out.println("My run method");	
			}
		};
		
		r1.run();
		
		
		
	}*/

	public List<Integer> toggleLockers(Integer lockerCount) {

		int openCount = 0;
		// result list which contains the door nos which are open
		List<Integer> openDoorsList = new ArrayList<>();
		// Map stores the locker number and number of times door needs to be toggled
		Map<Integer, Integer> m1 = new HashMap();
		m1.put(1, 1);
		m1.put(2, 2);

		if (lockerCount > 2) {
			for (int i = 3; i < lockerCount; i++) { // iteration for every locker
				m1.put(i, getNumberOfIterations(i));
			}
		}

		// Getting the open count through the values of map
		for (int i : m1.values()) {
			if (i % 2 != 0) {
				openCount++;
			}
		}

		// adding the open doors to the list openDoorsList
		for (Entry<Integer, Integer> e1 : m1.entrySet()) {
			if (e1.getValue() % 2 != 0) {
				openDoorsList.add(e1.getKey());
			}
		}

		return openDoorsList;
	}

	public int getNumberOfIterations(int number) {
		int count = 2;
		for (int i = 2; i < number; i++) {
			if (number % i == 0) {
				count++;
			}
		}

		return count;
	}
	
	//literals at odd places in reverse order
	public static String oddReverse(String str) {

		String retString = "";
		char[] carr = str.toCharArray();
		if (str.length() % 2 == 0) {
			for (int i = str.length() - 2; i >= 0; i = i - 2) {
				retString = retString + carr[i];
			}
		} else {
			for (int i = str.length() - 1; i >= 0; i = i - 2) {
				retString = retString + carr[i];
			}
		}

		return retString;
	}

	//seperate odd and even in an array
	public int[] sortArrayByParity(int[] A) {
	
		int[] retArr = new int[A.length];
		int even = 0;
	    int odd = A.length-1;
	    
	    for(int i=0;i<A.length;i++) {
	    	if(A[i]%2 == 0) {
	    		retArr[even] = A[i];
	    		even++;
	    	}
	    	else {
	    		retArr[odd] = A[i];
	    		odd--;
	    	}
	    }
	    
	    return retArr;
	}
	
	public static int[][] flipAndInvertImage(int[][] A) {
		
		int[][] resArr = new int[A.length][A.length];
		for(int i=0;i<A.length;i++) {
			int count = 0;
			for(int j=A.length-1;j>-1;j--) {
				resArr[i][count] = A[i][j];
				if(resArr[i][count] == 0) {
					resArr[i][count] = 1;
				}
				else {
					resArr[i][count] = 0;
				}
				count++;
			}
		}
		return resArr;
    }
	
	/*
	public BIDatasetLuceneIndex(String tenantID, String language, String dataIndexPath, String xsaName)
	   {
	      super();
	      this.tenantID = tenantID;
	      this.language = language;
	      this.dataIndexPath = dataIndexPath;
	      securityID = new SecurityIDSequencer();

	      if (language == null || language.isEmpty())
	         analyzer = AnalyzerFactory.getInstance(Version.LUCENE_7_1_0).getAnalyzer();
	      else
	         analyzer = AnalyzerFactory.getInstance(Version.LUCENE_7_1_0).getAnalyzerForLanguage(language);
	
	      
	      textFieldType.setStoreTermVectors(true);
	      HashMap<String, Analyzer> fieldNameAnalyzer = new HashMap<String, Analyzer>();
	      try 
	      {
	    	  Analyzer customAnalyzer = CustomAnalyzer.builder().withTokenizer(KeywordTokenizerFactory.class).addTokenFilter(LowerCaseFilterFactory.class).build();
			  fieldNameAnalyzer.put("Content", customAnalyzer);
	      } 
	      catch (IOException e) 
	      {
	    	  logger.log(BISearchLoggerFactory.INFORMATION_LEVEL, "Error in custom analyzer in index", e);
	      } 
	      analyzer = new DelegatingAnalyzerWrapper(Analyzer.PER_FIELD_REUSE_STRATEGY) {

	          @Override
	          protected Analyzer getWrappedAnalyzer(String fieldName) 
	          {
	              Analyzer analyzer = fieldNameAnalyzer.get(fieldName);
	              if (analyzer != null) 
	              {
	                  return analyzer;
	              } 
	              else 
	              {
	            	  if (language == null || language.isEmpty())
	            	  {
	            		  return AnalyzerFactory.getInstance(Version.LUCENE_7_1_0).getAnalyzer();
	            	  }
	            	  else
	            	  {
	            		  return AnalyzerFactory.getInstance(Version.LUCENE_7_1_0).getAnalyzerForLanguage(language);
	            	  }
	              }
	          }
	      };
	      this.xsaName = xsaName;
	   }*/

}
