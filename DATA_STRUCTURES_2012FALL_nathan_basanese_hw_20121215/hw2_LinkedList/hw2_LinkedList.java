//      hw2_LinkedList.java
//      
//      Copyright 2012 nbas <nathan@basanese.com> - HIS NATENESS, LORD OF THE EVERFLOWING CASKET OF BEEBLES. 
//      
//      This program is free software; you can redistribute it and/or modify
//      it under the terms of the GNU General Public License as published by
//      the Free Software Foundation; either version 2 of the License, or
//      (at your option) any later version.
//      
//      This program is distributed in the hope that it will be useful,
//      but WITHOUT ANY WARRANTY; without even the implied warranty of
//      MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//      GNU General Public License for more details.

import java.util.* ;

class Node<E> 
{
	private E data ; 
	private Node<E> link ; 

	public E getData (  ) 
	{	
		return data ; 
	} 
	
	public void setData ( E e ) 
	{	
		data = e ; 	
	}
	
	public Node<E> getLink (  )
	{	
		return link ;
	}
	
	public void setLink ( Node<E> l )
	{
		link = l ; 	
	}

	public Node ( E startingData , Node<E> startingLink )
	{
		data = startingData ;
		link = startingLink ;
    }
    
    public static <E> Node<E> listCopy ( Node <E> source ) 
	{
		Node<E> copysHead ;
		Node<E> copysTail ;

		if ( source  ==  null ) // EMPTY PARAMETER LIST? NO, SON. 
		{
			System.out.println  ( "ERROR, MAN. ERROR." ) ; // debuggling code
			return null ; 
		}

		copysHead = new Node<E> ( source.data , null ) ; //FIRST NODE FOR NEW LIST 
		copysTail = copysHead ; 

		while ( source.link != null) // REST OF NODES 
		{
			source = source.link; // ADVANCE IT. 
			copysTail.addNodeAfter  (  source.data ) ; // ADD NODE TO THE COPY
			copysTail = copysTail.link ;
		}
		return copysHead ; // RETURN NEW LIST'S HEAD AS THE NEW LIST
	}

	// GET LENGTH OF LIST, THAT'S THE GIST 
	public static <E> int listLength ( Node<E> head ) 
	{
		Node<E> cursor ; 
		int answer = 0 ; 

		for ( cursor = head ;  cursor != null ;  cursor = cursor.link )
		{
			answer++ ; 
		}
		return answer ; 
	}
	
	// ADD A NODE AFTERWARD 
	public void addNodeAfter ( E element ) 
	{
		link = new Node<E> ( element , link ) ; // EASY. 
	}
	
	// REMOVE A NODE AFTERWARD, JUST HAVE THE ONE BEFORE "SKIP"! TO MY LOU! 
	public void removeNodeAfter (  )
	{
		link = link.link ; // LIKE CURSOR++ ; 
	}
	
	// COPY A WHOLE LIST. 
	public static <E> Node<E>[  ] listCopyWithTail ( Node<E> source )
	{
		Node<E> copysHead ; 
		Node<E> copysTail ; 
		Node<E> [  ] answer =  ( Node<E>[  ] ) new Node[2] ; 

		// COPY AN EMPTY LIST?? 
		if ( source == null )
		{	
			System.out.println ( "COPY AN EMPTY LIST? NULL! " ) ; 
			return null ; 	
			// AT THIS POINT ANSWER IS NULL AND NULL STILL. 
		}

		//CREATE HEAD
		copysHead = new Node<E> ( source.data, null ) ; 
		copysTail = copysHead ; 

		//POPULATE NODES
		while ( source.link != null )
		{
			source = source.link ; 
			copysTail.addNodeAfter ( source.data ) ; 
			copysTail = copysTail.link ; 
		}
		// RETURN "ANSWER" AS LINKS TO COPY'S HEAD AND COPY'S TAIL. 
		answer[0] = copysHead ; 
		answer[1] = copysTail ; 
		return answer ; // THIS IS AN ARRAY. REMEMBER. 
	}
	
	// OUTPUT THE ENTIRE ARRAY, IN ALL ITS TEDIOUS GLORY. 
	public E printOut (  )
	{
		return getData (  ) ; 
	}
	
