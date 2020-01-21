package com.david.tree.binary_tree;

/**
* 二叉树的定义：或为空，或只有根节点，或有左子树和右子树（5种基本形态）
* 二叉树性质：
* 1、在二叉树的第i层上至多有2^(i-1)个结点（i>=1）
* 2、深度为k的二叉树至多有2^(k) - 1个结点（k>=1）
* 3、对于任何一颗二叉树，如果其终端结点数为n，度数为2的结点数为m，则n = m + 1
* 4、具有n个结点的完全二叉树的深度为k = floor(log2(n)) + 1
* 5、在含有n个结点的二叉链表中有n+1个空链域
*
*/
public class SimpleBinaryTree<T>{
	private Node<T> root;
	
	public SimpleBinaryTree(){}
	public SimpleBinaryTree(Node<T> root){
		this.root=root;
	}
	
	/**getter and setter*/
	public Node<T> getRoot() {
		return root;
	}
	
	public void setRoot(Node<T> root) {
		this.root = root;
	}
	
	/**先序递归遍历二叉树*/
	public void preOrderTraverse(){
		preOrderTraverse(root);
	}
	private void preOrderTraverse(Node<T> node) {
		if(node != null){
			System.out.println(node.getValue());
			preOrderTraverse(node.getLeft());
			preOrderTraverse(node.getRight());
		}
	}
	
	/**中序递归遍历二叉树*/
	public void inOrderTraverse(){
		inOrderTraverse(root);
	}
	private void inOrderTraverse(Node<T> node) {
		if(node != null){
			inOrderTraverse(node.getLeft());
			System.out.println(node.getValue());
			inOrderTraverse(node.getRight());
		}
	}
	
	/**后序递归遍历二叉树*/
	public void postOrderTraverse(){
		postOrderTraverse(root);
	}
	private void postOrderTraverse(Node<T> node) {
		if(node != null){
			postOrderTraverse(node.getLeft());
			postOrderTraverse(node.getRight());
			System.out.println(node.getValue());
		}
	}
	
	public static void main(String[] args){
		BinaryTree<String> bt = new BinaryTree<String>();
		Node<String> root=new Node<String>("a",null,null);
		bt.setRoot(root);
		root.setLeft(new Node<String>("b",null,null));
		root.setRight(new Node<String>("c",null,null));
		root.getLeft().setLeft(new Node<String>("d",null,null));
		root.getLeft().setRight(new Node<String>("e",null,null));
		//bt.preOrderTraverse();
		//bt.inOrderTraverse();
		bt.postOrderTraverse();
	}
}
