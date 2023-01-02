

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;


public class TST<T extends Comparable<T>> implements Iterable<T>{
    // root node of the tree
    TSTNode<T> root;
    //List<T> array2 = new ArrayList<>();

    TST<Integer> tree;
    



    // constructor
    public TST() {
        this.root = null;
    }

    // TODO: implement the tree class here

    public void insert(T element){

        if (root == null){

            root = new TSTNode<>(element);
        }
        else{

            this.root.add(element);
        }


    }




    public void remove(T element){




        root = deleteNode(root, element);
        
    }

    TSTNode<T> deleteNode(TSTNode<T> root, T element) {


        if (root == null) {

            return null;
        } else if (element.compareTo(root.element) < 0) {


            root.left = deleteNode(root.left, element);
        } else if (element.compareTo(root.element) > 0) {

            root.right = deleteNode(root.right, element);
        } else {

            if ((root.mid == null) && (root.left == null)) {

                root = root.right;
            } else if ((root.mid == null) && (root.right == null)) {

                root = root.left;

            } else if ((root.left == null) && (root.right == null)) {

                root = root.mid;
            } else if (root.left == null) {
                root.element = root.right.findMin().element;
                root.right = deleteNode(root.right, root.element);
            } else if (root.right == null) {

                root.element = root.right.findMin().element;
                root.right = deleteNode(root.right, root.element);
            } else {

                root.element = root.right.findMin().element;
                root.right = deleteNode(root.mid, root.element);
            }
        }


        return root;
    }




    public boolean contains(T element){

        if (root == null){

            return false;
        }

        else {

            return this.root.find(element);
        }

    }


    public List<T> inorder(TSTNode<T> root, List<T> array2){

        if (root != null) {

            inorder(root.left, array2);
            array2.add((T) root.element);
            inorder(root.mid, array2);
            inorder(root.right, array2);
            return array2;
        }

        return null;



    }








    public void rebalance() {



        ArrayList<T> list1 = new ArrayList<T>();
        this.inorder(this.root, list1);
        root = null;
        rebalanceHelp(list1);

    }


    public void rebalanceHelp(List<T> list){


        //if (list.size() < 1){

            //return;
        //}

        int mid1 = list.size()/2;
        T temp = list.get(mid1);
        insert(temp);

        ArrayList<T> helpList = new ArrayList<>();
        ArrayList<T> helpList1 = new ArrayList<>();
        //List<T> helpList = list.subList(0, mid1);
        //List<T> helpList1 = list.subList(mid1+1, list.size()-1);

        //rebalanceHelp(helpList);
        //rebalanceHelp(helpList1);





        for(int i = 0; i <= mid1-1; i++) {

            //if (list.get(mid1).compareTo(list.get(i)) == 0){

            //helpList2.add(list.get(i));
            //}
            /*
            else if(list.get(mid1).compareTo(list.get(i)) < 0) {

                helpList.add(list.get(i));
                insert(list.get(i));
            }


             */


            helpList.add(list.get(i));
            //insert(list.get(i));


            //}

            for (int j = mid1 + 1; j <= list.size() - 1; j++) {

            /*
            if (list.get(mid1).compareTo(list.get(j)) == 0){

                helpList2.add(list.get(j));
            }

            else if(list.get(mid1).compareTo(list.get(j)) > 0){

                helpList1.add(list.get(j));
            }


             *

             /
             */

                helpList1.add(list.get(j));
                //insert(list.get(j));
            }
        }



        if (helpList.size() != 0){

            rebalanceHelp(helpList);
        }

        else if(helpList1.size() != 0){

            rebalanceHelp(helpList1);
        }

        //else if(helpList2.size() != 0){

            //rebalanceHelp(helpList2);
        //}





    }




    // add your own helper methods if necessary

    
    /**
     * Caculate the height of the tree.
     * You need to implement the height() method in the TSTNode class.
     *
     * @return -1 if the tree is empty otherwise the height of the root node
     */
    public int height(){
        if (this.root == null)
            return -1;
        return this.root.height();
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator iterator() {
        // TODO: implement the iterator method here
        return new TSTIterator(this.root);


    }



    // --------------------PROVIDED METHODS--------------------
    // The code below is provided to you as a simple way to visualize the tree
    // This string representation of the tree mimics the 'tree' command in unix
    // with the first child being the left child, the second being the middle child, and the last being the right child.
    // The left child is connect by ~~, the middle child by -- and the right child by __.
    // e.g. consider the following tree
    //               5
    //            /  |  \
    //         2     5    9
    //                   /
    //                  8
    // the tree will be printed as
    // 5
    // |~~ 2
    // |   |~~ null
    // |   |-- null
    // |   |__ null
    // |-- 5
    // |   |~~ null
    // |   |-- null
    // |   |__ null
    // |__ 9
    //     |~~ 8
    //     |   |~~ null
    //     |   |-- null
    //     |   |__ null
    //     |-- null
    //     |__ null
    @Override
    public String toString() {
        if (this.root == null)
            return "empty tree";
        // creates a buffer of 100 characters for the string representation
        StringBuilder buffer = new StringBuilder(100);
        // build the string
        stringfy(buffer, this.root,"", "");
        return buffer.toString();
    }

    /**
     * Build a string representation of the tertiary tree.
     * @param buffer String buffer
     * @param node Root node
     * @param nodePrefix The string prefix to add before the node's data (connection line from the parent)
     * @param childrenPrefix The string prefix for the children nodes (connection line to the children)
     */
    private void stringfy(StringBuilder buffer, TSTNode<T> node, String nodePrefix, String childrenPrefix) {
        buffer.append(nodePrefix);
        buffer.append(node.element);
        buffer.append('\n');
        if (node.left != null)
            stringfy(buffer, node.left,childrenPrefix + "|~~ ", childrenPrefix + "|   ");
        else
            buffer.append(childrenPrefix + "|~~ null\n");
        if (node.mid != null)
            stringfy(buffer, node.mid,childrenPrefix + "|-- ", childrenPrefix + "|   ");
        else
            buffer.append(childrenPrefix + "|-- null\n");
        if (node.right != null)
            stringfy(buffer, node.right,childrenPrefix + "|__ ", childrenPrefix + "    ");
        else
            buffer.append(childrenPrefix + "|__ null\n");
    }

    /**
     * Print out the tree as a list using an enhanced for loop.
     * Since the Iterator performs an inorder traversal, the printed list will also be inorder.
     */
    public void inorderPrintAsList(){
        String buffer = "[";
        for (T element: this) {
            buffer += element + ", ";
        }
        int len = buffer.length();
        if (len > 1)
            buffer = buffer.substring(0,len-2);
        buffer += "]";
        System.out.println(buffer);
    }


    


}