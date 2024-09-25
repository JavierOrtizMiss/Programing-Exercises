#ifndef STATES_H
#define STATES_H

#include <bits/stdc++.h>

using namespace std;

class States{
private:
    string name;
    bool isAccepting;

public:
    States(string name,bool isAccepting = false);

    string getName() const;
    bool getIsAccepting() const;
    void setIsAccepting(bool isAccepting) const;
};

#endif STATES_H