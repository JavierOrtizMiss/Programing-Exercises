#include <bits/stdc++.h>
#include "States/states.h"

using namespace std;

int main(){
    ifstream archivo("automata.txt");
    string line;

    while (getline(archivo,line))
    {
        cout << line << endl;
    }
    



    archivo.close();
    return 0;
}