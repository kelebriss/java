public class ComplexNumber extends RealNumber
{
    private double imagPart;
    public ComplexNumber()
    {
        imagPart = 0.0;
    }
    public ComplexNumber(double inImag, double inReal)
    {
        super(inReal);
        imagPart = inImag;
    }
    public ComplexNumber (ComplexNumber inNumber)
    {
        super(inNumber);
        imagPart = inNumber.getImag();
    }
    public double getImag()
    {
        return imagPart;
    }
    public void setRealNumber(double inReal, double inImag)
    {
        super.setRealNumber(inReal);
        imagPart = inImag;
    }
    public boolean equals(ComplexNumber inNumber)
    {
        boolean isEqual=false;
        if(Math.abs(imagPart - inNumber.getImag()) < 0.0001)
        {
            isEqual=true;
        }
        return isEqual;
    }
    public String toString()
    {
        String outString;
        outString = super.toString() + imagPart + "i";
        return outString;
    }
    public void add (ComplexNumber inNumber)
    {
        imagPart = imagPart + inNumber.getImag();
        realPart = realPart + inNumber.getReal();
    }
    public void minus (ComplexNumber inNumber)
    {
        imagPart = imagPart + inNumber.getImag();
        realPart = realPart - inNumber.getReal();
    }
    public void muiltiply (ComplexNumber inNumber)
    {
        imagPart = imagPart*inNumber.getReal() + realPart*inNumber.getImag();
        realPart = realPart*inNumber.getReal() - imagPart*inNumber.getImag();
    }
    public void divide (ComplexNumber inNumber)
    {
       double otherReal = inNumber.getReal();
       double otherImag = inNumber.getImag();
        realPart = (realPart*otherReal + imagPart*otherImag)/(otherReal*otherReal + otherImag*otherImag);
        imagPart = (imagPart*otherReal - realPart*otherImag)/ (otherReal*otherReal + otherImag*otherImag);
    }
    public void add (ComplexNumber inA,ComplexNumber inB)
    {
        ComplexNumber result;
        double imag = inA.getImag() + inB.getImag();
        double real = inA.getReal() + inB.getReal();
        result = new ComplexNumber(realPart,imagPart);
    }
    public void minus (ComplexNumber inA,ComplexNumber inB)
    {
        ComplexNumber result;
        double imag = inA.getImag() - inB.getImag();
        double real = inA.getImag() - inB.getReal();
        result = new ComplexNumber(realPart,imagPart);
    }
    public void multiply (ComplexNumber inA,ComplexNumber inB)
    {
        ComplexNumber result;
        double imag = inA.getImag()*inB.getReal() + inA.getReal()*inB.getImag();
        double real = inA.getReal()*inB.getReal() - inA.getImag()*inB.getImag();
        result = new ComplexNumber(realPart,imagPart);
    }
    public void divide (ComplexNumber inA,ComplexNumber inB)
    {
        ComplexNumber result;
        double AReal = inA.getReal();
        double AImag = inA.getImag();
        double BReal = inB.getReal();
        double BImag = inB.getImag();
        double real = (AReal*BReal + AImag*BImag)/(BReal*BReal + BImag*BImag);
        double imag = (AImag*BReal - AReal*BImag)/(BReal*BReal + BImag*BImag);
        result = new ComplexNumber(realPart,imagPart);
    }
}
