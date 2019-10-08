
/***************************
 * @author Truc Trung Pham *
 **************************/
public class RealNumber
{
   public double realPart;
    public RealNumber()
    {
        realPart = 0.0;
    }
    public RealNumber(double inReal)
    {
        realPart = inReal;
    }
    public RealNumber(RealNumber inNumber)
    {
        realPart=inNumber.getReal();
    }
    public double getReal()
    {
      return realPart;
    }
    public void setRealNumber(double inReal)
    {
        realPart = inReal;
    }
    public boolean equals(RealNumber inNumber)
    {
      boolean isEqual=false;
      if(Math.abs(realPart - inNumber.getReal()) < 0.0001)
      {
          isEqual=true;
      }
      return isEqual;
    }
    public String toString()
    {
        String outString;
        outString= "" + realPart;
        return outString;
    }
    public void add(RealNumber inNumber)
    {
        realPart = realPart + inNumber.getReal();
    }
    public void minus (RealNumber inNumber)
    {
        realPart = realPart - inNumber.getReal();
    }
    public void muiltiply (RealNumber inNumber)
    {
        realPart = realPart * inNumber.getReal();
    }
    public void divide (RealNumber inNumber)
    {
        realPart = realPart / inNumber.getReal();
    }    
}
