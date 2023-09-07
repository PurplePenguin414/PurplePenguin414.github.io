public class Test {
  public static void main(String[] args) {

    int sum = 0;
    int item = 0;
    do {
      item++;
      if (sum < 5) 
        sum += item;
    }
    while (item < 5);
    
    System.out.println("Sum is " + sum);
  }
}
