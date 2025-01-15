import java.util.Scanner;

public class Search_Element
{
    public static void main(String[] args)
    {
        int n, x, flag = 0, i = 0;
        Scanner s = new Scanner(System.in);
        System.out.print("Proporciona el número de elementos en el arreglo:");
        n = s.nextInt();
        float a[] = new float[n];
        System.out.println("Introduce todos los elementos:");
        for(i = 0; i < n; i++)
        {
            a[i] = s.nextInt();
        }
        System.out.print("Proporciona el número que quieres buscar:");
        x = s.nextInt();
        for(i = 0; i < n; i++)
        {
            if(a[i] == x)
            {
                flag = 1;
                break;
            }
            else
            {
                flag = 0;
            }
        }
        if(flag == 1)
        {
            System.out.println("El elemento se encuentra en la posición:"+(i + 1));
        }
        else
        {
            System.out.println("Elemento no encontrado");
        }
    }
}
