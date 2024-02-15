package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private Integer roomNumber;
	private Date chakIn;
	private Date chakOut;
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {
	}

	public Reservation(Integer roomNumber, Date chakIn, Date chakOut) {
		super();
		this.roomNumber = roomNumber;
		this.chakIn = chakIn;
		this.chakOut = chakOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getChakIn() {
		return chakIn;
	}

	public Date getChakOut() {
		return chakOut;
	}

	
	public long Duration() {
		long diff = chakIn.getTime() - chakOut.getTime(); // Com isso tu pega a diferença entre as duas variavel EM MILISEGUNDOS.
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); // TIME-UNIT É UMA CLASSE DO JAVA QUE FAZ A CONVERÇÃO DOS MILISEGUNDOS/SEGUNDOS/MINUTOS/DIAS EM DIAS OU QUALQUER OUTRA COISA EM RELAÇÃO AO TEMPO.
	}
	
	public String UpdateDate( Date chakIn, Date chakOut) {
		
		Date now = new Date();
		if(chakIn.before(now) || chakOut.before(chakOut) ) {
			return "Reservation dates for update future";
		}
		if(!chakOut.after(chakIn)) {
			return "Erro in reservation: Chak-out must be after chak-In date";
		}
		
		this.chakIn = chakIn;
		this.chakOut = chakOut;
		return null; // Bom, por que retornar nulo? porque caso os dois if seja correto acima, não vai ter nada para retornar então tenho que retornar nullo para mostrar la que deu tudo certo.
	}
	
	@Override
	public String toString() {
	return "Room: " 
			+ roomNumber 
			+ ", chakIn: "
			+ sdf.format(chakIn) // Isso representa o modo que estou transformando o chakIn, com "/" e não com "-"
			+ ", chakOut: "
			+ sdf.format(chakOut)
			+ ", duratution: "
			+ Duration();
	}
	
}

