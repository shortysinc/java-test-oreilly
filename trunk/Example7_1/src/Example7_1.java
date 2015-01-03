import java.io.*;
import java.net.*;

/*
 * Example 7-1. Download a web page with a URLConnection
 */
public class Example7_1 {
	public static void main(String[] args) {
		if (args.length > 0) {
			try {
				// Open the URLConnection for reading
				URL u = new URL(args[0]);
				URLConnection uc = u.openConnection();
				try (InputStream raw = uc.getInputStream()) { // autoclose
					InputStream buffer = new BufferedInputStream(raw);
					// chain the InputStream to a Reader
					Reader reader = new InputStreamReader(buffer);
					int c;
					while ((c = reader.read()) != -1) {
						System.out.print((char) c);
					}
				}
			} catch (MalformedURLException ex) {
				System.err.println(args[0] + " is not a parseable URL");
			} catch (IOException ex) {
				System.err.println(ex);
			}
		}
	}
}
