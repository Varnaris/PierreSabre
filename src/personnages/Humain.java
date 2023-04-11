package personnages;

public class Humain {
	private String nom;
	private String boissonFavorite;
	private int argent;
	protected Humain[] memoire = new Humain[30];
	protected int nbConnaissance = 0;
	public Humain(String nom, String boissonFavorite, int argent) {
		super();
		this.nom = nom;
		this.boissonFavorite = boissonFavorite;
		this.argent = argent;
	}
	public String getNom() {
		return nom;
	}
	public int getArgent() {
		return argent;
	}
	protected void parler(String texte) {
		System.out.println("(" + nom + ") - " + texte);
	}
	public void direBonjour() {
		parler("Bonjour ! Je m’appelle " + nom + " et j’aime boire du " + boissonFavorite + ".");
	}
	public void boire() {
		parler("Mmmm, un bon verre de " + boissonFavorite + " ! GLOUPS !");
	}
	public void acheter(String bien, int prix) {
		if (prix <= argent) {
			parler("J'ai " + argent  + " sous en poche. Je vais pouvoir m'offrir " + bien + " à " + prix + " sous");
			perdreArgent(prix);
		} else {
			parler("Je n'ai plus que " + argent + " sous en poche. Je ne peux même pas m'offrir " + bien + " à " + 
			prix + " sous");
		}
	}
	protected void perdreArgent(int perte) {
		argent-=perte;
	}
	protected void gagnerArgent(int gain) {
		argent+=gain;
	}
	public void faireConnaissanceAvec(Humain humain) {
		direBonjour();
		humain.repondre(this);
		memoriser(humain);
	}
	private void memoriser(Humain humain) {
		if (nbConnaissance < 30) {
			memoire[nbConnaissance] = humain;
			nbConnaissance++;
		} else {
			for (int i = 0; i < 29; i++) {
				memoire[i] = memoire[i+1];
			}
			memoire[29] = humain;
		}
	}
	private void repondre(Humain humain) {
		direBonjour();
		memoriser(humain);
		
	}
	public void listerConnaissance() {
		String texte = "Je connais beaucoup de monde dont : ";
		for (int i = 0; i < nbConnaissance; i++) {
			if (i < nbConnaissance - 1)
				texte += memoire[i].getNom() +", ";
			else
				texte += memoire[i].getNom();
		}
		parler(texte);
	}
}
