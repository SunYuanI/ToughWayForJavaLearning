package algorithm;

public class AVLTree<AnyType extends Comparable<?super AnyType>> {
	private class BinaryNode<AnyType>{
		AnyType element;
		BinaryNode<AnyType> left;
		BinaryNode<AnyType> right;
		BinaryNode(AnyType element) {
			this(element,null,null);
		}
		BinaryNode(AnyType element,BinaryNode<AnyType>left,BinaryNode<AnyType>right) {
			this.element=element;
			this.left=left;
			this.right=right;
		}
	}
	
	
	private BinaryNode<AnyType> root;
	
	
	public AVLTree() {
		root=null;
	}
	
	
	public boolean contains(AnyType element) {
		return contains(element,root);
	}
	
	private boolean contains(AnyType element,BinaryNode<AnyType> node) {
		if(node==null) {
			return false;
		}
		if(element.compareTo(node.element)<0) {
			return contains(element,node.left);
		}else {
			if(element.compareTo(node.element)>0) {
				return contains(element,node.right);
			}else {
				return true;
			}
		}
	}
	
	
	public BinaryNode<AnyType> findmin(){
		return findmin(root);
	}
	
	private BinaryNode<AnyType> findmin(BinaryNode<AnyType> node){
		if(node==null) {
			return null;
		}else {
			return node.left==null? node:findmin(node.left);
		}
	}
	public BinaryNode<AnyType> findmax(){
		return findmax(root);
	}
	private BinaryNode<AnyType> findmax(BinaryNode<AnyType> node){
		if(node==null) {
			return null;
		}else {
			return node.right!=null? findmax(node.right):node;
		}
	}
	
	
	public void insert(AnyType element){
		root=insert(element, root);
	}
	
	public void insert(AnyType elements[]) {
		for(int i=0;i<elements.length;i++) {
			insert(elements[i]);
		}
	}
	
	private BinaryNode<AnyType> insert(AnyType element,BinaryNode<AnyType> node){
		if(node==null) {
			node=new BinaryNode<AnyType>(element);
			return node;
		}
		if(element.compareTo(node.element)<0) {
			node.left=insert(element, node.left);
		}else {
			if(element.compareTo(node.element)>0) {
				node.right=insert(element,node.right);
			}
		}
		return balance(node);
	}
	
	
	private BinaryNode<AnyType> balance(BinaryNode<AnyType> node){
		if(node==null) {
			return node;
		}
		if(height(node.left)-height(node.right)>1) {
			if(height(node.left.left)>=height(node.left.right)) {
				return RotateRight(node);
			}else {
				return RotateLeftRight(node);
			}
		}else {
			if(height(node.right)-height(node.left)>1) {
				if(height(node.right.right)>=height(node.right.left)) {
					return RotateLeft(node);
				}else {
					return RotateRightLeft(node);
				}
				
			}else {
				return node;
			}
		}
	}
	
	
	private BinaryNode<AnyType> RotateRight(BinaryNode<AnyType> node){
		BinaryNode<AnyType> temp=new BinaryNode<AnyType>(node.element);
		temp.right=node.right;
		temp.left=node.left.right;
		node.right=temp;
		node.element=node.left.element;
		node.left=node.left.left;
		return node;
	}
	
	private BinaryNode<AnyType> RotateLeft(BinaryNode<AnyType> node){
		BinaryNode<AnyType> temp=new BinaryNode<AnyType>(node.element);
		temp.left=node.left;
		temp.right=node.right.left;
		node.left=temp;
		node.element=node.right.element;
		node.right=node.right.right;
		return node;
	}
	
	private BinaryNode<AnyType> RotateLeftRight(BinaryNode<AnyType> node){
		node.left=RotateLeft(node.left);
		return RotateRight(node);
	}
	
	private BinaryNode<AnyType> RotateRightLeft(BinaryNode<AnyType> node){
		node.right=RotateRight(node.right);
		return RotateLeft(node);
	}
	private int height(BinaryNode<AnyType> node) {
		if(node==null) {
			return -1;
		}else {
			return 1+Math.max(height(node.left),height(node.right));
		}
	}
	
	
	public BinaryNode<AnyType> remove (AnyType element){
		return remove(element,root);
	}
	
	private BinaryNode<AnyType> remove(AnyType element,BinaryNode<AnyType> node){
		if(node==null) {
			return node;
		}
		if(element.compareTo(node.element)<0) {
			return remove(element,node.left);
		}else {
			if(element.compareTo(node.element)>0) {
				return remove(element,node.right);
			}else {
				if(node.left!=null&&node.right!=null) {
					AnyType temp=findmin(node.right).element;
					remove(temp);
					node.element=temp;
				}else {
					if(node.left!=null) {
						node.element=node.left.element;
						node.left=null;
					}else {
						if(node.right!=null) {
							node.element=node.right.element;
							node.right=null;
						}else {
							node.element=null;
							node=null;
						}
						
					}
				}
			}
		}
		return balance(node);
	}
	
	public boolean isEmpty() {
		return root==null;
	}
	
	public void printTree() {
		if(isEmpty()) {
			System.out.println("tree is empty.");
		}else {
			printTree(root);
		}
	}
	
	private void printTree(BinaryNode<AnyType> node) {
		if(node!=null&&node.element!=null) {
			printTree(node.left);
			System.out.println(node.element);
			printTree(node.right);
		}
	}

	public static void main(String[] args) {
		AVLTree<Integer> test=new AVLTree<>();
		Integer []a= {1,2,3,4,5,6,7};
		test.insert(a);
		test.printTree();
		test.remove(4);
		System.out.println("<------->");
		test.printTree();
		test.insert(4);
		System.out.println("<------->");
		test.printTree();
	}

}