	// RETURN LINK TO ITEM AT POSITION. 
	public static <E> Node<E> listPosition ( Node<E> head , int position )
	{
		Node<E> cursor ; 
		int i ; 

		if  ( position <= 0 )
			throw new IllegalArgumentException ( "POSITION NEGATIVE OR ZERO. ERROR. ERROR. GO BACK TO THE BLACK LANDS FROM WHENTS YOU CAME" ) ; 

		cursor = head ; 
		for ( i = 1 ;   ( i < position ) &&  ( cursor != null ) ; i++ )
		{
			cursor = cursor.getLink (  ) ; // ADVANCE THE CURSOR
		}
		// AFTER THIS LOOP'S RUN, CURSOR SHOULD BE AT THE PARAMETER "POSITION" LOCATION. 
		return cursor ; // THIS IS A LINK TO THE ITEM AT THE POSITION SUPPLIED. 
	}
	
	// LIST SEARCH, THE SEARCH FOR LISTS! THIS IS LIKE LISTPOSITION, EXCEPT THAT IT "FINDS" USING DATA, NOT POSITION INFORMATION. 
	public static<E> Node<E> listSearch ( Node<E> head, E target )
	{
		Node<E> cursor ; 
		for ( cursor=head ; cursor!=null ; cursor=cursor.getLink (  ) )
		{
			if ( target == cursor.getData (  ) )
			{
				return cursor ; 
			}
		}
		return null ; 
	}
}

class Lister<E> implements Iterator<E>
{
	private Node<E> current ; 

	public Lister ( Node<E> head )
	{
		current = head ; 
	}

	public boolean hasNext (  ) 
	{
		return ( current != null ) ; // IF NODE IS NOT NULL, RETURNS TRUE. 
	}


	public E next (  )
	{
		E answer ; 

		if ( !hasNext (  ) )
		{
			throw new NoSuchElementException ( "EMPTY. I AM SURROUNDED BY IMBECILES." ) ; 
		}
		
		answer = current.getData (  ) ; 
		current = current.getLink (  ) ; 

		return answer ; 
	}

	public void remove (  )
	{
		throw new UnsupportedOperationException ( "NO REMOVE" ) ; 
	}
}

class LinkedList<E> implements Cloneable
{
	private Node<E> headNode ; 
	private Node<E> tailNode ; 
	private int itemCount ; 
	private Node<E> cursor ; // "CURRENT" 
	private Node<E> preCursor ; 

	public Node<E> getHeadNode (  )
	{	
		return headNode ; 	
	}
	
	public void setHeadNode ( Node<E> head )
	{	
		headNode = head ; 	
	}
	
	public Node<E> getTailNode (  )
	{	
		return tailNode ; 	
	}
	
	public void setTailNode ( Node<E> tail )
	{	
		tailNode = tail ; 	
	}
	
	public int getitemCount (  )
	{	
		return itemCount ; 	
	}
	
	public void setitemCount ( int itemCountParameter ) 
	{	
		itemCount = itemCountParameter ; 	
	}
	
	public Node<E> getCursor (  )
	{ 	
		return cursor ; 	
	}
	
	public void setCursor ( Node<E> setCursorParameter )
	{	
		cursor = setCursorParameter ; 	
	}
	
	public Node<E> getPreCursor (  )
	{	
		return preCursor ; 	
	}
	
	public void setPreCursor ( Node<E> setPreCursorParameter )
	{	
		preCursor = setPreCursorParameter ; 
	}

	public LinkedList (  )
	{
		headNode = null ; 
		tailNode = null ; 
		itemCount = 0 ; 
		cursor = null ; 
		preCursor = null ; 
	}
	
	public void print (  )
	{
		Node<E> cursor ; 
		for ( cursor = headNode ;  cursor != null ;  cursor = cursor.getLink (  ) )
			{
				System.out.println ( cursor.getData (  ) ) ; 
			}
	}
	public void start (  )
	{
		if ( itemCount == 0 )
			throw new IllegalStateException ( "NO CURRENT, FOOL!!! " ) ; 

		cursor = headNode ; 
		preCursor = null ; 
	}

