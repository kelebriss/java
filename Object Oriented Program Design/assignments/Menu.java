
/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu
{
    public static void main(String[] args)
    {
        double numOne;
        double numTwo;
        System.out.println("Assigment - OOPD1001");
        System.out.println("(1) Input Real number");
        System.out.println("(2) Input Complex number");
        System.out.println("(3) Exit");
        System.out.println("Choice? ");
        int choice1;
        choice1=ConsoleInput.readInt("Select an application: ");
        switch(choice1)
        {
            case 1: 
            numOne = inputRealNumber();
            numTwo = inputRealNumber();
            break;
            case 2: 
            numOne = inputComplexNumber();
            numTwo = inputComplexNumber();
            break;
            case 3: return;
            break;
            default: choice1=ConsoleInput.readInt(" Error, must be 1 to 3");
            break;
        } 
    }
    public static double inputRealNumber()
    {
        ComplexNumber realPart;
        RealNumber number; 
        realPart=ConsoleInput.readDouble("Enter the real part");
        number = new RealNumber(realPart);
    }
    public static double inputComplexNumber()
    {
        ComplexNumber imagPart;
        ComplexNumber number;
        imagPart=ConsoleInput.readDouble("Enter the imaginary part");
        number = new ComplexNumber(imagPart);
        choice2=ConsoleInput.readInt("Select an application: ");
        System.out.println("(1) Add the numbers");
        System.out.println("(2) Subtract the numbers");
        System.out.println("(3) Multiply the numbers");
        System.out.println("(4) Divide the numbers");
        System.out.println("Choice? ");
        switch(choice2)
        {
            case 1: add(numOne, numTwo);
            break;
            case 2: subtract(numOne, numTwo);
            break;
            case 3: multiply(numOne, numTwo);
            break;
            case 4: divide(numOne, numTwo);
            break;
            default: choice2=ConsoleInput.readInt(" Error, must be 1 to 4");
            break;
        } 
    }
    public static double add(ComplexNumber numOne, ComplexNumber numTwo)
    {
        ComplexNumber oldNumOne;
        oldNumOne= new ComplexNumber(numOne);
        numOne.add(numTwo);
        System.out.println(oldNumOne.toString + "+" + numTwo.toString);
        return choice2;
    }
    public static double subtract(ComplexNumber numOne, ComplexNumber numTwo)
    {
        ComplexNumber oldNumOne;
        oldNumOne= new ComplexNumber(numOne);
        numOne.minus(numTwo);
        System.out.println(oldNumOne.toString + "+" + numTwo.toString);
        return choice2;
    }
    public static double multiply(ComplexNumber numOne, ComplexNumber numTwo)
    {
        ComplexNumber oldNumOne;
        oldNumOne= new ComplexNumber(numOne);
        numOne.multiply(numTwo);
        System.out.println(oldNumOne.toString + "+" + numTwo.toString);
        return choice2;
    }
    public static double divide(ComplexNumber numOne, ComplexNumber numTwo)
    {
        ComplexNumber oldNumOne;
        oldNumOne= new ComplexNumber(numOne);
        numOne.divide(numTwo);
        System.out.println(oldNumOne.toString + "+" + numTwo.toString);
        return choice2;
    }
   
}
