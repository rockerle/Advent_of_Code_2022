package day07.util;

import java.util.ArrayList;
import java.util.List;

public class Tree {
	
	private Node<Integer> root;
	
	public Tree() {
		root = new Node<Integer>(null,"/");
	}
	public void addNode(Node n) {
		root.addSubDir(n);
	}
	public Node<Integer> getRoot(){return root;}
	public void printTree() {
		root.printNode(0);
	}
	public List<Node> treeToList(){
		return treeToList(this.root);
	}
	private List<Node> treeToList(Node<Integer> n){
		List<Node> res = new ArrayList<>();
		res.add(n);
		n.getChildren().forEach(c->res.addAll(treeToList((Node<Integer>)c)));
		return res;
	}
}
