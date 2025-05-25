class Node {
    int data;
    Node left, right;
    Node (int d){
        data = d;
        left=null;
        right=null;
    }
}

class GfG {
    public static void main(String[] args) throws Exception {
        //Inicializar y localizar memoria de 3 nodos
        Node firstNode = new Node(2);
        Node secondNode = new Node(3);
        Node thirdNode = new Node(4);
        Node fourthNode = new Node(5);

        //Conectar los 3 nodos binarios
        firstNode.left = secondNode;
        firstNode.right = thirdNode;
        secondNode.left = fourthNode;

    }
}
