package helpers;

/**
 * A class with multiple static methods for various input types and styles. 
 * Built for the TerminalGames app.
 * 
 * @author Catmāoneko猫
 * @author EmperorGrock
 * @author invisiblekoi
 */
public class Input{
	/**
	 * Method to print a message, then get a string of whatever the user typed, between minLength and maxLength inclusive.
	 * @param message The message to be printed before getting input
	 * @param minLength The minimum length of the user input, inclusive
	 * @param maxLength The maximum length of the user input, inclusive
	 * @return the string of whatever the user typed between min and max length
	 */
	public static String getString(String message, int minLength, int maxLength){
		Terminal.printlnWithFormat(message + ": ", 7, 4);
		String input = System.console().readLine();
		while(input.length() > maxLength || input.length() < minLength){
			Terminal.printlnWithFormat("Input must be between " + minLength + " and " + maxLength + " Characters: ", 5, 3);
			input = System.console().readLine();
		}
		return input;
	}

	/**
	 * Simple method to print a message and return a string of whatever the user typed. 
	 * @param message The message to be printed before getting input
	 * @return whatever the user typed
	 */
	public static String getString(String message){
		Terminal.printlnWithFormat(message + ": ", 7, 4);
		return System.console().readLine();
	}

	/**
	 * Returns user inputted string
	 * @return string the user inputs
	 */
	public static String getString(){
		return System.console().readLine();
	}

	/**
	 * Returns user entered double value. Managed errors to keep asking until valid is entered.
	 * @return double the user enters
	 */
	public static double getDouble(){
		String input;
		double newDouble;
		while(true){
			try{
				input = System.console().readLine();
				newDouble = Double.parseDouble(input);
				break;
			}catch(NumberFormatException e){
				Terminal.printlnWithFormat("Invalid input. Please enter a decimal number. ", 5, 3);
				continue;
			}
		}
		return newDouble;
	}

	/**
	 * Print the message, and keep asking for input until a valid double is entered
	 * @param message The message to print before asking for input
	 * @return the double that the user entered. 
	 */
	public static double getDouble(String message){
		Terminal.printWithFormat(message + ": ", 7, 4);
		String input;
		double newDouble;
		while(true){
			try{
				input = System.console().readLine();
				newDouble = Double.parseDouble(input);
				break;
			}catch(NumberFormatException e){
				Terminal.printlnWithFormat("Invalid input. Please enter a decimal number. ", 5, 3);
				continue;
			}
		}
		return newDouble;
	}

	/**
	 * Print the message, and keep asking for input until a double is entered that is within the provided range (inclusive)
	 * @param message The message to print before asking for input
	 * @param min The minimum acceptable value (inclusive)
	 * @param max The maximum acceptable value (inclusive)
	 * @return The double that the user entered
	 */
	public static double getDouble(String message, double min, double max){
		Terminal.printWithFormat(message + ": ", 2, 0);
		String input;
		double newDouble;
		while(true){
			try{
				input = System.console().readLine();
				newDouble = Double.parseDouble(input);
				if(newDouble < min || newDouble > max){
					Terminal.printlnWithFormat("Input must be between " + min + " and " + max + ".", 5, 3);
				}else{
					break;
				}
			}catch(NumberFormatException e){
				Terminal.printlnWithFormat("Invalid input. Please enter a decimal number.", 5, 3);
				continue;
			}
		}
		return newDouble;
	}

	/**
	 * Method to get user entered integer. Manages errors to keep asking until valid int is entered.
	 * @return int the user entered.
	 */
	public static int getInt(){
		String input;
		int newInt;
		while(true){
			try{
				input = System.console().readLine();
				newInt = Integer.parseInt(input);
				break;
			}catch(NumberFormatException e){
				Terminal.printlnWithFormat("Invalid input. Please enter an integer.", 5, 3);
				continue;
			}
		}
		return newInt;
	}

	/**
	 * Print the message, and keep asking for input until an integer is entered
	 * @param message The message to print before asking for input
	 * @return The integer that the user entered
	 */
	public static int getInt(String message){
		Terminal.printWithFormat(message + ": ", 7, 4);
		String input;
		int newInt;
		while(true){
			try{
				input = System.console().readLine();
				newInt = Integer.parseInt(input);
				break;
			}catch(NumberFormatException e){
				Terminal.printlnWithFormat("Invalid input. Please enter an integer.", 5, 3);
				continue;
			}
		}
		return newInt;
	}

