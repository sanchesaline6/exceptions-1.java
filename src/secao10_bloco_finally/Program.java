package secao10_bloco_finally;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Program
{

	public static void main(String[] args)
	{
		File file = new File("C:\\Users\\aline\\Desktop\\teste.txt");
		Scanner sc = null;
		
		try
		{
			sc = new Scanner(file); //O Scanner pode ser usado para ler arquivos 
			while(sc.hasNextLine())
			{
				System.out.println(sc.nextLine());
			}
			System.out.println("File reading");
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Error opening file: " + e.getMessage());
		}
		finally
		{
			if(sc != null)
			{
				sc.close();
			}
		}

	}

}
