// Delta College - CST 283 - Klingler                 
// Demonstrates a shallow copy of two linked stack objects

public class DeepStack 
{
   public static void main(String [ ] args)   
   {
        // ----------------------------------------------------------
        LinkedStack<String> stack1 = new LinkedStack<String>();
       
        stack1.push("Blue");
        stack1.push("Red");
        stack1.push("White");          

        LinkedStack<String> stack2 = new LinkedStack<String>(stack1);
        
        System.out.println("Stack1");
        System.out.println(stack1 + "\n"); 
        System.out.println("Stack2");
        System.out.println(stack2 + "\n\n");
        
        stack1.pop();
        stack2.push("Purple");
        
        System.out.println("Stack1");
        System.out.println(stack1 + "\n"); 
        System.out.println("Stack2");
        System.out.println(stack2 + "\n\n");
   }    
}