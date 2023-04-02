package personnages;

public class Ronin extends Humain {
	int honneur = 1;
	public Ronin(String nom, String boissonFavorite, int argent) {
		super(nom, boissonFavorite, argent);
	}
	public void donner(Commercant beneficiaire, int somme) {
		parler(beneficiaire.getNom() + " prend ces " + somme + " sous.");
		beneficiaire.recevoir(somme);
		perdreArgent(somme);
	}
	public void provoquer(Yakuza adversaire) {
		parler("Je t'ai retrouvé vermine, tu vas payer pour ce que tu as fait à ce pauvre marchand!");
		if (2 * honneur >= adversaire.getReputation()){
			parler("Je t’ai eu petit yakusa!");
			int gain = adversaire.perdre();
			gagnerArgent(gain);
		} else {
			parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse en ont pris un coup.");
			int perte = getArgent();
			adversaire.gagner(perte);
			perdreArgent(perte);
		}
	}
}
