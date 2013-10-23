//      find_lowest_4.11.c
//      
//      Copyright 2012 nbas <nbas@INSPIRON8600> - HIS NATENESS, LORD OF THE EVERFLOWING CASKET OF BEEBLES. 
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

class hw1_DoubleArraySeq implements Cloneable 
/* Keeps track of a sequence of double numbers. 
 * The sequence can have a special "current element" 
 * which is specified and accessed through four methods that 
 * are not available in the bag class (start, getCurrent, 
 * advance, and isCurrent). */
{ 
	private double [] data ; 
	private int cursor ; 
	private int manyItems ; 
	private final int DEFAULT_INITIAL_CAPACITY = 10 ; 
	//bootstrap web framework for modern web applications you don't have 
	public hw1_DoubleArraySeq (  ) // Tested: Passed 20120925 
	{ 
		/* postcondition : This sequence is empty and has initialCapacity of 10. */ 
		/*	Throws OutOfMemoryError */ 
		// BOOK HAS : FINAL INT INITIAL_CAPACITY = 10 ; 
		manyItems = 0 ; // REMEMBER : manyItems must always be the actual cardinal number of items, one greater than the index. 
		data = new double[DEFAULT_INITIAL_CAPACITY] ; 
		// CAN'T DO THIS IF THERE ARE NO ITEMS TO CURSE. setCursorToBeginning (  ) ; // initializes the cursor to 0 ; 
	} 
	public hw1_DoubleArraySeq ( int initialCapacityParameter ) 
	{ 
		// initial capacity is the initial capacity of this sequence 
		// Precondition InitialCapacity is no-negative. 
		if ( initialCapacityParameter < 0 ) 
		{ 
			throw new IllegalArgumentException ( "initialCapacity is negative: " + initialCapacityParameter ) ; 
		}
		/* Postcondition : the sequence is empty and has the given initial capacity 
		* Throws Illegal Argument Excetpnio - indicates that initial capacity is negative, in keeping with the preconditions 
		*try // put something here that tests memory size 
		*/
		// throw OutOfMemoryError ; // (do this try/throw shit for memory later) 
		setSize ( 0 ) ; 
		data = new double [ initialCapacityParameter ] ; 
		setCursorToBeginning (  ) ; // initializes the cursor to 0 ; 
	} 
	private void ensureNewSlot (  ) 
	{ 
		if ( getSize (  ) >= data.length ) 
		{ 
			/* double the capacity and add 1; The addition of 1 at the end 
			 * is to make this work even if manyItems = 0; */
			 ensureCapacity ( manyItems * 2 + 1 ) ; 
		}
	}
	public void addAfter ( int whichElement , double dataToAdd ) // Tested: Passed 20120925 
	{ 
		// set cursor to the element you want to add something after, namely, the element whose index is whichElement
		
		if (!(isThereACursor (  )) )
		{
			throw new IllegalArgumentException ( "addAfter says, \n\"THERE'S NO CURSOR!!\"" ) ; 
		}
			if ( whichElement > getSize (  ) || whichElement < -2 /*|| whichElement < 0 //This caused an error with adding to the 0th element.*/ ) 
		{ 
			throw new IllegalArgumentException ( "Did you pick the \"leaded\" tit when you nursed? You can't add after an element that hasn't been created yet. Jesus." ) ; 
		} 
		setCursor( whichElement ) ; 
		//ensureNewSlot (  ) ; // ensureNewSlot makes a new slot for the element to be added 
		// for loop that moves the all elements one to the right, starting 
		// with the item whose index is manyItems, and ending by moving 
		// the item right after the item whose index is whichElement. 
		if ( getSize (  ) >= (data.length-1) ) 
		{ 
			/* double the capacity and add 1; The addition of 1 at the end 
			 * is to make this work even if manyItems = 0; */
			 ensureCapacity ( manyItems * 2 + 1 ) ; 
		}
		for ( int i = /*Start at the last item*/ manyItems - 1 ; i > getCursor (  ) ; i-- ) 
		{ 
			data [ i + 1 ] = data [ i ] ; /* Moves the data item to the next slot. */ 
		} 
		data [ whichElement+1 ] = dataToAdd ; 
		manyItems++ ; // there is another item added in, so we have to increase the size of our counter for the number of items, manyItems. 
	} 
	public void addBefore ( int whichElement, double dataToAdd ) // Tested 20120925. 
	{
		addAfter ( whichElement - 1 , dataToAdd ) ; 
		/* Adds a new element to this sequence, either before after the curent element. If 
		 * this new element would take this sequence byeond its current capacity, then the 
		 * capacity is increased before adding the new element. 
		 */
		 // The parameter double element is the new element that is being added. 
		 /* Postcondition is that a new copy of the element has been added to this sequence. If there was a 
		 current element, thehn addAfter places the new element after the rcurrent element, and addBefore places 
		 * the new element before the current element. If there was no current element, then addAfter places
		 * the new element at the end of this sequence, and adBefore places nthe new element 
		 * at the front of this sequence. In all cses, the new element becomes the 
		 * new current element of this sequencce. 
		 */
		 //throws OutOfMemoryError 
		 /* An attempt to increase the capacity beyond integer. MAX_VALUE will cause this 
		  * sequence to fail with an arithmetic overflow */ 
	}
			/* addAll follows: Place the contents of another sequence at the end of this sequence. 
		* Parameters : addend - a sequence whose contents will be placed at the end of this sequence 
		*Precondition : The parameter, addend, is not null. 
		* Postcondition : The elements from addend have been placed at the end 
		of this sequnce. The current element of this sequence remains where it was, 
		* and the addend is also unchanged. 
		 
		//throw NullPointerException ; 
		// Indicates that addend is null. 
		//throw OutOfMemoryError ; // Indicates insufficient memory to increase the capacibty of this sequence. 
		*/
	public void addAll ( hw1_DoubleArraySeq /*another arrayBag*/ addend ) // copies another bagg into our bag // Tested 20120925: Passed. 
	//Adds all of another bag to your bag. 
	{ 
		ensureCapacity ( manyItems + addend.manyItems ) ; 
		// it has a bigger array, then it has an if statement, 
		// if the size is greater than data.length, get a new array length copy it all in there. 
		/*Some people don't use this, and just use a loop. */
		System.arraycopy ( addend.data , 0 , data , manyItems , addend.manyItems ) ; 
		manyItems += addend.manyItems ; 
	} 

	public void advance (  ) // Tested 20120925: Passed. 
	{ 
		// Precondition : isCurrent (  ) returns true. 
		/* Postcondition : if the current element was already the end element of this sequence
		with nothing after it, then there is no longer any current element. 
		Otherwise, the new element is the element immeditately after the original current element. 
		*/
		if ( cursor == manyItems - 1 ) // That is, we ask, "Is the cursor at the last item?" 
		{
			throw new IllegalStateException ( "Cursor is at the end. You cannot advance. YOU SHALL NOT PASS. " ) ; 
		}
		cursor++ ; 
		// throw IllegalStateException ; 
		/*Indicates that there is no current element, so advance may not be called. */ 
	}
	public hw1_DoubleArraySeq clone (  ) // Tested 20120925 : Passed. 
	{ 
	hw1_DoubleArraySeq answer ; 
		try
		{
			answer = ( hw1_DoubleArraySeq ) super.clone (  ) ; 
		}
		catch ( CloneNotSupportedException e ) 
		{ 
			throw new RuntimeException 
			( "This class does not implement Cloneable." ) ; 
		}
		answer.data = ( double [] ) data.clone (  ) ; 
		/* hw1_DoubleArraySeq answer = new hw1_DoubleArraySeq ( getSize() ) ; 
		// Generate a copy of this sequence. 
		// throw OutOfMemoryError ; 
		// Indicates insufficient memory for creating the clone. 
		System.arraycopy ( data , 0 , answer , 0 , getSize() ) ; */ 
		return answer ; 
	} 
	public hw1_DoubleArraySeq concatenation ( hw1_DoubleArraySeq s1, hw1_DoubleArraySeq s2 ) // Tested 20120926: Passed. 
	/* Create a new sequence that contains all the elements from one 
	 * sequence followed by another 
	 */
	 {
			/* precondition is that s1 and s2 cant be null.*/
			if ( s1 == null || s2 == null ) 
			{ 
				throw new IllegalArgumentException ( "Dude, you can't submit null parameters. cmon. What are you, stupid?") ; 
			} 
			
			hw1_DoubleArraySeq answer = new hw1_DoubleArraySeq ( s1.getSize() + s2.getSize() ) ; 
			answer.ensureCapacity ( s1.getSize() + s2.getSize() ) ; 
			/* arraycopy: http://docs.oracle.com/javase/1.4.2/docs/api/java/lang/System.html */
			/* It has a bigger array, then it has an if statement, 
			 * if the size is greater than data.length, get a new array 
			 * length, and copy it all in there. 
			 * Some people don't use System.arraycopy, and 
			 * just use a loop. */ 
			System.arraycopy ( ( double [  ] ) s1.data , 0 , answer.data , 0 , s1.getSize (  ) ) ; 
			System.arraycopy ( s2.data , 0 , answer.data , s1.getSize (  ) , s2.getSize (  ) ) ; 
			// The above System.arraycopy calls copy first the s1 array, then the s2 array into the answer array. 
			// The above copying should really be accomplished with the addAll method, but I don't want to depend on that until I've gotten this version working. If there's something wrong with addAll, I don't want to confuse myself into thinking there is something wrong with concatenation. 
			answer.setSize ( s1.getSize() + s2.getSize() ) ; 
			answer.cursor = -1 ; /* WITH NO CURRENT ELEMENT 
			 
			 * throw NullPointerException ; 
			 * Indicates that one of the arguments is null. 
			 * throw OutOfMemoryError ; 
			 * Indicates insufficient memory for the new sequence. 
			 */
			return answer ; 
			/* Returns a new sequence, answer, that has the elements 
			 * of s1 followed by the elements of s2 */
		}
	public void ensureCapacity ( int minimumCapacity ) 
	{ 
		double [  ] biggerArray ; 
		if ( data.length < minimumCapacity ) 
		{ 
			biggerArray = new double [ minimumCapacity ] ; 
			System.arraycopy ( data , 0 , biggerArray , 0 , manyItems ) ; 
			data = biggerArray ; 
		}
		// This here is for error handling : 
		/*else 
		{ 
			System.out.println ( "ensureCapacity ( int ) says: There's enough space already. Quit your whining." ) ; 
		}*/ 
		//throws OutOfMemoryError ; 
		// Indicates insufficient memory for new double[minimumCapacity]
	}
	public int getCapacity (  ) 
	{ 
		return data.length ; 
	} 
	public int getCursor (  ) 
	{ 
		// Precondition isCurrent (  ) returns true. 
		//whatever the currentIndex element of the array is.  
		int ifThereIsACursor ; 
		ifThereIsACursor = 1 ; 
		if ( cursor > getSize() || cursor < 0 ) // if the cursor is less than 0, that means it has not yet been set. 
		{
			// (do this later) throw IllegalStateException ; // indicates that there is no current element 
			ifThereIsACursor = 0 ; 
		}
		return cursor*ifThereIsACursor ; 
	} 
	public double getCurrentElement (  ) 
	{ 
		if ( !isThereACursor() ) 
		{
			throw new IllegalStateException ( "getCurrentElement says: Zomg there's no fucking cursor. ") ; 
		}
		return data [ getCursor (  ) ] ; 
	}
	public void removeCurrentElement (  ) // Tested 20120929: Passed. 
	{ 
		// Remove the current element from this sequence. 
		// Precondition : isCurrent returns true. 
		// begin debugguerry code : 
		System.out.println ( "Alright, folks, the idea is to remove the data, " + data [ getCursor (  ) ] + ", which is at the cursor, index" + getCursor (  ) ) ; 
		System.out.println ( "The variable getSize returns " + getSize (  ) + ", and the method getLength (  ) returns " + getLength (  ) ) ; 
		if (!isThereACursor())
		{ 
			throw new IllegalStateException ( "There's no cursor goddamnit!" ) ; 
		} 
		// Postcondition : The current element has been removed. 
		for ( int i = getCursor (  ) ; i < ( getSize (  ) - 1); i++ ) // getSize (  ) - 1 evaluates to the index of the last "active" item in the list. 
		{ 
			System.out.println ( i ) ; 
			data[i] = data [i+1] ; // this replaces the data of the current data item with the data from the next data item. 
		} 
		manyItems-- ; // the reported size of our sequence must be reduced because an element has been removed. 
		// data[manyItems] = 0 ; // Zeroes whatever is in the slot after the last filled slot. 
		// use getCurrentElement? 
		// error handling for later : throw IllegalStateException ; 
		// indicates that there is no current element, so removeCurrent may not be called. 
	} 
	
	public int getLength (  ) 
	{ 
		return data.length ; 
	}
	
	public int getSize (  ) // Returns the index of the last item plus 1. 
	{ 
	// Accessor method to determine the number of elements. 
		return manyItems ; 
	}
	
	public void setSize ( int sizeToSet ) 
	{ 
		manyItems = sizeToSet ; 
	}
	
	public boolean isThereACursor (  ) // Tested 20120929: Passed. 
	{ 
		return ( cursor >= 0 && cursor < manyItems && manyItems != 0 ) ; // the manyItems != 0 is my concession to the functions that may check for a cursor before the use of the first element. 
		// addBefore, addAfter, and removeCurrent test whether a cursor 
		// exists at an array element using this method. 
		// Fred Sez: if equal to manyitems, then you're off the array. 
		// I say : manyItems AND  the cursor are equal after an element has been added, so we have to leave open the possibility that the cursor exists if they equal each other. 
		//accessor to determine whether this sequence has a specified current element 
		// 20120925 Fred was right. I was wrong. 
		// "Is there a cursor?" 
		// returns true if there is a cursor in use, or false if there is no cursor in use. 
	}
	// these three methods will drive your cursor 
	
	public void investigateMemory (  ) // Tested 20121001: Passed. 
	{
		Runtime r = Runtime.getRuntime (  ) ; 
		long mem1 , mem2 ;
		Integer someints[] = new Integer[1000] ; 
		System.out.println("Total memory is: " +
			r.totalMemory());
		mem1 = r.freeMemory();
		System.out.println("Initial free memory: " + mem1);
		r.gc();
		mem1 = r.freeMemory();
		System.out.println("Free memory after garbage collection: "
		+ mem1);
		for(int i=0; i<1000; i++)
		someints[i] = new Integer(i); // allocate integers
		mem2 = r.freeMemory();
		System.out.println("Free memory after allocation: "
		+ mem2);
		System.out.println("Memory used by allocation: "
		+ (mem1-mem2));
		// discard Integers
		// - 275 -
		for(int i=0; i<1000; i++) someints[i] = null;
		r.gc(); // request garbage collection
		mem2 = r.freeMemory();
		System.out.println("Free memory after collecting" +
		" discarded Integers: " + mem2); 
	}
	
	public void trimToSize (  ) // Tested 20120927 : Passed. 
	{ 
		// postcondition : this sequence's capacity has been trimmed to 
		// the number of active elements in use in it. 
		
		try
		{
			hw1_DoubleArraySeq answer = new hw1_DoubleArraySeq ( getSize (  ) ) ; 
		}
		catch ( OutOfMemoryError e ) 
		{ 
			throw new OutOfMemoryError 
			( "trimToSize says, \"There is not enough memory to trim this array\". Quite a catch-22, huh?" ) ; 
		}
		
		Runtime r = Runtime.getRuntime (  ) ; 
		int memoryLeft = r.freeMemory (  ) ; 
		if ( memoryLeft < 1024 ) 
		{
			throw new OutOfMemoryError 
			( 
				"trimToSize says, \"Runtime's \"freeMemory (  )\" " + 
				"returned " + memoryLeft + ", a value less than 1000. " + 
				"This probably means " + 
				"that memory is too small to do much more. " 
			); 
		}
		// throws OutOfMemoryError 
		// indicates insufficient memory for altering the capacity 
		hw1_DoubleArraySeq answer = new hw1_DoubleArraySeq ( getSize (  ) ) ; 
		System.arraycopy ( data , 0 , answer.data , 0 , getSize (  ) ) ; 
		data = answer.data ; 
		// let's also trim the original! 
	} 
	public void addBeginning ( double dataToAdd ) // Tested 20120927 : Passed. 
	{
		addBefore ( 0 , dataToAdd ) ; // This, in effect, adds the data supplied in the variable dataToAdd to the beginning of the array. 
	}
	
	public void addEnd ( double dataToAdd ) // Tested 20120926: Passed. 
	{ 
		// addAfter ( getSize (  ) , dataToAdd ) ; // This, in effect, adds the data supplied in dataToAdd to a new element after the manyItem-th element. 
		// Using addAfter, as above, produced logic errors. 
		// Now it's time to try it without. 
		if ( manyItems + 1 > data.length ) 
		{
			ensureCapacity ( manyItems * 2 + 1 ) ; 
		}
		data [ manyItems ] = dataToAdd ; 
		manyItems++ ; // Pretty much a postcondition of this method. 
	}
	
	public void removeBeginning (  ) // Tested 20120929: Passed. 
	{
		setCursorToBeginning (  ) ; 
		removeCurrentElement (  ) ; 
		// This method removes the element at index 0. 
	} 
	
	public void setCursorToBeginning (  ) // Tested 20120929: Passed. 
	{ 
		setCursor ( 0 ) ; 
	} 
	
	public void setCursorToLast (  ) 
	{ 
		setCursor ( manyItems - 1 ) ; // I put the - 1 in there since manyItems is the index of the last item, plus one. It's hacky. Bite me. 
	}
	
	public double getElementData ( int whichElement ) // Tested 20120926: Passed. 
	{ 
		int doIReturnTheElement ; 
		doIReturnTheElement = 1 ; 
		if ( whichElement > manyItems ) 
		{ 
		 doIReturnTheElement = 0 ; 
		 // do error handling later : throw IllegalArgumentException ( "Dammit don't choose an element outside the goddamn array." ) ; 
		}
		return data[whichElement]*doIReturnTheElement ; // the *doIReturnTheElement means that it returns 0 if they went outside the bounds of the sequence. 
	} 
	
	public void setCursor ( int whichElement ) // Tested 20120929 : Passed. 
	{ 
		if ( whichElement >= getSize (  ) && getSize (  ) != 0 ) // Again, my concession to an array without members yet. 
		{ 
			throw new IllegalArgumentException ( "Dammit don't choose an element outside the goddamn array." ) ; 
		} 
		else cursor = whichElement ; 
	}
	public void print (  ) // Tested 20120926 : Passed. 
	{
		setCursor ( 0 ) ; 
		if ( getSize (  ) <= 0 ) 
		{
			throw new IllegalStateException ( "WHAT THE FECK ARE YE BLIND? BLIND, ARE YE? THERE'S NOTHING IN YE'RE DAMN ARRAY, DAMMIT! HOW CAN YE HAVE ANY PUDDING IF YE DON'T EAT YER MEAT?" ) ; 
		}
		System.out.println ( getCurrentElement (  ) ) ; // This line might seem redundant, but it allows me to put advance first in the loop. 
		for ( int i = 0 ; i < ( getSize (  ) - 1 ) ; i++ ) 
		{
			advance (  ) ; 
			System.out.println ( getCurrentElement (  ) ) ; 
		}
	}
	public static void main ( String args[] ) 
	{ 
		hw1_DoubleArraySeq s = new hw1_DoubleArraySeq ( 5 ) ; // This tests the parametered constructor. 
		s.addEnd ( 1 ) ; // index 0. manyItems should now equal 1. 
		System.out.println ( "If manyitems is behaving itself, this number will be \"1\" : " + s.getSize(  ) ) ; // let's see if manyItems is behaving. 
		s.addEnd ( 5 ) ; 
		s.addEnd ( 2 ) ; 
		s.addEnd ( 4 ) ; 
		s.addEnd ( 2 ) ; 
		s.addEnd ( 5 ) ; // index 5. manyItems should now equal 6
		System.out.println ( "The variables in the array are as follows : " ) ; 
		s.print (  ) ; 
		System.out.println ( s.getElementData ( 0 ) + " " + s.getElementData ( 2 ) + " " + s.getElementData ( 3 ) + " " + s.getElementData ( 4 ) ) ; 
		System.out.println ( "Now we test whether the addAfter class works." ) ; 
		s.addAfter ( 2 , 6 ) ; // six is my favorite number, you see. Should appear after the first "2"
		System.out.println ( "getSize (  ) returns " + s.getSize(  ) ) ; 
		System.out.println ( "The variables in the array are now as follows : " ) ; 
		s.print (  ) ; 
		System.out.println ( "Now we test whether the addBefore class works." ) ; 
		s.addBefore ( 2 , 9) ; // should appear before the first "2" 
		s.print (  ) ; 
		System.out.println ( "Now it's time to test the addAll method." ) ; 
		hw1_DoubleArraySeq r = new hw1_DoubleArraySeq (  ) ; // This also tests the default constructor. 
		r.addEnd ( 11 ) ; 
		r.addEnd ( 15 ) ; 
		r.addEnd ( 12 ) ; 
		r.addEnd ( 14 ) ; 
		r.addEnd ( 12 ) ; 
		r.addEnd ( 15 ) ; // index 5. manyItems for "r" should now equal 6. 
		s.addAll ( r ) ; 
		System.out.println ( "Created \"r\" sequence, and added it using addAll() to \"s\". Its size is " + r.getSize (  ) ) ; 
		s.print (  ) ; 
		hw1_DoubleArraySeq f = r.clone (  ) ; 
		f.print (  ) ; 
		hw1_DoubleArraySeq g = new hw1_DoubleArraySeq (  ) ; 
		g.addEnd ( 111 ) ;
		g.addEnd ( 115 ) ; 
		g.addEnd ( 112 ) ; 
		g.addEnd ( 114 ) ; 
		g.addEnd ( 112 ) ; 
		g.addEnd ( 115 ) ; // index 5. manyItems for hw1_DoubleArraySeq "g" should now equal 6. 
		System.out.println ( "The data at g's index 5 is " + g.getElementData ( 5 ) ) ; 
		System.out.println ( "Created \"g\" sequence" ) ; 

		hw1_DoubleArraySeq KEEEUUUUWWWWUHHHHH = new hw1_DoubleArraySeq (  ) ; 
		System.out.println ( "Created \"KEEEUUUUWWWWUHHHHH\" sequence" ) ; 
		KEEEUUUUWWWWUHHHHH = KEEEUUUUWWWWUHHHHH.concatenation ( g , f ) ; 
		KEEEUUUUWWWWUHHHHH.print (  ) ; 
		
		// time to test trimToSize 
		System.out.println ( KEEEUUUUWWWWUHHHHH.getLength (  ) ) ; 
		KEEEUUUUWWWWUHHHHH.ensureCapacity ( 500 ) ; 
		System.out.println ( KEEEUUUUWWWWUHHHHH.getLength (  ) ) ; 
		System.out.println ( "Before trimToSize, " + KEEEUUUUWWWWUHHHHH.getLength (  ) ) ; 
		KEEEUUUUWWWWUHHHHH.trimToSize (  ) ; 
		System.out.println ( "Before trimToSize, " + KEEEUUUUWWWWUHHHHH.getLength (  ) ) ; 
		System.out.println ( "The length is " + KEEEUUUUWWWWUHHHHH.getLength (  ) + "." ) ; 
		KEEEUUUUWWWWUHHHHH.addBeginning ( 1111 ) ; 
		KEEEUUUUWWWWUHHHHH.print (  ) ; 
		KEEEUUUUWWWWUHHHHH.removeBeginning (  ) ; 
		System.out.println ( "Tested removeBeginning, here's what happened afterward." ) ; 
		KEEEUUUUWWWWUHHHHH.print (  ) ; 
		KEEEUUUUWWWWUHHHHH.investigateMemory (  ) ; 
	} 
} 

