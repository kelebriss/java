package WS3;

public class TowerOfHanoi2
{
    public static void main( String [] args)
    {
    	TowerOfHanoi2 toh = new TowerOfHanoi2();
        toh.towers(5,1,3," "); // test value of hanoi tower
    }
    public void towers(int n, int src, int dest, String space) //recursion method for hanoi tower
    {
        int tmp;
        
        System.out.println(space+ "tower (" + n +","+src+","+dest+") ");  
        space += "   "; // indent reculsion processor
        System.out.print("   "+space+"n="+n+", src="+src+", dest="+dest); 
        //first 3 spaces("   ") is that make clear indent with the other statement like appendix.
        //because numbering( such as (3),(4),(5) ) take 3 spaces, so if need to make a same indent should put 3 spaces. 
      
        if (n == 1) // if n=1 printing the moving condition : Base Case
        {
        System.out.println("");
        System.out.print("(1)" + space ); //when n=1, it is (1)
        moveDisk(src, dest);
        }
        else // process of hanoi tower.
        {
            tmp =6 - src - dest; // tmp is 'non-target' peg, since src+dest+tmp=6
            System.out.println(" ,tmp="+tmp);
            
            System.out.print("(3)"); // (n-1, src, tmp) value is (3)
            towers(n-1, src, tmp, space);
            
            System.out.print("(4)" + space); // (1, src, dest) value is (4)
            moveDisk(src, dest);
            
            System.out.print("(5)"); // (n-1, tmp, dest) value is (5)
            towers (n-1, tmp, dest, space);
        }
    }
    public void moveDisk(int src, int dest)
    {
		System.out.println("Move top disk from peg "+src +"to peg "+ dest);
    }
}