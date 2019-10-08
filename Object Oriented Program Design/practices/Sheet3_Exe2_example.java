
 import io.*;

 public class Example
  {
   public static void main ( String [] args)
   {
       boolean xval, xandy, Leapyear;
       int Year;
       Year=ConsoleInput.readInt("Enter the year");
       xval=xVal();
       xandy=XandY();
       Leapyear=leapyear(Year);
       System.out.println("is it even numbers? " + xval);
       System.out.println(" are x's and y's value same? " + xandy);
       System.out.println( "Is it leap year? " + Leapyear);

   }
   public static boolean xVal ( )
    {
        int Even;
        Even=ConsoleInput.readInt("Enter the Even number");
        if ( Even%2==0)
            return true;
        else
            return false;
    }
   public static boolean XandY ( )
    {
       double x, y;
       x=ConsoleInput.readDouble("Enter the x");
       y=ConsoleInput.readDouble("Enter the y");
       if (x==y)
           return true;
       else
           return false;
    }
   public static boolean leapyear (int year)
    {
         
        if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0)))
            return true;
        else 
            return false;
    }
  }
    


 
