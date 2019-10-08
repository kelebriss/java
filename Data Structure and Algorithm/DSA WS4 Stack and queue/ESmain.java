package WS4;

public class ESmain
{
   public static void main(String [] args) //test harness for EquationSolver
   {
       EquationSolver es;
       es = new EquationSolver();
       String eq = "(10.3*(14+3.2))/(5+2-4*3)";        
       System.out.println("result is "+es.solve(eq));
   }
}

