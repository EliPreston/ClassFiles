import java.util.Scanner;

class MathExample
{
  public static void main (String[] args)
  {
    double x1,y1,x2,y2;
    
    Scanner in = new Scanner(System.in);
    
    x1 = in.nextDouble(); y1 = in.nextDouble();
    x2 = in.nextDouble(); y2 = in.nextDouble();
    
    double distance = Math.sqrt((x2 - x1)*(x2 - x1) +
                           (y2 - y1)*(y2 - y1));
    System.out.println("Distance = " + distance);
  }
}
