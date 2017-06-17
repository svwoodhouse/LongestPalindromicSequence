package longestpalindromicsubsequence;

public class LongestPalindromicSubsequence 
{
   public static int findLongestPalindrome(String str)
	{
		char[] charArray = str.toCharArray();
		int[][] LPGrid = new int[str.length()][str.length()];
		int maxLength = 1;
		int start = 0;
		int lengthCheck = 1;
		
		//Sets the grid up for single chars
		for(int i= 0; i < str.length(); i++)
		{
			LPGrid[i][i] = 1;
		}
		
		for(int j = 1; j <= str.length(); j++)
		{
			for(int k = str.length()-j; k > 0; k--)
			{
				if(charArray[start] == charArray[start+lengthCheck])
				{
					LPGrid[start][start+lengthCheck] = 2 + (maxLength(LPGrid[start][(start+lengthCheck)-1],LPGrid[start+1][start+lengthCheck]));
					
					if(LPGrid[start][start+lengthCheck] > maxLength)
						maxLength = LPGrid[start][start+lengthCheck];
				}
				else
				{
					LPGrid[start][start+lengthCheck] = (maxLength(LPGrid[start][(start+lengthCheck)-1],LPGrid[start+1][start+lengthCheck]));
				}
				
				start+=1;
			}
			start = 0;
			lengthCheck +=1;
		}
		
		// Prints the grid for verification purposes
		for(int l = 0; l < str.length(); l++)
		{
			for(int m = 0; m < str.length(); m++)
			{
				System.out.print(LPGrid[l][m]);
			}
			System.out.println();
		}
		
		return maxLength;
	}

	public static int maxLength(int var1, int var2)
	{
		if(var1 > var2)
			return var1;
		else
			return var2;
	}
	
	public static void main(String[] args) 
	{
		String str = "bacdab";
		int maxL = findLongestPalindrome(str);
		System.out.println(maxL);

	}
    
}
