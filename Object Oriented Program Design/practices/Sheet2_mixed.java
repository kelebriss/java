
import io.*;

 public class Sheet2_mixed
{
    public static void main( String [] args)
    {
        double weirdvalue, S1, S2, S3, A, B, C;
        weirdvalue=ConsoleInput.readDouble(" Enter the weird value ");
        S1=ConsoleInput.readDouble(" Enter the first side ");
        S2=ConsoleInput.readDouble(" Enter the second side ");
        S3=ConsoleInput.readDouble(" Enter the third side ");
        A=ConsoleInput.readDouble(" Enter the square X's coefficient ");
        B=ConsoleInput.readDouble(" Enter the X's coefficeint ");
        C=ConsoleInput.readDouble(" Enter the C ");

        System.out.println(" the weird value is " +weird_value(weirdvalue));
        System.out.println(" the triangle's area is "+ triangle_area(S1, S2, S3));
        quadratic(A, B, C);

    }
    public static double weird_value(double value)
    {
        double weird;
        weird= (value*39+1.2)/2.6;
        return weird;
    }
    public static double triangle_area(double s1, double s2, double s3)
    {
        double s, area;
        s= (s1+s2+s3)/2.0;
        area=Math.sqrt((s*(s-s1)*(s-s2)*(s-s3)));
        return area;
    }
    public static void quadratic(double a, double b, double c)
    {
        double result1, result2;
        result1= (-b+Math.sqrt(Math.pow(b,2)-4*a*c))/2*a;
        result2= (-b-Math.sqrt(b*b-4*a*c))/2*a;
        System.out.println(" solution are "+result1+" and "+result2);
    }
}
