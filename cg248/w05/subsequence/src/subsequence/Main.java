package subsequence;

/**
 * Created by thiemann on 21.05.17.
 * Edited by Chandran on 02.06.2017
 */
public class Main {
    public enum PartialOrdering {
	LESS,
	EQUAL,
	GREATER,
	INCOMPARABLE
    }

    /** 
     * Initiall assume that the two strings are incompattible, and
     * adjust the statements depending on how far we can iterate
     * through each of the strings...
     * 
     * @param s1 
     * @param s2 
     * 
     * @return 
     */
    public static PartialOrdering subsequenceCompare(String s1, String s2) {

	boolean sOneInSTwo = true;
	boolean sTwoInSOne = true;
	char s1Char;
	char s2Char;
	int n = 0;
	int m = 0;

	// Search for s2 in s1.
	while ((n < s1.length()) && (m < s2.length())) {
	    if ((n == s1.length()) || (m == s2.length())) {
		break;
	    }

	    s1Char = s1.charAt(n);
	    s2Char = s2.charAt(m);

	    if (s1Char != s2Char) {
		// No match.
		n++;
	    } else {
		// Found a match.
		n++;
		m++;
	    }
	}

	if (m >= s2.length()) {
	    sTwoInSOne = false;
	}

	n = 0;
	m = 0;

	// Search for s1 in s2.
	while ((n < s2.length()) && (m < s1.length())) {
	    if ((n == s2.length()) || (m == s1.length())) {
		break;
	    }

	    s1Char = s1.charAt(m);
	    s2Char = s2.charAt(n);

	    if (s1Char != s2Char) {
		// No match.
		n++;
	    } else {
		// Found a match.
		n++;
		m++;
	    }
	}

	if (m >= s1.length()) {
	    sOneInSTwo = false;
	}

	if (sOneInSTwo && sTwoInSOne) {
	    return PartialOrdering.INCOMPARABLE;
	} else if (sOneInSTwo) {
	    return PartialOrdering.GREATER;
	} else if (sTwoInSOne) {
	    return PartialOrdering.LESS;
	} else {
	    return PartialOrdering.EQUAL;
	}
    }


    /** 
     * I used the main method for quick testing, before writing a
     * propper test in subsequence.MainTest. Ideally it should have
     * been test driven development...
     * 
     * @param argse 
     */
    public static void main(String[] argse) {
	// System.out.println(subsequenceCompare("Hello World", "eloWrld"));
	// System.out.println(subsequenceCompare("eloWrld", "Hello World"));
	// System.out.println(subsequenceCompare("Hello World", "World Hello"));
	// System.out.println(subsequenceCompare("Hello", "Hello"));
    }
}