/* Begin output from program : 
 * If manyitems is behaving itself, this number will be "1" : 1
The variables in the array are as follows : 
1.0
5.0
2.0
4.0
2.0
5.0
1.0 2.0 4.0 2.0
Now we test whether the addAfter class works.
getSize (  ) returns 7
The variables in the array are now as follows : 
1.0
5.0
2.0
6.0
4.0
2.0
5.0
Now we test whether the addBefore class works.
1.0
5.0
9.0
2.0
6.0
4.0
2.0
5.0
Now it's time to test the addAll method.
Created "r" sequence, and added it using addAll() to "s". Its size is 6
1.0
5.0
9.0
2.0
6.0
4.0
2.0
5.0
11.0
15.0
12.0
14.0
12.0
15.0
11.0
15.0
12.0
14.0
12.0
15.0
The data at g's index 5 is 115.0
Created "g" sequence
Created "KEEEUUUUWWWWUHHHHH" sequence
111.0
115.0
112.0
114.0
112.0
115.0
11.0
15.0
12.0
14.0
12.0
15.0
12
500
Before trimToSize, 500
Before trimToSize, 12
The length is 12.
1111.0
115.0
115.0
112.0
114.0
112.0
115.0
11.0
15.0
12.0
14.0
12.0
15.0
Alright, folks, the idea is to remove the data, 1111.0, which is at the cursor, index0
The variable getSize returns 13, and the method getLength (  ) returns 25
0
1
2
3
4
5
6
7
8
9
10
11
Tested removeBeginning, here's what happened afterward.
115.0
115.0
112.0
114.0
112.0
115.0
11.0
15.0
12.0
14.0
12.0
15.0
Total memory is: 31522816
Initial free memory: 31189736
Free memory after garbage collection: 31399264
Free memory after allocation: 31066168
Memory used by allocation: 333096
Free memory after collecting discarded Integers: 31399128


------------------
(program exited with code: 0)
Press return to continue
 */
