
package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Driver extends Application {
	public static void main(String[] args) { launch(args); }
	    
	    @Override
	    public void start(Stage stage) {
	    	//title of application
	        stage.setTitle("Creating Twin Primes and Hexagon Crosses");
	        
	        //the grid formatting
	        GridPane grid = new GridPane();
	        grid.setAlignment(Pos.CENTER);
	        grid.setHgap(5);
	        grid.setVgap(5);
	        grid.setPadding(new Insets(10, 10, 10, 10));
	        
	        //title
	        Text title = new Text("Twin Primes & Hexagon Crosses");
	        title.setFill(Color.LIGHTPINK);
	        title.setFont(Font.font("Tahoma", FontWeight.BOLD, 30));
	        grid.add(title, 0, 0, 2, 1);

	        //label for input
	        Label inputlabel = new Label("Enter number of hexagon crosses to output:");
	        grid.add(inputlabel, 0, 1);

	        //text field for where user inputs N
	        TextField userTextField = new TextField();
	        grid.add(userTextField, 1, 1);
	        
	        //button for entering input
	        Button submit = new Button("Submit");
	        HBox hbBtn = new HBox(10);
	        hbBtn.setAlignment(Pos.TOP_RIGHT);
	        hbBtn.getChildren().add(submit);
	        grid.add(hbBtn, 0, 3);
	        
	        //text area for hexagon crosses in GUI
	        TextArea ta = new TextArea();
	        GridPane.setConstraints(ta, 0, 5);
	        GridPane.setColumnSpan(ta, 2);
	        grid.getChildren().add(ta);

	        //when the button "submit" is pressed, the file is made and the output is put in the text area "ta"
	        submit.setOnAction((ActionEvent e) -> {
	        	//make sure the user inputted properly
	            if ((userTextField.getText() != null && !userTextField.getText().isEmpty())) {
	            	//get the text inputted by the user as a string
	            	String userinput = userTextField.getText();
	            	//convert user's N input from string to integer
	            	int intuserinput = Integer.parseInt(userinput);
	            	//will make results.txt
	            	FileIO.MakeFile(intuserinput);
	            	
	             	//also output the results by scanning the text file just made
	            	try (Scanner scanner = new Scanner(new File("result.txt"))) {
	            		//while the text file still has data, each line will be written in the text area "ta"
	                    while (scanner.hasNext()) {
	                    	//formatting for the text area "ta"
	                        ta.appendText(scanner.next() + " " + scanner.next() + "\n");
	                    }
	                } 
	            	catch (FileNotFoundException except) {
	                    except.printStackTrace();
	                }
	            } 
	            //if the user inputted incorrectly
	            else {
	                ta.setText("You have not left a number. Try again");
	            }
	        });
	        
	        //the grid for the application
	        Scene scene = new Scene(grid, 600, 475);
	        stage.setScene(scene);	        
	        stage.show();
	        
	    }
}
