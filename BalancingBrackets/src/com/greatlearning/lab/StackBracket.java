package com.greatlearning.lab;

import java.util.Scanner;
import java.util.Stack;

public class StackBracket {
	//to check if string is balanced
	private static boolean checkBracket(String input) {
		//create a stack
		Stack<Character> stack = new Stack<>();
		
		//for each loop
		for(char k: input.toCharArray())
		{	
			//pushing into stack
			if(k == '{' || k == '[' || k == '(')
			{
				stack.push(k);
				continue;
			}
			if(stack.isEmpty())
				return false; //no closing brackets available
		
			//popping elements from stack
			char z;
			switch(k)
			{
			case '}' :
					z = stack.pop();
					if(z == '[' || z == '(')
						return false;
					break;
					
			case ']' :
				z = stack.pop();
				if(z == '{' || z == '(')
					return false;
				break;
				
			case ')' :
				z = stack.pop();
				if(z == '[' || z == '{')
					return false;
				break;		
			} // end of switch statement
		}  //end of for each loop
		return(stack.isEmpty());
	}// end of check bracket method
	
	//main method
	public static void main(String[] args) {
		String input = "";
		Scanner sc = new Scanner(System.in);
		//input from user
		System.out.println("Enter your equation");
		input = sc.next();
		
		//to check if string is complete 
		if(input.length() % 2 !=0)
		{
			System.out.println("INCOMPLETE equation");
		}
		else
		{
			if(checkBracket(input))
			{
				System.out.println("Balanced equation");
			}
			else
			{
				System.out.println("UNBALANCED equation");
			}
		}
	}//main method
}
