public class TreeNode<T> {
	
	protected T data;
	protected TreeNode<T> leftChild;
	protected TreeNode<T> rightChild;
	/**
	 * Constructor
	 * @param dataNode the data to be stored n the TreeNode
	 */
	public TreeNode(T dataNode)
	{
		data = dataNode;
		leftChild = null;
		rightChild = null;
	}
	/**
	 * used for making deep copies 
	 * @param node
	 */
	public TreeNode(TreeNode<T> node)
	{
		new TreeNode<T> (node);
	}
	/**
	 * @return data within TreeNode
	 */
	public T getData()
	{
		return data;
	}
}
