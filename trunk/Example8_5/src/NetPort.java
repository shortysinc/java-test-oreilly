import java.io.*;
import java.net.*;

/**
 * @author Jorge Rivas
 * @version 1.0
 */

/*
 * Este programa muestra las conexiones abiertas en un puerto sobre
 * un host determinado. Por defecto el host es localhost.
 */

public class NetPort
{
	public static void main(String[] args)
	{
		String host = args.length > 0 ? args[0] : "localhost";
		
		for (int i = 25; i < 512; i++)
		{
			try
			{
				System.out.println(i);
				Socket s = new Socket(host, i);
				System.out.println("Hay un servicio ejecutandose en el puerto " + i + " sobre la ip: " + host);
				s.close();
			} 
			catch (UnknownHostException ex)
			{
				System.err.println(ex);
				break;
			} 
			catch (IOException ex)
			{
				// Aqui no deberia existir ningun sevricio ejecutandose.
			}
		}
	}
}