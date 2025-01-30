/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;
 
class Node
{
    protected int data;
    protected Node link;
 
    public Node()
    {
        link = null;
        data = 0;
    }    
    public Node(int d,Node n)
    {
        data = d;
        link = n;
    }    
    public void setLink(Node n)
    {
        link = n;
    }    
    public void setData(int d)
    {
        data = d;
    }    
    public Node getLink()
    {
        return link;
    }    
    public int getData()
    {
        return data;
    }
}
