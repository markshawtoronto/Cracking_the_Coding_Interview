package com.CrackingTheCodingInterview;
import java.util.*;

class Arrays_and_Strings
{
	public static void main(String[] args)
	{
		String input1 = "waterbottle";
		String input2 = "erbottlewat";
		Arrays_and_Strings as = new Arrays_and_Strings();

		boolean test = as.is_rotation(input1, input2);
		System.out.println(test);
	}

	// 1.1 Implement an algorithm to determine if a string has all unique characters.
	public boolean unique_characters(String str) // Book solution, using boolean array
	{
		if (str.length() > 128)
		{
			return false;
		}

		// Use a boolean array of size 256 (ASCI II length of characters)
		boolean[] char_set = new boolean[256];
		for (int i = 0; i < str.length(); i++)
		{
			int val = str.charAt(i);
			if (char_set[val])
			{
				// Already found this char in string
				return false;
			}
		}
		return true;
	}

	// 1.1 (cont)
	public static boolean unique_characters_hashmap(String input) // My solution, using a HashMap
	{
		// Try a HashMap
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		for (int i = 0; i < input.length(); i++)
		{
			Character letter = input.charAt(i);
			if (map.containsKey(letter))
			{
				return false;
			}
			else
			{
				map.put(letter, 1); // Add to the hashmap
			}
		}

		return true;
	}

	public boolean permutation(String input1, String input2)
	{
		// Use hashMap
		HashMap<Character, Integer> chars = new HashMap<Character, Integer>();

		if (input1.length() != input2.length())
		{
			return false;
		}

		for (int i = 0; i < input1.length(); i++)
		{
			Character letter = input1.charAt(i);
			if (chars.containsKey(letter))
			{
				int count = chars.get(letter);
				chars.put(letter, count + 1);
			}
			else
			{
				chars.put(letter, 1);
			}
		}

		for (int j = 0; j < input2.length(); j++)
		{
			Character letter = input2.charAt(j);

			if (chars.containsKey(letter))
			{
				int count = chars.get(letter);
				count = count - 1;
				if (count < 0)
				{
					return false;
				}

				chars.put(letter, count);
			}
			else
			{
				return false;
			}
		}

		return true;
	}

	// 1.3 Given two strings, write a method to decide if one is a permutation of the other
	public boolean permutation_calculator(String input1, String input2) // My solution, using an int array
	{
		// Check for equal length inputs
		if (input1.length() != input2.length())
		{
			return false;
		}

		// Use a counting array
		int[] char_set = new int[256];

		for (int i = 0; i < input1.length(); i++)
		{
			int val = (int) input1.charAt(i);
			char_set[val]++;
		}

		// Decrement counting array
		for (int k = 0; k < input2.length(); k++)
		{
			int val = (int) input2.charAt(k);
			char_set[val]--;
			if (char_set[val] < 0)
			{
				return false;
			}
		}

		return true;
	}

	// 1.3 (cont)
	public boolean permutation_calculator_hashmap(String input1, String input2) // My solution, using a HashMap
	{
		// Check for equal length inputs
		if (input1.length() != input2.length())
		{
			return false;
		}

		// Use a Java HashMap, the key is the character used, the value is the number of times used.
		HashMap<Character, Integer> characters = new HashMap<Character, Integer>();

		for (int i = 0; i < input1.length(); i++)
		{
			Character letter = input1.charAt(i);

			if (characters.containsKey(letter))
			{
				int count = characters.get(letter);
				characters.put(letter, count + 1);
			}
			else
			{
				characters.put(letter, 1);
			}
		}

		for (int j = 0; j < input2.length(); j++)
		{
			Character letter = input2.charAt(j);

			if (characters.containsKey(letter))
			{
				int count = characters.get(letter);
				if (count < 1)
				{
					return false;
				}
				characters.put(letter, count - 1);
			}
			else
			{
				return false;
			}
		}

		return true;
	}

	// 1.4 Replace all spaces in a string with "%20".
	public String space_replace(String input)
	{
		char[] charArray = input.toCharArray();
		String output = "";

		for (char c : charArray)
		{
			if (c != ' ')
			{
				output += c;
			}
			else
			{
				output += "%20";
			}
		}

		return output;
	}

