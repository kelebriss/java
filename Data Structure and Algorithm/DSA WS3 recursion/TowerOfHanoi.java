package WS3;

public class TowerOfHanoi 
{
	public static void main(String [] args)
	{
		TowerOfHanoi toh = new TowerOfHanoi();
		
		toh.towers(3,1,3); //test value of hanoi tower
	}
	private void towers(int n, int src, int dest)
	{
		int tmp;
		
		if(n==1)
			moveDisk(src,dest); // call moveDisk function(message)
		else
		{
			tmp = 6 - src - dest;
			towers(n-1, src, tmp);
			towers(1, src, dest);
			towers(n-1, tmp, dest);
		}
	}
	private void moveDisk(int src, int dest)
	{
		System.out.println("Move top disk from peg "+src +"to peg "+ dest);
	}
}
