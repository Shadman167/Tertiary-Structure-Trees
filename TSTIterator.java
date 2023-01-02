import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

class TSTIterator<T extends Comparable<T>> implements Iterator<T> {
    // TODO: implement the iterator class here
    // add your own helper methods if necessary

    int curr = 1;
    List<T> array1 = new ArrayList<>();
    
    public TSTIterator(TSTNode<T> root){

        inorder(root);
    }



    List<T> inorder(TSTNode root){


        if(root != null){

            inorder(root.left);
            array1.add((T) root.element);
            inorder(root.mid);
            inorder(root.right);

            //return array1;


            
        }

        return array1;

        
        /*
        else{

            preorder(root.left);
            array1.add((T) root.element);
            preorder(root.mid);
            preorder(root.right);
        }

         */



    }




    
    /**
     * Returns {@code true} if the iteration has more elements. (In other words, returns {@code true} if {@link #next}
     * would return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     */
    @Override
    public boolean hasNext() {


        //if (array1.size() == 0){
            
            //return false;
        //}
        
        //if(curr >= this.array1.size()){
            
            //return true;
        //}
        
        //return false;
        /*{
        
        for (int i = 0; i < array1.size(); i++) {

            if (array1.get(i) == null) {

                curr++;

        }

         */

        //return !(curr == array1.size());
        
        return curr <= array1.size();

    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     *
     * @throwsNoSuchElementException
     *         if the iteration has no more elements
     */
    @Override
    public T next() {



        T object1 = array1.get(curr - 1);

        curr++;

        return object1;
        /*
        for (int j = 0; j < array1.size(); j++) {


            if (hasNext()) {

                curr++;
            }

            else {

                return null;
            }
        }

        return null;
        
        
         */



    }
}