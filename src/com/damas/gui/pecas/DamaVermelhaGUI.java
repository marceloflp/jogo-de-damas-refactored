package com.damas.gui.pecas;

import javax.swing.JButton;

import com.damas.gui.CasaGUI;
import com.damas.icones.IconesPecas;
import com.damas.interfaces.pecasGUI;

public class DamaVermelhaGUI extends JButton implements pecasGUI{

	private static final long serialVersionUID = 1L;

	private IconesPecas icone;
	
	@Override
	public void desenharCasa(CasaGUI casa) {
		setIcon(icone.getDamaVermelha());
		
	}

}