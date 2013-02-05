package com.example.suphasitpichijai;

import java.io.*;
import java.util.*;

/**
 * An example of subclassing NanoHTTPD to make a custom HTTP server.
 */
public class HelloServer extends NanoHTTPD
{
	public HelloServer() throws IOException
	{
		super(7777, new File("."));
	}

	public Response serve( String uri, String method, Properties header, Properties parms, Properties files )
	{
		
		if ( parms.getProperty("cmd").equals("Play_Status")){
			return new NanoHTTPD.Response( HTTP_OK, MIME_HTML, connect.Play_Status );
		}
		if ( parms.getProperty("cmd").equals("FinalScore")){
			return new NanoHTTPD.Response( HTTP_OK, MIME_HTML, String.valueOf(multiactivity.FinalScore) );
		}
		
		return new NanoHTTPD.Response( HTTP_OK, MIME_HTML, "A" );


	}


	public static void main( String[] args )
	{
		try
		{
			new HelloServer();
		}
		catch( IOException ioe )
		{
			System.err.println( "Couldn't start server:\n" + ioe );
			System.exit( -1 );
		}
		System.out.println( "Listening on port 8080. Hit Enter to stop.\n" );
		try { System.in.read(); } catch( Throwable t ) {};
	}
}
