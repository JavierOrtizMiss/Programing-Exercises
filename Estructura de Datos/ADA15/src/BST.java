class BST
{
    private BSTNode root; // Nodo raíz del árbol.

    // Constructor por defecto: inicializa el árbol como vacío.
    public BST()
    {
        root = null; // La raíz se inicializa como null.
    }
    
    // Verifica si el árbol está vacío.
    public boolean isEmpty()
    {
        return root == null; // Devuelve true si la raíz es null.
    }
    
    // Inserta un dato en el árbol.
    public void insert(int data)
    {
        root = insert(root, data); // Llama al método recursivo para insertar el dato.
    }
    
    // Método recursivo para insertar un dato en el árbol.
    private BSTNode insert(BSTNode node, int data)
    {
        if (node == null) // Si el nodo actual es null, crea un nuevo nodo.
            node = new BSTNode(data);
        else
        {
            if (data <= node.getData()) // Si el dato es menor o igual al dato del nodo actual, inserta en el subárbol izquierdo.
                node.left = insert(node.left, data);
            else // Si el dato es mayor, inserta en el subárbol derecho.
                node.right = insert(node.right, data);
        }
        return node; // Devuelve el nodo actualizado.
    }
    
    // Elimina un dato del árbol.
    public void delete(int k)
    {
        if (isEmpty()) // Si el árbol está vacío, muestra un mensaje.
            System.out.println("Arbol vacio");
        else if (!search(k)) // Si el dato no está en el árbol, muestra un mensaje.
            System.out.println("Ups " + k + " no esta en el arbol");
        else
        {
            root = delete(root, k); // Llama al método recursivo para eliminar el dato.
            System.out.println(k + " eliminado del arbol");
        }
    }
    
    // Método recursivo para eliminar un dato del árbol.
    private BSTNode delete(BSTNode root, int k)
    {
        BSTNode p, p2, n;
        if (root.getData() == k)
        {
            System.out.println("El dato a eliminar es igual a root ");
            BSTNode lt, rt;
            lt = root.getLeft();
            
            rt = root.getRight();
            
            
            if (lt == null && rt == null){
                System.out.println("nodo izq y der del nodo root son null y se regresa");
                return null;
            }
            else if (lt == null)
            {
                System.out.println("Subarbol izq es null y regresa subarbol derecho");
                p = rt;
                return p;
            }
            else if (rt == null)
            {
                System.out.println("subarbol derecho es null y regresa subarbol izq");
                p = lt;
                return p;
            }
            else
            {
                System.out.println("a partir de root nada es null");
                p2 = rt;
                p = rt;
                while (p.getLeft() != null){
                    System.out.println("entra al while a recorrer el lado derecho del sub arbol por nodos izq");
                    p = p.getLeft();
                }
                
                p.setLeft(lt);
                return p2;
            }
        }
        if (k < root.getData())
        {
            System.out.println("el valor a eliminar es menor que root actual " + root.getData() + " y va a borrar por izq " );
            n = delete(root.getLeft(), k);
            root.setLeft(n);
        }
        else
        {
            System.out.println("el valor a eliminar NO es menor que root actual " + root.getData() +  "y va a borrar por der");
            n = delete(root.getRight(), k);
            root.setRight(n);             
        }
        return root;
    }
    
    // Cuenta el número de nodos en el árbol.
    public int countNodes()
    {
        return countNodes(root); // Llama al método recursivo para contar los nodos.
    }
    
    private int countNodes(BSTNode r)
    {
        if (r == null)
            return 0;
        else
        {
            int l = 1;
            l += countNodes(r.getLeft());
            l += countNodes(r.getRight());
            return l;
        }
    }
    
    // Busca un dato en el árbol.
    public boolean search(int val)
    {
        return search(root, val); // Llama al método recursivo para buscar el dato.
    }
    
    private boolean search(BSTNode r, int val)
    {
        boolean found = false;
        while ((r != null) && !found)
        {
            int rval = r.getData();
            if (val < rval)
                r = r.getLeft();
            else if (val > rval)
                r = r.getRight();
            else
            {
                found = true;
                break;
            }
            found = search(r, val);
        }
        return found;
    }
    
    // Realiza un recorrido en inorden.
    public void inorder()
    {
        inorder(root); // Llama al método recursivo para el recorrido inorden.
    }
    
    private void inorder(BSTNode r)
    {
        if (r != null)
        {
            inorder(r.getLeft());
            System.out.print(r.getData() +" ");
            inorder(r.getRight());
        }
    }
    
    // Realiza un recorrido en preorden.
    public void preorder()
    {
        preorder(root); // Llama al método recursivo para el recorrido preorden.
    }
    
    private void preorder(BSTNode r)
    {
        if (r != null)
        {
            System.out.print(r.getData() +" ");
            preorder(r.getLeft());             
            preorder(r.getRight());
        }
    }
    
    // Realiza un recorrido en postorden.
    public void postorder()
    {
        postorder(root); // Llama al método recursivo para el recorrido postorden.
    }
    
    private void postorder(BSTNode r)
    {
        if (r != null)
        {
            postorder(r.getLeft());             
            postorder(r.getRight());
            System.out.print(r.getData() +" ");
        }
    }     
}