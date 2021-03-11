package no.hvl.dat102.mengde.tabell;

import java.util.Iterator;

import no.hvl.dat102.mengde.adt.MengdeADT;

public class Hobby implements MengdeADT<Hobby> {
	
	private String hobbyNavn;
	
	public Hobby(String hobby) {
		hobbyNavn = hobby;
	}
	
	public String toString() {
		return "<" + hobbyNavn + ">";
	}
	
	public String getHobbyNavn() {
		return this.hobbyNavn;
	}
	
	public boolean equals(Object Hobby2) {
		Hobby hobbyDenAndre = (Hobby) Hobby2;
		return(hobbyNavn.equals(hobbyDenAndre.getHobbyNavn()));
	}

	@Override
	public void leggTil(Hobby element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void leggTilAlle(MengdeADT<Hobby> m2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Hobby fjernTilfeldig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hobby fjern(Hobby element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MengdeADT<Hobby> union(MengdeADT<Hobby> m2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean inneholder(Hobby element) {
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
	public MengdeADT<Hobby> snitt(MengdeADT<Hobby> m2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MengdeADT<Hobby> differens(MengdeADT<Hobby> m2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean undermengde(MengdeADT<Hobby> m2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<Hobby> oppramser() {
		// TODO Auto-generated method stub
		return null;
	}
}

