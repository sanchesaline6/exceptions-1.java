package secao10_problema_exemplo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import secao10_problema_exemplo.exceptions.DomainException;

/* Fazer um programa para ler os dados de uma reserva de hotel (n�mero do quarto,
 * data de entrada e data de sa�da) e mostrar os dados da reserva, inclusive sua
 * dura��o em dias. Em seguida, ler novas datas de entrada e sa�da, atualizar a reserva, e mostrar
 * novamente a reserva com os dados atualizados. O programa n�o deve aceitar dados
 * inv�lidos para a reserva, conforme as seguintes regras:
 * - Altera��es de reserva s� podem ocorrer para datas futuras
 * - A data de sa�da deve ser maior que a data de entrada
 */
public class Program
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try
		{
			System.out.print("Room number: ");
			int roomNumber = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkinDate = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkoutDate = sdf.parse(sc.next());
	
			Reservation reservation = new Reservation(roomNumber, checkinDate, checkoutDate);
			System.out.println("Reservation: " + reservation);
	
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkinDate = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkoutDate = sdf.parse(sc.next());
	
			reservation.updateDates(checkinDate, checkoutDate);		
			System.out.println("Reservation: " + reservation);
		}
		catch (ParseException e)
		{
			System.out.println("Invalid date format!");
		}
		catch(DomainException e)
		{
			System.out.println("Error in reservation: " + e.getMessage());
		}
		catch(InputMismatchException e)
		{
			System.out.println("Only numbers allowed");
		}
		catch(RuntimeException e)
		{
			System.out.println("Unexpected error!");
		}
		sc.close();

	}

}
