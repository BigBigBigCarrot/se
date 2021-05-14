package pers.david.se.tree.balanced_binary_tree;

import java.math.BigDecimal;

public class Node<T> implements Comparable{
	
	private T value;
	private Node<T> father;
	private Node<T> left;
	private Node<T> right;
	/**
	 * 节点层级，根节点层级为1
	 */
	private int level;
	/**
	 * 左子树深度、左分支的最深层级（相对于当前节点而言，没有左分支时值为0）
	 */
	private int leftDeepestLevel;
	/**
	 * 右子树深度、右分支的最深层级（相对于当前节点而言，没有右分支时值为0）
	 */
	private int rightDeepestLevel;
	
	public Node(){}
	public Node(T value){
		this.value=value;
	}
	public Node(T value, Node<T> left, Node<T>right){
		this.value=value;
		this.left=left;
		this.right=right;
	}
	
	/**
	 * 小于在父节点的在左，大于等于父节点的在右
	 * @return Node<T> :当连续插入形如321时返回3，或插入345时返回3
	 * (插入时可能对树进行调整，可能会改变根节点，tree根据add方法返回的节点判断根节点是否有变)没有调整时返回null
	 * @param node 要添加的节点
	 */
	public Node<T> add(Node<T> node){
		if(node.compareTo(this)==-1){//要添加的节点的值小于当前节点的值
			if(this.left!=null){//左子节点不为空
				return this.left.add(node);
			}else{//左子节点为空
				this.left=node;
				node.father=this;
				node.setLevel(this.level+1);//子节点的层级为当前节点层级+1
				
				Node<T> nodeReturned=null;
				
				/*
				//左子树深度为2(连续两个左子节点)，且右子树为0
				if(this.father!=null){
					if(this.father.right==null){//左子树深度为2(连续两个左子节点)，且右子树为0
						nodeReturned=this.father;
						if(this.father.getFather()==null){
							this.right=this.father;
							this.father.setLeft(null);
							this.father.setRight(null);
							this.father=null;
						}else{
							
						}
					}
				}
				*/
				
				//向上更新节点的子树深度
				this.setChildLevel(left,left.level);
				return nodeReturned;
			}
		}else{//要添加的节点的值大于等于当前节点的值
			if(this.right!=null){//左子节点不为空
				return this.right.add(node);
			}else{//左子节点为空
				this.right=node;
				node.father=this;
				node.setLevel(this.level+1);//子节点的层级为当前节点层级+1
				
				Node<T> nodeReturned=null;
				
				//右子树深度为2(连续两个右子节点)，且左子树深度为0
				if(this.father!=null){
					if(this.father.left==null){//右子树深度为2(连续两个右子节点)，且左子树深度为0
						nodeReturned=this.father;
						if(this.father.getFather()==null){
							
						}else{
							
						}
					}
				}
				
				//向上更新节点的子树深度
				this.setChildLevel(right,right.level);
				
				return nodeReturned;
			}
		}
	}
	
	/**
	 * 
	 * @param node 直接子节点(新插入节点所在的子树对于当前节点来说的儿子节点)
	 * @param latestLevel 新插入节点的层级
	 */
	public void setChildLevel(Node node,int latestLevel){
		if(node==this.left){//来自左子树
			if(this.leftDeepestLevel<latestLevel-this.level){//方便理解，可后续优化
				this.leftDeepestLevel=latestLevel-this.level;//方便理解，可后续优化
			}else{
				return;
			}
		}else{//来自右子树
			if(this.rightDeepestLevel<latestLevel-this.level){//方便理解，可后续优化
				this.rightDeepestLevel=latestLevel-this.level;//方便理解，可后续优化
			}else{
				return;
			}
		}
		
		if(this.father!=null){
			father.setChildLevel(this, latestLevel);
		}
	}
	
