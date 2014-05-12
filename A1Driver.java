import java.io.*;
import java.util.*;

/**
 * The class A1Driver inputs commands from the user and uses the URLList.java
 * class to complete tasks such as load, add, and write.
 * 
 * @author Osama Tariq
 * 
 */
public class A1Driver {
	public static URLList main = new URLList();

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);

		String user = "";

		while (!user.equalsIgnoreCase("End")) { // Runs until user inputs End
			user = input.next();
			if (user.equalsIgnoreCase("load")) {
				main.clear();
				input.nextLine();
				String htmlFileName = input.nextLine();
				BufferedReader br = new BufferedReader(new FileReader(
						htmlFileName));
				String line = " ";
				while (line != null) {
					line = br.readLine();
					if (line != null) {
						main.load(line);
					}
				}
			} else if (user.equalsIgnoreCase("add")) {
				input.nextLine();
				String html = input.nextLine();
				String title = input.nextLine();
				main.add(html, title);
			} else if (user.equalsIgnoreCase("list")) {
				int x = main.components();
				for (int j = 0; j < x; j++) {
					get(j);
				}
			} else if (user.equalsIgnoreCase("get")) {
				int get = input.nextInt();
				get(get);

			} else if (user.equalsIgnoreCase("size")) {
				System.out.println(main.components());
			} else if (user.equalsIgnoreCase("swap")) {
				int i = input.nextInt();
				int y = input.nextInt();
				main.swap(i, y);
			} else if (user.equalsIgnoreCase("Search")) {
				input.nextLine();
				String s = input.nextLine();
				int j = main.components();
				for (int x = 0; x < j; x++) {
					boolean toPrint = main.search(s, x);
					if (toPrint == true) {
						get(x);
					}
				}
			} else if (user.equalsIgnoreCase("Lookup")) {
				input.nextLine();
				String s = input.nextLine();
				int j = main.components();
				for (int x = 0; x < j; x++) {
					boolean toPrint = main.lookUp(s, x);
					if (toPrint == true) {
						get(x);
					}
				}
			} else if (user.equalsIgnoreCase("Remove")) {
				int i = input.nextInt();
				main.remove(i);
			} else if (user.equalsIgnoreCase("write")) {
				input.nextLine();
				String htmlFileName;
				htmlFileName = input.nextLine();

				write(htmlFileName);
			}

		}

	}

	/**
	 * Gets URL and title from list in the class URLList.java at the index
	 * specified. Outputs the URL and the Title on separate lines.
	 * 
	 * @param i int index of link you want to print
	 */
	public static void get(int i) {
		System.out.println(main.urlAt(i));
		System.out.println(main.titleAt(i));
	}

	/**
	 * Writes the list of links obtained from the URLlist.java class as an html file.
	 * 
	 * @param htmlFileName String that contains the name of the file to be created
	 * @throws IOException
	 */
	public static void write(String htmlFileName) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(htmlFileName));
		String html = "<html>";
		bw.write(html);
		bw.newLine();
		bw.write("<head>");
		bw.newLine();
		bw.write("		<title>" + htmlFileName + "</title>");
		bw.newLine();
		bw.write("	</head>");
		bw.newLine();
		bw.write("	<body>");
		bw.newLine();
		bw.write("		<h1>List Assignment</h1>");
		bw.newLine();
		bw.write("		<ul>");
		int j = main.components();
		for (int x = 0; x < j; x++) {
			bw.newLine();
			bw.write("			<li><a href=\"" + main.urlAt(x) + "\">"
					+ main.titleAt(x) + "</a></li>");
		}
		bw.newLine();
		bw.write("		</ul>");
		bw.newLine();
		bw.write("	</body>");
		bw.newLine();
		bw.write("</html>");

		bw.close();

	}
}
