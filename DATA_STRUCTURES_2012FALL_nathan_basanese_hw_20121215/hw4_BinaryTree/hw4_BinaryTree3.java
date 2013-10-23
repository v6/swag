//      hw4_BinaryTree3.java
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
import java.math.BigDecimal ; 

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
class BinaryTreeNode <E> /* implements Comparable<E> ATTEMPTATCOMPARETO */
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

	public E getLeftMostData (  ) 
	{
		if ( leftLink == null ) 
		{	
			return data ; 	
		}
		else
		{	
			return leftLink.getLeftMostData (  ) ; 	
		}
	}
	
	public E getRightMostData (  ) 
	{
		if ( rightLink == null ) 
		{	
			return data ; 	
		}
		else
		{	
			return rightLink.getRightMostData (  ) ; 
		}
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
	public BinaryTreeNode ( BinaryTreeNode<E> leftNodeLinkToConstruct, E nodeDataToConstruct, BinaryTreeNode<E> rightNodeLinkToConstruct ) 
	{ 
		leftLink = leftNodeLinkToConstruct ; 
		data = nodeDataToConstruct ; 
		rightLink = rightNodeLinkToConstruct ; 
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
		{	
			return true ; 	
		} 
		else
		{	
			return false ; 	
		}
	}
	
	/**
   * Uses a preorder traversal to print the data from each node at or below
   * this node of the binary tree.
   * @param - none
   * <dt><b>Postcondition:</b><dd>
   *   The data of this node and all its descendants have been writeen by
   *   <CODE>System.out.println( )</CODE> using a preorder traversal.
   **/
	public void preOrderPrint (  ) 
	{
		System.out.println ( data , " " ) ; 
		
		if ( leftLink != null ) 
		{
			leftLink.preOrderPrint (  ) ; 
		}
		if ( rightLink != null ) 
		{
			rightLink.preOrderPrint (  ) ; 
		}
	}
	
	/**
   * Uses an inorder traversal to print the data from each node at or below
   * this node of the binary tree, with indentations to indicate the depth
   * of each node.
   * @param <CODE>depth</CODE>
   *   the depth of this node (with 0 for root, 1 for the root's
   *   children, and so on)(
   * <dt><b>Precondition:</b><dd>
   *   <CODE>depth</CODE> is the depth of this node.
   * <dt><b>Postcondition:</b><dd>
   *   The data of this node and all its descendants have been writeen by
   *   <CODE>System.out.println( )</CODE> using an inorder traversal.
   *   The indentation of each line of data is four times its depth in the
   *   tree. A dash "--" is printed at any place where a child has no
   *   sibling.
   **/
	public void inOrderPrint (  ) 
	{
		if ( leftLink != null ) 
		{
			leftLink.inOrderPrint (  ) ; 
		}

		System.out.println ( data , " " ) ; 

		if ( rightLink != null ) 
		{
			rightLink.inOrderPrint (  ) ; 
		}
	}
	
	/**
   * Uses a postorder traversal to print the data from each node at or below
   * this node of the binary tree.
   * @param - none
   * <dt><b>Postcondition:</b><dd>
   *   The data of this node and all its descendants have been writeen by
   *   <CODE>System.out.println( )</CODE> using a postorder traversal.
   **/
	public void postOrderPrint (  ) 
	{
		if ( leftLink != null ) 
		{
			leftLink.postOrderPrint (  ) ; 
		}
		
		if ( rightLink != null ) 
		{
			rightLink.postOrderPrint (  ) ; 
		}
		
		System.out.println ( data , " " ) ; 
	}
	
	/**
   * Copy a binary tree.
   * @param <CODE>source</CODE>
   *   a reference to the root of a binary tree that will be copied (which may be
   *   an empty tree where <CODE>source</CODE> is null)
   * @return
   *   The method has made a copy of the binary tree starting at 
   *   <CODE>source</CODE>. The return value is a reference to the root of the copy. 
   * @exception OutOfMemoryError
   *   Indicates that there is insufficient memory for the new tree.   
   **/ 
	public static <E> BinaryTreeNode<E> treeCopy ( BinaryTreeNode<E> source ) 
	{
		BinaryTreeNode<E> leftCopy, rightCopy ; 

		if ( source  ==  null ) 
		{
			return null ; 
		}
		else
		{
			leftCopy = treeCopy ( source.leftLink ) ; 
			rightCopy = treeCopy ( source.rightLink ) ; 
			return new BinaryTreeNode<E> ( leftCopy, source.data , rightCopy ) ; 
		}
	}
}

class BinSearchTree <F extends Comparable</*? super */F>> 
{
	// DATA MEMBERS 
	private BinaryTreeNode<F> currentIndex , precursor , rootNode , BSTLeftNodeLink , BSTRightNodeLink ; 
	private int itemCount ; 

	// BINSEARCHTREE DEFAULT CONSTRUCTOR 
	public BinSearchTree (  ) 
	{
		rootNode = BSTRightNodeLink = BSTLeftNodeLink = currentIndex = precursor = null ; 
		itemCount = 0 ; 
	}