	// 1.5 Write a method to perform string compression (convert aaaabbbc => a4b3c).
	public String string_compression(String input)
	{
		char[] charArray = input.toCharArray();
		String output = "";

		// Initialize
		int count = 1;
		output += charArray[0];

		for (int i = 1; i < charArray.length; i++)
		{
			if (charArray[i] != charArray[i - 1])
			{
				if (count > 1)
				{
					output += count;
				}
				output += charArray[i];
				count = 1;
			}
			else
			{
				count++;
			}
		}

		int i = charArray.length - 1;
		if (charArray[i] == charArray[i-1])
		{
			return output + count;
		}
		else
		{
			return output;
		}
	}

	// 1.5 Faster version (using stringbuffer)
	public String string_compression_fast(String input)
	{
		// Check if compression would create a longer string
		int size = countCompression(input);
		if (size >= input.length())
		{
			return input;
		}

		// Initialize
		StringBuffer mystring = new StringBuffer();
		char last = input.charAt(0);
		int count = 1;

		for (int i = 1; i < input.length(); i++)
		{
			if (input.charAt(i) == last) // Found repeat char
			{
				count++;
			}
			else
			{
				mystring.append(last);
				mystring.append(count);
				last = input.charAt(i);
				count = 1;
			}
		}

		mystring.append(last);
		mystring.append(count);

		return mystring.toString();
	}

	public int countCompression(String input)
	{
		if (input == null || input.isEmpty())
		{
			return 0;
		}

		char last = input.charAt(0);
		int size = 0;
		int count = 1;

		for (int i = 1; i < input.length(); i++)
		{
			if (input.charAt(i) == last)
			{
				count++;
			}
			else
			{
				last = input.charAt(i);
				size += 1 + String.valueOf(count).length();
				count = 1;
			}
		}

		size += 1 + String.valueOf(count).length();

		return size;
	}


	// 1.6 Write a method to rotate an NxN matrix 90 degrees
	public void rotate(int[][] matrix, int n)
	{
		for (int layer = 0; layer < n / 2; layer++)
		{
			int first = layer;
			int last = n - 1 - layer;

			for (int i = first; i < last; i++)
			{
				int offset = i - first;
				// save top
				int top = matrix[first][i];

				// left -> top
				matrix[first][i] = matrix[last - offset][first];

				// bottom -> left
				matrix[last-offset][first] = matrix[last][last - offset];

				// right -> bottom
				matrix[last][last - offset] = matrix[i][last];

				// top - > right
				matrix[i][last] = top;
			}
		}
	}

	// 1.7 Write a method to set an entire row n and column of an m x n matrix to 0
	public void zeroify(int[][] matrix)
	{
		boolean[] row = new boolean[matrix.length];
		boolean[] column = new boolean[matrix[0].length];

		// Store the row and column indexes with a value of 0
		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix[0].length; j++)
			{
				if (matrix[i][j] == 0)
				{
					row[i] = true;
					column[j] = true;
				}
			}
		}

		// Nullify rows
		for (int i = 0; i < row.length; i++)
		{
			if (row[i])
			{
				for (int j = 0; j < matrix[0].length; j++)
				{
					matrix[i][j] = 0;
				}
			}
		}

		// Nullify columns
		for (int j = 0; j < column.length; j++)
		{
			if (column[j])
			{
				for (int i = 0; i < matrix.length; i++)
				{
					matrix[i][j] = 0;
				}
			}
		}
	}

	// 1.8 Write a method to test if one string is a rotation of another string. For example, "erbottlewat" is a rotation of "waterbottle"
	public boolean is_rotation(String input1, String input2)
	{
		if (input1.length() != input2.length())
		{
			return false;
		}

		Character target = input1.charAt(0);

		for (int i = 0; i < input2.length(); i++)
		{
			Character letter = input2.charAt(i);

			if (target == letter)
			{
				String unrotated = input2.substring(i, input1.length()) + input2.substring(0, i);
				if (input1.equals(unrotated))
				{

					return true;
				}
				else
				{
					return false;
				}
			}
		}

		return false;
	}
}