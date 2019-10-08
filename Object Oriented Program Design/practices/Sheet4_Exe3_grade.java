import io.*;

 public class Grade_Sheet4_EXE3
{
   public static void main ( String [] args)
    {
     int Ass, Mark;

      Ass=ConsoleInput.readInt( " Enter the amount of  completed Assessments (0 to 5) ");
      Mark=ConsoleInput.readInt( " Enter the Mark (0 to 100) ");
      System.out.println ( " The grade is " + Checker(Ass,Mark));
    }

   public static String Checker (int ass, int mark)
    {
      String result="";
        if ( ( ( (ass>=0)&&(ass<=5) ) && ( (mark>= 0)&&(mark<=100) ) )==true )
          {
            if (mark>=50)
            switch(ass)
             {
                 case 0:
                    result = "DNA";
                    break;
                 case 1: case 2: case 3: case 4: case 5:
                    result = (mark/10) + ("-") + mark;
                    break;
             }
            else
             {
               switch (ass)
                {
                  case 0:
                     result = "DNA";
                     break;
 
                  case 1: case 2: case 3: case 4:
                     result = "DNC-" + mark; 
                     break;
                  case 5:
                     result = "F-" + mark;
                     return result;
                }
             }
          }
        else
               result= " the values are invalid";
               return result;    
    }
}
