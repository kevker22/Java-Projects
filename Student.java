package aufgabe_601_Student_Compare;

import java.util.ArrayList;
/**
 * Diese Klasse beschreibt einen eindeutigen Student mit Matrikelnummer, Vor/- sowie Nachname
 * @author Kevin Bastian
 *
 */

public class Student {
	
	public int getMatrikelNummer() {
		return matrikelNummer;
	}

	public void setMatrikelNummer(int matrikelNummer) {
		this.matrikelNummer = matrikelNummer;
	}

	public String getVorName() {
		return vorName;
	}

	public void setVorName(String vorName) {
		this.vorName = vorName;
	}

	public String getNachName() {
		return nachName;
	}

	public void setNachName(String nachName) {
		this.nachName = nachName;
	}

	private int matrikelNummer; // getter und setter
	private String vorName; // getter und setter
	private String nachName; // getter und setter
	
	private static ArrayList<Student> liste = new ArrayList<Student>();
	private static StudentComparator comp = new StudentComparator();
	
	/**
	 * Konstruktor zum erzeugen von einem Studenten mit Vor/Nachnamen sowie Matrikelnummer
	 * @param matNummer
	 * @param vorName
	 * @param nachName
	 */
	
	public Student(int matNummer, String vorName, String nachName)
	{
		this.matrikelNummer = matNummer;
		this.vorName = vorName;
		this.nachName = nachName;
	}
	
	/**
	 * Testen zum sortieren von der ArreyList
	 *
	 */
	
	public static void main(String[] args)
	{
		Student student1 = new Student(87762, "Kevin", "Bastian");
		liste.add(student1);
		Student student2 = new Student(85241, "Marc", "Vogt");
		liste.add(student2);
		Student student3 = new Student(35785, "Maximilian", "Maier");
		liste.add(student3);
		Student student4 = new Student(12345, "Tatjana", "Stahl");
		liste.add(student4);
		Student student5 = new Student(11111, "Janik", "Frey");
		liste.add(student5);
		
		// Test für die Nachnamen:

		System.out.println("Nachnamen unsortiert:");

		for (Student student : liste)
		{
			System.out.println(student.getNachName());
		}

		System.out.println();
		liste.sort(comp);
		System.out.println("Nachnamen sortiert:");

		for (Student student : liste)
		{
			System.out.println(student.getNachName());
		}
		
	}

}