	public void advance (  )// SCOOCH TO THE NEXT ONE 
	{
		if ( !isCurrent (  ) )
		{
			throw new IllegalStateException ( "NO CURRENT, FOOL!!! " ) ; 
		}
		preCursor = cursor ; 
		cursor = cursor.getLink (  ) ; 
	}

    public E getRandomData (  )
    {
		int randomVal ; 
		Node<E> cursor ; 
		if  ( itemCount  == 0 )
		{
			throw new IllegalStateException ( "YOU CAN'T GET RANDOM DATA IF YOU DON'T EAT YOUR MEAT. HOW CAN YOU HAVE ANY DATA IF YOU DON'T EAT YOUR MEAT??? " ) ; 
		}
		randomVal = ( int ) ( Math.random (  ) * itemCount ) + 1 ; 
		cursor = Node.listPosition ( headNode, randomVal ) ; 
		return cursor.getData (  ) ; 
	}

	public boolean isCurrent (  ) 
	{

		if ( cursor != null ) 
		{
			return true ; 
		}
		else
		{
			return false ; 
		}
	}

	public int size (  )
	{
		return itemCount ; 
	}

	public void addFront ( E element )
	{
		headNode = new Node<E> ( element, headNode ) ; 
		itemCount++ ; 
	}
	
	public void addAll ( LinkedList<E> addend )
	{
		Node<E>[  ] copyInfo ; // LIKE ANSWER, BUT FOR COPY
		if ( addend.equals(null) ) 
		{ 
			System.out.println  ( " ADDEND IS NULL, FLY YOU FOOLS!" ) ; 
		} 
		if ( addend.itemCount > 0 )
		{
			copyInfo = Node.listCopyWithTail ( addend.headNode ) ; 
			copyInfo[1].setLink ( headNode ) ; 
			headNode = copyInfo[0] ; 
			itemCount = itemCount + addend.itemCount ; 
		}
	}
	
	public LinkedList<E> clone (  )
	{
		// CLONE LINKEDLIST OBJ. 
		LinkedList<E> answer ; 

		try  // TEST FOR CLONEABILITY
		{
			answer = ( LinkedList<E> ) super.clone (  ) ; 
		}
		catch ( CloneNotSupportedException e )
		{
			throw new RuntimeException
			 ( "NO CLONEABLE" ) ; 
		}
		answer.headNode = Node.listCopy ( headNode ) ; 
		return answer ; 
	}
	
	// COUNT HOW OFTEN SOMETHING APPEARS IN THE LIST BASED ON THE DATA 
	public int countOccurrences ( E target )
	{
		int answer = 0 ; 
		Node<E> cursor ; 
		cursor = Node.listSearch ( headNode, target ) ; 
		while ( cursor != null ) // ITERATE OVER THE LIST 
		{
			answer++ ; 
			cursor = cursor.getLink (  ) ; 
			cursor = Node.listSearch ( cursor, target ) ; 
	    }
	    return answer ; // THIS IS A COUNT OF THE NODES
	}
	
	// POINT TO THE HEADNODE, BASICALLY
	public Lister<E> iterator (  ) 
	{
		return new Lister<E> ( headNode ) ; 
	}

	// INSERT ELEMENT BEFORE. DOESN'T CHECK FOR DATA CONSITENCY. 
	public void addBefore ( E element )
	{
		if ( headNode == null )
		{
			headNode = new Node<E>  ( element , null ) ; 
			tailNode = headNode ; 
			cursor = headNode ; 
			preCursor = null ; 
		}
		else if ( isCurrent (  ) && cursor != headNode )
		{
			preCursor.addNodeAfter ( element ) ; 
			cursor = preCursor.getLink (  ) ; 
		}
		else
		{
			headNode = new Node<E> ( element , headNode ) ; 
			cursor = headNode ; 

			preCursor=null ; 
		}
		itemCount++ ; 
	}
	
