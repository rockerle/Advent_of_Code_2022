package day07;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import day07.util.Node;
import day07.util.Tree;

public class Part1 {

	private static Tree directories ;
	private static Node<Integer> currentNode;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(Scanner s= new Scanner(new FileInputStream("src/day07/Input.txt"))){
			while(s.hasNext()){
				String[] line = s.nextLine().split(" ");
				//System.out.println("current line length: "+line.length);
				if(line.length==2) {
					eval2long(line);
				}else if(line.length==3) {
					eval3long(line);
				}else {
					System.out.println("No valid option for input line found!");
				}
			}
		}catch(Exception e) {
			System.out.print(e.getMessage());
		}
		List<Node> folders = directories.treeToList();
		AtomicInteger count = new AtomicInteger(0);
		folders.forEach(f->{
			if(f.getDirSize()<=100000)
				count.getAndAdd(f.getDirSize());
		});
		System.out.println("Size of all folders with at most 100k data: "+count.get());
	}
	private static void eval3long(String[] s) {
		if(s[1].equals("cd") && s[2].equals("..")){
			currentNode = currentNode.getParent();
		}else if(s[1].equals("cd") && s[2].equals("/")) {
			directories = new Tree();
			currentNode = directories.getRoot();
		}else if(s[1].equals("cd") && !s[2].equals("..")) {
			Node<Integer> newNode = new Node<Integer>(currentNode,s[2]);
			currentNode.addSubDir(newNode);
			currentNode = newNode;
		} 
	}
	private static void eval2long(String[] s) {
		if(s[1].equals("ls") || s[0].equals("dir"))
			return;
		else{
			try {
				int a = Integer.parseInt(s[0]);
				currentNode.addFile(a);
			}catch(NumberFormatException e) {
				return;
			}
		}
	}
	private static List<Node> treeToList(Node<Integer> n){
		List<Node> res = new ArrayList<>();
		res.add(n);
		n.getChildren().forEach(c->res.addAll(treeToList((Node<Integer>)c)));
		return res;
	}
}
