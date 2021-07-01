/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GearVn
 */

public class BinaryTreeNode {
      Product infor;
    BinaryTreeNode left, right;
    int height;

    public BinaryTreeNode() {
    }

    BinaryTreeNode(Product infor){
        this.infor = infor;
        left = right = null;
        height=0;
    }
}
