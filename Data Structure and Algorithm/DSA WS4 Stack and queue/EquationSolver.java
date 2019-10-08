package WS4;
import java.util.*;

public class EquationSolver
{
    public double solve(String equation) // the function which called operating the code
    {
        DSAQueue postfix = parseInfixToPostfix(equation);
        return evaluatePostfix(postfix);
    }
    private DSAQueue parseInfixToPostfix(String equation) // the function which infix form expression convert into postfix form
    {
        StringTokenizer strTok = new StringTokenizer(equation,"+-*/()",true); // parsing by tokenizer
        String token = "";
        
        DSAQueue queue;
        queue = new DSAQueue(strTok.countTokens());
        DSAStack stack;
        stack = new DSAStack(strTok.countTokens());
        
        char term ;        
        while (strTok.hasMoreTokens()) //doing utill token is 0
        {
          
          token = strTok.nextToken(); // call the next token
          term = token.charAt(0);     // check first value of token
          switch(term)
          {
              case '(' :
                stack.push(term);
               break;
              case ')' :
                while( (Character)stack.top() != '(')
                {
                    queue.enqueue(stack.pop());
                }
                stack.pop();
               break;
              case '+': case '-': case '*': case '/':
                while( !(stack.isEmpty()) && (!(((Character)(stack.top()))).equals(Character.valueOf('(')) && ((precedenceOF(((Character)(stack.top())).charValue())) >= (precedenceOF(term)))))
                {
                    queue.enqueue(stack.pop());
                }
                stack.push(term);
               break;
              default :
                queue.enqueue((Double.valueOf(token)));
            }
        }
        while(stack.isEmpty() != true) // if inside stack has value then pop off the value
        {
            queue.enqueue(stack.pop());
        }
        return queue;
    }
    private double evaluatePostfix(DSAQueue postfixQueue) // the function which evalutates postfix
    {
        DSAStack opStack;
        opStack = new DSAStack();
        double val1, val2;
        
        while(postfixQueue.isEmpty() != true) //doing until queue is empty
        {
          if( (postfixQueue.peek() instanceof java.lang.Double) == true) // if first value of queue is double then do this process
           {
               System.out.println( "enqueue value " + postfixQueue.peek());
               opStack.push(postfixQueue.dequeue());
               System.out.println( "next enqueue value " + postfixQueue.peek());
           }
           else if( (postfixQueue.peek() instanceof java.lang.Character) == true)//if first value of queue is char then do this process
          { 
            System.out.println( "operating " + postfixQueue.peek());
           val2 = (double)opStack.pop();
           val1 = (double)opStack.pop();
           opStack.push(executeOperation( (Character)postfixQueue.dequeue(), val1, val2));
            System.out.println( "after operating push in stack " + opStack.top());
          }
        }
        System.out.println("**************************************"); // make it human readable liner
        return (double)opStack.top();
    }
    private int precedenceOF(char theOperator) // operating precedence function which helps evaluatePostfix function
    {
        int stat=0;
        if((theOperator == '+') || (theOperator == '-'))
         stat = 1;
         else if((theOperator == '*') || (theOperator == '/'))
         stat = 2;
         else if( stat == 0)
          throw new IllegalArgumentException(" entered not operator");
        return stat;
    }
    private double executeOperation(char op, double op1, double op2) //operating function which helps evaluatePostfix function
    {
        double result;
        switch(op)
        {
            case '+':
              result = op1 + op2;
             break;
            case '-':
              result = op1 - op2;
             break;
            case '*':
              result = op1 * op2;
             break;
            case '/':
              result = op1 / op2;
             break;
            default:
             throw new IllegalArgumentException(" entered not operator");
            }
        return result;
    }
}
