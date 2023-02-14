// Delta College - CST 283 - Klingler
// This class manages a text message with the ability to return the
// message in Morse Code.

public class MorseMessage
{
    char[] alphaCharString = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8',
            '9', '0', ' ' };

    String[] morseStrings = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
            "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.",
            "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
            "-.--", "--..", ".----", "..---", "...--", "....-", ".....",
            "-....", "--...", "---..", "----.", "-----", "*****" };   
    
    private String theMessage;
    
    // --------------------------------------------------------
    
    // No-Arg Constructor
    public MorseMessage()
    {
        theMessage = "";
    }

    // Parameterized constructor - receive message to be converted
    public MorseMessage(String inMsg)
    {
        theMessage = inMsg;
    }
    
    // --------------------------------------------------------   
    // Accessors and Mutators
    
    public String getMessage()
    {
        return theMessage;
    }
    
    public void setMessage(String m)
    {
        theMessage = m;
    }
    
    // --------------------------------------------------------   

    public String getMorseMessage()
    {
        String morseMessage = "*****";    // Initiate with separator
        
        // Traverse message field one char at a time.  Scan the alphanumeric
        // array of char for a match.  Replace with Morse Code string defined
        // parallel to matching char.  

        for (int i = 0; i < theMessage.length(); i++)
        {
            char currentChar = Character.toLowerCase(theMessage.charAt(i));
            
            for (int j = 0; j < alphaCharString.length; j++)
                if (currentChar == alphaCharString[j])
                    morseMessage += morseStrings[j] + "\n";
        }
  
        morseMessage += "*****";         // Conclude message with separator
        
        return morseMessage;
    }    
            

}

