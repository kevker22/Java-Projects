
package aufgabe_3_Double_Linked_List;


/**
 * Einer doppelt verkekketen Liste werden ListenElemente hinzugefügt oder
 * abgezogen, gleichzeit kann auch das Element einer gewissen Position abgefragt
 * werden. Methoden: addFirst, addLast, addSomewhere, getElement, removeFirst,
 * removeLast
 * 
 * @author Kevin Bastian
 */
public class DoppeltVerketteteListe {

	public ListenElement getFirst() {
		return first;
	}

	public void setFirst(ListenElement first) {
		this.first = first;
	}

	public ListenElement getLast() {
		return last;
	}

	public void setLast(ListenElement last) {
		this.last = last;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	private ListenElement first;
	private ListenElement last;
	private int size;

	/**
	 * 
	 * Mit dieser Methode wird einer Liste ein Element an der ersten Stelle
	 * hinzugefügt
	 * 
	 * @param value
	 *            = dem Übergebenen String was eingefügt werden soll
	 */

	public void addFirst(String value) {
		ListenElement element = new ListenElement();
		element.setData(value);
		if (size > 0) {
			element.setNachfolger(first);
			first.setVorgaenger(element);
			first = element;
		} else {
			assert size == 0; // Wenn die Liste keine Elemente vorher hatte
			first = element; // Ist es das erste ...
			last = element; // und gleichzeitig das letzte
		}

		size++;

	}

	/**
	 * Mit dieser Methode wird einer Liste ein Element an der letzten Stelle
	 * hinzugefügt
	 * 
	 * @param value
	 *            = dem Übergebenen String was eingefügt werden soll
	 */

	public void addLast(String value) {
		ListenElement element = new ListenElement();
		element.setData(value);
		if (size > 0) {
			element.setVorgaenger(last);
			last.setNachfolger(element);
			last = element;

		} else {
			assert size == 0; // Wenn die Liste keine Elemente vorher hatte
			first = element; // Ist es das erste ...
			last = element; // und gleichzeitig das letzte
		}
		size++;
	}

	/**
	 * Mit dieser Methode kann man einen String an einer beliebigen Position
	 * einfügen.
	 * 
	 * @param index
	 *            Die Position an der das gewünschte Element eingefügt werden soll
	 * @param value
	 *            Der Übergebene String der zur Liste hinzugefügt werden soll
	 */

	public void addSomewhere(int index, String value)
	{
		if (index <= 0) // Die Liste kann nicht weniger als 0 Elemente haben
		{
			throw new IllegalArgumentException("Index muss größer als 0 sein!");
		}
		else
		{
			if (index == 1)
			{
				this.addFirst(value); 
			}
			else if (index >= size)
			{
				this.addLast(value);
			}
			else
			{
				assert (index > 1) & (index < size);
				ListenElement iteratorElement = first;

				// iterriert durch bis zur richtigen Position der Liste
				while (index > 1)
				{
					iteratorElement = iteratorElement.getNachfolger();
					index--;
				}
				ListenElement newElement = new ListenElement();
				newElement.setData(value);

				// der Nachfolger des Neuen Elements ist die Position des
				// iteratorElements.
				newElement.setNachfolger(iteratorElement);

				// das neue Element wird der Nachfolger des Vorgängerelements
				newElement.getNachfolger().getVorgaenger().setNachfolger(newElement);

				/*
				 * der Vorgänger des Nachfolgers des neuen Elements wird jetzt
				 * der Vorgänger des neuen Elements.
				 */
				newElement.setVorgaenger(newElement.getNachfolger().getVorgaenger());

				// das neue Element wird der neue Vorgänger seines Nachfolgers.
				newElement.getNachfolger().setVorgaenger(newElement);
				size++;
			}
		}
	}

	/**
	 * Mit dieser Methode geben wir das gewünschte Element an der gewählten Postion
	 * aus
	 * 
	 * @param index
	 *            beschreibt die Position des Elements, dass ausgegeben werden soll
	 * @return Daten des gewählten Elements das ausgegeben werden soll am geünschten
	 *         Index
	 */
	public String getElement(int index) {
		if (index <= 0) {
			throw new IllegalArgumentException("Index muss größer als 0 sein!");
		} else if (index == 1) {
			return first.getData();
		} else if (index == size) {
			return last.getData();
		} else {
			ListenElement iteratorElement = first;

			/*
			 * der Nachfolger des Nachfolgers wird zum neuen Nachfolger bis wir die
			 * gewünschte Position in der Liste erreicht haben.
			 */
			while (index > 1) {
				iteratorElement = iteratorElement.getNachfolger();
				index--;
			}

			return iteratorElement.getData();
		}
	}
	
	/**
	 * Diese Methode enfernt das erste Element aus der Liste
	 * @return Daten des ersten bzw des gelöschten Elements
	 */
	public String removeFirst()
	{
		assert size > 0; // überprüft ob die Liste nicht leer ist
		final String data = first.getData(); // neuer String Data übernimmt Werte von 1. Element
		first = first.getNachfolger(); // Erstes Element wird zum Nachfolgenden verschoben
		first.setVorgaenger(null);  // Erstes Element wird Null gesetzt
		size--; // Die Größe der Liste wird um eines verringert
		return data; // Die Daten des gelöschten Elements werden zrurück gegeben
	}
	
	/**
	 * Diese Methode entfernt das letzte Element aus der Liste
	 * @return Daten des letzten bzw des gelöschten Elements
	 */
	public String removeLast()
	{
		assert size > 0; // überprüft ob die Liste nicht leer ist
		final String data = last.getData(); // neuer String Data übernimmt Werte vom letzten Element
		last = last.getVorgaenger(); // Letztes Element wird zum Vorgänger verschoben
		last.setNachfolger(null); // Letztes Element wird Null gesetzt
		size--; //Die Größe der Liste wird um eines verringert
		return data; // Die Daten des gelöschten Elements werden zrurück gegeben
	}
	

}
