package Segon.gestorDadrecesDinteres;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;
import java.util.Optional;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.input.MouseEvent;

import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;

public class SampleController {
	@FXML
	private Button Afegir;
	@FXML
	private Button Editar;
	@FXML
	private Button Borrar;
	@FXML
	private TableView<UrlGuardada> taula;
	@FXML
	private TableColumn taulaDescripcio;
	@FXML
	private TableColumn taulaUrl;
	@FXML
	private TableColumn taulaCategoria;

	ObservableList<UrlGuardada> observableWebs;
	private final String[] categories = {"Buscador", "educacio", "entreteniment", "altres"};
	
	/* Crear metodos de guardado y carga de los datos */

	// Event Listener on Button[#Afegir].onMouseClicked
	@FXML
	public void Afegir(MouseEvent event) {
		// Abrir ventana
		TextInputDialog ventanEmergente = new TextInputDialog("Walter White");
		ventanEmergente.setTitle("Tens tot Internet davant teu!");
		ventanEmergente.setHeaderText("On vols anar?");
		ventanEmergente.setContentText("Entra la teva url: htt://");

		// Optional puede o no puede contener un valor no nulo
		Optional<String> result = ventanEmergente.showAndWait();
		
		// ifPresent es true si el Optional contiene datos o false si no contiene
		// Como hacerlo con lambda
		result.ifPresent(url -> {
			// Comprovar si la url existe o por ejemplo conectarme a la url y buscar el titulo
			try {
				//      www.google.es
				
				Document doc = Jsoup.connect("http://"+url).get();
				String title = doc.title();
				String categoria;

				observableWebs.add(new UrlGuardada(title, url, retornaCategoriaWeb(title)));
				///taula.setItems(observableWebs);
				
			}catch(MalformedURLException e){
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		// Buscar si esta en la tabla y si está poner el mismo nombre que tiene en la tabla
		// (por si se ha editado el nombre)ir a la pagina, buscar el titulo, introducirlo en
		// la tabla y buscar si tiene categoria. Por ultimo cargar la tabla.
	}
	// Event Listener on Button[#Editar].onMouseClicked
	private String retornaCategoriaWeb(String pagina){
		/*for(Categoria categoria: categoriesList){
			String[] categoriesArray = categoria.getPagines();
			for(int i=0;i<categoriesArray.length;i++){
				if(categoriesArray[i].contains(pagina)){
					return categoria.getNom();
				}
			}
		}*/
		return null;
	}
	
	@FXML
	public void Editar(MouseEvent event) {
		// Abrir ventana
				TextInputDialog ventanEmergente = new TextInputDialog("Jessie Pinkman");
				ventanEmergente.setTitle("Edita el nom de la web");
				ventanEmergente.setHeaderText("Quin nom li vols posar?");
				ventanEmergente.setContentText("Proxim nom de la Web:");

				// Optional puede o no puede contener un valor no nulo
				Optional<String> result = ventanEmergente.showAndWait();
				
				// ifPresent es true si el Optional contiene datos o false si no contiene
				result.ifPresent(titol -> {
					// Acceder a la descripcion, modificarla y actualizar la tabla 
					try{
						int selected = taula.getSelectionModel().getSelectedIndex();
						UrlGuardada url = new UrlGuardada(titol,observableWebs.get(selected).getUrl(), observableWebs.get(selected).getCategoria());
						observableWebs.set(selected, url);
						
					} catch (Exception e){
						
					}
				});
	}
	// Event Listener on Button[#Borrar].onMouseClicked
	@FXML
	public void Borrar(MouseEvent event) {
		// Eliminar descripcion y url
		UrlGuardada fila = taula.getSelectionModel().getSelectedItem();
		observableWebs.remove(fila);
	}
	
	
	
	public void initialize(){
		taulaDescripcio.setCellValueFactory(
                new PropertyValueFactory<UrlGuardada, String>("titol"));
		taulaUrl.setCellValueFactory(
                new PropertyValueFactory<UrlGuardada, String>("url"));
		taulaCategoria.setCellValueFactory(
                new PropertyValueFactory<UrlGuardada, String>("categoria"));
		
		/* Introducir categorias, paginas con categoría y crear una funcion con un switch que cada caso 
		 * sea una categoría*/
		observableWebs =  FXCollections.observableArrayList();	
		taula.setItems(observableWebs);
		
	}
}