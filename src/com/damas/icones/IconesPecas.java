package com.damas.icones;

import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import com.damas.gui.CasaGUI;

public class IconesPecas {
	
	private URL PEDRA_BRANCA_URL = CasaGUI.class.getResource("/resources/pedra_branca.png"); 
    private URL DAMA_BRANCA_URL = CasaGUI.class.getResource("/resources/dama_branca.png"); 
    private URL PEDRA_VERMELHA_URL = CasaGUI.class.getResource("/resources/pedra_vermelha.png"); 
    private URL DAMA_VERMELHA_URL = CasaGUI.class.getResource("/resources/dama_vermelha.png"); 

    private Icon PEDRA_BRANCA = new ImageIcon(PEDRA_BRANCA_URL);
    private Icon DAMA_BRANCA = new ImageIcon(DAMA_BRANCA_URL);
    private Icon PEDRA_VERMELHA = new ImageIcon(PEDRA_VERMELHA_URL);
    private Icon DAMA_VERMELHA = new ImageIcon(DAMA_VERMELHA_URL);
	
    public URL getPedraBrancaUrl() {
		return PEDRA_BRANCA_URL;
	}
	public URL getDamaBrancaUrl() {
		return DAMA_BRANCA_URL;
	}
	public URL getPedraVermelhaUrl() {
		return PEDRA_VERMELHA_URL;
	}
	public URL getDamaVermelhaUrl() {
		return DAMA_VERMELHA_URL;
	}
	public Icon getPedraBranca() {
		return PEDRA_BRANCA;
	}
	public Icon getDamaBranca() {
		return DAMA_BRANCA;
	}
	public Icon getPedraVermelha() {
		return PEDRA_VERMELHA;
	}
	public Icon getDamaVermelha() {
		return DAMA_VERMELHA;
	}

}
