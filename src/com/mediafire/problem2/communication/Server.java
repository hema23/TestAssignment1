package com.mediafire.problem2.communication;

import java.io.*;
import java.net.*;

/**
 * Server program that receives the message.
 * 
 * @author Hemaanjana
 */
public class Server
{
    ServerSocket serverSocket;
    Socket connection = null;
    ObjectOutputStream out;
    ObjectInputStream in;
    String message;
    
    void start()
    {
    	//establishes connection with the client 
        try
        {
            serverSocket = new ServerSocket(2008, 10);
            
            connection = serverSocket.accept();
            
            out = new ObjectOutputStream(connection.getOutputStream());
            out.flush();
            
            in = new ObjectInputStream(connection.getInputStream());
            sendMessage("Connection successful");
            
                try
                {
                    message = (String)in.readObject();
                    System.out.println("client has sent this message : " + message);
                }
                catch(InvalidClassException ex)
                {
                	System.out.println("Improper input received");
                	ex.printStackTrace();
                }
                catch(ClassNotFoundException ex)
                {
                    ex.printStackTrace();
                }
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            try
            {
                in.close();
                out.close();
                serverSocket.close();
            }
            catch(IOException ioException)
            {
                ioException.printStackTrace();
            }
        }
    }
    
    /**
     * Used to sends the test message to see if connection is successful.
     * @param msg The message to be sent
     */
    private void sendMessage(String msg)
    {
        try
        {
            out.writeObject(msg);
            out.flush();
            System.out.println("Server sent this for testing : " + msg);
        }
        catch(IOException ioException){
            ioException.printStackTrace();
        }
    }
    
    public static void main(String args[])
    {
        Server server = new Server();
        while(true)
        {
            server.start();
        }
    }
}