import io.*;
 public class quiz
 {
  public static void main (String [] args)
  {
     valid();
  }

  public static double total()
  {
      double inputTotal;
      inputTotal=ConsoleInput.readDouble(" total weight ");

      while(inputTotal <0)
         {
             inputTotal=ConsoleInput.readDouble( " invalid. enter again ");         }
      return inputTotal;
  }
  public static int numpass()
  {
      int number;
      number=ConsoleInput.readInt(" how many people ");

      while(number <0)
         {
             number=ConsoleInput.readInt( " invalid. enter again ");
         }
      return number;
  }
  public static double passweight()
  {
      double passengerweight;
      passengerweight=ConsoleInput.readDouble(" how much kg ");
      while(passengerweight <= 20.0 || passengerweight >= 130.0)
      {
          passengerweight=ConsoleInput.readDouble(" invalid. enger again ");
      }
      return passengerweight;
  }
  public static double process(int passengers)
  {
      double totalpassweight=0;
      for(int count=1 ; count <= passengers ; count++)
      {
          totalpassweight = totalpassweight + passweight();
      }
      return totalpassweight;
  }
  public static void valid()
  {   
      
      if( total()-process(numpass()) >0)
           System.out.println( " safe ");
      
      else
          System.out.println( " danger ");
  }
 }
