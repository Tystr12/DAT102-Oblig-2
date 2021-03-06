package no.hvl.dat102.mengde.kjedet;

//********************************************************************
// Kjedet implementasjon av en mengde. 
//********************************************************************
import java.util.*;

import no.hvl.dat102.exception.EmptyCollectionException;
import no.hvl.dat102.mengde.adt.*;
import no.hvl.dat102.mengde.tabell.TabellIterator;

public class KjedetMengde<T> implements MengdeADT<T> {
	private static Random rand = new Random();
	private int antall; // antall elementer i mengden
	private LinearNode<T> start;

	/**
	 * Oppretter en tom mengde.
	 */
	public KjedetMengde() {
		antall = 0;
		start = null;
	}//

	@Override
	public void leggTil(T element) {
		if (!(inneholder(element))) {
			LinearNode<T> node = new LinearNode<T>(element);
			node.setNeste(start);
			start = node;
			antall++;
		}
	}

	@Override
	public void leggTilAlle(MengdeADT<T> m2) {
		Iterator<T> teller = m2.oppramser();
		while (teller.hasNext()) {
			leggTil(teller.next());
		}
	}

	@Override
	public T fjernTilfeldig() {
		if (erTom())
			throw new EmptyCollectionException("mengde");

		LinearNode<T> forgjenger, aktuell;
		T resultat = null;

		int valg = rand.nextInt(antall) + 1;
		if (valg == 1) {
			resultat = start.getElement();
			start = start.getNeste();
		} else {
			forgjenger = start;
			for (int nr = 2; nr < valg; nr++) {
				forgjenger = forgjenger.getNeste();
			}
			aktuell = forgjenger.getNeste();
			resultat = aktuell.getElement();
			forgjenger.setNeste(aktuell.getNeste());
		}
		antall--;

		return resultat;

	}//

	@Override
	public T fjern(T element) {

		if (erTom())
			throw new EmptyCollectionException("mengde");

		LinearNode<T> forgjenger, aktuell;
		T resultat = null;
		//TODO
		
		KjedetIterator<T> it = new KjedetIterator<T>(start);
		
		while(it.hasNext()) {
			it.next();
			if(it.next().equals(element)) {
				it.remove();
			} else if (!it.next().equals(element)){
				return null;
			}
		}
		
		return resultat;
	}//

	@Override
	public boolean inneholder(T element) {
		boolean funnet = false;
		LinearNode<T> aktuell = start;
		for (int soek = 0; soek < antall && !funnet; soek++) {
			if (aktuell.getElement().equals(element)) {
				funnet = true;
			} else {
				aktuell = aktuell.getNeste();
			}
		}
		return funnet;
	}

	@Override
	public boolean equals(Object ny) {
		if (this == ny) {
			return true;
		}
		if (ny == null) {
			return false;

		}
		if (getClass() != ny.getClass()) {
			return false;
		}

		boolean likeMengder = true;
		MengdeADT<T> m2 = (KjedetMengde<T>) ny;
		if (this.antall != m2.antall()) {
			likeMengder = false;
		} else {
			likeMengder = true;
			Iterator<T> teller = m2.oppramser();
			while (teller.hasNext() && likeMengder) {
				T element = teller.next();
				if (!this.inneholder(element)) {
					likeMengder = false;
				}
			}

		}
		return likeMengder;

	}

	@Override
	public boolean erTom() {
		return antall == 0;
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public MengdeADT<T> union(MengdeADT<T> m2) {
		//TODO
		MengdeADT<T> begge = new KjedetMengde<T>();
		LinearNode<T> aktuell = start;
		T element = null;

		KjedetIterator<T> it = new KjedetIterator<T>(aktuell);
		Iterator<T> it2 = m2.oppramser();
		
		while (it2.hasNext()) {
			it2.next();
			begge.leggTil(it2.next());
		} 
		while (it.hasNext()) {
			element = (T) it.next();
			begge.leggTil(element);
		}
		
		return begge;

	}//

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> m2) {
		MengdeADT<T> snittM = new KjedetMengde<T>();
		T element;
		T element2;
		//TODO
		
		KjedetIterator<T> it = new KjedetIterator<T>(start);
		Iterator<T> it2 = m2.oppramser();
		
		while(it.hasNext() && it2.hasNext()) {
			element = it.next();
			element2 = it2.next();
			if(element.equals(element2)) {
				snittM.leggTil(element);
			}
		}
		
		return snittM;
	}

	@Override
	public MengdeADT<T> differens(MengdeADT<T> m2) {
		MengdeADT<T> differensM = new KjedetMengde<T>();
		T element;
		T m2Element;
		//TODO
		
		KjedetIterator<T> it = new KjedetIterator<T>(start);
		Iterator<T> it2 = m2.oppramser();
		
		while(it.hasNext() && it2.hasNext()) {
			element = (T) it.next();
			m2Element = (T) it2.next();
			
				if (!element.equals(m2Element)) {
				differensM.leggTil(element);
				differensM.leggTil(m2Element);
			}
		}

		return differensM;
	}

	@Override
	public boolean undermengde(MengdeADT<T> m2) {
		boolean erUnderMengde = true;
		// Fyll ut
		return erUnderMengde;
	}

	@Override
	public Iterator<T> oppramser() {
		return new KjedetIterator<T>(start);
	}

	private void settInn(T element) {
		LinearNode<T> nyNode = new LinearNode<T>(element);
		nyNode.setNeste(start);
		start = nyNode;
		antall++;
	}
	
	public String toString() {
		String resultat = "";
		LinearNode<T> aktuell = start;
		while(aktuell != null) {
			resultat += aktuell.getElement().toString() + "\t";
			aktuell = aktuell.getNeste();
		}
		return resultat;
	}

}// class
