package patternmatch;

public class PatternMatchingBF {

	public static void main(String[] args) {
		
		String mainString = "Sadekujjaman";
		String patternString = "kujj";
		int ans = patternMatchingBF(mainString, patternString);
		System.out.println(ans);
		
	}
	
	private static int patternMatchingBF(String mainString, String patternString){
		
		int lm = mainString.length();
		int lp = patternString.length();
		int max = (lm - lp) + 1;
		
		for(int i = 0; i < max; i++){
			boolean flag = true;
			for(int j = 0; j < lp; j++){
				if(patternString.charAt(j) != mainString.charAt(j + i)){
					flag = false;
				}
			}
			
			if(flag == true)
				return i;
		}
		
		return -1;
	}

}
