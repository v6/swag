//      DoubleLinkedSeq.java
//      
//      Copyright 2012 nbas <nathan@basanese.com> - Nathan Basanese, all praise be upon his glorious fame and inconsolate name
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
// 	  File: BTNode.java from the package edu.colorado.nodes
// 	  Complete documentation is available from the BTNode link in:
//      http://www.cs.colorado.edu/~main/docs/
//
// >>>>>>>>>>>>>>>>>> STARTING PREPARATIONS >>>>>>>>>>>>>>>>>>
import java.util.* ; 

/******************************************************************************
* A BTNode provides a node for a binary tree. Each node 
* contains a piece of data (which is a reference to an E object) and references
* to a left and right child. The references to children may be null to indicate
* that there is no child. The reference stored in a node can also be null.
*
* <dl><dt><b>Limitations:</b> <dd>
*   Beyond Int.MAX_VALUE elements, treeSize, is wrong.
*
* <dt><b>Java Source Code for this class:</b><dd>
*   <A HREF="../../../../edu/colorado/nodes/BTNode.java">
*   http://www.cs.colorado.edu/~main/edu/colorado/nodes/BTNode.java </A>
*
* @author Michael Main 
*   <A HREF="mailto:main@colorado.edu"> (main@colorado.edu) </A>
*
* @version
*   Jul 22, 2005
******************************************************************************/
public class BinaryTreeNode <E>
{
	// Invariant of the BTNode<E> class:
   //   1. Each node has one reference to an E Object, stored in the instance
   //      variable data.
   //   2. The instance variables left and right are references to the node's
   //      left and right children.
   
	private E data  ; 
	private BinaryTreeNode<E> leftLink  ;  
	private BinaryTreeNode<E> rightLink  ; 

	// BEGIN BinaryTreeNode GETTERS 
	public E getData (  ) 
	{   
		return data  ; 	
	}
	
	public BinaryTreeNode <E> getLeftLink (  ) 
	{	
		return leftLink ; 	
	}
	public BinaryTreeNode<E> getRightLink (  ) 
	{   
		return rightLink ; 	
	}
	
	// BEGIN BinaryTreeNode SETTERS 
	public void setData ( E binaryTreeDataParameter ) 
	{	
		data = binaryTreeDataParameter ; 	
	}
	
	public void setLeftLink ( BinaryTreeNode<E> leftLinkSetParameter ) 
	{	
		leftLink = leftLinkSetParameter  ; 		
	}
	
	public void setRightLink ( BinaryTreeNode<E> setRightLinkParameter ) 
	{	
		rightLink = setRightLinkParameter ; 	
	}
	
	// BEGIN BinaryTreeNode CONSTRUCTOR 
	public BinaryTreeNode ( BinaryTreeNode<E> binaryTreeLeftNode , E nodeDataToConstruct , BinaryTreeNode<E> binaryTreeRightNode ) 
	{ 
		leftLink = binaryTreeLeftNode ; 
		data = nodeDataToConstruct ; 
		rightLink = binaryTreeRightNode ; 
	} 

	public E getLeftMostData (  ) 
	{
		if ( leftLink == null ) 
		{	return data ; 	}
		else
		{	return leftLink.getLeftMostData (  ) ; 	}
	}
	
	public E getRightMostData (  ) 
	{
		if ( rightLink == null ) 
		{	return data ; 	}
		else
		{	return rightLink.getRightMostData (  ) ; }
	}

	public BinaryTreeNode<E> removeRightMostLink (  ) 
	{
		if ( rightLink  ==  null ) 
		{
			return leftLink ; 
		}
		else
		{
			rightLink = rightLink.removeRightMostLink (  ) ; 
			return this ; 
		}
	}
	
	public BinaryTreeNode<E> removeLeftMostLink (  ) 
	{
		if ( leftLink  ==  null ) 
		{
			return rightLink ; 
		}
		else
		{
			leftLink = leftLink.removeLeftMostLink (  ) ; 
			return this ; 
		}
	}

	public boolean isLeaf (  ) 
	{
		if ( getRightLink (  )  == null && getLeftLink (  )  == null ) 
		{	return true ; 	}
		else
		{	return false ; 	}
	}
	
	public void preOrderPrint (  ) 
	{
		System.out.println ( data ) ; 
		if ( leftLink != null ) 
			leftLink.preOrderPrint (  ) ; 
		if ( rightLink != null ) 
			rightLink.preOrderPrint (  ) ; 
	}
	
	public void inOrderPrint (  ) 
	{
		if ( leftLink != null ) 
			leftLink.inOrderPrint (  ) ; 

		System.out.println ( data ) ; 

		if ( rightLink != null ) 
			rightLink.inOrderPrint (  ) ; 
	}
	
