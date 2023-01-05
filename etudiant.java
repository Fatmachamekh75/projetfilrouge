import java.time.LocalDate;
import java.util.Date;

/**
 * 
 */

/**
 * @author Fatma
 *
 */
public class Etudiant {
	
	private final int NUMEROETU;
	private static int numprochainetu=1;
	private String nom;
	private String prenom;
	private String adresse;
	private LocalDate datenaissance;;
	/** les accesseurs**/
	public static int getNumprochainetu() {
		return numprochainetu;
	}
	public static void setNumprochainetu(int numprochainetu) {
		Etudiant.numprochainetu = numprochainetu;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return this.adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public LocalDate getDatenaissance() {
		return datenaissance;
	}
	public void setDatenaissance(LocalDate datenaissance) {
		this.datenaissance = datenaissance;
	}
	public int getNUMEROETU() {
		return NUMEROETU;
	}
	
	
	/**les constructeurs**/
	public Etudiant(String nom, String prenom, String adresse, String datenaissance) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.datenaissance = LocalDate.parse(datenaissance);
		
		this.NUMEROETU=this.getNumprochainetu();
		this.incrementernumero();
	}
	public Etudiant(Etudiant E) {
		this.nom=E.nom;
		this.prenom=E.prenom;
		this.datenaissance=E.datenaissance;
		this.adresse=E.adresse;
		this.NUMEROETU=this.getNumprochainetu();
		this.incrementernumero();
	}
	/** les méthodes**/
	@Override
	public String toString() {
		return "Etudiant [NUMEROETU=" + NUMEROETU + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse
				+ ", datenaissance=" + datenaissance + "]";
	}
	public int incrementernumero() {
		
		return this.numprochainetu++;
		
	}
	
	public double moyparmatire(Note [] note,Matiere M) {
		 double moy=0;
		 int j=0;
		 for (int i=0;i<note.length;i++) {
		    if (note[i].getM()==M &&this.getNUMEROETU()==note[i].getEt().getNUMEROETU()) {
		    	moy+=note[i].getNote();
		    	j++;
		    }
		 }
		 return moy/j;
		
		
	}
	public double moygeneral(Note []l) {
		int j=0;
		double somme=0;
		for (int i=0;i<l.length;i++)
		   if (this.getNUMEROETU()==l[i].getEt().getNUMEROETU()) {
			   double c=l[i].getM().getCoef();
			   somme=somme+this.moyparmatire(l,l[i].getM())*c;
			   j+=c
					   ;
			   
			    }
		double moyenne=somme/j;
		return moyenne;
		
	}
	
	public String mention(double moye) {
		String mention;
		if (moye<10) {
			mention="redoublant";}
		else 
			if(moye<14) {
				mention="assez bien";}
			else 
				mention="très bien";
		
		
		return mention;
			
		
		
	}
	
	 public Etudiant comparet(Etudiant e,Etudiant et,double moye1,double moye2) {
		 if (moye1<moye2)
			 return e;
		 else 
			 return et;
			 
		 
	
	 }
	}
	