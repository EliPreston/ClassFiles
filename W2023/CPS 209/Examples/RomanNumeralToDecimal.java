/**
   Converts Roman numerals to decimal value
   
*/
import java.util.Scanner;

public class RomanNumeralToDecimal
{
	public static void main(String[] args)
	{
	   Scanner in = new Scanner("I C X D M L");

	   char romanNumeral = in.next().charAt(0);
	   System.out.println("Value: " + valueOf(romanNumeral) + "   Expected: 1") ;
	   
	   romanNumeral = in.next().charAt(0);
	   System.out.println("Value: " + valueOf(romanNumeral) + "   Expected: 100") ;
	   
	   romanNumeral = in.next().charAt(0);
	   System.out.println("Value: " + valueOf(romanNumeral) + "   Expected: 10") ;
	   
	   romanNumeral = in.next().charAt(0);
	   System.out.println("Value: " + valueOf(romanNumeral) + "   Expected: 500") ;
	   
	   romanNumeral = in.next().charAt(0);
	   System.out.println("Value: " + valueOf(romanNumeral) + "   Expected: 1000") ;
	   
	   romanNumeral = in.next().charAt(0);
	   System.out.println("Value: " + valueOf(romanNumeral) + "   Expected: 50") ;
	}
	
   /**
      Gives the value of the Roman numerals I X L C D M
      @param numeral a single Roman numeral
      @return the integer value of numeral
   */
   //$start write a static method valueOf with the appropriate parameters and return type. 	
   public static int valueOf(char numeral)
   {
      if (numeral == 'I')
      {
         return 1;
      }
      if (numeral == 'V')
      {
         return 5;
      }
      if (numeral == 'X')
      {
         return 10;
      }
      if (numeral == 'L')
      {
         return 50;
      }
      if (numeral == 'C')
      {
         return 100;
      }
      if (numeral == 'D')
      {
         return 500;
      }
      // must be an M
      return 1000;
   }
   //$end
}
