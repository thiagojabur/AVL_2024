
public class AVL {
	Node root;

	public AVL(Node root) {
		this.root = root;
	}
	
	public void printPreOrder() {
		printPreOrder(this.root);
	}
	
	public void printPreOrder(Node root) {
		if (root == null)
			return;
		System.out.println(root.value);
		
		printPreOrder(root.getLeftNode());
		printPreOrder(root.getRightNode());
		
	}
	
	public void printPostOrder() {
		printPostOrder(this.root);
	}
	
	public void printPostOrder(Node root) {
		if (root == null)
			return;
		
		printPostOrder(root.getLeftNode());
		printPostOrder(root.getRightNode());
		System.out.println(root.value);
		
		
	}
	
	public void printInOrder() {
		printInOrder(this.root);
	}
	
	public void printBalanceamentFactors() {
		printBalanceamentFactors(this.root);
	}
	
	
	public void printInternals() {
		printInternals(this.root);
	}
	
	public void printInternals(Node root) {
		if (root == null)
			return;
		printInternals(root.getLeftNode());
		if (isInternal(root))
			System.out.println(root.value);
		
		printInternals(root.getRightNode());
	}
	
	private int calculateDepth(Node node) {
	    if (node == null) {
	        return 0;
	    }
	    // Calcula a profundidade da árvore
	    return 1 + Math.max(calculateDepth(node.leftNode), calculateDepth(node.rightNode));
	}
	
	public boolean isFullBinaryTree() {
		 int depth = calculateDepth(root); // Calcula a profundidade máxima da árvore
		 
		 return isFullBinaryTree(root, depth, 0);
	}
	
	public Node successor(Node node) {
		 if (node.rightNode != null)
		        return minValue(node.rightNode);
		 else {
		
			 Node succ = null;
			 Node auxRoot = root;
			 
			    // Inicia na raiz e procura por um sucessor de node
			    while (auxRoot != null) 
			    {
			        if (node.value < auxRoot.value) 
			        {
			            succ = auxRoot;
			            auxRoot = auxRoot.leftNode;
			        }
			        else if (node.value > auxRoot.value)
			        	auxRoot = auxRoot.rightNode;
			        else
			            break;
			    }
			    return succ;
			 
		 }
			 
	}
	
	//método para achar o menor valor de uma sub-arvore ordenada
	public Node minValue(Node node)
	{
	    Node current = node;

	     while (current.leftNode != null) 
	    {
	        current = current.leftNode;
	    }
	    return current;
	}
	
	
	public boolean isFullBinaryTree(Node root, int d, int level) {
		
	    if (root == null)
	      return true;

	    // checa a presença de folhas 
	    if (root.leftNode == null && root.rightNode == null) {
	    	return (d == level + 1);
	    }	

	    if (root.leftNode == null || root.rightNode == null) {
	      
	      return false;
	    }  

	    return isFullBinaryTree(root.leftNode, d, level + 1) && isFullBinaryTree(root.rightNode, d, level + 1);

	}
	
	public void insertNode(Node newNode) {
		insertNode(root,newNode);
	}	
	
