package phonebook;

import java.util.*;
import java.io.*;

// Collect the users input in a hash map to create a "phone
// book". Later return the values uppon request.
public class Main {
    public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	int n = scan.nextInt();
	String withSpaces = "";
	String withoutSpaces = "";
	String tmp = "";
	int sw = 0;
	
	Map<String, String> map = new HashMap<String, String>();

	for (int i = 0; i < n; i++) {

	    withSpaces = "";
	    withoutSpaces = "";
	    tmp = "";

	    // Read up to three words and no more than that.
	    for (int m = 0; m < 4; m++) {
		tmp = scan.next();

		if (tmp.matches("[a-z]*[A-Z]*[a-z]*[A-Z]*")) {
		    // It's a name
		    if (m == 0) {
			withSpaces = tmp;
			withoutSpaces = tmp;
		    }

		    if (m == 1) {
			withSpaces += " " + tmp;
			withoutSpaces += tmp;
		    }

		    if (m == 2) {
			System.out.println("Error: cannot parse phone book.");
			sw = 1;
			break;
		    }

		} else if (tmp.matches("[0-9]*")) {
		    // It's a number
		    if (m == 0) {
			System.out.println("Not a name: " + tmp);
			break;
		    }

		    if (m == 1) {
			if (map.get(withoutSpaces) != null) {
			    System.out.println("Warning: overwriting entry for: " + withSpaces);
			}
			map.put(withoutSpaces, tmp);
			break;
		    }

		    if (m == 2) {
			if (map.get(withoutSpaces) != null) {
			    System.out.println("Warning: overwriting entry for: " + withSpaces);
			}
			map.put(withoutSpaces, tmp);
			break;
		    }
		    
		} else {
		    // It's neither a name nor a number.
		    System.out.println("Not a name: " + tmp);
		    break;
		}
	    }
	}
	    
	// Skip the first two new lines (if they are present).
	sw = 1;

	// Almost the same thing as above...
	
	// This code returns "Not Found" when unnecessary new lines
	// are in the input. I spent a lot of time trying to handle
	// this issue, but I didn't manage. I also tried with Buffered
	// reader...
	while (scan.hasNextLine() && (n != 0)) {

	    if (scan.hasNextLine()) {
		tmp = scan.nextLine();
	    }

	    if (tmp.replace(" ", "").matches("[a-z]*[A-Z]*[a-z]*[A-Z]*[a-z]*[A-Z]*[a-z]*[A-Z]*")) {
		withSpaces = tmp;
		withoutSpaces = tmp.replace(" ", "");

	    } else if (sw == 0) {
		// It's neither a name nor a number.
		System.out.println("Not a name: " + tmp);
		sw = 1;
	    }

	    if (map.get(withoutSpaces) != null) {
		System.out.println(withSpaces + " = " + map.get(withoutSpaces));
	    } else if (sw == 0) {
		System.out.println("Not found: " + withSpaces);
	    }

	    if (sw > 0) {
		sw--;
	    }
	}
    }
}