	public void addAfter ( E element )
	{
		// IF EMPTY LIST : 
		if ( headNode == null )
		{
			headNode = new Node<E>  ( element , null ) ; 
			tailNode = headNode ; 
			cursor = headNode ; 
			preCursor = null ; 
		}
		// IF INSIDE TARGET LIST 
		else if ( isCurrent (  ) && cursor != tailNode )
		{
			cursor.addNodeAfter ( element ) ; 
			preCursor=cursor ; 
			cursor=cursor.getLink (  ) ; 
		}
		// IF AT THE END OF TARGET LIST 
		else
		{
			tailNode.addNodeAfter ( element ) ; 
			preCursor = headNode ; 
			tailNode = tailNode.getLink (  ) ; 
			cursor = tailNode ; 
		}
		itemCount++ ; // MAKE SURE THE AMOUNT IS KEPT TRACK OF 
	}
	
	public static <E> LinkedList<E> listConcatenation ( LinkedList s1, LinkedList s2 )
	{
		if ( s1 == null||s2 == null )
			throw new NullPointerException ( "one of the LinkedList's is null" ) ; 
		else
		{
			LinkedList<E> answer = new LinkedList<E> (  ) ; 

			answer.addAll ( s1 ) ; 
			answer.addAll ( s2 ) ; 
			return answer ; 
		}
	}

	public void removeCurrent (  )
	{
		if ( !isCurrent (  ) )
		{
			throw new IllegalStateException ( "IN YOUR FACE!" ) ; 
		}
		if ( cursor == headNode )
		{
			headNode = headNode.getLink (  ) ; 	
		}
		if ( cursor == tailNode )
		{
			tailNode = preCursor ; 
			cursor = cursor.getLink (  ) ; 
		}
		if ( preCursor!=null )
		{
			preCursor.setLink ( cursor ) ; 
		}
		itemCount-- ; 
	}




}








class hw2_LinkedList
{

	public static void main ( String[  ] args )
	{

		LinkedList<Boolean> FARMOLO = new LinkedList<Boolean> (  ) ; 
		LinkedList<Boolean> FARMOLOS_BROTHER = new LinkedList<Boolean> (  ) ; 

		System.out.println ( "TEST AA AND RC. " ) ; 
		Boolean testBool = new Boolean ( false ) ; 
		System.out.println ( testBool ) ; 
		FARMOLO.addAfter ( new Boolean( false ) ) ; 
		FARMOLO.addAfter ( new Boolean ( true ) ) ; 
		FARMOLO.addAfter ( new Boolean ( false ) ) ; 
		FARMOLO.addAfter ( new Boolean ( false ) ) ; 
		FARMOLO.removeCurrent (  ) ; 
		FARMOLO.print (  ) ; 

		System.out.println ( "CONCATENATION TIME, THE TIME OF CONCATENATION. BEHOLD ITS GLORY." ) ; 

		FARMOLOS_BROTHER.addAfter ( new Boolean ( false ) ) ; 
		FARMOLOS_BROTHER.addAfter ( new Boolean ( false ) ) ; 
		FARMOLOS_BROTHER.addAfter ( new Boolean ( false ) ) ; 
		FARMOLOS_BROTHER.addAfter ( new Boolean ( false ) ) ; 
		FARMOLOS_BROTHER.addAfter ( new Boolean ( true ) ) ; 

		LinkedList<Boolean> FARMOLOS_SISTER_OMG = LinkedList.listConcatenation ( FARMOLO , FARMOLOS_BROTHER ) ; 

		FARMOLOS_SISTER_OMG.print (  ) ; 
		System.out.println ( "this is addAll " ) ; 

		FARMOLO.addAll ( FARMOLOS_SISTER_OMG ) ; 
		FARMOLO.print (  ) ; 
		System.out.println ( "SUBMIT ALL QUERIES TO THE COMPLAINT DEPARTMENT, WHERE THEY WILL COMPLAIN AT YOU." ) ; 

	}

}
/*
false
false
CONCATENATION TIME, THE TIME OF CONCATENATION. BEHOLD ITS GLORY.
false
false
false
false
true
false
this is addAll 
false
false
false
false
true
false
false
SUBMIT ALL QUERIES TO THE COMPLAINT DEPARTMENT, WHERE THEY WILL COMPLAIN AT YOU.


------------------
(program exited with code: 0)
Press return to continue
*/
