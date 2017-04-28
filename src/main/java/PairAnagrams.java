import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PairAnagrams {
	
	public static Map<Integer, ArrayList<String>> superSet = new HashMap<Integer, ArrayList<String>>();
	
	public static void pairAnagrams(String[] arr) {
		for (String s: arr) {
			int hash = computeHash(s);
			if (superSet.get(hash) == null) {
				superSet.put(hash, new ArrayList<String>());
			}
			superSet.get(hash).add(s);
		}
	}
	
	public static int computeHash(String s) {
		int res = 0;
		for(int i = 0; i < s.length(); i++) {
			res += s.charAt(i) * 10;
		}
		return res;
	}
	
	public static void main(String[] args) {
		String[] arr = {"trees", "bike", "cars", "steer", "arcs","cbps"};
		pairAnagrams(arr);
		for (ArrayList<String> a: superSet.values()) {
			System.out.println(a);
		}
	}
}