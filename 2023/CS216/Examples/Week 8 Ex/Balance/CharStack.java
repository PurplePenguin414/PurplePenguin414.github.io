// Delta College - CST 283 - Klingler                  
// This class defines an array-based stack for primitive characters.
// Variable top manages index for top of stack as well as the
// count of elements in the stack.

class CharStack
{
    private char stackArray[];
    private int stackSize;
    private int top;

    //****************************************************
    //Constructor - Define a stack with designated 
    // capacity       
    public CharStack(int size)
    {
        stackArray = new char[size]; 
        stackSize = size; 
        top = 0;
    }

    //****************************************************
    // Method push pushes the argument onto the stack.     
    // PRECONDITION: Stack is NOT FULL     
    public void push(char newItem)
    {
        stackArray[top] = newItem;
        top++;
    }

    //****************************************************
    // Method pop returns the value at the top    
    // of the stack and then removes it.      
    // PRECONDITION: Stack is NOT EMPTY
    public char pop()
    {
        top--;
        return stackArray[top];
    }

    //****************************************************
    // Method peek returns the value at the top    
    // of the stack and then removes it.      
    // PRECONDITION: Stack is NOT EMPTY
    public char peek()
    {
        return stackArray[top-1];
    }
    
    //****************************************************
    // Member function clear "empties" the stack by   
    // altering the "top" pointer index    
    public void clear()
    {
        top = 0;
    }

    //***************************************************
    // Member function isFull returns true if the stack
    // is full, or false otherwise.    
    public boolean isFull() 
    {
        boolean status;

        if (top == stackSize) 
            status = true;
        else
            status = false;

        return status;
    }

    //****************************************************
    // Method returns true if the stack is empty, or false
    // otherwise.     
    public boolean isEmpty()
    {
        boolean status;

        if (top == 0)
            status = true;
        else 
            status = false;

        return status;
    }
}
