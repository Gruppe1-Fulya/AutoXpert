import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class HelloFX extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX Client");

        // TextArea for displaying the response
        TextArea responseTextArea = new TextArea();

        // Button for sending the API request
        Button sendRequestButton = new Button("Send Request");
        sendRequestButton.setOnAction(event -> {
            // Create a RestTemplate instance
            RestTemplate restTemplate = new RestTemplate();

            // Send GET request to the API endpoint
            ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://localhost:8080/kunde/ekle", String.class);

            // Get the response body
            String response = responseEntity.getBody();

            // Display the response in the TextArea
            responseTextArea.setText(response);
        });

        // Create a VBox layout and add the controls
        VBox root = new VBox(10);
        root.getChildren().addAll(sendRequestButton, responseTextArea);

        // Create a Scene with the layout
        Scene scene = new Scene(root, 400, 300);

        // Set the Scene to the Stage
        primaryStage.setScene(scene);

        // Show the Stage
        primaryStage.show();
    }
}
