package personnages;

public class Yakuza extends Humain{ 
	private String clan;
	private int reputation = 0;
	 public Yakuza(String nom, String boissonFavorite, int argent, String clan) {
			super(nom,boissonFavorite,argent);
			this.clan = clan;
	 }
	 public int getReputation() {
		return reputation;
	}
	public void extorquer(Commercant victime) {
		int gain = victime.getArgent();
		gagnerArgent(gain);
		reputation+=1;
		parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par là ?");
		parler(victime.getNom() + ", si tu tiens à la vie donne moi ta bourse !");
		victime.seFaireExtorquer();
		parler("J’ai piqué les " + gain + " sous de " + victime.getNom() + 
				", ce qui me fait " + getArgent() + " sous dans ma poche. Hi ! Hi !");
	}
	 public int perdre() {
		int argent = getArgent();
		reputation--;
		parler("J’ai perdu mon duel et mes " + argent + " sous, snif... J'ai déshonoré le clan de "+ clan + ".");
		return argent;
	}
	 public void gagner(int gain) {
			gagnerArgent(gain);
			reputation++;
			parler("Ce ronin pensait vraiment battre " + getNom() + " du clan de " + clan + " ? "
					+ "Je l'ai dépouillé de ses " + gain + " sous.");
		}
	 @Override
	 public void direBonjour() {
		 super.direBonjour();
		 parler("Mon clan est celui de " + clan +".");
	 }
}