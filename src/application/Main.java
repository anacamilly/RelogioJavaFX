package application;
	
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class Main extends Application {
	
	//Criação do Label que irá informar as horas na tela.
	private Label labelRelogio = new Label();
	
	//SimpleDateFormat é a classe do Java que transforma datas para Strings.
	private SimpleDateFormat formatador = new SimpleDateFormat("hh:mm:ss a");
	
	//Emitido pelo Java
	public static void main(String[] args) {
		launch(args);
	}

	private void atualizaHoras() {
		Date agora = new Date();
		labelRelogio.setText(formatador.format(agora));
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//Criação da font usando método de fábrica.
		Font font = Font.font("Arial", FontWeight.EXTRA_BOLD, 70);
		labelRelogio.setFont(font);
		
		//Efeito da borda do Label
		labelRelogio.setEffect(new DropShadow(10, Color.BLUEVIOLET));
		
		//Ligação do loop infinito que roda a cada segundo e utiliza o Label chamando o metódo atualizaHoras 
		KeyFrame frm = new KeyFrame(Duration.millis(1000), e -> atualizaHoras());
		Timeline timeline = new Timeline(frm);
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
		
		//Criação do PrimaryStage, a scene com um StackPane e colocamos o lblRelogio
		Scene scene = new Scene(new StackPane(labelRelogio), 450, 150);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		//Título do Projeto
		primaryStage.setTitle("Relógio");
		
		//Ícone do Projeto
		Image image = new Image("C:/Users/User/eclipse-workspace/Relogio/img/rlg.png");
	    primaryStage.getIcons().add(image);
	}

}
