package conditionalfunctions;

public class Functions {
    public static void main(String[] args) {
	// Empty for now
    }

    public static String turbineControl(double input) {
	if(!(Math.abs(input - 50.0) < 1)) {
	    return "DISCONNECT";
	}

	if(!(Math.abs(input - 50.0) < 0.001)) {
	    if((input - 50) < 0) {
		return "MORE_WATER";
	    } else {
		return "LESS_WATER";		
	    }
	}

	return "STEADY";
    }
}
