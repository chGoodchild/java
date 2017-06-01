package subsequence;

/**
 * Created by thiemann on 21.05.17.
 */
public class Main {
    public enum PartialOrdering {
	LESS,
	EQUAL,
	GREATER,
	INCOMPARABLE
    }

    /** 
     * 
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

	System.out.println("Look for " + s2 + " in " + s1);
	// Search for s2 in s1.
	// for (; m < s2.length(); m++) {
	    System.out.println("outer_cycle");
	    while ((n < s1.length()) && (m < s2.length())) {
		System.out.print(" m: " + m + " n: " + n);
		s1Char = s1.charAt(n);
		s2Char = s2.charAt(m);

		System.out.println(s2Char + " and " + s1Char);

		if (s1Char != s2Char) {
		    // No match.
		    if (n < s1.length()) {
			n++;
			// break;
		    } else {
			break;
		    }
		} else {
		    // Found a match.
		    n++;
		    m++;
		}
	    }
	// }

	if (m >= s2.length()) {
	    sTwoInSOne = false;
	}

	n = 0;
	m = 0;
	System.out.println("Look for " + s1 + " in " + s2);
	// Search for s1 in s2.
	//	for (; m < s1.length();) {
	    System.out.println("outer_cycle");
	    while ((n < s2.length()) && (m < s1.length())) {
		System.out.print(" m: " + m + " n: " + n);
		s1Char = s1.charAt(m);
		s2Char = s2.charAt(n);

		System.out.println(s1Char + " and " + s2Char);

		if (s1Char != s2Char) {
		    // No match.
		    if (n < s2.length()) {
			n++;
			// break;
		    } else {
			break;
		    }
		} else {
		    // Found a match.
		    n++;
		    m++;
		}
	    }
	    //	}

	System.out.println("PING3");
	if (m >= s1.length()) {
	    sOneInSTwo = false;
	}

	if (sOneInSTwo && sTwoInSOne) {
	    System.out.println("PING");
	    return PartialOrdering.EQUAL;
	} else if (sOneInSTwo) {
	    System.out.println("PING");
	    return PartialOrdering.LESS;
	} else if (sTwoInSOne) {
	    System.out.println("PING");
	    return PartialOrdering.GREATER;
	} else {
	    System.out.println("PING");
	    return PartialOrdering.INCOMPARABLE;
	}
    }


    /** 
     * 
     * 
     * @param argse 
     */
    public static void main(String[] argse) {
	System.out.println(subsequenceCompare("Hello World", "eloWrld"));
	System.out.println(subsequenceCompare("Hello World", "World Hello"));
    }
}

