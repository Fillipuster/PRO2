package display;

import java.util.Scanner;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;

public class MainApp extends Application {

	public static void main(String[] args) {
		Application.launch();
	}
	
	private Sphere ball;

	@Override
	public void start(Stage primaryStage) throws Exception {
		Button btnRotate = new Button("Rotate");
		btnRotate.setOnAction(e -> btnRotateAction());
		ball = new Sphere(200);
		ball.setMaterial(buildMaterial());
		Group root = new Group(ball, btnRotate);
		
		Scene scene = new Scene(root, 600, 600);
		scene.setFill(Color.BLACK);
		PerspectiveCamera camera = new PerspectiveCamera(true);
		camera.setNearClip(0.1);
		camera.setFarClip(1000);
		camera.setTranslateZ(-1000);
		scene.setCamera(camera);
		
		primaryStage.setTitle("Navball");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private PhongMaterial buildMaterial() {
		PhongMaterial material = new PhongMaterial();
		
		material.setDiffuseMap(new Image(
			"C:\\eclipse\\eclipse-workspace\\Navball\\planet.jpg",
			4096d,
			2048d,
			true,
			true
		));
		
		return material;
	}
	
	private void btnRotateAction() {
		ball.setRotate(10d);
	}

}
