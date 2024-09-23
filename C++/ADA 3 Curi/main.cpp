#include <bits/stdc++.h>

using namespace std;

int main() {
    ifstream archivo("datos.txt");
    string linea;
    
    while (getline(archivo, linea)) {
        cout << linea << endl; 
    }

    archivo.close(); 

    return 0;
}