	public void postOrderPrint (  ) 
	{
		if ( leftLink != null ) 
			leftLink.postOrderPrint (  ) ; 
		if ( rightLink != null ) 
			rightLink.postOrderPrint (  ) ; 
		System.out.println ( data ) ; 
	}
	
	/**
   * Copy a binary tree.
   * @param <CODE>source</CODE>
   *   a reference to the rootNode of a binary tree that will be copied (which may be
   *   an empty tree where <CODE>source</CODE> is null)
   * @return
   *   The method has made a copy of the binary tree starting at 
   *   <CODE>source</CODE>. The return value is a reference to the rootNode of the copy. 
   * @exception OutOfMemoryError
   *   Indicates that there is insufficient memory for the new tree.   
   **/ 
	
	public static <E> BinaryTreeNode<E> treeCopy ( BinaryTreeNode<E> source ) 
	{
		BinaryTreeNode<E> leftCopy, rightCopy ; 

		if ( source  ==  null ) 
			return null ; 
		else
		{
			leftCopy = treeCopy ( source.leftLink ) ; 
			rightCopy = treeCopy ( source.rightLink ) ; 
			return new BinaryTreeNode<E> ( leftCopy, source.data , rightCopy ) ; 
		}
	}
}

class BinarySearchTree
{
	private BinaryTreeNode<String> rootNode ; 
	private BinaryTreeNode<String> rightNode ; 
	private BinaryTreeNode<String> leftNode ; 
	private int manyItems ; 
	private BinaryTreeNode<String> cursor ; 
	private BinaryTreeNode<String> preCursor ; 

	public BinarySearchTree (  ) 
	{
		rootNode = null ; 
		rightNode=null ; 
		leftNode=null ; 
		cursor=null ; 
		preCursor=null ; 
		manyItems=0 ; 
	}

	public BinaryTreeNode<String> getrootNode (  ) 
	{	
		return rootNode ; 	
	}

	public BinaryTreeNode<String> getRightNode (  ) 
	{	
		return rightNode ; 	
	}
	
	public void setRightNode ( BinaryTreeNode<String> rightNodeDataParameter ) 
	{	
		rightNode = rightNodeDataParameter ; 	
	}

	public BinaryTreeNode<String> getLeftNode (  ) 
	{	
		return leftNode ; 	
	}
	
	public void setLeftNode ( BinaryTreeNode<String> element ) 
	{	
		leftNode = element ; 	
	}

	public BinaryTreeNode<String> getCursor (  ) 
	{	
		return cursor ; 	
	}
	
	public void setCursor ( BinaryTreeNode<String> element ) 
	{	
		cursor = element ; 	
	}

	public BinaryTreeNode<String> getPreCursor (  ) 
	{	
		return preCursor ; 	
	}
	
	public void setPreCursor ( BinaryTreeNode<String> element ) 
	{	
		preCursor = element ; 	
	}

	public void postPrint (  ) 
	{	
		rootNode.postOrderPrint (  ) ; 	
	}

	public void prePrint (  ) 
	{	
		rootNode.preOrderPrint (  ) ; 	
	}

	public void orderedPrint (  ) 
	{	
		rootNode.inOrderPrint (  ) ; 	
	}

	public void print ( String type ) 
	{
		if ( type.equals ( "pre" )  ) 
		{
			rootNode.preOrderPrint (  ) ; 
		}
		else if ( type.equals ( "post" )  ) 
		{
			rootNode.postOrderPrint (  ) ; 
		}
		else if ( type.equals ( "inorder" )  ) 
		{
			rootNode.inOrderPrint (  ) ; 
		}
		else
		{
			System.out.println ( "INVALID PRINT TYPE. CHOOSE 1 FOR PRE ORDER, 2 FOR POST ORDER, 3 FOR IN ORDER" ) ; 
		}
	}

	public void add ( String element ) 
	{
		if ( element == null ) 
		{
			throw new IllegalStateException ( "no data" ) ; 
		}
		cursor = rootNode ; 
		if ( rootNode == null ) 
		{
			rootNode = new BinaryTreeNode<String> ( null, element , null ) ; 
			return ; 
		}

		boolean done = false ; // flag variable

		while ( done == false ) 
		{
			if ( element.compareTo ( cursor.getData (  )  ) <= 0 ) // 0 should be a variable ask fred
			{											// need compareTo methode
				if ( cursor.getLeftLink (  ) == null ) 
				{
					cursor.setLeftLink ( new BinaryTreeNode<String> ( null , element , null )  ) ; 
					done = true ; 
				}
				else
				{
					cursor = cursor.getLeftLink (  ) ; 
				}
			}

			else
			{
				if ( cursor.getRightLink (  )  == null ) 
				{ 
					cursor.setRightLink ( new BinaryTreeNode<String> ( null , element , null )  ) ; 
					done = true ; 
				} 
				else
				{
					cursor = cursor.getRightLink (  ) ; 
				}
			}
		}
	}