	// BINSEARCHTREE GETTERS 
	public BinaryTreeNode<F> getRootLink (  ) 
	{	
		return rootNode ; 	
	}
	
	public BinaryTreeNode<F> getRightNodeLink (  ) 
	{	
		return BSTRightNodeLink ; 	
	}

	public BinaryTreeNode<F> getLeftNodeLink (  ) 
	{	
		return BSTLeftNodeLink ; 	
	}
	
	public BinaryTreeNode<F> getCurrent (  ) 
	{	
		return currentIndex ; 	
	}

	public BinaryTreeNode<F> getPrecursorLink (  ) 
	{	
		return precursor ; 	
	}
	
	// BINSEARCHTREE 
	public void setRightNodeLink ( BinaryTreeNode<F> rightNodeLinkParameter ) 
	{	
		BSTRightNodeLink = rightNodeLinkParameter ; 
	}
	
	public void setLeftNodeLink ( BinaryTreeNode<F> leftNodeLinkParameter ) 
	{	
		BSTLeftNodeLink = leftNodeLinkParameter ; 	
	}
	
	public void setCursor ( BinaryTreeNode<F> cursorNodeLinkParameter ) 
	{	
		currentIndex = cursorNodeLinkParameter ; 	
	}
	
	public void setPrecursor ( BinaryTreeNode<F> precursorNodeLinkParameter ) 
	{	
		precursor = precursorNodeLinkParameter ; 
	}
	//////////////////////////////ADD METHODS FOR TREE AND NODE PARAMETERS ////////////////
	

	public void appendTree ( BinSearchTree<F> addendTree ) 
	{
		BinaryTreeNode<F> rootNodeOfAddend ; 
		if ( rootNode == addendTree.rootNode ) 
		{
			rootNodeOfAddend = BinaryTreeNode.treeCopy ( addendTree.rootNode ) ; 
			appendTree ( rootNodeOfAddend ) ; 
		}
		else
		{
			appendTree ( addendTree.rootNode ) ; 
		}
	}

	private void appendTree ( BinaryTreeNode<F> rootNodeOfAddend ) 
	{
		if ( rootNodeOfAddend != null ) 
		{
			insert ( rootNode , rootNodeOfAddend.getData (  )  ) ; 
			appendTree ( rootNodeOfAddend.getLeftLink (  )  ) ; 
			appendTree ( rootNodeOfAddend.getRightLink (  )  ) ; 
		}
	}
	
	public static BinSearchTree concatenation ( BinSearchTree treeParameterStart, BinSearchTree treeParameterEnd ) 
	{
		BinSearchTree answer ; 
		answer = new BinSearchTree (  ) ; 
		if ( treeParameterStart == null||treeParameterEnd == null ) 
		{ 
			throw new IllegalStateException ( "NULL, DAMMIT. DO BETTER." ) ; 
		} 
		
		else 
		{ 
			answer.appendTree ( treeParameterStart ) ; 
			answer.appendTree ( treeParameterEnd ) ; 
			answer.itemCount = treeParameterStart.itemCount + treeParameterEnd.itemCount ; 
		} 
		return answer ; 
	} 	
	
	// INSERT 
	
	public static int COMPARISON_THRESHOLD = 0 ; 
	
	public void insert(BinaryTreeNode<F> node, F value ) 
	{
		if ( value == null ) 
		{
			throw new IllegalArgumentException ( "NODE IS NULL" ) ; 
		}
        if ( compareTo ( currentIndex.getData (  )  ) < COMPARISON_THRESHOLD ) 
        {
            if ( node.getLeftLink (  ) != null ) 
            {
                insert ( node.getLeftLink (  ) , value ) ;
            } 
            else 
            { 
                System.out.println ( "  Inserted " + value + " to left of Node " + node.getData (  ) ) ;
                node.setLeftLink ( new BinaryTreeNode<F> ( null , value , null ) ) ; //                 node.left = new Node ( value ) ; in implementation 2 (unencapsulated) 
            }
        } 
        else if ( value.compareTo ( currentIndex.getData (  )  ) > 0 ) // value supplied > node's value in more concise terms. 
        {
            if ( node.getRightLink (  ) != null ) // THAT IS, "IF THERE IS A NODE TO THE RIGHT." 
            {
                insert ( node.getRightLink (  ) , value ) ; 
            } 
            else 
            {
                System.out.println ( "  Inserted " + value + " to right of Node " + node.getData (  ) ) ; // DONE THIS LINE FINALLY. 
                node.setRightLink ( new BinaryTreeNode<F> ( null , value , null ) ) ; // DON'T FORGET THE NULLS!
            }
        }
    }
	/* ATTEMPTATCOMPARETO. CUZAK IS NO HELP. NO HELP AT ALL. 
	
	// AH, BUT WHAT DO I MAKE THE RETURN TYPE? DAMMIT!!!
	*/
	public <E extends Comparable</*? super */E>> E /*<? extends E>*/ compareTo ( Object other ) 
	{
          Object answer ; // THIS IS WHAT WE'LL RETURN. 
          try 
          {
             answer = super.compareTo( ) ; 
          }
          catch (ComparableNotSupportedException e)
          { 
             throw new RuntimeException
             ("NO COMPARISON SUPPORTED. ABORT. ABORT.");
          }
          return answer;
       }
	/**/
	// REMOVE DATA
	public boolean removeData ( F element ) 
	{
		currentIndex = rootNode ; 

		while ( currentIndex != null && currentIndex.getData (  ) != element ) 
		{
			F cursorComparisonValue = (F) currentIndex.getData (  ) ; 
			if ( cursorComparisonValue.compareTo ( element ) > 0 ) 
			{
				precursor = currentIndex ; 
				currentIndex = currentIndex.getLeftLink (  ) ; 
			}
			else
			{
				precursor = currentIndex ; 
				currentIndex = currentIndex.getRightLink (  ) ; 
			}
		}
		if ( currentIndex == null ) 
		{ 
			return false ;  // NULL COUNTS AS FAILURE. REMEMBER THAT! 
			//System.out.println ( "Cannot remove data, nothing there." ) ; 
		}
		if ( currentIndex  ==  rootNode && currentIndex.getLeftLink (  )  == null ) 
		{
			rootNode = rootNode.getRightLink (  ) ; 
			return true ; 
		}
		else if ( currentIndex.getLeftLink (  )  == null ) 
		{
			if ( currentIndex  ==  precursor.getLeftLink (  )  ) 
			{
				precursor.setLeftLink ( currentIndex.getRightLink (  )  ) ; 
			}
			else
			{
				precursor.setRightLink ( currentIndex.getRightLink (  )  ) ; 
			}
			return true ; 
	   }
		if ( currentIndex.getLeftLink (  )  != null ) 
		{ 
			currentIndex.setData ( currentIndex.getLeftLink (  ).getRightMostData (  )  ) ; 
			currentIndex.setLeftLink ( currentIndex.getLeftLink (  ).removeRightMostLink (  )  ) ; 
		} 
		return true ; 
	}
	
