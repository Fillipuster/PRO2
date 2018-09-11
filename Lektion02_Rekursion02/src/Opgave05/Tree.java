package Opgave05;

import java.util.Random;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Tree extends Application {
    private int steps = 10;
    private double lengthModifier = 130;
    private double angleIntensity = 40;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        Pane root = initContent();
        Scene scene = new Scene(root);

        stage.setTitle("Tree");
        stage.setScene(scene);
        stage.show();
    }

    private Pane initContent() {
        Pane pane = new Pane();
        pane.setPrefSize(500, 500);
        plantTree(pane, 250, 490, -90);
        return pane;
    }

    private void plantTree(Pane pane, double x, double y, double ang) {
        drawTree(pane, x, y, ang, 0);
    }

    private void drawTree(Pane pane, double x, double y, double ang, double step) {
        step++;

        Random rand = new Random();

        // Termination;
        if (step > steps) {
            return;
        }

        // Choosing locations;
        double len = (lengthModifier / step) + rand.nextDouble() * 10;

        double endX = x + len * Math.cos(Math.toRadians(ang));
        double endY = y + len * Math.sin(Math.toRadians(ang));

        // Setting color and adding to pane;
        Line l = new Line(x, y, endX, endY);
        int colVal = (int) step * (255 / steps);
        l.setStroke(Color.rgb(colVal, colVal, 0));
        pane.getChildren().add(l);

        // Choosing angles and recursive calls;
        double angMult = angleIntensity + step * 2;
        double angPos = ang + rand.nextDouble() * angMult + 2;
        double angNeg = ang - rand.nextDouble() * angMult - 2;
        drawTree(pane, endX, endY, angPos, step);
        drawTree(pane, endX, endY, angNeg, step);

        // Randomly branch off in to a 3rd instead of just two (50/50);
        if (rand.nextBoolean()) {
            drawTree(pane, endX, endY, ang + (rand.nextDouble() - 0.5) * angMult * 2, step);
        }
    }

}
