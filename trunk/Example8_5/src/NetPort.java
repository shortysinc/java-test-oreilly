import java.io.*;
import java.net.*;

/**
 * @author Jorge Rivas
 * @version 1.0
 */

/*
 * Este programa muestra las conexiones abiertas en un puerto determinado sobre
 * un host determinado. Por defecto el host es localhost.
 */

public class NetPort
{
	public static void main(String[] args)
	{
		String host = args.length > 0 ? args[0] : "localhost";
		
		for (int i = 1; i < 1024; i++)
		{
			try
			{
				Socket s = new Socket(host, i);
				System.out.println("There is a server on port " + i + " of "
						+ host);
				s.close();
			} 
			catch (UnknownHostException ex)
			{
				System.err.println(ex);
				break;
			} 
			catch (IOException ex)
			{
				// must not be a server on this port
			}
		}
	}
}