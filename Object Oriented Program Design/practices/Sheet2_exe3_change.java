
import io.*;

 public class Sheet2_exe3_change
 {
     public static void main (String [] args)
     {
         double cost, paid;

         cost=ConsoleInput.readDouble(" Enter the cost of products( increments of 5cents eg. xx.xx) ");
         paid=ConsoleInput.readDouble(" Enter the customer payments( increments of 5cents eg. xx.xx) ");
        System.out.println(""); 
         change(cost,paid);

     }
     public static void change(double Cost, double Paid)
     {
         double change,dollor,cent;
        if(Paid>=Cost)
        {
         if((Math.abs(Cost%0.05)<1)&&(Math.abs(Paid%0.05)<1))
         {

          change= Paid - Cost;
          
          dollor=(int)change;
          cent=Math.round((change-dollor)*100);

          System.out.println(" the change is "+ (int)dollor+"dollor "+(int)cent+"cent ");
         }
         else
         {
          System.out.println( " please enter ther increments of 5cents ");
          System.out.println( " Cost is " +Cost+" Paid is "+Paid);
          System.out.println( " Cost2 is " +(Cost%0.05)+" Paid2 is "+(Paid%0.05)); 
         }
        }
        else
        System.out.println( " costomer paid money is less than product's cost ");
     }
 }



