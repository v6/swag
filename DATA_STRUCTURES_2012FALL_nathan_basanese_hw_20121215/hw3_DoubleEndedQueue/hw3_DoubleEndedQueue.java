//      hw3_DoubleEndedQueue.java
//      
//      Copyright 2012 nbas <nbas@INSPIRON8600> - HIS NATENESS ,  LORD OF THE EVERFLOWING CASKET OF BEEBLES. 
//      
//      This program is free software ; you can redistribute it and/or modify
//      it under the terms of the GNU General Public License as published by
//      the Free Software Foundation ; either version 2 of the License ,  or
//      ( at your option ) any later version.
//      
//      This program is distributed in the hope that it will be useful , 
//      but WITHOUT ANY WARRANTY ; without even the implied warranty of
//      MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//      GNU General Public License for more details.
             
import java.util.* ;

class DoubleNode<E>
{
	private E data ;
	private DoubleNode<E> linkToFrontNode ; 
	private DoubleNode<E> linkToRearNode ;

	public E getData (   ) 
	{
		return data ; 
	}
	
	public void setData ( E eData ) 
	{	
		data = eData ;	
	}

	public DoubleNode<E> getLinkToFrontNode (  ) 
	{	
		return linkToFrontNode ;	
	}
	public void setLinkToFrontNode ( DoubleNode<E> linkToFrontNodeParameter ) 
	{	
		linkToFrontNode = linkToFrontNodeParameter ;	
	}

	public DoubleNode<E> getLinkToRearNode (  ) 
	{	
		return linkToRearNode ;	
	}
	public void setLinkToRearNode ( DoubleNode<E> linkToRearNodeParameter ) 
	{	
		linkToRearNode = linkToRearNodeParameter ;	
	}

	public DoubleNode ( E initialDataParameter ,  DoubleNode<E> linkToFrontNodeLinkParameter ,  DoubleNode<E> linkToRearNodeLinkParameter ) 
	{	
		data = initialDataParameter ;
		linkToFrontNode = linkToFrontNodeLinkParameter ;
		linkToRearNode = linkToRearNodeLinkParameter ;
	}
}

class Deque<E>
{
	private int itemCount ;
	private DoubleNode<E> dequeFrontNode ; 
	private DoubleNode<E> dequeRearNode ;

	public int getitemCount (  ) 
	{	
		return itemCount ;	
	}
	
	public void setitemCount ( int item ) 
	{	
		itemCount = item ; 
	}

	public DoubleNode<E> getFront (  ) 
	{	
		return dequeFrontNode ;	
	}
	
	public void setFront ( DoubleNode<E> setFrontParameter ) 
	{	
		dequeFrontNode = setFrontParameter ;	
	}

	public DoubleNode<E> getRear (  ) 
	{	
		return dequeRearNode ;	
	}
	
	public void setRear ( DoubleNode<E> setRearParameter ) 
	{	
		dequeRearNode = setRearParameter ;	
	}

	public Deque (  ) 
	{
		itemCount = 0 ;
		dequeFrontNode = null ;
		dequeRearNode = null ;
	}

	public boolean dequeHasNoItems (  ) 
	{
		if ( itemCount == 0 ) 
		{
			return true ;
		}
		else
		{
			return false ;
		}
	}

	public void addRear ( E item ) 
	{
		if ( dequeHasNoItems (  )  ) 
		{
			dequeFrontNode = new DoubleNode ( item , null , null ) ;
			dequeRearNode = dequeFrontNode ;
		}
		else
		{
			DoubleNode<E> dummyRearNode = new DoubleNode<E> ( item , dequeRearNode , null ) ;
			dequeRearNode.setLinkToRearNode ( dummyRearNode ) ;
			dequeRearNode = dummyRearNode ;

		}
		itemCount++ ;
	}

	public void addFront ( E addend ) 
	{
		if ( dequeHasNoItems (  )  ) 
		{
			dequeFrontNode = new DoubleNode ( addend , null , null ) ;
			dequeRearNode = dequeFrontNode ;
		}
		else
		{
			DoubleNode<E> dummyAddFrontNode = new DoubleNode<E> ( addend , null , dequeFrontNode ) ;
			dequeFrontNode.setLinkToFrontNode ( dummyAddFrontNode ) ;
			dequeFrontNode = dummyAddFrontNode ;
		}
		itemCount++ ;
	}

	public E removeFront (  ) 
	{
		E answer ;
		answer = dequeFrontNode.getData (  ) ;
		dequeFrontNode = dequeFrontNode.getLinkToRearNode (  ) ;
		itemCount-- ;

		if ( dequeHasNoItems (  )  ) 
		{
			dequeRearNode = null ;
		}
		else
		{
			dequeFrontNode.setLinkToFrontNode ( null ) ;
		}
		return answer ;
	}
	
	public E removeRear (  ) 
	{
		E dataOfNodeRemoved ;
		dataOfNodeRemoved = dequeRearNode.getData (  ) ;
		dequeRearNode = dequeRearNode.getLinkToFrontNode (  ) ;
		itemCount-- ;

		if ( dequeHasNoItems (  )  ) 
		{
			dequeFrontNode = null ;
		}
		else
		{
			dequeRearNode.setLinkToRearNode ( null ) ;
		}
		return dataOfNodeRemoved ;
	}
	
	public void print (  ) 
	{
		for ( DoubleNode<E> i = dequeFrontNode ; i != null ; i = i.getLinkToRearNode (  )  ) 
		{
			System.out.println ( i.getData (  )  ) ;
		}
	}
}

class hw3_DoubleEndedQueue
{
	public static void main ( String[] args ) 
	{
		Deque<Boolean> listOfFalseHoods = new Deque<Boolean> (  ) ;

		System.out.println ( "DOUBLEENDEDQUEUE TIME. BEHOLD ITS GLORY." ) ; 
		listOfFalseHoods.addFront ( false ) ;
		listOfFalseHoods.addFront ( false ) ;
		listOfFalseHoods.addFront ( true ) ;
		listOfFalseHoods.addFront ( false ) ;
		listOfFalseHoods.addFront ( true ) ;
		listOfFalseHoods.addFront ( false ) ;
		listOfFalseHoods.addFront ( false ) ;
		System.out.println ( "ADDING TO THE REAR." ) ; 
		listOfFalseHoods.addRear ( true ) ;
		listOfFalseHoods.addRear ( false ) ;
		listOfFalseHoods.addRear ( true ) ;
		listOfFalseHoods.addRear ( true ) ;
		listOfFalseHoods.print (  ) ;
	}


}
/*
Press any key to continue . . .

DOUBLEENDEDQUEUE TIME. BEHOLD ITS GLORY.
ADDING TO THE REAR.
false
false
true
false
true
false
false
true
false
true
true


------------------
(program exited with code: 0)
Press return to continue
*/
