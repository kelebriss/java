
 import io.*;

  public class Brick_Sheet3_Exe5
  {
      public static void main ( String [] args)
      {
       double FrontHeight, FrontLength, SideHeight, SideLength, BrickHeight, BrickLength, BHdFH, BLdFL, BLdSH, BLdSL;
       int TF, TS, Total;
     

       FrontHeight=ConsoleInput.readDouble(" Enter the Front  wall's Height " );
       FrontLength=ConsoleInput.readDouble(" Enter the Front  wall's Length ");
       SideHeight=ConsoleInput.readDouble(" Enter the side wall's Height ");
       SideLength=ConsoleInput.readDouble(" Enter the side wall's Length ");
       BrickHeight=ConsoleInput.readDouble(" Enter the Brick's Height ");
       BrickLength=ConsoleInput.readDouble(" Enter the Brick's Length ");
       
       BHdFH= FrontHeight/BrickHeight;
       if (FrontHeight%BrickHeight!=0)
           BHdFH++;
       BLdFL= FrontLength/BrickLength;
       if (FrontLength%BrickLength!=0)
           BLdFL++;
       BLdSH= SideHeight/BrickHeight;
       if (SideHeight%BrickHeight!=0)
           BLdSH++;
       BLdSL= SideLength/BrickLength;
       if (SideLength%BrickLength!=0)
           BLdSL++;

       TF=(int)BHdFH*(int)BLdFL;
       TS=(int)BLdSL*(int)BLdSH;

       Total=(TF+TS)*2;
 
       System.out.println(  TF + "bricks need to build the front wall ");
       System.out.println(  TS + "bricks need to build the one side wall ");
       System.out.println(  Total + "bricks need to build the front,back and side wall ");
      }
  }

