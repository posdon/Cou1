package main.model.blackjack;

enum Color {
	CLOVERS ("Tr"),
	PIKES ("Pi"),
	HEARTS ("Co"),
	TILES ("Ca");
	
	private final String abbr;
	
	private Color(String abbr) {
		this.abbr = abbr;
	}
	
	public String getAbbr() { return this.abbr;}
}
