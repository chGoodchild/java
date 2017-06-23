package weirdnumbers;

import java.util.Scanner;
import java.lang.Boolean;

public class Main {
    public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	int input = scan.nextInt();
	boolean is_weird = false;

	if((input % 2) == 1) {
	    // odd number
	    is_weird = true;
	} else {
	    // even number
	    if((2 <= input) && (input <= 5)) is_weird = false;
	    if((6 <= input) && (input <= 20)) is_weird = true;
	    if(input > 20) is_weird = false;
	}

	if(input < 0) is_weird = true;

	if(is_weird == true) {
	    System.out.println("Weird");
	} else {
	    System.out.println("Not Weird");
	}
    }
}
