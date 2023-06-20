import Objects.JSONParser;
import Objects.SpringHttpClient;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.text.Font;

public class Client extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        TextField plakaTextField = new TextField();
        Button getButton = new Button("Informationen abrufen");
        Label resultLabel = new Label();
        Label markaLabel = new Label();
        Label plakaLabel = new Label();
        Label zustandLabel = new Label();
        Label GetSchadeResultLabel= new Label();
        Label Reparatur_oldLabel = new Label();
        Label Kosten_oldLabel = new Label();

        Font labelFont = new Font("Arial", 16);
        markaLabel.setFont(labelFont);
        plakaLabel.setFont(labelFont);
        zustandLabel.setFont(labelFont);
        GetSchadeResultLabel.setFont(labelFont);
        Reparatur_oldLabel.setFont(labelFont);
        Kosten_oldLabel.setFont(labelFont);

        // GET methodu için kısım
        getButton.setOnAction(e -> {
            String plaka = plakaTextField.getText();
            String result = SpringHttpClient.getFahrzeug(plaka);
            //GetSchadeResultLabel .setText("Burası schade içindir");
            JSONParser.parseFahrzeugData(result, markaLabel, plakaLabel, zustandLabel, GetSchadeResultLabel, Reparatur_oldLabel, Kosten_oldLabel );
        });

        VBox getVBox = new VBox(10);
        getVBox.getChildren().addAll(new Label("Suche Fahrzeug"), plakaTextField, getButton, resultLabel, markaLabel, plakaLabel, zustandLabel, GetSchadeResultLabel, Reparatur_oldLabel, Kosten_oldLabel);


        // PUT methodu için kısım
        Label plaka_putLabel = new Label("Kfz:");
        TextField plaka_putTextField = new TextField();
        Label reparaturLabel = new Label("Reparatur:");
        TextField reparaturTextField = new TextField();
        Label kostenLabel = new Label("Kosten:");
        TextField kostenTextField = new TextField();
        //Label zustandLabel_put = new Label("Zustand:");
        //TextField zustandTextField = new TextField();
        Button putButton = new Button("Aktualisieren");

        putButton.setOnAction(e -> {
            String plaka_put = plaka_putTextField.getText();
            String reparatur = reparaturTextField.getText();
            String kosten = kostenTextField.getText();
            //String zustand = zustandTextField.getText();
            SpringHttpClient.updateFahrzeug(plaka_put, reparatur, kosten);
            if (SpringHttpClient.isSuccessful()) {
                resultLabel.setText("Fahrzeug ist erfolgreich aktualisiert. Fahrzeug ist fertig.");
            } else {
                resultLabel.setText("Fahrzeug kann nicht aktualisiert werden. Fehler code: " + SpringHttpClient.getErrorCode());
            }
            // Güncelleme işlemi tamamlandıktan sonra gerekli işlemleri yapabilirsiniz
        });

        GridPane putGridPane = new GridPane();
        putGridPane.setHgap(10);
        putGridPane.setVgap(10);
        putGridPane.setPadding(new Insets(10));
        putGridPane.addRow(0, plaka_putLabel, plaka_putTextField);
        putGridPane.addRow(1, reparaturLabel, reparaturTextField);
        putGridPane.addRow(2, kostenLabel, kostenTextField);
        //putGridPane.addRow(1, zustandLabel_put, zustandTextField);
        putGridPane.addRow(3, putButton);
        VBox putVBox = new VBox(10);


        //Get Kunde
        Label name = new Label();
        Label nachname = new Label();



        putVBox.getChildren().addAll(new Label("Fahrzeug Aktualisieren"), putGridPane,resultLabel);

        // Ana düzen
        //HBox root = new HBox(20);
        VBox root = new VBox(20);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(getVBox, putVBox);

        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Spring Project Client");
        primaryStage.show();
    }
}

