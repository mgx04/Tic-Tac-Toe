package ticTacToe;

import java.util.Arrays;
import java.util.Scanner;

public class MainClass {

	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {


		char[][] grid = new char[3][3];

		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				grid[i][j] = '_';
			}
		}

		displayGrid(grid);
		playStart(grid);	

	}//end main method


	//display method
	public static void displayGrid(char[][] grid)
	{
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}
	//end display method

	//START play method
	public static void playStart(char[][] grid)
	{
	    boolean playerTurn = false;

	    while(true)
	    {
	        if(!playerTurn)
	        {
	            System.out.print("It is Player 1's turn. Player 1 is X\n");

	            int column, row;
	            char x = 'x';
	            char o = 'O';

	            System.out.print("Player 1 enter a row (0-2)\n");
	            row = input.nextInt();
	            System.out.print("Player 1 enter a column (0-2)\n");
	            column = input.nextInt();

	            if(grid[row][column] != '_')
	            {
	                System.out.print("That spot is already taken! Try again\n");
	                displayGrid(grid);
	            }
	            else if(grid[row][column] == '_')
	            {
	                grid[row][column] = x;
	                displayGrid(grid);
	                if(checkWinner(grid, x, o))
	                {
	                    break;  
	                }
	                playerTurn = true;
	            }
	        }

	        else
	        {
	            System.out.print("It is Player 2's turn. Player 2 is O\n");

	            int column, row;
	            char o = 'O';
	            char x = 'X';

	            System.out.print("Player 2 enter a row (0-2)\n");
	            row = input.nextInt();
	            System.out.print("Player 2 enter a column (0-2)\n");
	            column = input.nextInt();

	            if(grid[row][column] != '_')
	            {
	                System.out.print("That spot is already taken! Try again\n");
	                displayGrid(grid);
	            }
	            else if(grid[row][column] == '_')
	            {
	                grid[row][column] = o;
	                displayGrid(grid);
	                if(checkWinner(grid, x, o))
	                {
	                    break;  
	                }
	                playerTurn = false;
	            }    

	        }

	    }

	}//END playStart method


	public static boolean checkWinner(char[][] grid, char x, char o)
	{
		boolean winnerFound = false;
		//START checks to see if winner row
		for(int i = 0; i < 3; i++)
		{
			if(grid[i][0] == x && grid[i][1] == x && grid[i][2] == x)
			{
				System.out.print("Player 1 has won!");
				winnerFound = true;
			}
			else if(grid[i][0] == o && grid[i][1] == o && grid[i][2] == o)
			{
				System.out.print("Player 2 has won!");
				winnerFound = true;
			}
			//END of for
		}


			//START checks to see if winner column
			for(int j = 0; j < 3; j++)
			{
				if(grid[0][j] == x && grid[1][j] == x && grid[2][j] == x)
				{
					System.out.print("Player 1 has won!");
					winnerFound = true;
				}
				else if(grid[0][j] == o && grid[1][j] == o && grid[2][j] == o)
				{
					System.out.print("Player 2 has won!");
					winnerFound = true;
				}
			}//END of for


			//START checks diagonal_1
			if(grid[0][0] == x && grid[1][1] == x && grid[2][2] == x)
			{
				System.out.print("Player 1 has won!");
				winnerFound = true;
			}
			else if(grid[0][0] == o && grid[1][1] == o && grid[2][2] == o)
			{
				System.out.print("Player 2 has won!");
				winnerFound = true;
			}
			//END of checks diagonal_1


			//START checks diagonal_2
			if(grid[0][2] == x && grid[1][1] == x && grid[2][0] == x)
			{
				System.out.print("Player 1 has won!");
				winnerFound = true;
			}
			else if(grid[0][2] == o && grid[1][1] == o && grid[2][0] == o)
			{
				System.out.print("Player 2 has won!");
			}
			
			if(!winnerFound)
			{
				boolean isFull = true;
				for(int i = 0; i < 3; i++)
				{
					for(int j = 0; j < 3; j++)
					{
						if(grid[i][j] == '_')
						{
							isFull = false;
							break;
						}
					}
				}
				
				if(isFull)
				{
					System.out.println("No winners! It's a draw!");
				}
			}
			return winnerFound;

		}//END of isWinner method

	}//END main class


