/**
    @author Matthew Yeung, Casey Wong
 */

package project1forme.roughdraft;
import java.util.ArrayList;


public class difference 
{
    //====================================================================================
    /**
     * @param array1 an array that contains string elements
     * @param array2 same as array1
     * @param arrayDif a string array that recieves elements coming from the method diff which takes both array1 and array2
     * @return a for loop with an integer counter prints the results of arrayDif for the size of arrayDif
    */
    //====================================================================================
    public static void main(String[] args) 
    {
        String[] array1 = { "a", "b", "c" };
        String[] array2 = { "b", "b", "d", "e" };
        String[] arrayDif = diff(array1,array2);

        for (int i=0; i < arrayDif.length;i++)
        {
            System.out.print(arrayDif[i]);
        }
    }
//====================================================================================
/**
 * difference first adds all the elements in arrayA and then removes duplicates in arrayB
 * @param arrayA this method takes in An array of strings. ArrayA will be added initially to listDif using the .add() method provided by  java.util.ArrayList
 * @param arrayB this method also takes in an array of strings. ArrayB's elements will be individually compared with  listDif's elements
 * @param listDif after taking things from arrayA, listDif will be compared to arrayB to remove singular instances of the same string elements for all elements in arrayB.
 * @return arrayDif will be returned after listDif is converted back into an array for easier printing using a for loop
 */
//====================================================================================
    public static String[] diff(String[] arrayA, String[] arrayB)
    {
        ArrayList<String> listDif = new ArrayList<>();

        for (int i=0; i < arrayA.length;i++)
        {
            listDif.add(arrayA[i]);
        }

        for (int i=0; i< arrayB.length;i++)
        {
            if (listDif.contains(arrayB[i]))
            {
                listDif.remove(arrayB[i]);
            }
        }

        String[] arrayDif = new String[listDif.size()];
        for (int i = 0; i < listDif.size(); i++) 
        {
          arrayDif[i] = listDif.get(i);
        }
        return arrayDif;
    }
    
}
