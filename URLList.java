import java.util.Vector;

/**
 * Creates a list and has various methods to manipulate the list.
 * 
 * @author Osama Tariq
 */
public class URLList {
	Vector<String> URL = new Vector<String>();
	Vector<String> Title = new Vector<String>();

	/**
	 * Takes in a String and if the string contains a URL and a title, it adds
	 * them to a list.
	 * 
	 * @param line A String that the link and title will be extracted from 
	 */
	public void load(String line) {
		if (line.contains("<a href=")) {
			int urlStart = line.indexOf("\"") + 1;
			int urlEnd = line.indexOf("\"", urlStart);
			int titleEnd = line.indexOf("</a>");
			String html = line.substring(urlStart, urlEnd);
			String title = line.substring((urlEnd + 2), titleEnd);
			add(html, title);
		}
	}

	/**
	 * Takes in a URL and a title and inserts them into a list.
	 * 
	 * @param html A String of the URL
	 * @param title A String of the Title
	 * 
	 */
	public void add(String html, String title) {
		URL.addElement(html);
		Title.addElement(title);
	}

	/**
	 * Returns URL at the specified index
	 * @param j
	 *            int index of the URL you want to Obtain
	 * @return Link at the specified index.
	 */
	public String urlAt(int j) {
		String ret = URL.elementAt(j);
		return ret;
	}

	/**
	 * Returns Title at the specified index
	 * @param j
	 *            int index of the Title you want to Obtain
	 * @return Title at the specified index.
	 */
	public String titleAt(int j) {
		String ret = Title.elementAt(j);
		return ret;
	}

	/**
	 * @return Returns the size of the list
	 */
	public int components() {
		int comp = URL.size();
		return comp;
	}

	/**
	 * Takes in two index i and y and swaps the links at those indices
	 * 
	 * @param i int index of link 
	 * @param y int index of Second link
	 * 
	 */
	public void swap(int i, int y) {
		String temp;
		temp = URL.elementAt(i);
		URL.setElementAt(URL.elementAt(y), i);
		URL.setElementAt(temp, y);
		temp = Title.elementAt(i);
		Title.setElementAt(Title.elementAt(y), i);
		Title.setElementAt(temp, y);

	}

	/**
	 * Takes in a string and an index and checks if the URL at that index
	 * contains the string.
	 * 
	 * @param s String that has to be searched
	 * @param x	int index of the location to search
	 * @return Returns True if it does and false otherwise.
	 */
	public boolean search(String s, int x) {
		boolean link = false;
		link = URL.elementAt(x).contains(s);
		return link;

	}

	/**
	 * Takes in a string and an index and checks if the title at that index
	 * contains the string.
	 * 
	 * @param s String that has to be looked up
	 * @param x	int index of the location to look up
	 * @return Returns boolean value.
	 */
	public boolean lookUp(String s, int x) {
		boolean link = false;
		link = Title.elementAt(x).contains(s);
		return link;
	}

	/**
	 * Removes link at the specified index
	 * 
	 * @param i int Index of the link to be removed
	 */
	public void remove(int i) {
		URL.remove(i);
		Title.remove(i);
	}

	/**
	 * Removes all links from the list.
	 */
	public void clear() {
		URL.clear();
		Title.clear();
	}

}
