//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver_class
{
    public static void main(String args[])
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int grid[][] = new int[9][9];
            for(int i = 0; i < 9; i++)
            {
                for(int j = 0; j < 9; j++)
                grid[i][j] = sc.nextInt();
            }
            
            Solution ob = new Solution();
            
            if(ob.SolveSudoku(grid) == true)
                ob.printGrid(grid);
            else
                System.out.print("NO solution exists");
            System.out.println();
            
        }
    }
}




// } Driver Code Ends


//User function Template for Java

class Solution
{
    static boolean isValid(int[][] grid,int r,int c,int k)
    {
        for (int i=0;i<9;i++)
        {
            //row check
            if (grid[r][i]==k)
                return false;
                
            //col check
            if (grid[i][c]==k)
                return false;
                
            //sub grid check
            if (grid[3*(r/3)+i/3][3*(c/3)+i%3]==k)
                return false;
        }
        
        return true;
    }
    
    static boolean helper(int grid[][])
    {
        for (int i=0;i<9;i++)
        {
            for (int j=0;j<9;j++)
            {
                if (grid[i][j]==0)
                {
                    for (int k=1;k<=9;k++)
                    {
                        if (isValid(grid,i,j,k))
                        {
                            grid[i][j]=k;
                            if (helper(grid))
                                return true;
                            else
                                grid[i][j]=0;
                        }
                    }
                    return false;
                }
            }
        }
        
        return true;
    }
    
    //Function to find a solved Sudoku. 
    static boolean SolveSudoku(int grid[][])
    {
        boolean[][] row=new boolean[9][9];
        boolean[][] col=new boolean[9][9];
        boolean[][] subGrid=new boolean[9][9];
        
        for (int i=0;i<9;i++)
        {
            for (int j=0;j<9;j++)
            {
                if (grid[i][j]==0)
                    continue;
                    
                int val=grid[i][j]-1;
                
                //row check
                if (row[i][val])
                    return false;
                row[i][val]=true;
                
                //col check
                if (col[j][val])
                    return false;
                col[j][val]=true;
                
                //subGrid check
                int gridNum=(i/3)*3+j/3;
                if (subGrid[gridNum][val])
                    return false;
                subGrid[gridNum][val]=true;
            }
        }
        
        helper(grid);
        
        return true;
    }
    
    //Function to print grids of the Sudoku.
    static void printGrid (int grid[][])
    {
        for (int i=0;i<9;i++)
            for (int j=0;j<9;j++)
                System.out.print(grid[i][j]+" ");
    }
}