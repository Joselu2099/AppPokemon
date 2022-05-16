package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import controller.AppPokemon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.pokemon.Pokemon;
import model.pokemon.PokemonRepository;

public class PokemonChooserController implements Initializable{
	
	@FXML
	private Label lblWarning;
	@FXML
	private ImageView pk1;
	@FXML
	private ImageView pk2;
	@FXML
	private ImageView pk3;
	@FXML
	private ImageView pk1Choosed;
	@FXML
	private ImageView pk2Choosed;
	@FXML
	private ImageView pk3Choosed;
	@FXML
	private Button btnEscoger;
	
	private ArrayList<Pokemon> pokes;
	private int pokeElegido;
	
	@FXML
    private void choosedOne() {
		pokeElegido=0;
		pk1Choosed.setVisible(true);
		pk2Choosed.setVisible(false);
		pk3Choosed.setVisible(false);
	}
	
	@FXML
    private void choosedTwo() {
		pokeElegido=1;
		pk1Choosed.setVisible(false);
		pk2Choosed.setVisible(true);
		pk3Choosed.setVisible(false);
	}
	
	@FXML
    private void choosedThree() {
		pokeElegido=2;
		pk1Choosed.setVisible(false);
		pk2Choosed.setVisible(false);
		pk3Choosed.setVisible(true);
	}
	
	@FXML
    private void escoger(ActionEvent event) {
		if(pokeElegido==-1) {
			lblWarning.setText("No has elegido ningun pokemon");
		}else {
			AppPokemon.getINSTANCE().escogerPokemon(pokes.get(pokeElegido));
	        ControladorGUI.setScene("appPokemon");
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		pokeElegido=-1;
		pokes = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			pokes.add(PokemonRepository.getINSTANCE().generarPokemonRandom(1));
		}
		pk1.setImage(new Image(pokes.get(0).getSprite()));
		pk2.setImage(new Image(pokes.get(1).getSprite()));
		pk3.setImage(new Image(pokes.get(2).getSprite()));
	}
}
