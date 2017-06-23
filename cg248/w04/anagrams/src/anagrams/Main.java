package anagrams;

import java.util.Scanner;
import java.util.ArrayList;

// Detect anagrams. Both input words must have the same length. The
// anagrams are detected by parsing through two both words and
// deleting a character each time it is found in both words. If both
// words are empty in the end, they were anagrams.
public class Main {
    public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	
	String s1 = scan.next();
	String s2 = scan.next();
	ArrayList<Character> str1 = new ArrayList<Character>();
	ArrayList<Character> str2 = new ArrayList<Character>();

	for (int m = 0; m < (s1.length()); m++) {
	    str1.add(s1.charAt(m));
	}

	for (int n = 0; n < (s2.length()); n++) {
	    str2.add(s2.charAt(n));
	}

	for (int m = 0; m < str2.size();) {
	    for (int n = 0; n < str1.size();) {
		if (Character.toUpperCase(str1.get(n)) == Character.toUpperCase(str2.get(m))) {
		    str1.remove(n);
		    str2.remove(m);
		    n = 0;
		    m = 0;
		    break;
		} else {
		    n++;
		    if (n == str1.size()) {
			m++;
		    }
		}
	    }
	}

	if ((str1.size() == 0) && (str2.size() == 0)) {
	    System.out.println("Anagrams");
	} else {
	    System.out.println("Not anagrams");
	}
    }
}


