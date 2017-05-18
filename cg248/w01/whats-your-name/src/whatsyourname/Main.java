package whatsyourname;


import java.io.*;
import java.util.Scanner;


public class Main {
    /**
     * Read name and surname from stdin and print a greeting.
     */
    public static void main(String[] args)  {
	// Initialize the scanner.
        Scanner scan = new Scanner(System.in);

	// Use the scanner.
	String first_name = scan.next();
	String sir_name = scan.next();

	// Use the scanned words.
	System.out.println("Hello " + first_name + "! " + "You just delved into Java.");
	System.out.println("Your full name: " + first_name + " " + sir_name + ".");

    }
}
