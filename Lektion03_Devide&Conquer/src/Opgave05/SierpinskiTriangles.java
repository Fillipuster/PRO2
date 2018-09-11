package Opgave05;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class SierpinskiTriangles extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        Pane root = initContent();
        Scene scene = new Scene(root);

        stage.setTitle("Sierpinsky");
        stage.setScene(scene);
        stage.show();
    }

    public void formatTriangle(Polygon p) {
        p.setFill(Color.TRANSPARENT);
        p.setStroke(Color.BLACK);
    }

    private Pane initContent() {
        Pane pane = new Pane();
        pane.setPrefSize(500, 500);

        Polygon firstTriangle = new Polygon();
        firstTriangle.getPoints().addAll(new Double[] { 5d, 495d, 250d, 5d, 495d, 495d, });
        formatTriangle(firstTriangle);
        pane.getChildren().add(firstTriangle);

        sierpinsky(pane, 5d, 495d, 5);
        return pane;
    }

    private void sierpinsky(Pane pane, double x, double y, int stepsLeft) {
        if (stepsLeft <= 0) {
            return;
        }

        Polygon p = new Polygon();

        double len = stepsLeft * 10;

        double x2 = x + len * Math.cos(Math.toRadians(45));
        double y2 = y + len * Math.sin(Math.toRadians(45));

        double x3 = x2 - len * Math.cos(Math.toRadians(-45));
        double y3 = y2 - len * Math.sin(Math.toRadians(-45));

        p.getPoints().addAll(new Double[] { x, y, x, y, x2, y2, x3, y3 });
        p.setFill(Color.rgb(0, 0, 0, 0));
        p.setStroke(Color.rgb(0, 0, 0));
        pane.getChildren().add(p);

        stepsLeft--;
        // sierpinsky(pane, stepsLeft);
    }

    // private void drawTree(Pane pane, double x, double y, double ang, double step)
    // {
    // step++;
    //
    // Random rand = new Random();
    //
    // // Termination;
    // if (step > steps) {
    // return;
    // }
    //
    // // Choosing locations;
    // double len = (lengthModifier / step) + rand.nextDouble() * 10;
    //
    // double endX = x + len * Math.cos(Math.toRadians(ang));
    // double endY = y + len * Math.sin(Math.toRadians(ang));
    //
    // // Setting color and adding to pane;
    // Line l = new Line(x, y, endX, endY);
    // int colVal = (int) step * (255 / steps);
    // l.setStroke(Color.rgb(colVal, colVal, 0));
    // pane.getChildren().add(l);
    //
    // // Choosing angles and recursive calls;
    // double angMult = angleIntensity + step * 2;
    // double angPos = ang + rand.nextDouble() * angMult + 2;
    // double angNeg = ang - rand.nextDouble() * angMult - 2;
    // drawTree(pane, endX, endY, angPos, step);
    // drawTree(pane, endX, endY, angNeg, step);
    //
    // // Randomly branch off in to a 3rd instead of just two (50/50);
    // if (rand.nextBoolean()) {
    // drawTree(pane, endX, endY, ang + (rand.nextDouble() - 0.5) * angMult * 2,
    // step);
    // }
    // }

}
