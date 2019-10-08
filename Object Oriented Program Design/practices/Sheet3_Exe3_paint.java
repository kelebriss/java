
import io.*;

 public class Paint_Sheet3_EXE3
 {
     public static void main ( String [] args)
     {
         double Length, Width, Covered, Area, Paint;

         Length=ConsoleInput.readDouble(" Enter the length ");
         Width=ConsoleInput.readDouble(" Enter the Width ");
         Covered=ConsoleInput.readDouble(" Enter the sqaure meter covered by a 1 x 10 paint tin");

         Area = Length*Width;
         Paint = (Area/Covered)*2;

         System.out.println( " The dimension's areae is " + Area + "square meters ");
         System.out.println( " 1*10 L paint tin is needed to cover" + Covered + " square meters for once");
         System.out.println( " " + Paint + " paint tins are needed for coating twice the wall");
     }
 }

