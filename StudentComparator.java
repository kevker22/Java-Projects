package aufgabe_601_Student_Compare;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {

	/**
	 * Vergleicht zwei Studenten zuerst nach Nachname, Vorname und zuletzt nach
	 * Matrikelnummer falls alles davor gleich sein sollte.
	 */
	// Wird von der Comperator Methode zum Überschreiben gezwungen
	@Override
	public int compare(Student s1, Student s2) {

		// sind die Nachnamen gleich ?
		if (s1.getNachName().equals(s2.getNachName())) {

			// sind die Vornamen gleich ?
			if (s1.getVorName().equals(s2.getVorName())) {

				// sind die Matrikelnummern gleich ?
				if (s1.getMatrikelNummer() == s2.getMatrikelNummer()) {
					return 0;

					// Matrikelnummern sind nicht gleich
				} else {

					if (s1.getMatrikelNummer() > s2.getMatrikelNummer()) {
						return 1;
					} else {
						return -1;
					}
				}

				// Vornamen sind nicht gleich
			} else {
				int laengeKuerzesterVorname = Math.min(s1.getVorName().length(), s2.getVorName().length());
				// Math.min gibt die kleiner Zahl (Länge) zurück
				// For Schleife durchläuft Char für Char den String und Vergleicht diese
				for (int i = 0; i < laengeKuerzesterVorname; i++) {
					if (s1.getVorName().charAt(i) > s2.getVorName().charAt(i)) {
						return 1;
					} else if (s1.getVorName().charAt(i) < s2.getVorName().charAt(i)) {
						return -1;
					}
				}
				return 0;
			}

			// Nachnamen sind nicht gleich
		} else {
			int laengeKuerzesterNachname = Math.min(s1.getNachName().length(), s2.getNachName().length());
			for (int i = 0; i < laengeKuerzesterNachname; i++) {
				if (s1.getNachName().charAt(i) > s2.getNachName().charAt(i)) {
					return 1;
				} else if (s1.getNachName().charAt(i) < s2.getNachName().charAt(i)) {
					return -1;
				}
			}
			return 0;
		}
	}
	
}
