package personnages;
public class Commercant extends Humain{ 
	 public Commercant(String nom, int argent) {
			super(nom,"thé",argent);
	 }
	 public int seFaireExtorquer() {
		 int argent = getArgent();
		perdreArgent(getArgent());
		parler("J’ai tout perdu! Le monde est trop injuste...");
		return argent;
	}
	 public void recevoir(int argent){
		parler(argent + " sous ! Je te remercie généreux donateur!");
	}
}