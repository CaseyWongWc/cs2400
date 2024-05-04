package project11hashing;


class Entry<S extends Comparable<? super S>, T> 
           implements Comparable<Entry<S, T>>
   {
      private S key;
      private T value;

      private Entry(S searchKey, T dataValue)
      {
         key = searchKey;
         value = dataValue;
      } // end constructor

      public int compareTo(Entry<S, T> other)
      {
         return key.compareTo(other.key);
      } // end compareTo

    public S getKey() {
        return key;
    }

    // public void setKey(S key) {
    //     this.key = key;
    // }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    
/*   The class Entry also defines the methods equals, toString, getKey, getValue,
     and setValue; no setKey method is provided. 
   . . . */
    
   

   } // end Entry