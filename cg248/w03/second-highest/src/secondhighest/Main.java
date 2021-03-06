package secondhighest;

import java.*;

public class Main {
    public static int secondHighest(int[] numbers) {
	int largest = Integer.MIN_VALUE;
	int second_largest = Integer.MIN_VALUE;
	for (int i = 0; i < numbers.length; i++) {
	    if (numbers[i] > largest) {
		second_largest = largest;
		largest = numbers[i];
	    } else if ((numbers[i] > second_largest) && (numbers[i] != largest)) {
		second_largest = numbers[i];
	    }
	}
	return second_largest;
    }

    public static void main(String[] args) {
	
    }
}
