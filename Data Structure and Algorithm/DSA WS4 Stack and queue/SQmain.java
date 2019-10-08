package WS4;

import java.util.*;
public class SQmain
{
   public static void main(String [] args)// test harness for stack and queue array
   {
       int i,j;
       int sCap,qCap;
       Object sVal, qVal;
       DSAStack stack;
       DSAQueue queue;
	   Scanner scan = new Scanner(System.in);
       System.out.println("enter the stack default capacity");
       sCap=scan.nextInt(); 
       stack = new DSAStack(sCap);        //decide capacity of stack array
       for(i=stack.getCount();i<sCap; i++) //set the value into stack array
       {
           if(stack.isFull()==true)
               throw new ArrayIndexOutOfBoundsException("stack is full");
           else
           {
        	   System.out.println("enter the stack value");  
             sVal=scan.nextDouble();
             stack.push(sVal);
           }
       }
       for(i=stack.getCount(); i>0; i--) //call the value from stack array
       {
           if(stack.isEmpty()==true)
             throw new ArrayIndexOutOfBoundsException("stack is empty");
           else
           {
        	  System.out.println("current top item of stack array is :"+stack.top());
              System.out.print("doing pop");
              sVal=stack.pop();
              System.out.println(sVal);
           }
       }
       System.out.println("enter the queue default capacity");
       qCap=scan.nextInt();
       queue = new DSAQueue(qCap);  // decide capacity of queue array
       for(j=queue.getCount();j<qCap; j++) //set the value into queue array
       {
           if(queue.isFull()==true)
               throw new ArrayIndexOutOfBoundsException("stack is full");
           else
           {
        	 System.out.println("enter the queue value");  
             qVal=scan.nextDouble();
             queue.enqueue(qVal);
           }
       }
       for(j=queue.getCount(); j>0; j--) //call the value from queue array
       {
           if(queue.isEmpty()==true)
             throw new ArrayIndexOutOfBoundsException("stack is empty");
           else
           {
              System.out.println("current front item of queue array is :"+queue.peek());
              System.out.print("doing dequeue");
              qVal=queue.dequeue();
              System.out.println(qVal);
           }
       }
       scan.close();
   }

}
