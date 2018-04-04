package aufgabe_7_Generische_Liste;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
/**
 * Ein Test für die Abgeänderte Double Linked List mit <E> statt Strings mit String Element als Beispiel.
 * @author Kevin Bastian
 *
 */

public class DoppeltVerketteteListeTest
{

	/**
	 * Erzeugen einer doppelt verketteten Liste mit 0 Elementen.
	 */
	@Test
	public void testDoppeltVerketteteListe()
	{
		DoppeltVerketteteListe<String> list = new DoppeltVerketteteListe<String>();
		assertEquals(null, list.getFirst());
		assertEquals(null, list.getLast());
		assertEquals(0, list.getSize());
	}

	/**
	 * Einfügen eines Elements an das Ende der leeren Liste.
	 */
	@Test
	public void testAddLast1()
	{
		DoppeltVerketteteListe<String> list = new DoppeltVerketteteListe<String>();
		list.addLast("hallo");
		assertEquals("hallo", list.getFirst().getData());
		assertEquals("hallo", list.getLast().getData());
		assertEquals(1, list.getSize());
	}

	/**
	 * Einfügen eines Elements an den Anfang der leeren Liste.
	 */
	@Test
	public void testAddFirst1()
	{
		DoppeltVerketteteListe<String> list = new DoppeltVerketteteListe<String>();
		list.addFirst("hallo");
		assertEquals("hallo", list.getFirst().getData());
		assertEquals("hallo", list.getLast().getData());
		assertEquals(1, list.getSize());
	}

	/**
	 * Einfügen mehrerer Elemente am Anfung and am Ende der leeren Liste.
	 */
	@Test
	public void testAddFirst2()
	{
		DoppeltVerketteteListe<String> list = new DoppeltVerketteteListe<String>();
		list.addFirst("hallo");
		list.addFirst("name");
		list.addLast("datum");
		assertEquals("name", list.getFirst().getData());
		assertEquals("datum", list.getLast().getData());
		assertEquals(3, list.getSize());
	}

	/**
	 * Einfügen eines Elements mit addSomewhere() in eine leere Liste.
	 */
	@Test
	public void testAddSome1()
	{
		DoppeltVerketteteListe<String> list = new DoppeltVerketteteListe<String>();
		list.addSomewhere(1, "hallo");
		assertEquals("hallo", list.getFirst().getData());
		assertEquals("hallo", list.getLast().getData());
		assertEquals(1, list.getSize());
	}

	/**
	 * Einfügen eines Elements mit addSomewhere() an eine Position größer als die Länge
	 * der Liste.
	 */
	@Test
	public void testAddSome2()
	{
		DoppeltVerketteteListe<String> list = new DoppeltVerketteteListe<String>();
		list.addSomewhere(363, "hallo");
		assertEquals("hallo", list.getFirst().getData());
		assertEquals("hallo", list.getLast().getData());
		assertEquals(1, list.getSize());
	}

	/**
	 * Einfügen eines Elements mit addSomewhere() an eine Position zwischen Anfang und
	 * Ende der Liste.
	 */
	@Test
	public void testAddSome3()
	{
		DoppeltVerketteteListe<String> list = new DoppeltVerketteteListe<String>();
		list.addFirst("hallo");
		list.addFirst("name");
		list.addLast("datum");
		list.addSomewhere(3, "drei");
		assertEquals("name", list.getFirst().getData());
		assertEquals("drei", list.getLast().getData());
		assertEquals(4, list.getSize());
		assertEquals("drei", list.getElement(4));
		assertEquals("hallo", list.getElement(2));
	}

	/**
	 * Einfügen eines Elements mit addSomewhere() an einer Position die kleiner als 1
	 * ist.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAddSome4()
	{
		DoppeltVerketteteListe<String> list = new DoppeltVerketteteListe<String>();
		list.addFirst("hallo");
		list.addFirst("name");
		list.addLast("datum");
		list.addSomewhere(-3, "minusdrei");
	}

	/**
	 *c Auslesen der Daten an Indizes die auh in der Liste vorkommen.
	 */
	@Test
	public void testGetElement1()
	{
		DoppeltVerketteteListe<String> list = new DoppeltVerketteteListe<String>();
		list.addFirst("hallo");
		list.addFirst("name");
		list.addLast("datum");
		assertEquals("name", list.getElement(1));
		assertEquals("hallo", list.getElement(2));
		assertEquals("datum", list.getElement(3));
	}

	/**
	 * Auslesen der Daten an einem Index kleiner/gleich 0.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetElement2()
	{
		DoppeltVerketteteListe<String> list = new DoppeltVerketteteListe<String>();
		list.addFirst("hallo");
		list.addFirst("name");
		list.addLast("datum");
		list.getElement(-3);
	}

	/**
	 * Entfernen des ersten Elements aus einer nichtleeren Liste.
	 */
	@Test
	public void testRemoveFirst1()
	{
		DoppeltVerketteteListe<String> list = new DoppeltVerketteteListe<String>();
		list.addFirst("hallo");
		list.addFirst("name");
		list.addLast("datum");
		assertEquals("name", list.getFirst().getData());
		assertEquals(3, list.getSize());
		list.removeFirst();
		assertEquals("hallo", list.getFirst().getData());
		assertEquals(2, list.getSize());
	}

	/**
	 * Entfernen des ersten Elements aus einer leeren Liste.
	 */
	@Test(expected = AssertionError.class)
	public void testRemoveFirst2()
	{
		DoppeltVerketteteListe<String> list = new DoppeltVerketteteListe<String>();
		list.removeFirst();
	}

	/**
	 * Entfernen des letzten Elements aus einer nichtleeren Liste.
	 */
	@Test
	public void testRemoveLast1()
	{
		DoppeltVerketteteListe<String> list = new DoppeltVerketteteListe<String>();
		list.addFirst("hallo");
		list.addFirst("name");
		list.addLast("datum");
		assertEquals("datum", list.getLast().getData());
		assertEquals(3, list.getSize());
		list.removeLast();
		assertEquals("hallo", list.getLast().getData());
		assertEquals(2, list.getSize());
	}

	/**
	 * Entfernen des letzten Elements aus einer leeren Liste.
	 */
	@Test(expected = AssertionError.class)
	public void testRemoveLast2()
	{
		DoppeltVerketteteListe<String> list = new DoppeltVerketteteListe<String>();
		list.removeLast();
	}
}
