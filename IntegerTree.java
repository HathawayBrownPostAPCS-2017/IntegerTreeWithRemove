
//Implements a BST with IntegerTreeNode nodes

public class IntegerTree

{
private IntegerTreeNode root;  // holds the root of this BST
private boolean messagesOn;    // whether to write messages while traversing

/* -----------------------  Constructor  ------------------------------  */
// Constructor: creates an empty BST.
public IntegerTree()
{
 root = null;
 messagesOn = false;
}


/* ----------------------  Helper Methods  ----------------------------  */

/** Turn on or or the message printing  */
public void setMessages (boolean msg)
{  messagesOn = msg;  }



/** returns the tree as a String.
 * Order is dependent on the ordering scheme of toString (IntegerTreeNode)
 * 
 * @return the Binary Search Tree as a String, including [brackets] and ,commas,
 */
public String toString()
{
	String str = toString(root);
	if (str.endsWith(", "))
	{
		str = str.substring(0, str.length() - 2);
	}
	return "[" + str + "]"; 
}

// Returns a subtree as a String in (infix) order
// You can change the order by changing the recursive calls
private String toString (IntegerTreeNode node)
{
	if (node == null)  { return ""; } 
	else 
	{
		return toString(node.getLeft()) +
				node.getValue() + ", " +
				toString(node.getRight());
	}
}


/* --------------------------------------------------------------------  */
/*  Non-recursive, top-level methods that call their respective          */
/*    recursive versions (found below)                                   */
/* --------------------------------------------------------------------  */

/** Searches for the Integer value in the binary search tree.
 *  
 * @param value Integer to search for
 * @return whether value is found in the tree.
 */
public boolean contains(Integer value)
{
 return contains(root, value);
}

/** Adds the Integer value to the binary search tree, if it is not already there.
 * 
 * @param value Integer to add to the tree
 * @return false if the Integer value is already in the tree; true if it was added.
 */
public boolean add (Integer value)
{
	if (contains(value))
	{  
		if (messagesOn)  System.out.println(value.intValue() + " is already in the tree.");
		return false;
	}
	if (messagesOn)  System.out.println("Adding " + value.intValue() + " to the tree.");
	root = add(root, value);
	return true;
}


/** Removes value from this BST.  Returns true if value has been
 *  found and removed; otherwise returns false. 
 *  
 *   @param the Integer to remove 
 *   @return whether the Integer value was removed from the tree
 */
public boolean remove(Integer value)
{
  if (!contains(value))
    return false;
  root = remove(root, value);
  return true;
}


/* --------------------------------------------------------------------  */
/*  Recursive, private methods that navigate the Binary Search Tree      */
/* --------------------------------------------------------------------  */
// Recursive method to search for the Integer value
private boolean contains (IntegerTreeNode node, Integer value)
{
	if (node == null) 	{  return false; }
	else
	{
		int diff = value.compareTo(node.getValue());
		if (diff == 0)  { return true; }
		else if (diff < 0)
		{
			return contains (node.getLeft(), value);
		}
		else   // diff > 0
		{
			return contains (node.getRight(), value);
		}
	}
}

// Adds value to this BST, 
// Returns the root of the new tree
//
// Precondition: the tree rooted at node does not contain the Integer value
private IntegerTreeNode add(IntegerTreeNode node, Integer value)
{
	if (node == null)
	{
		if (messagesOn)  { System.out.println("Found null; inserting."); }
		node = new IntegerTreeNode(value);
	}
	else
	{
		int diff = value.compareTo(node.getValue());
		if (diff > 0)
		{
			if (messagesOn)  { System.out.println("Bigger than " + node.getValue() + ", inserting on the right."); }
			node.setRight(add (node.getRight(), value));
		}
		else  // diff < 0
		{
			if (messagesOn)  { System.out.println("Smaller than " + node.getValue() + ", inserting on the left."); }
			node.setLeft(add (node.getLeft(), value));
		}
	}
	return node;
}


//Adds value to this BST, 
//Returns the root of the new tree
//
//Precondition: the tree rooted at node does contain the Integer value
private IntegerTreeNode remove(IntegerTreeNode node, Integer value)
{
   // dummy code until we write it
	// return node;

	int diff = value.compareTo(node.getValue());	
	if (diff < 0)
	{
		node.setLeft(remove (node.getLeft(), value));
		return node;
	}
	else if (diff > 0)
	{
		node.setRight(remove(node.getRight(), value));
		return node;
	}
	else   // found the one to remove!
	{
		if (node.getLeft() == null && node.getRight() == null)   // Leaf; take it out
		{
			return null;
		}
		else if (node.getLeft() == null)               // Nothing on left; just connect to the right
		{
			return node.getRight();
		}
		else if (node.getRight() == null)              // Nothing on right; just connect to the left
		{
		    return node.getLeft();
		}
		else                                   // Data on both sides; carefully disconnect
		{
			// Find smallest element in right subtree
			IntegerTreeNode prev = node;
			IntegerTreeNode toMove = node.getRight();
			while (toMove.getLeft() != null)
			{
				prev = toMove;
				toMove = toMove.getLeft();
			}
			
			// Move it to the root
			prev.setLeft(toMove.getRight());
			toMove.setLeft(node.getLeft());
			toMove.setRight(node.getRight());
			node = toMove;
		}
		return node;
	}
    	
}




} // End of IntegerTree