package com.mediafire.problem2.communication;

import java.io.*;
import java.net.*;

/**
 * Client program that sends the message.
 * 
 * @author Hemaanjana
 * 
 */
public class Client {
	Socket requestSocket;
	ObjectOutputStream out;
	ObjectInputStream in;
	String message;

	/***
	 * Client establishes a connection with the sever
	 * @param msg
	 */
	void startSendingMessage(String msg) 
	{
		try 
		{
			requestSocket = new Socket("localhost", 2008);
			out = new ObjectOutputStream(requestSocket.getOutputStream());
			out.flush();

			in = new ObjectInputStream(requestSocket.getInputStream());

			sendMessage(msg);
		} 
		catch (UnknownHostException ex) 
		{
			ex.printStackTrace();
		} 
		catch (IOException ex) 
		{
			ex.printStackTrace();
		} 
		finally 
		{
			try 
			{
				in.close();
				out.close();
				requestSocket.close();
			} 
			catch (IOException ex) 
			{
				ex.printStackTrace();
			}
		}
	}

	/*** 
	 * Clients input message to test the connection
	 * @param msg
	 */
	void sendMessage(String msg) 
	{
		try 
		{
			out.writeObject(msg);
			out.flush();
			System.out.println("client sends message " + msg);
		} 
		catch (IOException ioException) 
		{
			ioException.printStackTrace();
		}
	}

	public static void main(String args[]) {
		Client client = new Client();
		client.startSendingMessage("Testing");
	}
}
