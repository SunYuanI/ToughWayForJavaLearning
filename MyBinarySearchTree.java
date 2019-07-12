package algorithm;
public class MyBinarySearchTree<AnyType extends Comparable<?super AnyType>> {
	
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
	
	
	public MyBinarySearchTree() {
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
			return node;
		}else {
			return findmin(node.left);
		}
	}
	public BinaryNode<AnyType> findmax(){
		return findmax(root);
	}
	private BinaryNode<AnyType> findmax(BinaryNode<AnyType> node){
		if(node==null) {
			return node;
		}else {
			return findmax(node.right);
		}
	}
	
	
	public void insert(AnyType element){
		root=insert(element, root);
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
		return node;
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
					node=remove(findmin(node.right).element);
				}else {
					node=(node.left!=null)? node.left:node.right;
				}
			}
		}
		return node;
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
		if(node!=null) {
			printTree(node.left);
			System.out.println(node.element);
			printTree(node.right);
		}
	}
	public static void main(String[] args) {
		MyBinarySearchTree<Integer> test=new MyBinarySearchTree<>();
		test.insert(4);
		test.insert(2);
		test.insert(1);
		test.insert(3);
		test.insert(6);
		test.insert(5);
		test.insert(7);
		test.printTree();

	}

}
