package a;

import java.io.*;
import java.util.*;

class Network 
{
	StringTokenizer strTok;
	String fName,suffix,line;
	Edge eHead, nEdge=null;
	Vertex vHead;
	int vNum, eNum;
	
	public Network()
	{
		//default constructor doing nothing
	}
	public Edge nextEdge() // function which call Edge if current Edge is null then call head
	{					   // if current Edge is not null then call current next Edge
		if(nEdge == null)
			nEdge = eHead;
		else
			nEdge = nEdge.getNext();
		
		return nEdge;
	}
	public Network(String filename) throws IOException // function which read file and save data
	{								// if file's suffix is 'nt' then re-write file with sorted data
		Vertex cVertex;
		Edge cEdge;
		
		strTok = new StringTokenizer(filename,"."); // split into filename part and suffix part
		fName = strTok.nextToken();
		suffix = strTok.nextToken();
		
		FileOutputStream fileStrm = null;
		PrintWriter pw;
		
		if(suffix.equals("srt")) // if suffix is srt then just read it
			readFile(filename);
		else if(suffix.equals("nt"))// if suffix is nt then read it after sort then write on new file 
		{
			readFile(filename);
			sort();
			try{
				fileStrm = new FileOutputStream(fName+".srt");
				pw = new PrintWriter(fileStrm);
				
				///////////////////////////////////////////////////////////////
				/////////////try to write sorted data into file////////////////
				///////////////////////////////////////////////////////////////
				pw.println("<NET>");
				
				cVertex = vHead;
				while(cVertex != null) // enter the data into file until empty
				{	
					if(cVertex.isSource()==true) // if Vertex is source then do this
						pw.println("<VERTEX REL=" + cVertex.getRel().toString() + " TYPE=\""+cVertex.getType() + "\" COST=" + Integer.toString(cVertex.getCost()) + " NAME=\""+cVertex.getName() + "\" SOURCE />");
					else if(cVertex.isTarget() == true) // if Vertex is Target then do this
						pw.println("<VERTEX REL=" + cVertex.getRel().toString() + " TYPE=\""+cVertex.getType() + "\" COST=" + Integer.toString(cVertex.getCost()) + " NAME=\""+cVertex.getName() + "\" TARGET />");
					else 
						pw.println("<VERTEX REL=" + cVertex.getRel().toString() + " TYPE=\""+cVertex.getType() + "\" COST=" + Integer.toString(cVertex.getCost()) + " NAME=\""+cVertex.getName() + "\" />");
				}
				cEdge = eHead;
				while(cEdge != null)// enter the data into file until empty
				{
					pw.println("<EDGE FROM=\"" + cEdge.getFrom().getName() + "\" TO=\"" + cEdge.getTo().getName() + "\" REL=" + cEdge.getRel().toString() + " TYPE=\"" + cEdge.getType() + "\" COST=" + Integer.toString(cEdge.getCost()) + " NAME=\"" + cEdge.getName() + "\" />");
				}
				pw.println("<\\NET>");
				pw.close(); // close the file
			}
			catch (IOException e)
			{
				System.out.println("Error in writing to file: "+e.getMessage());
			}
		}
		else // if file suffix is not nt or srt then throw to error
		{
			throw new IOException("invalid type of file");
		}
			
	}
	public void readFile(String filename) // read file data then call function for saving data
	{
		
		FileInputStream fileStrm = null; 
		InputStreamReader rdr;
		BufferedReader bufRdr;
		
		try 
		{
			fileStrm = new FileInputStream(filename);
			rdr = new InputStreamReader(fileStrm);
			bufRdr = new BufferedReader(rdr);
			
			line = bufRdr.readLine(); // read the whole line
			while (line != null) // till file is end
			{
			processLine(line); // call the function processLine and pass line into it
			line = bufRdr.readLine(); // read  again
			}
			fileStrm.close(); // close the file
		} 
		catch (IOException e) 
		{
			if (fileStrm != null) 
			{
			 try { fileStrm.close(); }  // if file not close then close it
			 catch (IOException ex2) { }
			}
			System.out.println("Error in file processing: " + e.getMessage()); // catch any error then print it
		}
	}
	public void processLine(String line)// save the data into Edge or Vertex
	{
		vNum = 0;
		eNum = 0;
		
		String tmp[] = line.split(" "); // whole line split into words then save into array
		
		if(tmp[0].equals("<NET>")||tmp[0].equals("<\\NET>")) 
		{
			//doing nothing because of sign of start or end
		}
		else if(tmp[0].equals("<VERTEX")) // if first word is <Vertex then save into Vertex
		{
			vNum++;
			Vertex cVertex, vNode;
			vNode = new Vertex();
			cVertex =vHead;
			
			if(tmp.length == 7) // if it has 7 items mean is this Vertex is Source or Target
			{
				if(tmp[5].equals("SOURCE"))
					vNode.setSource();
				else if(tmp[5].equals("TARGET"))
					vNode.setTarget();
			}
			vNode.setRel(Double.parseDouble(tmp[1].substring(4))); // Save into node each Data
			vNode.setType(tmp[2].substring(6,tmp[2].length()-1));
			vNode.setCost(Integer.parseInt(tmp[3].substring(5)));
			vNode.setName(tmp[4].substring(6, tmp[4].length()-1));
			
			if(cVertex == null) // if Vertex is empty then insert into Head
				vHead = vNode;
			else // else insert into last
			{
				while(cVertex.getNext() != null) // get the last node in Vertex
				{
					cVertex = cVertex.getNext();
				}
				cVertex.setNext(vNode); // set the node as last one
			}
		}
		else if(tmp[0].equals("<EDGE")) // if first word is <Edge then save into Edge
		{
			eNum++;
			Vertex cVertex;
			Edge cEdge, eNode;
			eNode = new Edge();
			
			eNode.setRel(Double.parseDouble(tmp[3].substring(4)));// Save into node each Data
			eNode.setType(tmp[4].substring(6,tmp[4].length()-1));
			eNode.setCost(Integer.parseInt(tmp[5].substring(5)));
			eNode.setName(tmp[6].substring(6, tmp[6].length()-1));
			
			cVertex = vHead;
			while(!cVertex.getName().equals(tmp[1].substring(6,tmp[1].length()-1))) // check which Vertex is match to Edge's from Vertex
			{																	   // when found it then save into From
				cVertex = cVertex.getNext();
			}
			eNode.setFrom(cVertex); // set the from Vertex
			
			cVertex = vHead;
			while(!cVertex.getName().equals(tmp[2].substring(4, tmp[2].length()-1))) // check which Vertex is match to Edge's to Vertex
			{																		 // when found it then save into To
				cVertex = cVertex.getNext();
			}
			eNode.setTo(cVertex); // set the To Vertex
			
			cEdge = eHead;
			if(cEdge == null) // if Edge is empty then insert into Head
				eHead = eNode;
			else // else isert into last
			{
				while(cEdge.getNext() != null) // get the last node in Edge
				{
					cEdge = cEdge.getNext();
				}
				cEdge.setNext(eNode);// set the node as last one
			}
		}
			
	}
	public void display() // show the Networfile's information on the screen
	{
		Vertex cVertex;
		Edge cEdge;
		
		cVertex = vHead;
		System.out.println("<NET>");
		while(cVertex != null)
		{	
			System.out.println("<VERTEX REL=" + cVertex.getRel().toString() + " TYPE=\""+cVertex.getType() + "\" COST=" + Integer.toString(cVertex.getCost()) + " NAME=\""+cVertex.getName() + "\" />");
		}
		cEdge = eHead;
		while(cEdge != null)
		{
			System.out.println("<EDGE FROM=\"" + cEdge.getFrom().getName() + "\" TO=\"" + cEdge.getTo().getName() + "\" REL=" + cEdge.getRel().toString() + " TYPE=\"" + cEdge.getType() + "\" COST=" + Integer.toString(cEdge.getCost()) + " NAME=\"" + cEdge.getName() + "\" />");
		}
		System.out.println("<\\NET>");
	}
	
