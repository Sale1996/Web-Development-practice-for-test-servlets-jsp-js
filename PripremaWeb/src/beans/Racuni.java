package beans;

import java.util.ArrayList;

public class Racuni {
	
	ArrayList<Racun> racuni;

	public Racuni() {
		racuni=new ArrayList<Racun>();
	}
	
	public Boolean dodajRacun(Racun racun){
		for(Racun racun1 : racuni){
			if(racun1.getBrojRacuna().equals(racun.getBrojRacuna()))
				return false;
		}
		racuni.add(racun);		
		return true;
	}
	
	public void obrisiRacun(String brojRacuna){
		int i;
		for(i=0; i < racuni.size();i++){
			if(racuni.get(i).getBrojRacuna().equals(brojRacuna))
				break;
		}
		racuni.remove(i);
	}
	
	public int nadjiIndex(String brojRacuna){
		int i;
		for(i=0; i < racuni.size();i++){
			if(racuni.get(i).getBrojRacuna().equals(brojRacuna))
				return i;
		}
		return -1;
	}

	public ArrayList<Racun> getRacuni() {
		return racuni;
	}

	public void setRacuni(ArrayList<Racun> racuni) {
		this.racuni = racuni;
	}
	

}
