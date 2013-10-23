//      hw5_HashTable.java
//      
//      Copyright 2012 nbas <nathan@basanese.com> - Nathan Basanese , all praise be upon his glorious fame and inconsolate name
//      
//      This program is free software ; you can redistribute it and/or modify
//      it under the terms of the GNU General Public License as published by
//      the Free Software Foundation ; either version 2 of the License , or
//      ( at your option ) any later version.
//      
//      This program is distributed in the hope that it will be useful , 
//      but WITHOUT ANY WARRANTY ; without even the implied warranty of
//      MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//      GNU General Public License for more details.
// 	  File: BTNode.java from the package edu.colorado.nodes
// 	  Complete documentation is available from the BTNode link in:
//      http://www.cs.colorado.edu/~main/docs/
//
// >>>>>>>>>>>>>>>>>> STARTING PREPARATIONS >>>>>>>>>>>>>>>>>>

import java.util.* ;

class Table < K , E >
{
	private int manyItems ;
	private Object [  ] keys ;
	private Object [  ] data ;
	private boolean [  ] hasBeenUsed ;


	public Object [  ] getData ( ) 
	{	
		return data ;
	}
	
	public Object [  ] getKey ( ) 
	{	
		return keys ;
	}
	public int getManyItems ( ) 
	{	
		return manyItems ;	
	}

	Table ( ) 
	{}// "LE FRED CONSTRUCTOR, A WORK IN MINIMALISM" COURTESY OF CUZAK. 

	public Table ( int capacity ) 
	{
		keys = new Object [ capacity ] ;
		data = new Object [ capacity ] ;
		hasBeenUsed = new boolean [ capacity ] ;
		manyItems = 0 ;
	}

	public E put ( K key , E element ) 
	{
		int index = findIndex ( key ) ;
		int count = 0 ;
		E answer ;
		if ( index != -1 ) 
		{
			answer = ( E ) data[index] ;
			data [ index ] = element ;
			return answer ;
		}
		else
		{
			if ( manyItems < data.length ) 
			{
				index = hash ( key ) ;

				while ( keys[index] != null ) 
				{
					count++ ;
					index = ( index + count ) % data.length ; 
				}
				keys[index] = key ;
				data[index] = element ;
				hasBeenUsed[index] = true ;
				manyItems++ ;
				return null ;
			}
			else
			{ 
				throw new IllegalStateException ( "FULL LIKE A HULL OF BULL" ) ;
			} 
		}
	}

	private int findIndex ( K key ) 
	{
		int count = 0 ;
		int i = hash ( key ) ;
		while (  ( count < data.length ) && ( hasBeenUsed [ i ] )  ) 
		{
			if ( key.equals ( keys[i] )  ) 
			{
				return i ;
			}
			count++ ;
			i = ( i + count ) % data.length ;//
		}
		return -1 ;
	}


	private int hash ( Object key ) 
	{
		return Math.abs ( key.hashCode ( )  ) % data.length ;
	}

	private int nextIndex ( int i ) 
	{
		if ( i + 1 == data.length ) 
			return 0 ;
		else
			return i + 1 ;
	}

	public E get ( K key ) 
	{
		int index = findIndex ( key ) ;
		if ( index == -1 ) 
		{
			return null ;
		}
		else
		{
			return ( E ) data[index] ;
		}
	}

	public E remove ( K key ) 
	{
		int index = findIndex ( key ) ;
		E answer = null ;
		if ( index != -1 ) 
		{
			answer = ( E ) data[index] ;
			keys[index] = null ;
			data[index] = null ;
			manyItems-- ;
		}
		return answer ;
	}

}

class hw5_HashTable
{
	public static void main ( String [  ] args ) 
	{
		Table< String , String > mensaOfIdiots = new Table<String , String> ( 10 ) ;
		Scanner in = new Scanner ( System.in ) ;

		mensaOfIdiots.put ( "Billy Bob" , "70440" ) ;
		mensaOfIdiots.put ( "Janey McPiddunHead-Allister" , "78770707" ) ;
		mensaOfIdiots.put ( "Oprah Winfrey" , "OFF THE CHARTS" ) ;
		mensaOfIdiots.put ( "Bill Gates" , "-803" ) ;
		mensaOfIdiots.put ( "Dudley Dooright" , "1002" ) ;
		
		System.out.println ( mensaOfIdiots.get ( "Bill Gates" ) ) ; 
		System.out.println ( mensaOfIdiots.get ( "Oprah Winfrey" ) ) ; 
		System.out.println ( mensaOfIdiots.get ( "Janey McPiddunHead-Allister" ) ) ; 
		System.out.println ( mensaOfIdiots.get ( "Bill Gates" ) ) ; 

	}
}
/*
-803
OFF THE CHARTS
78770707
-803


------------------
(program exited with code: 0)
Press return to continue

*/
