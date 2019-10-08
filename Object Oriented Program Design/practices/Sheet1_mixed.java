
import io.*;

public class hello
 {
     public static void main ( String [] args)
     {
       int numone, numtwo, sum, diff;
       double Celsius, Fahrenheit, pounds, kilos, amps, mah, Crating, time;       
         numone=ConsoleInput.readInt ("Enter 1st number");
         numtwo=ConsoleInput.readInt ("Enter 2nd nubmer");
         Fahrenheit=ConsoleInput.readDouble ("Enter the Fahrenheit");
         pounds=ConsoleInput.readDouble ("Enter the pounds");
         amps=ConsoleInput.readDouble ("Enter the amps");
         mah=ConsoleInput.readDouble ("Enter the mAh");

         sum = numone + numtwo;
         Celsius = ((Fahrenheit - 32.0) * 5.0) / 9.0;
         kilos = poundstokilos (pounds);
         Crating= amps * 1000 / mah;
         time = Timeexp (Crating);

         System.out.println ("sum is " + sum);
         System.out.println 
             ("two integer's diff is " + Math.abs(numone-numtwo));
         System.out.println ("Fahrenheit to Celcius is " + Celsius);
         System.out.println ("pounds to kilos is " + kilos);
         System.out.println ("Flight time is " + time);
         System.exit(0);

     }
     private static double poundstokilos(double pound)
     {
         double kilo;
         kilo = pound * (1/2.204) ;
         return kilo;
     }
     private static double Timeexp(double crating)
     {
         double time;
         time = 60 / crating ;
         return time;
     }


 }

