package listoperations;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

// This class is responsible for parsing stdin and searching vor known
// patterns / commands. These commands manipulate an ArrayList of
// Strings. Some of the commands can have arguments (words / Strings).
public class Main {
    public static void main(String[] args) {
	// Scanner to read the input.
	Scanner scan = new Scanner(System.in);
	// The first word of a line.
	String command;
	// The first argument of a given command.
	String inputOne;
	// The second argument of a given command.
	String inputTwo;
	// This integer is used to keep track of weather the list is
	// already sorted. (A boolean might have been better).
	int sorted;
	// Keep track of whether the input was valid or not.
	int valid;
	// A string for temprurarily storing data.
	String tmp;
	// This is the ArrayList that the user can manipulate.
	ArrayList<String> str = new ArrayList<String>();

	// Repeat as long as there is an input.
	while (scan.hasNext()) {
	    valid = 0;
	    command = scan.next();

	    // Use regex
	    if (command.matches("^append")) {
		valid = 1;
		if (scan.hasNext()) {
		    inputOne = scan.next();
		    // Use regex
		    if (inputOne.matches("[a-z]*[A-Z]*[0-9]*[a-z]*[A-Z]*[0-9]*")) {
			// The input is a valid word
			str.add(inputOne);
		    } else {
			System.out.println("INVALID COMMAND");
		    }
		} //   else {
		//     // This state should never be reached. We were not
		//     // told how the program should react though...
		// }
	    }
	    
	    // Use regex
	    if (command.matches("^pop")) {
		valid = 1;
		if (str.size() > 0) {
		    str.remove(str.size() - 1);
		} else {
		    System.out.println("DOES NOT COMPUTE");
		}
	    }

	    if (command.matches("^set")) {
		valid = 1;
		inputOne = scan.next();
		if (scan.hasNext()) {
		    if (inputOne.matches("[0-9]*")) {
			if (scan.hasNext()) {
			    inputTwo = scan.next();
			} else {
			    inputTwo = "";
			}
			if ((Integer.parseInt(inputOne) < 0) || Integer.parseInt(inputOne) > str.size() - 1) {
			    System.out.println("DOES NOT COMPUTE");
			} else {
			    str.set(Integer.parseInt(inputOne), inputTwo);
			}
		    } else {
			System.out.println("DOES NOT COMPUTE");
		    }
		} //   else {
		//     // This state should never be reached. We were not
		//     // told how the program should react though...
		// }
	    }

	    if (command.matches("^remove-first")) {
		valid = 1;
		inputOne = scan.next();
		for (int i = 0; i < str.size(); i++) {
		    if (str.get(i).matches(inputOne)) {
			str.remove(i);
			break;
		    }
		}
	    }

	    if (command.matches("^remove-all")) {
		valid = 1;
		inputOne = scan.next();
		for (int i = 0; i < str.size(); i++) {
		    if (str.get(i).matches(inputOne)) {
			str.remove(i);
		    }
		}
	    }

	    if (command.matches("^print")) {
		valid = 1;
		System.out.print("::");
		for (int i = 0; i < str.size(); i++) {
		    System.out.print(" " + str.get(i));
		}
		System.out.println("");
	    }

	    if (command.matches("^sort")) {
		valid = 1;
		sorted = 0;
		Collections.sort(str);
	    }

	    if (command.matches("^reverse")) {
		valid = 1;
		for (int i = 0; i < (str.size() / 2); i++) {
		    tmp = str.get(i);
		    str.set(i, str.get(str.size() - i - 1));
		    str.set((str.size() - i - 1), tmp);
		}
	    }

	    if (valid == 0) {
		// This state is not permitted!
		System.out.println("INVALID COMMAND");
	    }
	}
    }
}
