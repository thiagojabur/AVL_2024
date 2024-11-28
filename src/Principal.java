
public class Principal {

	public static void main(String[] args) {
		Node cinco = new Node(5);
		Node oito = new Node(8);
		Node nove = new Node(9);
		Node sete = new Node(7);
		Node seis = new Node(6);
		Node dois = new Node(2);
		Node dez = new Node(10);

		Node quatro = new Node(4);
		Node tres = new Node(3);
		
		
		AVL teste = new AVL(cinco);
		
		teste.insertNode(oito);
		teste.insertNode(sete);
		teste.insertNode(nove);
		teste.insertNode(seis);
		teste.insertNode(dez);
		
		
		//System.out.println(teste.isLeaf(raiz));
		//System.out.println(teste.isInternal(raiz));
		//System.out.println("Nível: " +teste.depth(raiz));
	    
		teste.printInOrder();
		
		//System.out.println(teste.isStrictBinaryTree());
		
		System.out.println("Folhas");
		
		teste.printLeafs();
		
		System.out.println("Internos");
		teste.printInternals();
		
		System.out.println("Todos os nós em ordem");
		teste.printInOrder();
		
		System.out.println("Calculando os fatores de balanceamento");
		teste.setBalanceFactors();
		
		
		System.out.println("Verificando fator de Balanceamento");
		teste.printBalanceFactors();
		
		System.out.println("Altura do 5 " + teste.height(cinco));
		System.out.println(cinco.height);
	}
}