	public void deleteNode(Node toDelete) {
		//TO-DO atualizar o BF
		
		if (toDelete == root) {
			System.out.println("Apagando a raiz");
			
			if (toDelete.degree() == 0) {
				root = null;
			}	
			//se tiver apenas um filho
			//a raiz passa a ser o filho

			if (toDelete.degree() == 1) {
				if (toDelete.rightNode == null) {
					root = toDelete.leftNode;
					toDelete.leftNode = null;
				} else { //o leftNode é null
					root = toDelete.rightNode;
					toDelete.rightNode = null;
				}

			}
			return;
		}
		//verificar os casos
		//toDelete não possui nenhum filho
		if (toDelete.leftNode == null && toDelete.rightNode == null) {
			System.out.println("Nenhum filho");
			
			//saber se o toDelete está a esq ou dir
			Node parent = getParent(toDelete); 
			if (parent.leftNode == toDelete )
				parent.leftNode = null;
			else 
				parent.rightNode = null;
			
			System.out.println("Nó removido: " + toDelete.value);
			return;
		}
		//toDelete possui apenas um filho
		if (toDelete.leftNode == null && toDelete.rightNode != null) {
			System.out.println("Apenas um filho e na direita cujo valor é " + toDelete.rightNode.value);	
			Node parent = getParent(toDelete); 
			
			//verificar se o toDelete está a esq ou a direita em relacao ao parent
			if (parent.leftNode == toDelete )
				parent.leftNode = toDelete.rightNode;
			else 
				parent.rightNode = toDelete.rightNode;
			
			System.out.println("Nó removido: " + toDelete.value);
			
			return;
		}
			else if (toDelete.leftNode != null && toDelete.rightNode == null){
			System.out.println("Apenas um filho e na esquerda cujo valor é " + toDelete.leftNode.value);
			Node parent = getParent(toDelete); 
			
			//verificar se o toDelete está a esq ou a direita em relacao ao parent
			if (parent.leftNode == toDelete )
				parent.leftNode = toDelete.leftNode;
			else 
				parent.rightNode = toDelete.leftNode;
				
			System.out.println("Nó removido: " + toDelete.value);
	
		
		} else 
		{
			System.out.println("Tem dois filhos");
			
			Node successorNode = successor(toDelete);
			System.out.println("Sucessor " + successorNode);
			Node parentNode = getParent(toDelete);
			System.out.println("Pai do no a ser apagado " + parentNode);
			if (parentNode.getRightNode() == toDelete) {
				parentNode.rightNode = successorNode;
				successorNode.leftNode =  toDelete.leftNode;	
				toDelete.leftNode = null;
				toDelete.rightNode = null;
			}
		
		}
		
		
		//toDelete possui dois filhos

	}
	
	public Node insertNode(Node root, Node newNode) {
		
		//insere novo nó na folha a partir de 
		//comparacoes
		if (root == null) {
			return newNode;
		}
		
		if (root.value == newNode.value)
            return root;
		
		if (newNode.value < root.value) {
			//insere na esquerda
			
			root.setLeftNode(insertNode(root.leftNode,newNode)); 
		
		} else {
			//insere na direita
			
			root.setRightNode(insertNode(root.rightNode,newNode)); 
			 
		}
		return root;		
	}
	
	public void printLeafs() {
		printLeafs(this.root);
	}
	
	
	public void printLeafs(Node root) {
		if (root == null)
			return;
		printLeafs(root.getLeftNode());
		if (isLeaf(root)) {
			System.out.println(root.value);
			//System.out.println(" Nível: " + depth(root));
		}			
		printLeafs(root.getRightNode());	
	}
	
	public void printInOrder(Node root) {
		if (root == null)
			return;
		
		printInOrder(root.getLeftNode());
		System.out.println(root.value);
		printInOrder(root.getRightNode());

	}
	
	public void printBalanceamentFactors(Node root) {
		if (root == null)
			return;
		
		printBalanceamentFactors(root.getLeftNode());
		System.out.println("Node = " + root.value + " | BF = " + root.getBf());
		printBalanceamentFactors(root.getRightNode());

	}
	
	
	public boolean isStrictBinaryTree() {
		return isStrictBinaryTree(this.root);
	}
	
	
	
	public boolean isStrictBinaryTree(Node root) {
		//condição de saída
		if (root == null) return true;
		
		if (root.degree() == 1)	return false;
		
		return isStrictBinaryTree(root.leftNode)&& isStrictBinaryTree(root.rightNode);
		
	}
	
	public void addLeftChild(Node node, Node leftChild) {
		node.setLeftNode(leftChild);
	}
	
	public boolean isLeaf(Node node) {
		if (node.getLeftNode() == null && node.getRightNode()==null)
		  return true;
		return false;
	}
	
	public boolean isInternal(Node node) {
		return !isLeaf(node); 
	}

	public Node getRoot() {
		return root;
	}

	//profundidade
	
	public int depth(Node node) {
		return depth(this, node);
	}
	
	public int depth(AVL T, Node node) {
		if (node == root)
			return 0;
		else   
			return 1 + depth(T, T.getParent(node));
	}
	
	public Node getParent(Node node) {
        if (this.root == null || this.root == node) {
            return null;
        }
        return getParent(this.root, node);
    }
	
	public Node getParent(Node subTree, Node node) {
        if (subTree == null){
            return null;
        }

        if (subTree.getLeftNode() == node || subTree.getRightNode() == node){
            return subTree;
        }

        Node parent;
        if((parent = getParent(subTree.getLeftNode(), node)) != null)
            return parent;
        

        return getParent(subTree.getRightNode(), node);
    }
	
	
	
	public void setRoot(Node root) {
		this.root = root;
	}
}