	public Node<T> popMin(){
		Node<T> minNode=null;
		if(this.left==null){//没有左子节点
			minNode=this;
			//System.out.println("当前弹出的节点的值为："+minNode.getValue());
			if(minNode.father!=null){
				if(minNode.right==null){//没有右子节点
					minNode.father.setLeft(null);
					//System.out.println("当前弹出的节点没有右子节点，设置弹出节点的父节点的左子节点为null,父节点的值为:"+minNode.getFather().getValue());
				}else{//有右子节点
					this.father.setLeft(this.right);
					this.right.setFather(this.father);
					this.right.setLevel(this.level);//右子节点替代当前节点，改右子节点的层级为当前节点的层级值
					//System.out.println("当前弹出的节点有右子节点");
				}
			}
		}else{//有左子节点
			minNode=this.left.popMin();
		}
		return minNode;
	}
	
	public Node<T> popMax(){
		Node<T> maxNode=null;
		if(this.right==null){//没有右子节点
			maxNode=this;
			//System.out.println("当前弹出的节点的值为："+maxNode.getValue());
			if(maxNode.father!=null){
				if(maxNode.left==null){//没有左子节点
					maxNode.father.setRight(null);
					//System.out.println("当前弹出的节点没有左子节点，设置弹出节点的父节点的右子节点为null,父节点的值为:"+maxNode.getFather().getValue());
				}else{//有左子节点
					this.father.setRight(this.left);
					this.left.setFather(this.father);
					this.left.setLevel(this.level);//左子节点替代当前节点，改左子节点的层级为当前节点的层级值
					//System.out.println("当前弹出的节点有右子节点");
				}
			}
		}else{//有右子节点
			maxNode=this.right.popMax();
		}
		return maxNode;
	}
	
	public void resetLevel(){
		if(father!=null){
			this.level=father.getLevel()+1;
		}else{
			this.level=1;
		}
		
		if(this.left!=null){
			left.resetLevel();
		}
		if(this.right!=null){
			right.resetLevel();
		}
	}
	
	
	
	//getters and setters
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	
	public Node<T> getLeft() {
		return left;
	}
	public void setLeft(Node<T> left) {
		this.left = left;
	}
	
	public Node<T> getRight() {
		return right;
	}
	public void setRight(Node<T> right) {
		this.right = right;
	}
	
	public Node<T> getFather() {
		return father;
	}
	public void setFather(Node<T> father) {
		this.father = father;
	}
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	public int getLeftDeepestLevel() {
		return leftDeepestLevel;
	}
	public void setLeftDeepestLevel(int leftDeepestLevel) {
		this.leftDeepestLevel = leftDeepestLevel;
	}
	public int getRightDeepestLevel() {
		return rightDeepestLevel;
	}
	public void setRightDeepestLevel(int rightDeepestLevel) {
		this.rightDeepestLevel = rightDeepestLevel;
	}
	
	/**
	 * 1.compareTo(2) return -1
	 * 1.compareTo(1) return 0
	 * 1.compareTo(0) return 1
	 */
	public int compareTo(Object obj) {
		Node<T> node=(Node<T>)obj;
		Object comparedValue=node.getValue();
		if(value.getClass().equals(Integer.class)){
			return ((Integer)value).compareTo((Integer)comparedValue);
		}
		if(value.getClass().equals(Long.class)){
			return ((Long)value).compareTo((Long)comparedValue);
		}
		if(value.getClass().equals(Double.class)){
			return ((Double)value).compareTo((Double)comparedValue);
		}
		if(value.getClass().equals(BigDecimal.class)){
			return ((BigDecimal)value).compareTo((BigDecimal)comparedValue);
		}
		return -2;
	}
	
	/*
	public static void main(String[] args) {
		Node<BigDecimal> root=new Node<BigDecimal>();
		root.setValue(new BigDecimal(1.0));
		
		Node<BigDecimal> node1=new Node<BigDecimal>();
		node1.setValue(new BigDecimal(0.99));
		
		Node<BigDecimal> node2=new Node<BigDecimal>();
		node2.setValue(new BigDecimal(1.2));
		
		Node<BigDecimal> node3=new Node<BigDecimal>();
		node3.setValue(new BigDecimal(1.3));
		
		root.add(node1);
		root.add(node2);
		root.add(node3);
		
		System.out.println(root.getLeft());
		System.out.println(root.getRight());
		System.out.println(root.getRight().getRight());
		
	}
	*/
	
	
}
