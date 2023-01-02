

import java.util.Iterator;

class TSTNode<T extends Comparable<T>>{
    T element;     	            // The data in the node
    TSTNode<T>  left;   		// left child
    TSTNode<T>  mid;   		    // middle child
    TSTNode<T>  right;          //right child


    // TODO: implement the node class here




    TSTNode(T element){

        this.element = element;


    }


    void add(T element){


        if (this.element.compareTo(element) > 0){

            if (this.left == null) {
                this.left = new TSTNode<>(element);
            }

            else {

                this.left.add(element);
            }
        }



        else if(this.element.compareTo(element) < 0){

             if(this.right == null) {

                 this.right = new TSTNode<>(element);
             }
             else {

                 this.right.add(element);
             }

        }



        else if(this.element.compareTo(element) == 0){

            if(this.mid == null){

                this.mid = new TSTNode<>(element);
            }

            else {

                this.mid.add(element);
            }

        }

    }


    boolean find(T element){


        if (this.element.compareTo(element) == 0){

            return true;
        }


        else if (this.element.compareTo(element) > 0){

            if (this.left == null){

                return false;
            }
            else {
                return this.left.find(element);
            }


        }



        else if (this.element.compareTo(element) < 0){

            if (this.right == null){

                return false;
            }

            else {

                return this.right.find(element);
            }
        }



        else{

            return false;
        }

    }



    TSTNode<T> findMax(){


        if (this.right != null){

            return this.right.findMax();
        }

        else{

            return this;
        }
    }

    TSTNode<T> findMin(){


        if (this.left != null){

            return this.left.findMin();
        }

        else{

            return this;
        }
    }

    int height() {

        int get_height_left = -1;
        int get_height_right = -1;
        int get_height_mid = -1;

        if (this.mid == null && this.left == null && this.right == null) {

            return 0;
        }

        else{



            if (this.right != null){

                get_height_right = this.right.height();
            }

            else if(this.left != null){

                get_height_left = this.left.height();
            }

            else{

                get_height_mid = this.mid.height();
            }

            //return Math.max(get_height_mid, Math.max(get_height_left, get_height_right)) + 1;
        }

        return Math.max(get_height_mid, Math.max(get_height_left, get_height_right)) + 1;

    }






}