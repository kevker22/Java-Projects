
package aufgabe_3_Double_Linked_List;

/**
 * @author Kevin Bastian
 *
 */
public class ListenElement {

	private String data;
	private ListenElement vorgaenger;
	private ListenElement nachfolger;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public ListenElement getVorgaenger() {
		return vorgaenger;
	}

	public void setVorgaenger(ListenElement vorgaenger) {
		this.vorgaenger = vorgaenger;
	}

	public ListenElement getNachfolger() {
		return nachfolger;
	}

	public void setNachfolger(ListenElement nachfolger) {
		this.nachfolger = nachfolger;
	}

}
