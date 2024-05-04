package project9graphs;
import java.util.Iterator;
import project0semisterlongproject.Listinterface;

public interface ListWithIteratorInterface<T> extends Listinterface<T>, Iterable<T>
{
   public Iterator<T> getIterator();
} 
