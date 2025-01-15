import java.util.Scanner;
public class DeleteElementInArray
{
    public static void main(String[] args)
    {
        int n, x, flag = 1, loc = 0;
        Scanner s = new Scanner(System.in);
        System.out.print("Introduce el número de elementos del arreglo:");
        n = s.nextInt();
        int a[] = new int[n];
        System.out.println("Proporciona todos los elementos del arreglo:");
        for (int i = 0; i < n; i++)
        {
            a[i] = s.nextInt();
        }
        System.out.print("Introduce el valor del elemento a eliminar:");
        x = s.nextInt();
        for (int i = 0; i < n; i++)
        {
            if(a[i] == x)
            {
                flag =1;
                loc = i;
                break;
            }
            else
            {
                flag = 0;
            }
        }
        if(flag == 1)
        {
            for(int i = loc+1; i < n; i++)
            {
                a[i-1] = a[i];
            }
            System.out.print("El arreglo después de eliminar el elemento:");
            for (int i = 0; i < n-2; i++)
            {
                System.out.print(a[i]+",");
            }
            System.out.print(a[n-2]);
           
           
        }
        else
        {
            System.out.println("Elemento no encontrado");
        }
    }
}