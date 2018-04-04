
package aufgabe_7_Generische_Liste;

/**
 * @author Kevin Bastian
 *
 */
public class ListenElement<E> {

	private E data;
	private ListenElement<E> vorgaenger;
	private ListenElement<E> nachfolger;

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public ListenElement<E> getVorgaenger() {
		return vorgaenger;
	}

	public void setVorgaenger(ListenElement<E> vorgaenger) {
		this.vorgaenger = vorgaenger;
	}

	public ListenElement<E> getNachfolger() {
		return nachfolger;
	}

	public void setNachfolger(ListenElement<E> nachfolger) {
		this.nachfolger = nachfolger;
	}

}
