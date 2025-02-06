package com.damas.gui.pecas;

import com.damas.gui.CasaGUI;
import com.damas.icones.IconesPecas;
import com.damas.interfaces.pecasGUI;

import javax.swing.JButton;

public class PedraBrancaGUI extends JButton implements pecasGUI{
	
	private static final long serialVersionUID = 1L;
	
	private IconesPecas icone;
	
	public PedraBrancaGUI() {
		setIcon(null);
	}
	
	@Override
	public void desenharCasa(CasaGUI casa) {
		setIcon(icone.getPedraBranca());
		
	}

}
