// Delta College - CST 283 - Klingler                 
// Demonstrates a shallow copy of two linked stack objects

public class ShallowStack 
{
   public static void main(String [ ] args)   
   {
        // ----------------------------------------------------------
        LinkedStack<String> stack1 = new LinkedStack<String>();
       
        stack1.push("Blue");
        stack1.push("Red");
        stack1.push("White");    
        
        System.out.println("Stack1 - Initially");
        System.out.println(stack1 + "\n\n");    
        
        LinkedStack<String> stack2 = new LinkedStack<String>();
        
        stack2 = stack1;
        
        System.out.println("Stack1 - After Assignment");
        System.out.println(stack1 + "\n"); 
        System.out.println("Stack2 - After Assignment");
        System.out.println(stack2 + "\n\n");
        
        stack1.pop();  
                
        System.out.println("Stack1 - After Pop");
        System.out.println(stack1 + "\n"); 
        System.out.println("Stack2 - After Pop");
        System.out.println(stack2 + "\n\n");
        
        stack2.push("Purple");
        
        System.out.println("Stack1 - After Push");
        System.out.println(stack1 + "\n"); 
        System.out.println("Stack2 - After Push");
        System.out.println(stack2 + "\n\n");
   }    
}