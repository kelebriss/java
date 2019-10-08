/**
 * 
 * @author Hyojin Cha 90008546
 * @Real Number and Imagine Number Calculator
 */

import io.*;
public class CalculatorAssignment
{
    public static void main(String [] args)
    {
        Menu.firstmenu();
    }
}
class RealNumber
{
    private static double Value1;
    private static double Value2;
    public RealNumber()
    {
        Value1=0.0;
        Value2=0.0;
    }
    public RealNumber(double inValue1, double inValue2)
    {
        Value1=0.0;
        Value2=0.0;
        setValue(inValue1, inValue2);
    }
    public RealNumber(RealNumber inNumber)
    {
        Value1=inNumber.getValue1();
        Value2=inNumber.getValue2();
    }
    public double getValue1()
    {
        return Value1;
    }
    public double getValue2()
    {
        return Value2;
    }
    public static void setValue(double inValue1,double inValue2)
    {
        if((inValue1>=0.0)&&(inValue2>=0.0))
        {
            Value1=inValue1;
            Value2=inValue2;
        }
    }
    public static void add(double val1,double val2)
    {
             System.out.println(" RealValue1+RealValue2 = "+ (Value1+Value2));
    }
    public static void subtract(double val1,double val2)
    {
           System.out.println(" RealValue1-RealValue2 = "+ (Value1-Value2));
    }
    public static void multiply(double val1,double val2)
    {
           System.out.println(" RealValue1*RealValue2 = "+ (Value1*Value2));
    }
    public static void divide(double val1,double val2)
    {
           System.out.println(" RealValue1/RealValue2 = "+ (Value1/Value2));
    }     
        public boolean equals(RealNumber inNumber)
    {
        boolean isEqual=false;
        if(Math.abs(Value1-inNumber.getValue1())<0.001)
         if(Math.abs(Value2-inNumber.getValue2())<0.001)
          isEqual=true;
        return isEqual;
    }
}
class ComplexNumber extends RealNumber
{
    private static double img1;
    private static double img2;
    public ComplexNumber()
    {
        img1=0.0;
        img2=0.0;
    }
    public ComplexNumber(double inValue1, double inValue2, double inImg1, double inImg2)
    {

        img1=0.0;
        img2=0.0;
        setImg(inValue1, inValue2, inImg1, inImg2);
    }
    public ComplexNumber(ComplexNumber inNumber)
    {
        img1=inNumber.getImg1();
        img2=inNumber.getImg2();
    }
    public double getImg1()
    {
        return img1;
    }
    public double getImg2()
    {
        return img2;
    }
    public static void setImg(double inValue1,double inValue2, double inImg1,double inImg2)
    {
        if((inImg1>=0.0)&&(inImg2>=0.0))
        {

            img1=inImg1;
            img2=inImg2;
        }
    }
    public boolean equals(ComplexNumber inNumber)
    {
        boolean isEqual=false;
        if(Math.abs(img1-inNumber.getImg1())<0.001)
         if(Math.abs(img2-inNumber.getImg2())<0.001)
          isEqual=true;
        return isEqual;
    }    
    public static void add(double Value1,double Value2,double img1,double img2)
    {
            System.out.println(" (RealValue1+ImagineValue1)+(RealValue2+ImagineValue2) = "+ ((Value1+Value2) + " + " + (img1+img2)+"i"));
    }
    public static void subtract(double Value1,double Value2,double img1,double img2)
    {
           System.out.println(" (RealValue1+ImagineValue1)-(RealValue2+ImagineValue2) =" + ((Value1-Value2) + "+" + (img1-img2)+"i"));
    }
    public static void multiply(double Value1,double Value2,double img1,double img2)
    {
           System.out.println(" (RealValue1+ImagineValue1)-(RealValue2+ImagineValue2) =" + ((Value1*Value2)-(img1*img2)) + " + " + ((Value2*img1)+(Value1*img2))+"i");
    }
    public static void divide(double Value1,double Value2,double img1,double img2)
    {
           System.out.println(" (RealValue1+ImagineValue1)-(RealValue2+ImagineValue2) ="+ (((Value1*Value2)+(img1*img2))/(Math.pow(Value2,2)+Math.pow(Value2,2))) + " + " +((Value2*img1)+(Value1*img2))+"i");
    }
}
class Menu
{
    private static double Value1;
    private static double Value2;
    private static double Value3;
    private static double Value4;
    public static void firstmenu()
    {
        int selection;
        System.out.println(" Select the option ");
        System.out.println(" 1. Real Number ");
        System.out.println(" 2. Complex Number ");
        System.out.println(" 3. Exit ");
        selection=ConsoleInput.readInt();
        switch(selection)
        {
        case 1:
        {
        System.out.println(" Select the option ");
        System.out.println(" 1. Add ");
        System.out.println(" 2. Subtract ");
        System.out.println(" 3. Multiply ");
        System.out.println(" 4. Divide ");
        selection=ConsoleInput.readInt();
        switch(selection)
        {
        case 1:
        Value1=ConsoleInput.readDouble("Enter the 1st value");
        Value2=ConsoleInput.readDouble("Enter the 2nd value");
        RealNumber.setValue(Value1,Value2);
        RealNumber.add(Value1, Value2);
        break;
        case 2:
        Value1=ConsoleInput.readDouble("Enter the 1st value");
        Value2=ConsoleInput.readDouble("Enter the 2nd value");
        RealNumber.setValue(Value1,Value2);
        RealNumber.subtract(Value1, Value2);
        break;
        case 3:
        Value1=ConsoleInput.readDouble("Enter the 1st value");
        Value2=ConsoleInput.readDouble("Enter the 2nd value");
        RealNumber.setValue(Value1,Value2);
        RealNumber.multiply(Value1, Value2);
        break;
        case 4:
        Value1=ConsoleInput.readDouble("Enter the 1st value");
        Value2=ConsoleInput.readDouble("Enter the 2nd value");
        RealNumber.setValue(Value1,Value2);
        RealNumber.divide(Value1, Value2);
        break;
        }
        firstmenu();
        break;
    }
    
        case 2:
        {
        System.out.println(" Select the option ");
        System.out.println(" 1. Add ");
        System.out.println(" 2. Subtract ");
        System.out.println(" 3. Multiply ");
        System.out.println(" 4. Divide ");
        selection=ConsoleInput.readInt();
        switch(selection)    
        {
        case 1:
        Value1=ConsoleInput.readDouble("Enter the 1st Realvalue");
        Value2=ConsoleInput.readDouble("Enter the 2nd Realvalue");
        Value3=ConsoleInput.readDouble("Enter the 1st Imaginevalue");
        Value4=ConsoleInput.readDouble("Enter the 2nd Imaginevalue");
        ComplexNumber.setImg(Value1,Value2,Value3,Value4);
        ComplexNumber.add(Value1, Value2, Value3, Value4);
        break;
        case 2:
        Value1=ConsoleInput.readDouble("Enter the 1st Realvalue");
        Value2=ConsoleInput.readDouble("Enter the 2nd Realvalue");
        Value3=ConsoleInput.readDouble("Enter the 1st Imaginevalue");
        Value4=ConsoleInput.readDouble("Enter the 2nd Imaginevalue");
        ComplexNumber.setImg(Value1,Value2,Value3,Value4);
        ComplexNumber.subtract(Value1,Value2,Value3,Value4);
        break;
        case 3:
        Value1=ConsoleInput.readDouble("Enter the 1st Realvalue");
        Value2=ConsoleInput.readDouble("Enter the 2nd Realvalue");
        Value3=ConsoleInput.readDouble("Enter the 1st Imaginevalue");
        Value4=ConsoleInput.readDouble("Enter the 2nd Imaginevalue");
        ComplexNumber.setImg(Value1,Value2,Value3,Value4);
        ComplexNumber.multiply(Value1,Value2,Value3,Value4);
        break;
        case 4:
        Value1=ConsoleInput.readDouble("Enter the 1st Realvalue");
        Value2=ConsoleInput.readDouble("Enter the 2nd Realvalue");
        Value3=ConsoleInput.readDouble("Enter the 1st Imaginevalue");
        Value4=ConsoleInput.readDouble("Enter the 2nd Imaginevalue");
        ComplexNumber.setImg(Value1,Value2,Value3,Value4);
        ComplexNumber.divide(Value1,Value2,Value3,Value4);
        break;
        }
    }
        firstmenu();
        break;
        
        
        case 3:
        break;
        }
    }
}