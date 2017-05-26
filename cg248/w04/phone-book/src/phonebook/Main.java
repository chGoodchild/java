package phonebook;

import java.util.*;
import java.io.*;

// Collect the users input in a hash map to create a "phone
// book". Later return the values uppon request.
public class Main {
    public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);

	InputStreamReader r = new InputStreamReader(System.in);
	BufferedReader br = new BufferedReader(r);

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
	    

	// withoutSpaces = withSpaces = "";
	// sw = 1;
	// sw = 0;
	// while (scan.hasNextLine() && scan.nextLine().isEmpty()) {
	//     withSpaces = scan.nextLine();
	// }
	//     System.out.println("Ping");
	//      withSpaces = scan.nextLine();
	// }
	
	// Almost the same thing as above...
	// while (scan.hasNext()) {
	while (scan.hasNext() && (n != 0)) {
	    
	    // try {

	    // 	while (br.readLine() == null) {
	    // 	    tmp = br.readLine();
	    // 	}
	    // } catch (IOException e) {
	    // 	System.out.println("IOEXception e");
	    // 	break;
	    // }

	    // for (int m = 0; m < 3; m++) {
	    // if (scan.hasNextLine()) {
	    try {
		tmp = br.readLine();
	    } catch (IOException e) {
		System.out.println("IOEXception e");
		break;
	    }
	    // } else {
	    // I have to do this, because the test case doesn't
		// have a new line after Harry!
	    // 	tmp = scan.next();
	    // }
	    // else {
	    // 	break;
	    // }

	    if (tmp.replace(" ", "").matches("[a-z]*[A-Z]*[a-z]*[A-Z]*[a-z]*[A-Z]*[a-z]*[A-Z]*")) {
		// It's a name
		// if (m == 0) {
		    withSpaces = tmp;
		    withoutSpaces = tmp.replace(" ", "");
		    // if (map.get(withoutSpaces) != null) {
		    // 	break;
		    // }
		// }

		// if ((m == 1) && !(tmp.matches("$.*"))) {
		//     withSpaces += " " + tmp;
		//     withoutSpaces += tmp;
		//     break;
		// }

	    } else if (sw == 0) {
		// It's neither a name nor a number.
		System.out.println("Not a name: " + tmp);
		sw = 1;
		// break;
	    }

	    // }

	    // withoutSpaces.matches("[a-z]*[A-Z]*[a-z]*[A-Z]*[a-z]*[A-Z]*[a-z]*[A-Z]*")

	    if (map.get(withoutSpaces) != null) {
		System.out.println(withSpaces + " = " + map.get(withoutSpaces));
	    } else if (sw == 0) {
		System.out.println("Not found: " + withSpaces);
		sw = 0;
	    }
	}
    }
}
