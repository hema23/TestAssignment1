package com.mediafire.problem3.multithreading;

/**
 * Write a program that is comprised of two threads. Both threads contain a loop
 * that attempts to increment the same global integer as many times as possible.
 * Both threads run for five seconds and then terminate. Use a mutex to prevent
 * both threads from simultaneously incrementing the global integer.
 * 
 * @author Hemaanjana
 * 
 */
public class MultiThreadingProblem
{
	/** Common variable that two threads try to increment.**/
    public static Integer common_value = 0;

    /**
     * Thread class that has run method to increment the global integer.
     * 
     * @author Hemaanjana
     */
    static class ExampleThread extends Thread
    {
    	/** Name of the thread **/
        String name;

        public ExampleThread(String name)
        {
            System.out.println("Creating thread with name " + name);

            this.name = name;
        }

        @Override
        public void run()
        {

            while (true)
            {
                synchronized (common_value)
                {
                    common_value = common_value + 1;
                    System.out.println(name);
                    System.out.println(common_value);
                }
            }
        }

    }

    public static void main(String args[]) throws InterruptedException
    {
    	//Creates two threads and starts them.
        ExampleThread thread1 = new ExampleThread("Thread1");
        ExampleThread thread2 = new ExampleThread("Thread2");

        thread1.start();

        Thread.sleep(4000);

        thread2.start();
    }

}

