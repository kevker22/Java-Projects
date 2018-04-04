
package aufgabe_7_Generische_Liste;


/**
 * Einer doppelt verkekketen Liste werden ListenElemente hinzugef�gt oder
 * abgezogen, gleichzeit kann auch das Element einer gewissen Position abgefragt
 * werden. Methoden: addFirst, addLast, addSomewhere, getElement, removeFirst,
 * removeLast
 * 
 * @author Kevin Bastian
 */
public class DoppeltVerketteteListe<E> {

	public ListenElement<E> getFirst() {
		return first;
	}

	public void setFirst(ListenElement<E> first) {
		this.first = first;
	}

	public ListenElement<E> getLast() {
		return last;
	}

	public void setLast(ListenElement<E> last) {
		this.last = last;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	private ListenElement<E> first;
	private ListenElement<E> last;
	private int size;

	/**
	 * 
	 * Mit dieser Methode wird einer Liste ein Element an der ersten Stelle
	 * hinzugef�gt
	 * 
	 * @param value
	 *            = dem �bergebenen String was eingef�gt werden soll
	 */

	public void addFirst(E value) {
		ListenElement<E> element = new ListenElement<E>();
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
	 * hinzugef�gt
	 * 
	 * @param value
	 *            = dem �bergebenen String was eingef�gt werden soll
	 */

	public void addLast(E value) {
		ListenElement<E> element = new ListenElement<E>();
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
	 * einf�gen.
	 * 
	 * @param index
	 *            Die Position an der das gew�nschte Element eingef�gt werden soll
	 * @param value
	 *            Der �bergebene String der zur Liste hinzugef�gt werden soll
	 */

	public void addSomewhere(int index, E value)
	{
		if (index <= 0) // Die Liste kann nicht weniger als 0 Elemente haben
		{
			throw new IllegalArgumentException("Index muss gr��er als 0 sein!");
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
				ListenElement<E> iteratorElement = first;

				// iterriert durch bis zur richtigen Position der Liste
				while (index > 1)
				{
					iteratorElement = iteratorElement.getNachfolger();
					index--;
				}
				ListenElement<E> newElement = new ListenElement<E>();
				newElement.setData(value);

				// der Nachfolger des Neuen Elements ist die Position des
				// iteratorElements.
				newElement.setNachfolger(iteratorElement);

				// das neue Element wird der Nachfolger des Vorg�ngerelements
				newElement.getNachfolger().getVorgaenger().setNachfolger(newElement);

				/*
				 * der Vorg�nger des Nachfolgers des neuen Elements wird jetzt
				 * der Vorg�nger des neuen Elements.
				 */
				newElement.setVorgaenger(newElement.getNachfolger().getVorgaenger());

				// das neue Element wird der neue Vorg�nger seines Nachfolgers.
				newElement.getNachfolger().setVorgaenger(newElement);
				size++;
			}
		}
	}

	/**
	 * Mit dieser Methode geben wir das gew�nschte Element an der gew�hlten Postion
	 * aus
	 * 
	 * @param index
	 *            beschreibt die Position des Elements, dass ausgegeben werden soll
	 * @return Daten des gew�hlten Elements das ausgegeben werden soll am ge�nschten
	 *         Index
	 */
	public E getElement(int index) {
		if (index <= 0) {
			throw new IllegalArgumentException("Index muss gr��er als 0 sein!");
		} else if (index == 1) {
			return first.getData();
		} else if (index == size) {
			return last.getData();
		} else {
			ListenElement<E> iteratorElement = first;

			/*
			 * der Nachfolger des Nachfolgers wird zum neuen Nachfolger bis wir die
			 * gew�nschte Position in der Liste erreicht haben.
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
	 * @return Daten des ersten bzw des gel�schten Elements
	 */
	public E removeFirst()
	{
		assert size > 0; // �berpr�ft ob die Liste nicht leer ist
		final E data = first.getData(); // neuer String Data �bernimmt Werte von 1. Element
		first = first.getNachfolger(); // Erstes Element wird zum Nachfolgenden verschoben
		first.setVorgaenger(null);  // Erstes Element wird Null gesetzt
		size--; // Die Gr��e der Liste wird um eines verringert
		return data; // Die Daten des gel�schten Elements werden zrur�ck gegeben
	}
	
	/**
	 * Diese Methode entfernt das letzte Element aus der Liste
	 * @return Daten des letzten bzw des gel�schten Elements
	 */
	public E removeLast()
	{
		assert size > 0; // �berpr�ft ob die Liste nicht leer ist
		final E data = last.getData(); // neuer String Data �bernimmt Werte vom letzten Element
		last = last.getVorgaenger(); // Letztes Element wird zum Vorg�nger verschoben
		last.setNachfolger(null); // Letztes Element wird Null gesetzt
		size--; //Die Gr��e der Liste wird um eines verringert
		return data; // Die Daten des gel�schten Elements werden zrur�ck gegeben
	}
	

}