	/**
	 * Print the message, and keep asking for input until an integer is entered that is within the provided range (inclusive)
	 * @param message The message to print before asking for input
	 * @param min The minimum acceptable value (inclusive)
	 * @param max The maximum acceptable value (inclusive)
	 * @return The integer that the user entered
	 */
	public static int getInt(String message, int min, int max){
		Terminal.printWithFormat(message + ": ", 2, 0);
		String input;
		int newInt;
		while(true){
			try{
				input = System.console().readLine();
				newInt = Integer.parseInt(input);
				if(newInt < min || newInt > max){
					Terminal.printlnWithFormat("Input must be between " + min + " and " + max + ".", 5, 3);
				}else{
					break;
				}
			}catch(NumberFormatException e){
				Terminal.printlnWithFormat("Invalid input. Please enter an integer.", 5, 3);
				continue;
			}
		}
		return newInt;
	}

	/**
	 * Print the message, and keep asking for input with format "int,int" until a list of integers is entered that is within the provided range (inclusive)
	 * @param message The message to print before asking for input.
	 * @param min The minimum acceptable value (inclusive)
	 * @param max The maximum acceptable value (inclusive)
	 * @param dimensions The number of integers to expect in the list
	 * @return The array of integers that the user entered
	 */
	public static int[] getCoords(String message, int min, int max, int dimensions){
		boolean allowed = true;
		int[] input = new int[dimensions];
		do{
			allowed = true;
			Terminal.printWithFormat(message + "\nYou must separate each number using a comma: ", 2, 0);
			String[] splString = System.console().readLine().split(",");
			if (splString.length != dimensions){
				Terminal.printlnWithFormat("Invalid Syntax.\n", 5, 3);
				allowed = false;
				continue;
			}
			for(int i = 0; i < dimensions; i++){
				try{
					input[i] = Integer.parseInt(splString[i]);
					if(input[i] < min || input[i] > max){
						Terminal.printlnWithFormat("Input must be between " + min + " and " + max + ".\n", 5, 3);
						allowed = false;
						break;
					}
				}catch(NumberFormatException e){
					Terminal.printlnWithFormat("Invalid input. Please enter integers separated by commas.", 5, 3);
					allowed = false;
				}
			}
		} while(!allowed);
		return input;
	}

	/**
	 * Print the message, and keep asking for input until a valid 'y' or 'n' is entered
	 * @param message The message to print before asking for input
	 * @return true if the user entered 'y', false if the user entered 'n'
	 */
	public static boolean getYesNo(String message){
		Terminal.printWithFormat(message + " (y/n): ", 2, 0);
		String input = "";
		while(true){
			input = System.console().readLine().toLowerCase();
			if(input.equals("y")){
				return true;
			}else if(input.equals("n")){
				return false;
			}else{
				Terminal.printlnWithFormat("Invalid input. Please enter 'y' or 'n'.", 5, 3);
			}
		}
	}

	/**
	 * Print the message and a list of choices, and keep asking for input until a valid choice is entered
	 * @param message The message to print before the list of choices (if null, a default message will be printed)
	 * @param choices An array of strings representing the choices to present to the user
	 * @return The index of the choice that the user selected (1-based index)
	 */
	public static int advancedAsk(String message,String[] choices){
		int input=0;
		if (message.equals(null)){
			Terminal.printlnWithFormat("Please choose from the following", 2, 0);
		} else {
			Terminal.printlnWithFormat(message, 7, 4);
		}
		for (int i=0;i<choices.length;i++){
			System.out.println((i+1)+": "+choices[i]);
		}
		while (true){
			try{
				input=Integer.parseInt(System.console().readLine());
				if (input<1 || input>choices.length){
					if (message.equals(null)){
						Terminal.printlnWithFormat("Please enter an integer: ", 5, 3);
					} else {
						System.out.println(message);
					}
					continue;
				}
				return input;
			} catch (NumberFormatException e){
				if (message.equals(null)){
					Terminal.printlnWithFormat("Please enter a valid value", 5, 3);
				} else {
					System.out.println(message);
				}
			}
		}
	}		

	public static int[] multiAsk(String[] questions, String[][] choices){
		int[] input=new int[questions.length];
		for (int i=0;i<questions.length;i++){
			input[i]=advancedAsk(questions[i],choices[i]);
		}
		return input;
	}
}