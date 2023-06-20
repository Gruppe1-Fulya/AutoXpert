package Objects;
import javafx.scene.control.Label;
import org.json.JSONObject;

public class JSONParser {
    public static void parseFahrzeugData(String jsonData, Label markaLabel, Label plakaLabel, Label zustandLabel, Label schadeResultLabel, Label reparaturenLabel, Label kostenLabel) {
        JSONObject jsonObject = new JSONObject(jsonData);

        String marka = jsonObject.getString("marka");
        String plaka = jsonObject.getString("kfz");
        String zustand = jsonObject.getString("zustand");
        String schade= jsonObject.getString("schade");
        String reparatur= jsonObject.getString("reparaturen");
        String kosten= jsonObject.getString("kosten");

        markaLabel.setText("Marke: " + marka);
        plakaLabel.setText("Kfz: " + plaka);
        zustandLabel.setText("Zustand: " + zustand);
        schadeResultLabel.setText("Schade: " + schade);
        reparaturenLabel.setText("Reparaturen: " + reparatur);
        kostenLabel.setText("Kosten: " + kosten);

    }

}

