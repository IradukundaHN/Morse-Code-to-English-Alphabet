import java.util.ArrayList;

/**
 * generic linked binary tree which inherits from the LinkedConverterTreeInterface
 * Implements the LinkedConverterTreeInterface
 * Creates and builds the MorseCodeTree
 * Uses recursive method to add a node to the tree
 * Uses recursive method to fetch a node from the tree
 *
 */
public class MorseCodeTree implements LinkedConverterTreeInterface{

	private TreeNode<String> root;
	
	/**
	 * Constructor that builds the tree
	 */
	public MorseCodeTree()
	{
		buildTree();
	}
	/**
	 * Method that returns a reference to the root
	 */
	@Override
	public TreeNode getRoot() {
		return this.root;
	}
	
	/**
	 * method that sets the root of the MorseCodeTree
	 * copy of newNode become the new root
	 */
	@Override
	public void setRoot(TreeNode newNode) {
	
		root = newNode;
	}

	/**
	 * Recursive method which adds element to the correct position in the tree based on the code
	 * A ‘.’ (dot) means to traverse left 
	 * a ‘-‘ (dash) means to traverse right
	 * The code ".-" would be stored as the right child of the left child of the root
	 * Algorithm for the recursive method:
	 *  1. if there is only one character 
	 *  a. if the character is '.' (dot) store to the left of the current root 
	 *  b. if the character is "-" (dash) store to the right of the current root 
	 *  c. return 
	 *  2. if there is more than one character 
	 *  a. if the first character is "." (dot) new root becomes the left child 
	 *  b. if the first character is "-" (dash) new root becomes the right child 
	 *  c. new code becomes all the remaining characters in the code (beyond the first character)
	 *  d. call addNode(new root, new code, letter)
	 */
	public void addNode(TreeNode<String> root, String code, String letter) {
		
		if(code.length()==1)
		{
			if(code.equals("."))
			{
				root.leftChild = new TreeNode<String>(letter);
			}
			else
			{
				root.rightChild = new TreeNode<String>(letter);
			}
			return;
		}
		else
		{
			if(code.charAt(0)=='.')
			{
				addNode(root.leftChild,code.substring(1),letter);
			}
			else
			{
				addNode(root.rightChild,code.substring(1),letter);
			}
		}
	}

	/**
	 * adds element to the correct poosition in the tree based on the code
	 * Method call the recursive method addNode
	 * @param code
	 * @param result
	 * @return letter for the node to be added
	 */
	public MorseCodeTree insert(String code, String result) {
		
		if(root==null)
		{
			setRoot(new TreeNode<String>(result));
		}
		else
		{
			addNode(root,code,result);
		}
		return this;
	}
	
	/**
	 * recursive method that fetches the data of the TreeNode that corresponds with the code
	 * A '.' (dot) means traverse to the left.
	 * A "-" (dash) means traverse to the right. 
	 * The code ".-" would fetch the data of the TreeNode stored as the right child of the left child of the root 
	 * @param root
	 * @param code
	 * @return string corresponding to the code
	 */
	public String fetchNode(TreeNode<String> root, String code) {
	
		if(code.length()==1)
		{
			if(code.equals("."))
			{
				return root.leftChild.getData();
			}
			else
			{
				return root.rightChild.getData();
			}
		}
		else
		{
			if(code.charAt(0) == '.')
				return fetchNode(root.leftChild,code.substring(1));
			else
				return fetchNode(root.rightChild,code.substring(1));
		}
	}
	
	/**
	 * Fetch the data in the tree based on the code
	 * method that call the recursive method fetchNode 
	 */
	@Override
	public String fetch(String code) {
		
		return fetchNode(root,code);
	}

	/**
	 * recursive method to put the contents of the tree in an ArrayList in LNR (Inorder) 
	 */
	@Override
	public void LNRoutputTraversal(TreeNode root, ArrayList list) {
		
		if(root != null)
		{
	        LNRoutputTraversal(root.leftChild, list);
	       list.add(root.getData());
	        LNRoutputTraversal(root.rightChild, list);
	    }	
		
	}
	/**
	 * Method that returns an ArrayList of items in the linked Tree in LNR (Inorder) Traversal order Used for testing to make sure tree is built correctly 
	 */
	@Override
	public ArrayList toArrayList() {
		
		ArrayList<String> printTree = new ArrayList<String>();
		LNRoutputTraversal(root,printTree);
		
		return printTree;
	}
	
	/**
	 * method that builds the MorseCodeTree by inserting the nodes of the tree level by level based on the code. 
	 * level zero: TreeNode with "" (empty string); 
	 * level one: insert(".", "e"); insert("-", "t");
	 * level two: insert("..", "i"); insert(".-", "a"); insert("-.", "n"); insert("—", "m")
	 * Insert into the tree by tree level from left to right 
	 * A ‘.’ will take the branch to the left;
	 * a ‘-’ will take the branch to the right. 
	 */
	@Override
	public void buildTree() {
		//level zero
		root = new TreeNode<String>("");
		//level one
		insert(".","e");
		insert("-", "t");
		//level two
		insert("..","i");
		insert(".-","a");
		insert("-.","n");
		insert("--","m");
		//level three
		insert("...","s");
		insert("..-","u");
		insert(".-.","r");
		insert(".--","w");
		insert("-..","d");
		insert("-.-","k");
		insert("--.","g");
		insert("---","o");
		//level four
		insert("....","h");
		insert("...-","v");
		insert("..-.","f");
		insert(".-..","l");
		insert(".--.","p");
		insert(".---","j");
		insert("-...","b");
		insert("-..-","x");
		insert("-.-.","c");
		insert("-.--","y");
		insert("--..","z");
		insert("--.-","q");
	}

	@Override
	public LinkedConverterTreeInterface delete(Object data) throws UnsupportedOperationException {
		return null;
	}

	@Override
	public LinkedConverterTreeInterface update() throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedConverterTreeInterface insert(Object code, Object result) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addNode(TreeNode root, Object code, Object letter) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Object fetchNode(TreeNode root, Object code) {
		// TODO Auto-generated method stub
		return null;
	}
	public static String morseCompare(String code) {
		String englishAlphabet = "abcdefghijklmnopqrstuvwxy z";
		String morseAlphabet[] = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-", "..-","...-",".--","-..-","-.--","/","--.."};

		String[] line = code.split(" ");
		String word ="";
		String element = "";
		for(int i=0; i<line.length;i++)
		{
			element = line[i];
			
			for(int j=0; j<morseAlphabet.length;j++)
			{
				if(element.equals(morseAlphabet[j]))
				{
					word += englishAlphabet.charAt(j);
				}
			}
		}
		return word;
	}

}