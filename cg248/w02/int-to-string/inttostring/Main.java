package inttostring;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);

	// Check if it has an integer and report the result...
	if(scan.hasNextInt()) {
	    System.out.println("Found Int: " + scan.nextInt());
	} else {
	    System.out.println("No int");
	}
    }
}
