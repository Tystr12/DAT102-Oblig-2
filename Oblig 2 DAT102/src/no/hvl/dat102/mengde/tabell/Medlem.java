package no.hvl.dat102.mengde.tabell;

import java.util.Iterator;


import no.hvl.dat102.mengde.adt.MengdeADT;

public class Medlem<T> implements MengdeADT<T>{
	private String navn;
	private T[] medlemTab;
	private int statusIndeks = -1;
	private Hobby hobby;
	
	
	public Medlem(String navn, Hobby h) {
		this.navn = navn;
		this.hobby = h;
	}
	
	public void setNavn(String navn) {
		this.navn = navn;
	}
	
	public String getMedlemNavn() {
		return this.navn;
	}
	
	public void setMedlemHobby(Hobby h) {
		this.hobby = h;
	}
	
	public MengdeADT<Hobby> getMedlemHobby() {
		return this.hobby;
	}
	
	public boolean passerTil(Medlem m2) {
		if(this.hobby.equals(m2.getMedlemHobby())) {
			return true;
	}
		return false;
	}
	
	public void skivUtAlleMedlemmer() {
		/*
		 * TabellIterator<T> it = new TabellIterator<T>(medlemTab, statusIndeks); while
		 * (it.hasNext()) { Hobby current = (Hobby) it.next();
		 * System.out.println("Medlem:" + current.getNavn()); }
		 */
		for(int i = 0; i < statusIndeks; i++) {
			Medlem current = (Medlem) medlemTab[i];
			System.out.println("Medlem:" + " " + current.getMedlemNavn());
			System.out.println("Hobby:" + " " + current.getMedlemHobby());
		}
	}

	@Override
	public void leggTil(Object element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void leggTilAlle(MengdeADT m2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T fjernTilfeldig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T fjern(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MengdeADT union(MengdeADT m2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean inneholder(Object element) {
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
	public MengdeADT snitt(MengdeADT m2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MengdeADT differens(MengdeADT m2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean undermengde(MengdeADT m2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator oppramser() {
		// TODO Auto-generated method stub
		return null;
	}
	public int getStatusIndeks() {
	
		return statusIndeks;
	}
	public void setStatusIndeks(int n) {
		this.statusIndeks = n;
	}
}

