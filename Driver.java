package LAB4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Driver extends Application {
	final double ASSESSMENT = .6;
	final double TAX = .64;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage gui) throws Exception {
		TextField input = new TextField();
		Label lbl = new Label("Enter Property Value");
		Button btn = new Button("Enter");
		btn.setOnAction(event -> {
			double cost = Double.parseDouble(input.getText());

			cost *= ASSESSMENT;
			double temp = cost;
			int count = 0;

			while (temp > 0) {
				temp -= 100;
				count++;
			}

			lbl.setText("Tax For Land: " + (count * TAX));
		});

		HBox hb = new HBox();
		hb.getChildren().addAll(lbl, input, btn);

		Scene container = new Scene(hb);
		gui.setScene(container);
		gui.setTitle("PropertyCalc");
		gui.show();

	}

}
