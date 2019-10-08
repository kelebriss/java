package a;

import java.io.IOException;

// Class file for the the OBDDH diagram.
//
// The idea is that a diagram is created (which loads in the network and then sets up the structures). Then compute
// is called, which gets the class to actually generate all of the nodes and also computes the reliability. Finally,
// the reliability is displayed to the screen.
 
import java.util.*;

// Add code where appropriate but do not change existing code without written permission
//
// This code isn't entirely complete but is usable

class OBDDH
{
  private FloatingPoint reliability;
  private Qc current;
  private Qn next;
  private Network net;

  // The default constructor creates the root node of the OBDDH diagram
  public OBDDH( String filename ) throws IOException 
  {
    // First load in the network
    net = new Network( filename );

    // Then set up the rest of the structures
    reliability = new FloatingPoint( 0.0 );  // Will be adding to this number
    next = new Qn();                         // Initialize the next queue to be empty
    HNode root = new HNode();                      // Set up the root node of the diagram
    current = new Qc( root );                // Initialize the current queue to contain the root node

    // Start the computation
    compute();
  }

  // Computes the reliability of the network, which must have been initialized before this is called
  private void compute() throws IOException 
  {
    HNode node, child;
    Edge e = null; // try,catch make it error so initialize as null

    while ( !current.isEmpty() ) // Keep going through levels until all nodes are processed
    {
      try	// make the try/catch for NullException for preventing from crash the program
      {
    	  e = net.nextEdge();
      }  
      catch(Exception e1)
      {
    	  System.out.println("can get next edge"+e1);};
      }								// Get the edge to be processed for this level
      while ( !current.isEmpty() ) // Work on the current level until all nodes are processed
      {
        node = current.front(); // Remove the first node from the current level
        child = node.makePos( e );
        add( child );
        node.makeNeg( e );      // Transform node into its own negative child
        add( node );
      } // End of loop over current queue

      // We now move on to the next level of the diagram. This means putting the nodes from Qn onto Qc.
      // Qn becomes empty.
      next.swap( current );
      // After the swap, the only way for Qc to be empty is if both Qc and Qn are empty. When this happens we're done.
    }

  // Checks to see if the node is terminal. If not, attempts to add the node to Qn. If terminal and successful, record the
  // reliability.
  private void add( HNode n )
  {
    if ( n.isSuccess() )
    {
      reliability.add( n.getRel() ); // Record the reliability of the successful node. It gets discarded.
    }
    else if ( !n.isFailed() ) // Failure nodes are ignored and discarded.
    {
      if ( next.add( n ) ) 
      {
    	  next.merge(n); // if next inside already has node then merge it
      }
      else
    	  addToQn(n); // if next inside has not same node then insert it
    }
  }

  // Displays the reliability of the network to the screen
  // Note that the marking scripts expect exactly this format. Students should not write anything to output -
  // the only output should be through this method unless an exception occurs.
  public void displayRel() 
  {
    System.out.println("The reliability of the network is "+reliability.toString());
  }

  // Initializes the network by calling the constructor to load information from a file
  private void loadNetwork( String filename ) throws IOException 
  {
	  net = new Network( filename );
	  
	  net.display();
  }

  // After a new child node has been created this method attempts to add it to next
  private void addToQn( HNode node ) 
  {
	  next.insert(node);
  }


} // end of class OBDDH
