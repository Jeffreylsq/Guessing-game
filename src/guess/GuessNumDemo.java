package guess;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class GuessNumDemo {
	public static void main(String []args) {


		Scanner kb = new Scanner(System.in);
		System.out.println("*****************Welcome to guessing game***************");	

		int level;
		while(true)
		{ 
			System.out.println( "Please choose your level of game" + '\n' +"(5,7,9)");
			level = kb.nextInt();                    // choose number of letter
			if(level == 9 || level == 7 || level == 5)
			{
				break; 
			}


		}
		char [] answer = new char[level];
		answer = generateArray(level);


		System.out.println("Cheat----" + String.valueOf(answer)); // Cheat answer


		while(true) {
			System.out.println("Please enter your guess");
			String str = kb.next().toUpperCase();
			if(str.equals("EXIT") )
			{
				break;
			}


			char [] guess = str.toCharArray();
			int [] array = new int [2];
			array = compare(answer,guess);


			if(array[0] == 5 && array[1] == 5)
			{
				System.out.println("Letter correct number: " + array[0]);
				System.out.println("Position correct number: " + array[1]);
				break;
			}

			System.out.println("Letter correct number: " + array[0]);
			System.out.println("Position correct number: " + array[1]);
		}





	}


	public static char [] generateArray(int num)
	{
		char [] array = new char[num];
		char [] words = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P'
				,'Q','R','S','T','U','V','W','X','Y','Z'};
		boolean []flag = new boolean[words.length];
		Random ran = new Random();

		for(int i = 0; i < array.length; i++)
		{    int index = 0;
		do {
			index = ran.nextInt(26);
			array[i] = words[index];
		}while(flag[index]== true);
		flag[index] = true;
		}
		return array;
	}

	public static int [] compare(char [] answer, char [] guess)
	{
		int [] array = new int [2]; // array[0] letter correct, array[1] position correct


		for(int i = 0; i < answer.length ; i++)
		{
			for(int j = 0; j < guess.length; j++)
			{
				if(answer[i] == guess[j])
				{
					array[0]++;
					if(i == j)
					{
						array[1]++;
					}
					break;
				}
			}
		}
		return array;

	}

}