	public Boolean removeData ( String element ) 
	{
		cursor = rootNode ; 

		while ( cursor != null && cursor.getData (  ) != element ) 
		{
			if ( cursor.getData (  ).compareTo ( element ) > 0 ) 
			{
				preCursor = cursor ; 
				cursor = cursor.getLeftLink (  ) ; 
			}
			else
			{
				preCursor = cursor ; 
				cursor = cursor.getRightLink (  ) ; 
			}
		}
		if ( cursor == null ) 
		{ 
			return false ;  
		}
		if ( cursor  ==  rootNode && cursor.getLeftLink (  )  == null ) 
		{
			rootNode = rootNode.getRightLink (  ) ; 
			return true ; 
		}
		else if ( cursor.getLeftLink (  )  == null ) 
		{
			if ( cursor  ==  preCursor.getLeftLink (  )  ) 
			{
				preCursor.setLeftLink ( cursor.getRightLink (  )  ) ; 
			}
			else
			{
				preCursor.setRightLink ( cursor.getRightLink (  )  ) ; 
			}
			return true ; 
	   }
		if ( cursor.getLeftLink (  )  != null ) 
		{ 
			cursor.setData ( cursor.getLeftLink (  ).getRightMostData (  )  ) ; 
			cursor.setLeftLink ( cursor.getLeftLink (  ).removeRightMostLink (  )  ) ; 
		} 
		return true ; 
	}

	public void addAll ( BinarySearchTree addEnd ) 
	{
		BinaryTreeNode<String> addrootNode ; 
		if ( rootNode == addEnd.rootNode ) 
		{
			addrootNode=BinaryTreeNode.treeCopy ( addEnd.rootNode ) ; 
			addTree ( addrootNode ) ; 
		}
		else
		{
			addTree ( addEnd.rootNode ) ; 
		}
	}

	private void addTree ( BinaryTreeNode<String> addrootNode ) 
	{
		if ( addrootNode != null ) 
		{
			add ( addrootNode.getData (  )  ) ; 
			addTree ( addrootNode.getLeftLink (  )  ) ; 
			addTree ( addrootNode.getRightLink (  )  ) ; 
		}
	}
	public static BinarySearchTree union ( BinarySearchTree tree1, BinarySearchTree tree2 ) 
	{
		BinarySearchTree answer = new BinarySearchTree (  ) ; 
		if ( tree1 == null||tree2 == null ) 
			throw new NullPointerException ( "one of the LinkedList's is null" ) ; 
		else
		{
			answer.addAll ( tree1 ) ; 
			answer.addAll ( tree2 ) ; 
			answer.manyItems = tree1.manyItems + tree2.manyItems ; 
		}
		return answer ; 
	}


}



class Homework5
{
	public static void main ( String[] args ) 
	{

		Scanner in= new Scanner ( System.in ) ; 

		BinarySearchTree s1 = new BinarySearchTree (  ) ; 
		BinarySearchTree s2 = new BinarySearchTree (  ) ; 
		BinarySearchTree s3 = new BinarySearchTree (  ) ; 
		s1.add ( "a" ) ; 
		s1.add ( "g" ) ; 
		s1.add ( "f" ) ; 
		s1.add ( "d" ) ; 
		s1.add ( "e" ) ; 
		s1.add ( "b" ) ; 
		System.out.println ( " start " ) ; 
		s1.print ( "post" ) ; /////print
		System.out.println ( " removes f" ) ; 
		s1.removeData ( "f" ) ; 
		System.out.println ( " " ) ; 
		s1.print ( "post" ) ; /////print
		System.out.println ( " removes g" ) ; 
		s1.removeData ( "g" ) ; 
		System.out.println ( " " ) ; 
		s1.print ( "post" ) ; /////print
		System.out.println ( " " ) ; 
		s2.add ( "r" ) ; 
		s2.add ( "x" ) ; 
		s2.add ( "z" ) ; 
		s2.add ( "m" ) ; 
		s2.add ( "n" ) ; 
		s2.add ( "p" ) ; 

		s3 = BinarySearchTree.union ( s1,s2 ) ; 
		s3.print ( "post" ) ; 
		System.out.println ( " this is Union " ) ; 

		//s1.removeData ( "z" ) ; 
		//s1.postPrint (  ) ; 




		System.out.println ( "enter the type of print methode you would like to use or Q to quit" ) ; 
		System.out.println ( "Print types are [pre, post, inorder]" ) ; 
		String printType = in.nextLine (  ) ; 

		while ( !printType.equals ( "Q" )  ) 
		{
			//if  ( printType.equals ( "pre" ) ||printType.equals ( "inorder" ) ||printType.equals ( "post" )  ) 

				s1.print ( printType ) ; 


				System.out.println ( " would you like to print again or Q to quit" ) ; 
				printType = in.nextLine (  ) ; 



		}

	}
}


