package stdin;


import java.util.Scanner;

// read  3 ints from sdtin and print each on a new line
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

	// Read three Integers
	int one = scan.nextInt();
	int two = scan.nextInt();
	int three = scan.nextInt();

        // Write the three integers
	System.out.println(one);
	System.out.println(two);	
	System.out.println(three);
    }
}
