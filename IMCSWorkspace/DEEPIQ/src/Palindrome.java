import java.util.Arrays;

public class Palindrome {

	public static void main(String[] args) {
		/*String str="madam";
		int start=str.length()/2;
		int end=str.length()/2;
		if(str.length()%2==0){
			System.out.println(checkPalindrome(str,start , end));
		}else{
			System.out.println(checkPalindrome(str, start-1, end+1));
		}*/
		
		String str1="beat";
		String str2="bett";
		System.out.println(chechkAnagram(str1,str2));
	}

	
	private static boolean chechkAnagram(String str1, String str2) {
		if(str1.length()!=str2.length())
			return false;
		int [] temp=new int[26];
		Arrays.fill(temp, 0);
		for (int i = 0; i < str1.length(); i++) {
			temp[str1.charAt(i)-'a']++;
		}
		
		for (int i = 0; i < str2.length(); i++) {
			if(temp[str2.charAt(i)-'a']<=0){
				return false;
			}else{
				temp[str2.charAt(i)-'a']--;
			}
		}
		
		return true;
		
	}


	public static boolean checkPalindrome(String str, int start, int end) {
		while (start >= 0 && end < str.length() && str.charAt(start) == str.charAt(end)) {
			start--;
			end++;
		}
		if (start == -1 && end == str.length())
			return true;
		else
			return false;
	}

}
