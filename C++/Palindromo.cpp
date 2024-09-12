#include <bits/stdc++.h>
using namespace std;

bool isPalindromo(const string &word) {
    int i = 0;
    int j = word.length() - 1;

    while (i <= j) {
        if (word[i] != word[j]) {
            return false;
        }
        i++;
        j--;
    }
    return true; 
}

int main() {
    cout << boolalpha;
    cout << isPalindromo("radar") << endl;
    return 0;
}
