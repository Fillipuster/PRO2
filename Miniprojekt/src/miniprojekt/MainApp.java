package miniprojekt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.application.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApp extends Application {

	private static Connection connection;
	private static Statement stmt;
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		// JDBC
		try {
			// Generel opsætning via native driver;
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=miniprojekt2semester;user=sa;password=1116;");
			stmt = connection.createStatement();
		}
		catch (Exception e) {
			System.out.println("Database connection error: " + e.getMessage());
			e.printStackTrace();
		}
		
		// JavaFX
		GridPane pane = new GridPane();
    	pane.setPadding(new Insets(10d));
    	pane.setHgap(10d);
    	pane.setVgap(10d);
        pane.setPrefSize(350, 250);
        buildWindow(pane);
        
        stage.setTitle("EAAA Karakterregistrereing");
        stage.setScene(new Scene(pane));
		stage.show();
	}
	
	private ComboBox<String> cboxUddannelser;
	private ComboBox<Eksamen> cboxEksaminer;
	private ComboBox<Studerende> cboxStuderende;
	private ComboBox<Integer> cboxKarakter;
	private Button btnSubmit;
	private Label lblStatus;
	
	private void buildWindow(GridPane pane) {
		cboxUddannelser = new ComboBox<String>();
		cboxUddannelser.getItems().addAll(getUddannelser());
		cboxUddannelser.setOnAction(event -> cboxUddannelserAction());
		cboxUddannelser.setPrefWidth(300);
		pane.add(cboxUddannelser, 0, 0);
		
		cboxEksaminer = new ComboBox<Eksamen>();
		cboxEksaminer.setDisable(true);
		cboxEksaminer.setOnAction(event -> cboxEksaminerAction());
		cboxEksaminer.setPrefWidth(300);
		pane.add(cboxEksaminer, 0, 1);
		
		cboxStuderende = new ComboBox<Studerende>();
		cboxStuderende.setDisable(true);
		cboxStuderende.setOnAction(event -> cboxStuderendeAction());
		cboxStuderende.setPrefWidth(300);
		pane.add(cboxStuderende, 0, 2);
		
		cboxKarakter = new ComboBox<Integer>();
		cboxKarakter.setDisable(true);
		cboxKarakter.setOnAction(event -> cboxKarakterAction());
		pane.add(cboxKarakter, 0, 3);
		fillCboxKarakter();
		
		btnSubmit = new Button("Submit");
		btnSubmit.setDisable(true);
		btnSubmit.setOnAction(event -> btnSubmitAction());
		pane.add(btnSubmit, 0, 4);
		
		lblStatus = new Label("");
		pane.add(lblStatus, 0, 5);
	}
	
	private ArrayList<String> getUddannelser() {
		ArrayList<String> result = new ArrayList<>();
		String sql = "SELECT navn FROM Uddannelse";
		
		try {
			ResultSet queryResult = stmt.executeQuery(sql);
			while (queryResult.next()) {
				result.add(queryResult.getString("navn"));
			}
		} catch (SQLException e) {
			System.out.println("SQL Error: " + e.getMessage());
			lblStatus.setText(e.getMessage());
			e.printStackTrace();
		}
		
		return result;
	}
	
	private ArrayList<Eksamen> getEksaminer(String uddannelse) {
		ArrayList<Eksamen> result = new ArrayList<>();
		String sql = "SELECT id, betegnelse FROM Eksamen WHERE uddannelse = (SELECT id FROM Uddannelse WHERE navn = ?)";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.clearParameters();
			ps.setString(1, uddannelse);
			ResultSet queryResult = ps.executeQuery();
			while (queryResult.next()) {
				Eksamen e = new Eksamen(queryResult.getInt("id"), queryResult.getString("betegnelse"));
				result.add(e);
			}
		} catch (SQLException e) {
			System.out.println("SQL Error: " + e.getMessage());
			lblStatus.setText(e.getMessage());
			e.printStackTrace();
		}
		
		return result;
	}
	
	private ArrayList<Studerende> getStuderende(String uddannelse) {
		ArrayList<Studerende> result = new ArrayList<>();
		String sql = "SELECT fornavn, efternavn, cpr FROM Studerende WHERE uddannelse = (SELECT id FROM Uddannelse WHERE navn = ?)";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.clearParameters();
			ps.setString(1, uddannelse);
			ResultSet queryResult = ps.executeQuery();
			while (queryResult.next()) {
				Studerende s = new Studerende(queryResult.getString("cpr"), queryResult.getString("fornavn"), queryResult.getString("efternavn"));
				result.add(s);
			}
		} catch (SQLException e) {
			System.out.println("SQL Error: " + e.getMessage());
			lblStatus.setText(e.getMessage());
			e.printStackTrace();
		}
		
		return result;
	}
	
	private void cboxUddannelserAction() {
		cboxEksaminer.getItems().removeAll(cboxEksaminer.getItems());
		cboxEksaminer.getItems().addAll(getEksaminer(cboxUddannelser.getSelectionModel().getSelectedItem()));
		if (cboxEksaminer.getItems().size() > 0) {
			cboxEksaminer.setDisable(false);
		} else {
			cboxEksaminer.setDisable(true);
		}
	}
	
	private void cboxEksaminerAction() {
		cboxStuderende.getItems().removeAll(cboxStuderende.getItems());
		cboxStuderende.getItems().addAll(getStuderende(cboxUddannelser.getSelectionModel().getSelectedItem()));
		if (cboxStuderende.getItems().size() > 0) {
			cboxStuderende.setDisable(false);
		} else {
			cboxStuderende.setDisable(true);
		}
	}
	
	private void cboxStuderendeAction() {
		cboxKarakter.setDisable(cboxStuderende.getSelectionModel().isEmpty());
	}
	
	private void cboxKarakterAction() {
		btnSubmit.setDisable(cboxKarakter.getSelectionModel().isEmpty());
	}
	
	private void btnSubmitAction() {
		if (!checkAllCboxes()) {
			lblStatus.setText("Alle felter skal udfyldes!");
			return;
		}
		
		String sql = "INSERT INTO Eksamensforsøg VALUES(?, ?, ?, GETDATE())";
		
		try {
			int karakter = cboxKarakter.getSelectionModel().getSelectedItem();
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.clearParameters();
			ps.setString(1, cboxStuderende.getSelectionModel().getSelectedItem().getCpr());
			ps.setInt(2, cboxEksaminer.getSelectionModel().getSelectedItem().getId());
			ps.setInt(3, karakter);
			ps.execute();
			
			String lbl = "Tillykke med " + karakter + " tallet!\n";
			if (karakter < 2) {
				lbl += "Godt på vej.";
			} else {
				lbl += "O.K.";
			}
			lblStatus.setText(lbl);
		} catch (SQLException e) {
			lblStatus.setText(e.getMessage());
			if (e.getErrorCode() == 50000) {
				return;
			}
			System.out.println("SQL Error: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	private void fillCboxKarakter() {
		cboxKarakter.getItems().add(-3);
		cboxKarakter.getItems().add(0);
		cboxKarakter.getItems().add(2);
		cboxKarakter.getItems().add(4);
		cboxKarakter.getItems().add(7);
		cboxKarakter.getItems().add(10);
		cboxKarakter.getItems().add(12);
	}
	
	private boolean checkAllCboxes() {
		return (!cboxUddannelser.getSelectionModel().isEmpty() && !cboxEksaminer.getSelectionModel().isEmpty() && !cboxStuderende.getSelectionModel().isEmpty() && !cboxKarakter.getSelectionModel().isEmpty());
	}

}
