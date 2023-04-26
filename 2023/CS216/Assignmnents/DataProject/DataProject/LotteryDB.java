// Delta College - CST 283 - Klingler             
// This class is a test driver for a generic binary search tree of integers.
// Features testing:  size and depth

import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.Scanner;

public class LotteryDB {

    private static int MAX_TREE_SIZE = 1000; // 1000
    private static BinarySearchTree<LotteryCustomer> theTree;
    private static int numElems = 0;

    public static void main(String[] args) {

        // Instantiate search tree and load from file
        theTree = new BinarySearchTree<LotteryCustomer>();
        String temp = "";

        loadTree();
        System.out.println("\n\nThe Data Is Loaded---------------------------------------------------");
    }

    // Method loads binary search tree from file of data
    public static void loadTree() {

        String newDataObj = "";
        String id = "";
        String fname = "";
        String lname = "";
        String addy = "";
        String city = "";
        String state = "";
        String zip = "";
        String phone = "";
        String email = "";
        String tickets = "";

        File inputfile;
        inputfile = new File("2023/CS216/Assignmnents/DataProject/DataProject/lotterycustomers.txt");

        // Read file and populate linked list with Data objects
        try (BufferedReader br = new BufferedReader(new FileReader(inputfile))){
            String line;
            int i = 0;
            while ((line = br.readLine()) != null ) {
                String[] values = line.split(",");
                LotteryCustomer cust = new LotteryCustomer();

                // Tokenize line and save data
                cust.ID = values[0];
                cust.Fname = values[1];
                cust.Lname = values[2];
                cust.Addy = values[3];
                cust.City = values[4];
                cust.State = values[5];
                cust.Zip = values[6];
                cust.Phone = values[7];
                cust.Email = values[8];
                cust.Tickets = values[9];

                // Construct object and add to array of objects
                System.out.println(cust);
                theTree.add(cust);

                i++; // Advance marker index
            }
            numElems = i;
            br.close(); // Close file
        } catch (IOException e) // If file error, report to console and crash
        {
            System.out.println("ERROR: File input error" + e );
            System.exit(0);
        }

    }

}