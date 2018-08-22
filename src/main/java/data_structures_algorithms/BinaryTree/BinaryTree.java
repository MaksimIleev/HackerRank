package data_structures_algorithms.BinaryTree;

public class BinaryTree {

    Node root;

    /*
    *  Add new Node
    * */
    public void add(int key) {
        Node newNode = new Node(key);
        if(root == null) {
            root = newNode;
        } else {

            Node parent;
            Node focusNode = root;

            while(true) {
                parent = focusNode;

                if(key < focusNode.key) {

                    focusNode = focusNode.leftChild;

                    if(focusNode == null) {

                        parent.leftChild = newNode;
                        return;
                    }
                } else if(key > focusNode.key) {

                    focusNode = focusNode.rightChild;

                    if(focusNode == null) {

                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public Node find(int key) {
        Node focusNode = root;

        if(key < focusNode.key) {

            focusNode = focusNode.leftChild;

        } else {

            focusNode = focusNode.rightChild;
        }

        if(focusNode == null) {
            return null;
        }

        return focusNode;
    }

    public boolean delete(int key) {
        // start from hte root
        Node focusNode = root;
        Node parent = root;

        boolean isItLeftChild = false;

        // search the node
        while(key != focusNode.key) {

            // parent becomes focused node
            parent = focusNode;

            // focus to the left
            if(key < focusNode.key) {

                focusNode = focusNode.leftChild;
                isItLeftChild = true;

               // focus to the right
            } else {

                focusNode = focusNode.rightChild;
                isItLeftChild = false;
            }

            // if not found
            if(focusNode == null) return false;
        }

        /*
        *  If NO children -> e.g 2
        *         8
        *       /  \
        *      4   12
        *     /
        *    2
        * */
        if(focusNode.leftChild == null && focusNode.rightChild == null) {

            // if it's root -> delete it
            if(focusNode == root) root = null;

            if(isItLeftChild) {
                // e.g 2
                parent.leftChild = null;

            } else {
                // .e.g 12
                parent.rightChild = null;
            }
        /*
         *  If NO right child -> e.g 4
         *         8
         *       /  \
         *      4   12
         *     /   /
         *    2   11
         * */
        } else if(focusNode.rightChild == null) {

            if(focusNode == root) root = focusNode.leftChild;

            if(isItLeftChild) {
                // e.g 4
                parent.leftChild = focusNode.leftChild;

            } else {
                // e.g 12
                parent.rightChild = focusNode.leftChild;
            }
        /*
         *  If NO left child only -> e.g 4 or 12
         *         8
         *       /  \
         *      4   12
         *      \     \
         *       6     14
         * */
        } else if(focusNode.leftChild == null) {

            if(focusNode == root) root = focusNode.rightChild;

            else if(isItLeftChild) {
                // e.g 4
                parent.leftChild = focusNode.rightChild;

            } else {
                // e.g 12
                parent.rightChild = focusNode.rightChild;
            }

        /*
         *  If both children present -> e.g 8, 4 or 12
         *         8
         *       /   \
         *      4    12
         *     / \   / \
         *    5  6  13 14
         * */
        } else {

            Node replacement = getReplacementNode(focusNode);

            // If the focusNode is root replace root
            // with the replacement

            if (focusNode == root)
                root = replacement;

                // If the deleted node was a left child
                // make the replacement the left child

            else if (isItLeftChild)
                parent.leftChild = replacement;

                // Vice versa if it was a right child

            else
                parent.rightChild = replacement;

            replacement.leftChild = focusNode.leftChild;

        }

        return true;
    }

    /*
     *  If both children present -> e.g 8, 4 or 12
     *         8
     *       /   \
     *      4    12
     *     / \   / \
     *    5  6  13 14
     * */
    public Node getReplacementNode(Node replacedNode) {

        // e.g replacedNode = 4
        Node replacementParent = replacedNode; //4
        Node replacement = replacedNode; //4

        Node focusNode = replacedNode.rightChild; //6

        // While there are no more left children

        while (focusNode != null) {

            replacementParent = replacement; //6

            replacement = focusNode;//6

            focusNode = focusNode.leftChild;//5

        }

        // If the replacement isn't the right child
        // move the replacement into the parents
        // leftChild slot and move the replaced nodes
        // right child into the replacements rightChild

        if (replacement != replacedNode.rightChild) { //12

            replacementParent.leftChild = replacement.rightChild;
            replacement.rightChild = replacedNode.rightChild;

        }

        return replacement;

    }


    public void inOrderTraverse(Node currentNode) {
        if(currentNode != null) {
            // traverse left node first
            inOrderTraverse(currentNode.leftChild);
            System.out.println(currentNode);

            // trverse right node
            inOrderTraverse(currentNode.rightChild);
        }
    }

    public void preOrderTraverse(Node currentNode) {
        if(currentNode != null) {
            System.out.println(currentNode);
            preOrderTraverse(currentNode.leftChild);
            preOrderTraverse(currentNode.rightChild);
        }
    }

    public void postOrderTraverse(Node currentNode) {
        if(currentNode != null) {
            preOrderTraverse(currentNode.leftChild);
            preOrderTraverse(currentNode.rightChild);
            System.out.println(currentNode);
        }
    }

    class Node {

        int key;
        Node leftChild = null;
        Node rightChild = null;

        public Node(int key) {
            this.key = key;
        }

        @Override
        public String toString() {
            return "parent key: " + key + " left: " + (leftChild != null? leftChild.key : -1) + " right:" + (rightChild != null? rightChild.key: -1);
        }
    }
}
