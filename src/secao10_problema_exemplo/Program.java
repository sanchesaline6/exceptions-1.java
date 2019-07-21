package secao10_problema_exemplo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

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

	public static void main(String[] args) throws ParseException
	{
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room number: ");
		int roomNumber = sc.nextInt();

		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkinDate = sdf.parse(sc.next());

		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkoutDate = sdf.parse(sc.next());

		if (!checkoutDate.after(checkinDate))
		{
			System.out.println("Error in reservation: Check-out date must be after check-in date!");
		} 
		else
		{
			Reservation reservation = new Reservation(roomNumber, checkinDate, checkoutDate);
			System.out.println("Reservation: " + reservation);

			System.out.println();
			System.out.println("Enter data to update the reservation: ");

			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkinDate = sdf.parse(sc.next());

			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkoutDate = sdf.parse(sc.next());
			
			String error = reservation.updateDates(checkinDate, checkoutDate);
			if(error != null)
				System.out.println("Error in reservation: " + error);
			System.out.println("Reservation: " + reservation);
			
		}
		sc.close();

	}

}
