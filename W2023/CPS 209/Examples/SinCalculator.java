import java.util.Scanner ;
/**
   This class reads from the user input that looks like
   4 degrees
   3.5 radians
   5.5 Radians
   19 DEGREES

   It prints the sin of the angle (where the angle is in radians)
   and it prints the absolute value of the angle in degrees.
 */
public class SinCalculator
{
    public static void main(String[] args)
    {
	System.out.println("Hello World") ;
	Scanner scanner = new Scanner(System.in) ;
	System.out.println("Enter number and word like: 4.5 degrees or 3.2 radians") ;
	double number = scanner.nextDouble() ;
	String word = scanner.next() ;
	System.out.println("You said " + number + " " + word) ;
	double radians = 0, degrees = 0 ;
	if (word.equalsIgnoreCase("degrees")) 
	{
	    radians = Math.toRadians(number) ;
	    degrees = number ;
	}
	else if (word.equalsIgnoreCase("radians")) 
	{
	    radians = number ;
	    degrees = Math.toDegrees(number) ;
	}
	else
	{
	    System.out.println("bad input") ;
	    System.exit(0) ;
	}
	System.out.println(Math.sin(radians)) ;
	System.out.println(Math.abs(degrees)) ;
    }
}
