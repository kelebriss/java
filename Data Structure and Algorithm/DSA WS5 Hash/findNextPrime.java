package WS5;

import java.io.*;

public class findNextPrime implements Serializable // make it can be serialization
{
	int prime,i;

	public int function(int val)
	{
		boolean isPrime=false;
		if(val <= 1) // prime number must be larger than 1
			throw new IllegalArgumentException("must larger than 1");
		else if((val %2)==0) // condition 1
			prime = val+1;
		else
			prime = val; // condition 2
		
		prime = prime-2; // reduce value for while loop(inside while loop do add again)
		while(!isPrime)
		{

			prime +=2;
			i=3;
			isPrime = true;
			while((i*i <= prime) && (isPrime)) // check the value is prime number or not
			{
				if(prime % i ==0)
					isPrime = false;
				else
					i+=2;
			}
			
		}
		return prime;
	}
}
