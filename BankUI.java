package bankomaten;

import java.util.List;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author 224Mi
 */
public class BankUI extends Application {
    
    // Create variables used in the multiple methods
    
    Bankomaten b;
    
    Stage window;
    
    Scene startingScene;
    Scene employeeScene;
    Scene customerScene;
    
    String customerName;
    
    Label customerWelcome;
    
    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        b = new Bankomaten();
        b.createDefault();
        
        
        
        /* 
            Startingscreen = Window Scene
        */
        BorderPane startingRoot = new BorderPane();
        startingRoot.setPadding(new Insets(20));
                
        // Create boxes for top-, center- and bottomelements
        HBox startingTop = new HBox(20);
        HBox startingCenter = new HBox(30);
        HBox startingBottom = new HBox(10);
        
        // Create buttonelements
        Button employee = new Button("Employee");
        Button customer = new Button("Customer");
        Button exit = new Button("Exit");
        
        // Create & adjust labelelements
        Label startingWelcome = new Label("ATM - Automated Teller Machine");
        startingWelcome.getStyleClass().add("headerLabel");
        
        // Set actionhandling
        employee.setOnAction(e -> window.setScene(employeeScene));
        customer.setOnAction(e -> tryFindUser());
        exit.setOnAction(e -> System.exit(0));
        
        // Add the elements to the top, center and bottom boxes
        startingTop.getChildren().add(startingWelcome);
        startingCenter.getChildren().addAll(employee, customer);
        startingBottom.getChildren().add(exit);
        
        // Add the boxes to the root at the top, center and bottom respectively
        startingRoot.setTop(startingTop);
        startingRoot.setCenter(startingCenter);
        startingRoot.setBottom(startingBottom);

        // Align the elements
        startingTop.setAlignment(Pos.CENTER);
        startingCenter.setAlignment(Pos.CENTER);
        startingBottom.setAlignment(Pos.CENTER_RIGHT);
        
        startingScene = new Scene(startingRoot, 440, 350);
        startingScene.getStylesheets().add("bankomaten/StylingBankUI.css");

        /*
            Customer Screen
        */
        BorderPane customerRoot = new BorderPane();
        customerRoot.setPadding(new Insets(20));
        
        // Create boxes for the customerelements
        HBox customerTop = new HBox(20);
        VBox customerCenter = new VBox(10);
        VBox customerCenterTop = new VBox(5);
        HBox customerCenterBottom = new HBox(20);
        HBox customerBottom = new HBox(20);
        
        // Customer welcometext
        customerWelcome = new Label();
        customerWelcome.getStyleClass().add("headerLabel");

        // Labels for customerinformation
        
        // Buttons for Customerservices
        Button withdraw = new Button("Withdraw");
        Button deposit = new Button("Deposit");
        
        // Returnbutton to homescreen
        Button customerReturn = new Button("Return to startingpage");
        customerReturn.setOnAction(e -> window.setScene(startingScene));
        
        // Add the elements to the boxes respectively
        customerTop.getChildren().add(customerWelcome);
        customerCenter.getChildren().add(customerCenterBottom);
        customerCenterBottom.getChildren().addAll(withdraw, deposit);
        customerBottom.getChildren().add(customerReturn);
        
        // Add the elements to the window for Customers
        customerRoot.setTop(customerTop);
        customerRoot.setCenter(customerCenter);
        customerRoot.setBottom(customerBottom);
        
        // Align the elements
        customerTop.setAlignment(Pos.CENTER);
        customerCenter.setAlignment(Pos.CENTER);
        customerCenterBottom.setAlignment(Pos.CENTER);
        customerBottom.setAlignment(Pos.CENTER_RIGHT);
        
        customerScene = new Scene(customerRoot, 440, 350);
        customerScene.getStylesheets().add("bankomaten/StylingBankUI.css");

        
        /*
            Employee Screen
        */
        BorderPane employeeRoot = new BorderPane();
        employeeRoot.setPadding(new Insets(20));
        
        // Add boxes for the elements
        HBox employeeTop = new HBox(20);
        HBox employeeCenter = new HBox(20);
        HBox employeeBottom = new HBox(20);
        
        // Create a welcometext for Employees
        Label employeeWelcome = new Label("Services for the employees");
        employeeWelcome.getStyleClass().add("headerLabel");

        // Create a returnbutton to the homescreen
        Button employeeReturn = new Button("Return to startingpage");
        employeeReturn.setOnAction(e -> window.setScene(startingScene));
        
        // Add the elements to the boxes
        employeeTop.getChildren().add(employeeWelcome);
        employeeBottom.getChildren().add(employeeReturn);
        
        // Add the elements to the window for Employees
        employeeRoot.setTop(employeeTop);
        employeeRoot.setBottom(employeeBottom);
        
        // Align the elements to the window for Employees
        employeeTop.setAlignment(Pos.CENTER);
        employeeBottom.setAlignment(Pos.CENTER_RIGHT);
        
        employeeScene = new Scene(employeeRoot, 440, 350);
        employeeScene.getStylesheets().add("bankomaten/StylingBankUI.css");

        
        
        // Startsettings
        window.setTitle("ATM - Automated Teller Machine");
        window.setScene(startingScene);
        window.show();
    }
    
    /*
        Check if user exist
    
        @return true if user exist
        @return false if nonexisting user
    */
    private Boolean tryFindUser() {
        Bank bank = b.getBank();
        List<Customer> customers = bank.getCustomers();
        
        String input = JOptionPane.showInputDialog(null, "Ange ditt personnummer");
        
        if (input == null)
            return false;
        
        // Find if the input matches the personal ID number
        for (Customer c : customers) {
            if (input.equals(c.getPersonalIDNumber())) {
                customerName = c.getName();
                customerWelcome.setText("Services for " + customerName);
                window.setScene(customerScene);
                return true;
            }
        }
        JOptionPane.showMessageDialog(null, "Angivet personnummer fanns inte i vår databas, försök igen senare!");
        return false;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
