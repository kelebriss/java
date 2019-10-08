import io.*;

 public class asd
 {
     public static void main ( String [] args)
     {
         double Length, Width, Covered, Area, Paint;

         Length=ConsoleInput.readDouble(" Enter the length ");
         Width=ConsoleInput.readDouble(" Enter the Width ");
         Covered=ConsoleInput.readDouble(" Enter the sqaure meter covered by a 1 x 10 paint tin");

         Area = Length*Width;
         Paint = (Area/Covered)*2;

         if (((Check(Length)==false) || (Check(Width)==false) || (Check(Covered)==false))==true )
           {
            System.out.println();
            System.out.println( " Inputed invalid value. Values are below ");
            System.out.println();
            System.out.println( " Length value is " + Length);
            System.out.println( " Width value is " + Width);
            System.out.println( " Covered by paint is " + Covered);
           }
         else
           {
            System.out.println();  
            System.out.println( " The dimension's areae is " + Area + "square meters ");
            System.out.println( " 1*10 L paint tin is needed to cover" + Covered + " square meters for once");
            System.out.println( " " + Paint + " paint tins are needed for coating twice the wall");
            System.out.println();
           }

}

    public static boolean Check (double value)
     {
         if (value >=0)
            return true ;
         else
            return false;
     }
 }

