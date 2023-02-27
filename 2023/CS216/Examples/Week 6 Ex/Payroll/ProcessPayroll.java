// Delta College - CST 283 - Klingler 
// This program processes payroll by instantiating an object of the
// Payroll class.  The driver includes a simple JavaFX text area with
// no user interaction.

import javafx.application.Application;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ProcessPayroll extends Application
{
    private double VIEW_HEIGHT = 400;
    private double VIEW_WIDTH  = 500;

    private TextArea outputTextArea;
    private String outputReport;      // Container for overall report

    private String name;
    private int id;
    private double salary, hours, rate;
    private String code;      // Employee type code:  H-hourly  S-salaried

    public final String FILENAME = "inpay.txt";

    public static void main(String[] args)
    {
        launch(args);    // Launch the application.
    }

    @Override
    public void start(Stage primaryStage)
    {
        double tot_gross, tot_net, tot_tax;   // Declare totals

        outputReport = writeReportHeading();   // Initialize counters and write report header.

        // Open file.  Process in batch format line-by-line.  Process at it goes.
        try {
            // Intitate file
            Scanner inputFileScanner;
            File inputfile;
            inputfile = new File(FILENAME);
            inputFileScanner = new Scanner(inputfile);

            // Initializes totals
            tot_gross = 0;
            tot_net = 0;
            tot_tax = 0;

            // Commence file processing loop
            while (inputFileScanner.hasNext()) {
                // Read first data tokens - name, id, employee type
                name = inputFileScanner.next();
                id = inputFileScanner.nextInt();
                code = inputFileScanner.next();

                // Salaried worker detected - create object and add to list 
                if (code.equals("S")) {
                    salary = inputFileScanner.nextDouble();
                    SalariedWorker salaryPerson = new SalariedWorker(name, id, salary);
                    salaryPerson.calcGrossPay();
                    salaryPerson.calcTaxNet();
                    outputReport += salaryPerson.writeFormattedLine();

                    tot_gross += salaryPerson.getGross();
                    tot_tax += salaryPerson.getTax();
                    tot_net += salaryPerson.getNet();

                }

                // Hourly worker detected - create object and add to list 
                if (code.equals("H")) {
                    hours = inputFileScanner.nextDouble();
                    rate = inputFileScanner.nextDouble();
                    HourlyWorker hourlyPerson = new HourlyWorker(name, id, hours, rate);
                    hourlyPerson.calcGrossPay();
                    hourlyPerson.calcTaxNet();
                    outputReport += hourlyPerson.writeFormattedLine();

                    tot_gross += hourlyPerson.getGross();
                    tot_tax += hourlyPerson.getTax();
                    tot_net += hourlyPerson.getNet();
                }
            }

            // Add totals to report
            outputReport += writeTotals(tot_gross, tot_tax, tot_net);

            // Send output report to text area.  Configure text area.
            outputTextArea = new TextArea(outputReport);
            outputTextArea.setEditable(false);
            outputTextArea.setFont(Font.font("Monospaced", FontWeight.BOLD, FontPosture.REGULAR, 16));

            inputFileScanner.close();   // Close file
        } catch (IOException e)  // If file error, reset list status flag
        {
            System.out.println("Problem with File - Shutting Down");
            System.exit(0);
        }

        // Set up overall scene with text area.
        outputTextArea.setPrefHeight(VIEW_HEIGHT);
        outputTextArea.setPrefWidth(VIEW_WIDTH);
        HBox mainContainer = new HBox(outputTextArea);
        Scene scene = new Scene(mainContainer, VIEW_WIDTH, VIEW_HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Payroll");
        primaryStage.show();
    }

    // ----------------------------------------------------------------
    // initialize with table headings
    public String writeReportHeading() {
        return "NAME           ID     GROSS      TAX     NET\n";
    }

    // ----------------------------------------------------------------
    // Prepare a formatted String for totals
    public String writeTotals(double totG, double totT, double totN)
    {
        String outString = "";
        outString += "\nTOTAL              ";
        outString += String.format("%9.2f", totG);
        outString += String.format("%9.2f", totT);
        outString += String.format("%9.2f", totN);

        return outString;
    }
}
