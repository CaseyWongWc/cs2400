package Aexceptions;

public class EmptyQueueException extends Exception 
{
    public EmptyQueueException() 
    {
        super("Queue is empty.");
    }

    public EmptyQueueException(String message) 
    {
        super(message);
    }
}

