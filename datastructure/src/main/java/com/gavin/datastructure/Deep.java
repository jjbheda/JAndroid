package com.gavin.datastructure;

public class Deep {

    public int findDeep(BinaryTree binaryTree) {

        if (binaryTree == null)
            return 0;


        int dLeftChild = findDeep(binaryTree.left);
        int dRightChild = findDeep(binaryTree.right);

        return dLeftChild > dRightChild ? dLeftChild + 1 : dRightChild + 1;

    }
}