	////////////////////////////// PRINT METHODS ////////////////////////
	public void postOrderPrint (  ) 
	{ 
		rootNode.postOrderPrint (  ) ; 
	} 

	public void preOrderPrint (  ) 
	{	
		rootNode.preOrderPrint (  ) ; 	
	}

	public void inOrderPrint (  ) 
	{	
		rootNode.inOrderPrint (  ) ; 	
	}
}

class hw4_BinaryTree3
{
	/* http://docs.oracle.com/javase/1.5.0/docs/api/java/math/BigDecimal.html */
	public static void main ( String [  ] args ) 
	{
		System.out.println ( "TEST" ) ; // debigging code
		Scanner in = new Scanner ( System.in ) ; 

		BinSearchTree <Integer> fraxinusPennsylvanica = new BinSearchTree (  ) ; // MUCH LOVE FOR THE TREES. 
		BinSearchTree <Integer> ailanthusAltissima = new BinSearchTree (  ) ; 
		BinSearchTree <Integer> malusSylvestris = new BinSearchTree (  ) ; 
		Integer testInt = new Integer ( 3 ) ; 
		fraxinusPennsylvanica.insert ( fraxinusPennsylvanica.getRootLink (  ) , testInt ) ; 
		fraxinusPennsylvanica.insert ( 1 ) ; 
		fraxinusPennsylvanica.insert ( 2 ) ; 
		fraxinusPennsylvanica.insert ( 4 ) ; 
		fraxinusPennsylvanica.insert ( 5 ) ; 
		fraxinusPennsylvanica.insert ( 2 ) ; 
		fraxinusPennsylvanica.postOrderPrint (  ) ; 
		System.out.println ( 5 ) ; 
		fraxinusPennsylvanica.removeData ( 5 ) ; 
		fraxinusPennsylvanica.postOrderPrint (  ) ; 
		fraxinusPennsylvanica.removeData ( 4 ) ; 
		fraxinusPennsylvanica.postOrderPrint (  ) ; 
		ailanthusAltissima.insert ( 1 ) ; 
		ailanthusAltissima.insert ( 24 ) ; 
		ailanthusAltissima.insert ( 26 ) ; 
		ailanthusAltissima.insert ( 13 ) ; 
		ailanthusAltissima.insert ( 14 ) ; 
		ailanthusAltissima.insert ( 16 ) ; 
		
		System.out.println ( "CONCATENATION AWAITS, FOOL!" ) ; 
		malusSylvestris = BinSearchTree.concatenation ( fraxinusPennsylvanica,ailanthusAltissima ) ; 
		malusSylvestris.postOrderPrint (  ) ; 
		
		System.out.println ( "PRE ORDER PRINTETHING AWAITETHING!" ) ; 
		fraxinusPennsylvanica.preOrderPrint (  ) ; 
		System.out.println ( "IN ORDER PRINTETHING AWAITETHING!" ) ; 
		fraxinusPennsylvanica.inOrderPrint (  ) ; 
		System.out.println ( "POST ORDER PRINTETHING AWAITETHING!" ) ; 
		fraxinusPennsylvanica.postOrderPrint (  ) ; 
	}
}
/* 
TEST
1 2 4 5 2 5 2 4 2 1 
5
1 2 2 
*/ 
