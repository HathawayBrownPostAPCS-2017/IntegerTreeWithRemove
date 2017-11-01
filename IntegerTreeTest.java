// A class used to test the Integer tree

import java.util.Scanner;


public class IntegerTreeTest {

	public static void main (String[] args)
	{
		Scanner keyboard = new Scanner (System.in);
		
		IntegerTree myTree = new IntegerTree();
		myTree.setMessages(true);
		
		System.out.print("Enter the tree yourself [0] or at random [1]:");
		int choice = keyboard.nextInt();
		
		if (choice == 0)    // enter numbers into the tree
		{
			System.out.print("Enter an integer to add to the tree (0 to quit): ");
			int n = keyboard.nextInt();
			
			while (n != 0)
			{
				myTree.add(new Integer(n));
				System.out.println(myTree);
				
				System.out.print("Enter an integer to add to the tree (0 to quit): ");
				n = keyboard.nextInt();
			}
		}
		else     // make the tree at random
		{
			System.out.print("How many integers to attempt to add?  ");
			int count = keyboard.nextInt();
			System.out.print("Maximum possible integer:  ");
			int max = keyboard.nextInt();
			
			for (int i = 1; i <= count; i++)
			{
				myTree.add(new Integer((int)(Math.random() * max) + 1));
			}
		}
		
		System.out.println("\n\nYour current tree is: \n" + myTree);
		
	    // NOW, let's remove some items from the tree!
		
		System.out.print ("Number to remove from the tree [0 to quit]: ");
		int n = keyboard.nextInt();
		while (n != 0)
		{
			myTree.remove(n);

			System.out.print ("Number to remove from the tree [0 to quit]: ");
			n = keyboard.nextInt();
		}
		
		System.out.println("\n\nYour final tree is: \n" + myTree);

		keyboard.close();
	}
	
}
