package Segon.gestorDadrecesDinteres;


public class Categoria {
	
	String nom = "";
	String [] pagines;
	
	public Categoria(){
		
	}
	public Categoria(String no){
		nom = no;
	}
	public Categoria(String no, String[]pagine){
		nom = no;
		pagines = pagine;
	}
	
	
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String[] getPagines() {
		return pagines;
	}	
	public void setPagines(String[] pagines) {
		this.pagines = pagines;
	}
	

}
