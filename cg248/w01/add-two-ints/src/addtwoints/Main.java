package addtwoints;

import java.util.Scanner;

// read two ints from stdin, add them and print out the result.
public class Main {

    public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);

	// First read both integers
	int first = scan.nextInt();
	int second = scan.nextInt();

	// Then print both integers
	int sum = first + second;
	System.out.println(sum);
    }
}
