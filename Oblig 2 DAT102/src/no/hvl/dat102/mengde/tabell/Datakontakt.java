package no.hvl.dat102.mengde.tabell;

import java.util.Iterator;

import no.hvl.dat102.mengde.adt.MengdeADT;

public class Datakontakt<T> implements MengdeADT<T>{
	Medlem[] medlemsTabell;
	int antallMedlemmer;
	
	
	public void leggTilMedlem(T medlem) {
		if (!inneholder(medlem)) {
			medlemsTabell[antallMedlemmer] = (Medlem) medlem;
			antallMedlemmer++;
		}
		
	}
	
	public int finnMedlemsIndeks(String medlemNavn) {
		for(int i = 0; i < antallMedlemmer; i++) {
			if(medlemsTabell[i].getMedlemNavn().equals(medlemNavn)) {
				return i;
			}
		}
		return -1;
	}
	
	public int finnPartnerFor(String medlemNavn) {
		for(int i = 0; i < antallMedlemmer; i++) {
			  if(medlemsTabell[i].getMedlemNavn().equals(medlemNavn)) {
					Medlem first = medlemsTabell[i];
					Medlem second = medlemsTabell[i+1];
					if(first.getStatusIndeks() == -1 && second.getStatusIndeks() == -1) {
						first.setStatusIndeks(i+1);
						second.setStatusIndeks(i);
						int partnerIndeks = i+1;
						return partnerIndeks;
					}
				}
			}
		return -1;
	}
	
	public void tilbakestillStatusIndeks(String medlemNavn) {
		for(int i = 0; i < medlemsTabell.length; i++) {
			if(medlemsTabell[i].getMedlemNavn().equals(medlemNavn)) {
				Medlem target = medlemsTabell[i];
				target.setStatusIndeks(-1);
				medlemsTabell[i+1].setStatusIndeks(-1);
				System.out.println("Kobling brutt mellom " + target.getMedlemNavn() + " og " 
				+ medlemsTabell[i+1].getMedlemNavn());
			}
		}
	}
	
	@Override
	public void leggTilAlle(MengdeADT<T> m2) {
		
	}

	@Override
	public T fjernTilfeldig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T fjern(T element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MengdeADT<T> union(MengdeADT<T> m2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean inneholder(T element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean erTom() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int antall() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> m2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MengdeADT<T> differens(MengdeADT<T> m2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean undermengde(MengdeADT<T> m2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<T> oppramser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void leggTil(T element) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
