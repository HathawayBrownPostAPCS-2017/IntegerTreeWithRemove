/** A node for a binary search tree.
 * This one contains Integers
 * 
 * @author Post-AP CS 2017
 *
 */

public class IntegerTreeNode
{
  private Integer value;
  private IntegerTreeNode left;
  private IntegerTreeNode right;

  // Constructors:

  public IntegerTreeNode(Integer initValue)
  {
    value = initValue;
    left = null;
    right = null;
  }

  public IntegerTreeNode(Integer initValue, IntegerTreeNode initLeft, IntegerTreeNode initRight)
  {
    value = initValue;
    left = initLeft;
    right = initRight;
  }

  // Methods:

  public Integer getValue() { return value; }
  public IntegerTreeNode getLeft() { return left; }
  public IntegerTreeNode getRight() { return right; }
  public void setValue(Integer theNewValue) { value = theNewValue; }
  public void setLeft(IntegerTreeNode theNewLeft) { left = theNewLeft; }
  public void setRight(IntegerTreeNode theNewRight) { right = theNewRight; }
}