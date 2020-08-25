package myPackage;

public class Question18Implementation extends Question18Abstract {
	
	@Override
	public boolean findCapitalLetters(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) <= 90 && s.charAt(i) >= 65) return true;
		}
		
		return false;
	}
	
	@Override
	public String allCaps(String s) {
		StringBuilder sb = new StringBuilder(s);
		
		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) <= 122 && sb.charAt(i) >= 97) {
				sb.setCharAt(i, (char)(sb.charAt(i) - 32));
			}
		}
		
		return sb.toString();
	}

	@Override
	public int convertToInt(String s) {
		int n = 0;
		
		for (int i = 0; i < s.length(); i++) {
			n += s.charAt(i);
		}
		
		return n + 10;
	}
}
