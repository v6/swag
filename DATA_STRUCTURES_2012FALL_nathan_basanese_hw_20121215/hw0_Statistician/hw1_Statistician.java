//      hw1_Statistician.java
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

/* Specify, design, and implement a class called Statistician. After a statistician is initialized, 
it can be given a sequence of double numbers. Each number in the sequence is given to t he statistician by activating 
a method called nextNumber. For example, we can declare a statistician called s and then give it to the sequence of 
numbers 1.1, -2.4, 0.8, as shown here: 
Statistician s = new Statistician( ) ; 
s.nextNumber(1.1); 
s.nextNumber(-2.4); 
s.nextNumber(0.8); 

After a sequence has been given to a statistician, there are various methods to obtain information about the sequence. Include methods 
that will provide 
the length of the sequence, 
the last number of the sequence, 
the sum of all the numbers, 
in the sequence, 
the arithmetic mean of the numbers, 
the smallest number of the sequence, 
and the largest number 
in the sequence. 
Notice that the length and sum methods can be called at any 
time, even if there are no numbers in the sequence. */

import java.util.* ; 

class hw1_Statistician 
{ 
	public int length = 0 ; 
	public double last = 0 ; 
	public double first = 0 ; 
	public double smallest = 0 ; 
	public double biggest = 0 ; 
	public double sum = 0 ; 
	int length (  ) 
	{ 
		return length ; // returns a counter made, somehow, to record whatever the length is 
	}
	double first (  ) 
	{ 
		return first ; // This returns the first number, from the first call of nextNumber. 
	}
	double last (  ) 
	{ 
		return last ; // This just spits back the last number entered. 
	} 
	double mean (  ) 
	{ 
		return sum / ((double)length) ; // This is pretty easy. It's just the average. I don't know why the book chose to call it the arithmetic mean. 
	}
	double biggest (  ) 
	{ 
		return biggest ; // gives back the biggest number 
	} 
	double smallest (  ) 
	{ 
		return smallest ; // gives back the smallest number 
	} 
	void nextNumber ( double lastNumber ) // now we have the meat of the problem. 
	{ 
/*// The lines below are for use if you would like this to be interactive. 
		System.out.print ( "Enter a number --> " ) ; 
		double lastNumber = in.nextDouble ; 
*/
		length++ ; // Gets a number from the user and bumps up the length value. 
		if ( lastNumber < smallest ) smallest = lastNumber ; 
		if ( lastNumber > biggest ) biggest = lastNumber ; 
		if ( length == 1 ) first = lastNumber ; 
		last = lastNumber ; 
		sum = sum + lastNumber ; 
	} 
	void print (  ) // this just shows all the current values of the class' data. 
	{ 
		System.out.println ( first+ last+ smallest+ biggest+ mean (  )+ length ) ; 
	} 
	Statistician (  ) {  } ; // This is the blank constructor method. 
} 
class hw_1_Statistician
{
	public static void main ( String[] args ) 
	{
		Scanner in = new Scanner ( System.in ) ; 
		Statistician s = new Statistician (  ) ; 
		s.nextNumber ( 1.1 ) ; 
		s.nextNumber ( -2.4 ) ; 
		s.nextNumber ( 0.8 ) ; 
		s.nextNumber ( 0.16666 ) ; 
		System.out.println ( s.last (  )  + " " + s.first (  ) + " " + s.biggest (  ) + s.smallest (  ) + s.mean (  ) ) ; 
	}
}
