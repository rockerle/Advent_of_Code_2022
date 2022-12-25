package day07;

import java.io.FileInputStream;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import day07.util.Node;
import day07.util.Tree;

public class Part2 {

	private static Node<Integer> currentNode;
	private static Tree directories;
	private static final int maxMemory = 70000000;
	private static final int necesseryMem = 30000000;
	private static int toFree;
	
	public static void main(String[] args) {
		try(Scanner s= new Scanner(new FileInputStream("src/day07/Input.txt"))){
			while(s.hasNext()){
				String[] line = s.nextLine().split(" ");
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
		toFree = necesseryMem - (maxMemory - directories.getRoot().getDirSize());
		System.out.println("Looking for a folder that has minimum size of "+toFree);
		Collections.sort(folders);
		folders.forEach(n->{
			if(n.getDirSize()>=toFree) {
				System.out.println("===========================");
				System.out.println("Found folder "+n.getName() + " with size: "+n.getDirSize());
				System.out.println("===========================");
			}
		});
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
}
