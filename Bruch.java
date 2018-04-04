package aufgabe_1_Bruch;

/**
 * Für einen Bruch braucht man einen Nenner + Zähler , Benöitigte Klassen: Add,
 * Sub, Mutl, Div, GGT, Kürzen
 * 
 * @author Kevin Bastian
 */

public class Bruch {
	private int zaehler;
	private int nenner;

	/**
	 * Standwartkonstruktor
	 */

	public Bruch() {

	}

	/**
	 * Erzeugt einen Bruch mit ganzzahligem Zähler und possitiven ganzzahligen
	 * Nenner
	 * 
	 * @param zaehler
	 * @param nenner
	 */
	public Bruch(int zaehler, int nenner) {
		if (nenner <= 0) {
			throw new IllegalArgumentException("Der Nenner muss größer als 0 sein!");
		} else {
			this.zaehler = zaehler;
			this.nenner = nenner;
		}
	}

	/**
	 * Addiert zwei Brüche indem sie zuerst auf den gleichen Nenner gebracht und
	 * dannach die Zähler addiert werden. Dann wird gekürzt
	 * 
	 * @param bruch
	 *            ein Bruchobjekt
	 */

	public void addieren(Bruch bruch) {
		if (this.nenner == bruch.nenner) {
			this.zaehler += bruch.zaehler;
			this.kuerzen();
		} else {
			int nenner = this.nenner;
			this.nenner *= bruch.nenner;
			this.zaehler *= bruch.nenner;
			bruch.nenner *= nenner;
			bruch.zaehler *= nenner;
			this.zaehler += bruch.zaehler;
			this.kuerzen();
		}
	}

	/**
	 * Subtrahiert zwei Brüche indem sie zuerst auf den gleichen Nenner gebracht und
	 * dannach die Zähler subtrahiert werden. Dann wird gekürzt
	 * 
	 * @param bruch
	 *            ein Bruchobjekt
	 */

	public void subtrahieren(Bruch bruch) {
		if (this.nenner == bruch.nenner) {
			this.zaehler -= bruch.zaehler;
			this.kuerzen();
		} else {
			int nenner = this.nenner;
			this.nenner *= bruch.nenner;
			this.zaehler *= bruch.nenner;
			bruch.nenner *= nenner;
			bruch.zaehler *= nenner;
			this.zaehler -= bruch.zaehler;
			this.kuerzen();
		}
	}

	/**
	 * Mulipliziert zwei Brüche, indem jeweils die Zähler und Nenner miteinander #
	 * multipliziert werden
	 * 
	 * @param bruch
	 *            ein Bruchobjekt
	 */
	public void multiplizieren(Bruch bruch) {
		this.zaehler *= bruch.zaehler;
		this.nenner *= bruch.nenner;
		this.kuerzen();
	}

	/**
	 * Dividiert einen Bruch durch einen anderen Bruch indem der Kehrbruch gebildet
	 * wird und die Brüche dann multipliziert werden
	 * 
	 * @param bruch
	 *            ein Bruchobjekt
	 */
	public void dividieren(Bruch bruch) {
		int speicher = bruch.zaehler;
		bruch.zaehler = bruch.nenner;
		bruch.nenner = speicher;
		this.multiplizieren(bruch);
	}

	/**
	 * Nutzt den Euklidischen Algorithmus, indem der GGT von Nenner und Zähler
	 * bestimmt wird und anschließend Zähler und Nenner durch den GGT geteilt werden
	 */
	public void kuerzen() {
		int ggt = 1;
		int rest = 1;
		int eins = Math.abs(this.zaehler);
		int zwei = Math.abs(this.nenner);

		if (zwei > eins) {
			eins = Math.abs(this.nenner);
			zwei = Math.abs(this.zaehler);
		}

		do {
			ggt = zwei;
			rest = eins % zwei;
			eins = zwei;
			zwei = rest;
		} while (rest != 0);

		this.zaehler /= ggt;
		this.nenner /= ggt;
	}

	public int getZaehler() {
		return zaehler;
	}

	public void setZaehler(int zaehler) {
		this.zaehler = zaehler;
	}

	public int getNenner() {
		return nenner;
	}

	public void setNenner(int nenner) {
		this.nenner = nenner;
	}

}
