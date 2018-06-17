package beans;

public class Racun {
	String brojRacuna;
	String tipRacuna;
	int raspolozivo;
	int rezervisano;
	int ukupno;
	String online;
	String aktivan;
	
	public Racun(String brojRacuna, String tipRacuna, int raspolozivo, int rezervisano, int ukupno, String online,
			String aktivan) {
		super();
		this.brojRacuna = brojRacuna;
		this.tipRacuna = tipRacuna;
		this.raspolozivo = raspolozivo;
		this.rezervisano = rezervisano;
		this.ukupno = ukupno;
		this.online = online;
		this.aktivan = aktivan;
	}
	
	public void Aktiviraj(){
		aktivan="DA";
		
	}
	public void Deaktiviraj(){
		aktivan="NE";
	}
	
	public void Uplati(int broj){
		this.raspolozivo+=broj;
		this.ukupno+=broj;
	}

	public String getBrojRacuna() {
		return brojRacuna;
	}

	public void setBrojRacuna(String brojRacuna) {
		this.brojRacuna = brojRacuna;
	}

	public String getTipRacuna() {
		return tipRacuna;
	}

	public void setTipRacuna(String tipRacuna) {
		this.tipRacuna = tipRacuna;
	}

	public int getRaspolozivo() {
		return raspolozivo;
	}

	public void setRaspolozivo(int raspolozivo) {
		this.raspolozivo = raspolozivo;
	}

	public int getRezervisano() {
		return rezervisano;
	}

	public void setRezervisano(int rezervisano) {
		this.rezervisano = rezervisano;
	}

	public int getUkupno() {
		return ukupno;
	}

	public void setUkupno(int ukupno) {
		this.ukupno = ukupno;
	}

	public String getOnline() {
		return online;
	}

	public void setOnline(String online) {
		this.online = online;
	}

	public String getAktivan() {
		return aktivan;
	}

	public void setAktivan(String aktivan) {
		this.aktivan = aktivan;
	}
	

}
