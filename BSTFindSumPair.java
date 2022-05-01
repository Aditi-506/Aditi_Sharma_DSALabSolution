/**
 * 
 */
package com.greatlearning.lab3;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Admin
 *
 */
public class BSTFindSumPair {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BSTFindSumPair bstFindSumPair = new BSTFindSumPair();
		Node rootNode = null;
		rootNode = bstFindSumPair.insert(rootNode, 40);
		rootNode = bstFindSumPair.insert(rootNode, 20);
		rootNode = bstFindSumPair.insert(rootNode, 60);
		rootNode = bstFindSumPair.insert(rootNode, 10);
		rootNode = bstFindSumPair.insert(rootNode, 30);
		rootNode = bstFindSumPair.insert(rootNode, 50);
		rootNode = bstFindSumPair.insert(rootNode, 70);
		int inputSum = 130;
		bstFindSumPair.findPairWithGivenSum(rootNode, inputSum);

	}

	static class Node {
		int nodeData;
		Node leftNode, rightNode;

	};

	static Node newNode(int nodeData) {
		Node tempNode = new Node();
		tempNode.nodeData = nodeData;
		tempNode.leftNode = null;
		tempNode.rightNode = null;

		return tempNode;

	}

	public Node insert(Node root, int key) {
		if (root == null) {
			return newNode(key);

		}

		if (key < root.nodeData) {
			root.leftNode = insert(root.leftNode, key);

		} else {
			root.rightNode = insert(root.rightNode, key);
		}
		return root;

	}

	public boolean findPair(Node root, int sum, Set<Integer> set) {
		if (root == null) {
			return false;

		}

		if (findPair(root.leftNode, sum, set)) {
			return true;
		}

		if (set.contains(sum - root.nodeData)) {
			System.out.println("\n Pair is found: (" + (sum - root.nodeData) + "," + root.nodeData + ")");
			return true;
		} else {
			set.add(root.nodeData);
		}
		return findPair(root.rightNode, sum, set);
	}

	public void findPairWithGivenSum(Node root, int sum) {
	Set<Integer> objHashSet = new HashSet<Integer>();

		if (!findPair(root, sum, objHashSet)) {
			System.out.println("\n Pair Doesnot Exist");

		}
	}
}