	public void sort() // if file suffix is 'nt' then do this
	{
		boolean exist;
		int i,j=0,k,l=0,n=1;
		Vertex[] vArr = new Vertex[vNum];
		Vertex cVertex;
		Edge[] eArr = new Edge[eNum];
		Edge[] eTmp = new Edge[eNum];
		Edge cEdge, tmp;
		
		cVertex = vHead;
		cEdge = eHead;
		
		for(i = 0; i<eNum; i++) // Edge data save into Array
		{
			eArr[i] = cEdge;
			cEdge = cEdge.getNext();
		}
		cVertex = vHead;
		while(!cVertex.isSource()) // get the source Vertex
		{
			cVertex = cVertex.getNext();
		}
		vArr[0] = cVertex; // save source Vertex into array
		vArr[0].setOrder(0); // set the order( smaller mean is close to source)
		for(j=0; j<vNum; j++) 
		{
			for(i=0; i<eNum; i++)
			{
				if(eArr[i].getFrom() == vArr[j]) // looking for Edge form is same as Vertex[j]
				{
					eTmp[l] = eArr[i]; // if find same vertex then save into eTmp array(Edge temp array)
					l++;
					exist = false;
					for(k=0; k<j; k++) // checking found vertex is already exist in Vertex array
					{
						if(vArr[k] == eArr[i].getTo()) //if found vertex already exist in array then skip it
							exist = true;
					}
					if(exist == false) // if not exist in array then save into array
					{
						vArr[n] = eArr[i].getTo();
						vArr[n].setOrder(n); // give the order number for later sorting
						n++;
					}
				}
			}
		}
		for(i=0; i<eNum; i++) // sorting inside Edge which follow the Vertex's order
		{
			for(j=0; j<eNum; j++)
			{
				if(eTmp[i].getFrom() == eTmp[j].getFrom()) // if Edge's From is same then
				{
					if(eTmp[i].getTo().getOrder() > eTmp[j].getTo().getOrder()) // comparing To vertex which smaller one going front of array 
					{
						tmp= eTmp[i];
						eTmp[i] = eTmp[j];
						eTmp[j] = tmp;
					}
				}
			}
		}
		cEdge = eHead;
		for(i=0; i<eNum; i++) // save into Edge
		{
			cEdge = eTmp[i];
			cEdge = cEdge.getNext();
		}
		cVertex = vHead; // save into Vertex 
		for(i=0; i<vNum; i++)
		{
			cVertex = vArr[i];
			cVertex = cVertex.getNext();
		}
	}
}
