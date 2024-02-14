package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Project {
	public static void main(String args[]) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Chack-in date(dd/MM/yyyy) ");
		Date chakIn = sdf.parse(sc.next()); // Estou fazendo o parse ler o que será contido dentro da data especificada..
		System.out.print("Chack-in date(dd/MM/yyyy) ");
		Date chakOut = sdf.parse(sc.next()); 
		
		if(!chakOut.after(chakIn)) {
			System.out.println("Erro in reservation: Chak-out must be after chak-In date");
		}else {
			Reservation reservation = new Reservation(number, chakIn, chakOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println("Enter new Date a reservetion: ");
			System.out.print("Chack-in date(dd/MM/yyyy) ");
			chakIn = sdf.parse(sc.next()); 
			System.out.print("Chack-in date(dd/MM/yyyy) ");
			chakOut = sdf.parse(sc.next());
			Date now = new Date();
			if(chakIn.before(now) || chakOut.before(chakOut) ) {
				System.out.println("Erro in reservation: Chak-out must be after chak-In date now");
			}else if(!chakOut.after(chakIn)) {
				System.out.println("Erro in reservation: Chak-out must be after chak-In date");
			}else{
				
				reservation.UpdateDate(chakIn, chakOut);
				System.out.println("Reservation: " + reservation);

			}	
		}
	}
}

