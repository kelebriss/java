
import io.*;

 public class Sheet2_exe5_discount
{
    public static void main(String [] args)
    {
        double Cost,per;
        Cost=ConsoleInput.readDouble(" Enter the cost of product ");
        per=ConsoleInput.readDouble( " Enter the discount percentage ");
        discount(Cost, per);

    }
    public static void discount(double cost, double percentage)
    {
        double price,price2;

        if((cost>=0)&&(percentage>=0))
        {
            price=cost*(1-percentage/100);
            price2=(int)(price*100);

            System.out.println(price2/100);
        }
        else
            System.out.println(" invalid value ");
    }
}

        
