class AVLTree
{
    private AVLNode root; // Nodo raíz del árbol AVL

    // Constructor: inicializa el árbol vacío
    public AVLTree()
    {
        root = null;
    }

    // Verifica si el árbol está vacío
    public boolean isEmpty()
    {
        return root == null;
    }

    // Vacía el árbol
    public void makeEmpty()
    {
        root = null;
    }

    // Inserta un dato en el árbol
    public void insert(int data)
    {
        root = insert(data, root);
    }

    // Obtiene la altura de un nodo
    private int height(AVLNode t )
    {
        return t == null ? -1 : t.height;
    }

    // Devuelve el máximo de dos valores
    private int max(int lhs, int rhs)
    {
        return lhs > rhs ? lhs : rhs;
    }

    // Inserta un valor en el árbol de manera recursiva y balancea
    private AVLNode insert(int x, AVLNode t)
    {
        if (t == null)
            t = new AVLNode(x); // Si el nodo es nulo, crea uno nuevo
        else if (x < t.data)
        {
            t.left = insert( x, t.left ); // Inserta en el subárbol izquierdo
            if( height( t.left ) - height( t.right ) == 2 ) // Verifica el balance
                if( x < t.left.data )
                    t = rotateWithLeftChild( t ); // Rotación simple izquierda
                else
                    t = doubleWithLeftChild( t ); // Rotación doble izquierda
        }
        else if( x > t.data )
        {
            t.right = insert( x, t.right ); // Inserta en el subárbol derecho
            if( height( t.right ) - height( t.left ) == 2 ) // Verifica el balance
                if( x > t.right.data)
                    t = rotateWithRightChild( t ); // Rotación simple derecha
                else
                    t = doubleWithRightChild( t ); // Rotación doble derecha
        }
        else
          ;  // Duplicado; no hace nada
        t.height = max( height( t.left ), height( t.right ) ) + 1; // Actualiza la altura
        return t;
    }

    /* Rotación simple con hijo izquierdo */
    private AVLNode rotateWithLeftChild(AVLNode k2)
    {
        AVLNode k1 = k2.left; // k1 es el hijo izquierdo de k2
        k2.left = k1.right; // El hijo derecho de k1 pasa a ser hijo izquierdo de k2
        k1.right = k2; // k2 pasa a ser hijo derecho de k1
        k2.height = max( height( k2.left ), height( k2.right ) ) + 1; // Actualiza altura de k2
        k1.height = max( height( k1.left ), k2.height ) + 1; // Actualiza altura de k1
        return k1; // Retorna el nuevo subárbol
    }

    /* Rotación simple con hijo derecho */
    private AVLNode rotateWithRightChild(AVLNode k1)
    {
        AVLNode k2 = k1.right; // k2 es el hijo derecho de k1
        k1.right = k2.left; // El hijo izquierdo de k2 pasa a ser hijo derecho de k1
        k2.left = k1; // k1 pasa a ser hijo izquierdo de k2
        k1.height = max( height( k1.left ), height( k1.right ) ) + 1; // Actualiza altura de k1
        k2.height = max( height( k2.right ), k1.height ) + 1; // Actualiza altura de k2
        return k2; // Retorna el nuevo subárbol
    }

    /**
     * Doble rotación: primero rotar el hijo derecho del subnodo izq; 
     * después el nodo desbalanceado con su nuevo hijo izq 
     */
    private AVLNode doubleWithLeftChild(AVLNode k3)
    {
        k3.left = rotateWithRightChild( k3.left ); // Rotación derecha en el hijo izquierdo
        return rotateWithLeftChild( k3 ); // Rotación izquierda en k3
    }

    /**
     * Doble rotación: Primero rotar el hijo izq del subnodo der;
     * después el nodo desbalanceado con su nuevo hijo der 
     */      
    private AVLNode doubleWithRightChild(AVLNode k1)
    {
        k1.right = rotateWithLeftChild( k1.right ); // Rotación izquierda en el hijo derecho
        return rotateWithRightChild( k1 ); // Rotación derecha en k1
    }    

    // Cuenta el número de nodos en el árbol
    public int countNodes()
    {
        return countNodes(root);
    }

    // Cuenta nodos recursivamente
    private int countNodes(AVLNode r)
    {
        if (r == null)
            return 0; // Si el nodo es nulo, retorna 0
        else
        {
            int l = 1; // Cuenta el nodo actual
            l += countNodes(r.left); // Cuenta los nodos del subárbol izquierdo
            l += countNodes(r.right); // Cuenta los nodos del subárbol derecho
            return l; // Retorna el total
        }
    }

    // Busca un valor en el árbol
    public boolean search(int val)
    {
        return search(root, val);
    }

    // Busca recursivamente un valor en el árbol
    private boolean search(AVLNode r, int val)
    {
        boolean found = false; // Variable para indicar si se encontró el valor
        while ((r != null) && !found)
        {
            int rval = r.data; // Valor del nodo actual
            if (val < rval)
                r = r.left; // Busca en el subárbol izquierdo
            else if (val > rval)
                r = r.right; // Busca en el subárbol derecho
            else
            {
                found = true; // Valor encontrado
                break;
            }
            found = search(r, val); // Llamada recursiva
        }
        return found; // Retorna si se encontró o no
    }

    // Muestra el recorrido inorden del árbol
    public void inorder()
    {
        inorder(root);
    }

    // Recorrido inorden recursivo
    private void inorder(AVLNode r)
    {
        if (r != null)
        {
            inorder(r.left); // Recorre subárbol izquierdo
            System.out.print(r.data +" "); // Imprime el dato
            inorder(r.right); // Recorre subárbol derecho
        }
    }

    // Muestra el recorrido preorden del árbol
    public void preorder()
    {
        preorder(root);
    }

    // Recorrido preorden recursivo
    private void preorder(AVLNode r)
    {
        if (r != null)
        {
            System.out.print(r.data +" "); // Imprime el dato
            preorder(r.left); // Recorre subárbol izquierdo             
            preorder(r.right); // Recorre subárbol derecho
        }
    }

    // Muestra el recorrido postorden del árbol
    public void postorder()
    {
        postorder(root);
    }

    // Recorrido postorden recursivo
    private void postorder(AVLNode r)
    {
        if (r != null)
        {
            postorder(r.left); // Recorre subárbol izquierdo             
            postorder(r.right); // Recorre subárbol derecho
            System.out.print(r.data +" "); // Imprime el dato
        }
    }     
}