/**
    @author Matthew Yeung, Casey Wong
 */
package project1forme;


public interface BagInterface<T> 
{
/**
 * @param getCurrentSize returns the size of the Bag
 * @param isEmpty checks if the bag has zero elements
 * @param add  puts a specific generic datatype to the bag
 * @param remove removes unspecified entry from the bag
 * @param remove(TanEntry) removes a specified entry from the bag
 * @param clear empties the bag
 * @param getFrequencyOf counts for all instances in a Bag
 * @param contains sees if there is an entry in a bag
 * @param toArray turns things into an array
 * @param union see rough draft
 * @param intersection see rough draft
 * @param difference see rough draft
 * @return
 */
    public int getCurrentSize();
    public boolean isEmpty(); 
    public boolean add(T newEntry); 
    public T remove(); 
    public boolean remove(T anEntry); 
    public void clear();
    public int getFrequencyOf(T anEntry);
    public boolean contains (T anEntry);
    public T[] toArray(); 


    public BagInterface<T> union(BagInterface<T> anotherBag); //
    public BagInterface<T> intersection(BagInterface<T> anotherBag); // 
    public BagInterface<T> difference(BagInterface<T> anotherBag); //
}
