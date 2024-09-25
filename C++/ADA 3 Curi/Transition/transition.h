#ifndef TRANSITION_H
#define TRANSITION_H

#include <bits/stdc++.h>
using namespace std;

class Transition{
private:
    string stateInitial;
    string symbol;
    string stateEnd;
public:
    Transition(string stateInitial, string symbol, string stateEnd);
    string getStateInitial() const;
    string getSymbol() const;
    string getStateEnd() const;
}

#endif TRANSITION_H