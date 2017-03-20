package Segon.gestorDadrecesDinteres;

import java.io.Serializable;

import javafx.beans.property.SimpleStringProperty;

public class UrlGuardada implements Serializable {
	
	SimpleStringProperty titol;
	SimpleStringProperty url;
	SimpleStringProperty categoria;

	public UrlGuardada(){
		
	}
	
	public UrlGuardada(String tito, String ur, String categori){
		titol = new SimpleStringProperty(tito);
		url = new SimpleStringProperty(ur);
		categoria = new SimpleStringProperty(categori);
	}
/***************** STRINGS ******************/
	public String getTitol() {
		return titol.get();
	}

	public void setTitol(String titol) {
		this.titol.set(titol);
	}

	public String getUrl() {
		return url.get();
	}

	public void setUrl(String url) {
		this.url.set(url);
	}

	public String getCategoria() {
		return categoria.get();
	}

	public void setCategoria(String categoria) {
		this.categoria.set(categoria);
	}
	
/***************** PROPERTYS ******************/
	public SimpleStringProperty getTitolP() {
		return titol;
	}

	public SimpleStringProperty getUrlP() {
		return url;
	}

	public SimpleStringProperty getCategoriaP() {
		return categoria;
	}

	public void setTitolP(SimpleStringProperty titol) {
		this.titol = titol;
	}

	public void setUrlP(SimpleStringProperty url) {
		this.url = url;
	}

	public void setCategoriaP(SimpleStringProperty categoria) {
		this.categoria = categoria;
	}

}
