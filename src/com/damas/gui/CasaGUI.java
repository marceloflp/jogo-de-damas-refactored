package com.damas.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.damas.constantes.CoresTabuleiro;
import com.damas.cores.Cores;
import com.damas.icones.IconesPecas;

/**
 * Interface Grafica de uma Casa no tabuleiro do jogo.
 *
 * @author Alan Moraes &lt;alan@ci.ufpb.br&gt;
 * @author Leonardo Villeth &lt;lvilleth@cc.ci.ufpb.br&gt;
 * @author João Victor da S. Cirilo {@link joao.cirilo@academico.ufpb.br}
 */
public class CasaGUI extends JButton {

	private CoresTabuleiro constante;
	private IconesPecas icone;
	private Cores cores;
	
    // Constantes 
    public static final Color COR_CLARA = new Color(255, 255, 250);
    public static final Color COR_ESCURA = new Color(87, 168, 124);
    private static final Color COR_DESTAQUE = new Color(0, 1, 0, 0.4f);

    // Cores das pecas
    public final int SEM_PECA = -1;
    public final int PECA_BRANCA = 0;
    public final int PECA_VERMELHA = 1;

    private int x;
    private int y;
    private Color cor;

    public CasaGUI(int x, int y, Color cor, TabuleiroGUI tabuleiro) {
        this.x = x;
        this.y = y;
        this.cor = cor;
        this.icone = new IconesPecas();
        this.cores = new Cores();
        setIcon(null);

        // Layout e cor
        setBackground(cor);
        setOpaque(false);
        setBorder(BorderFactory.createLineBorder(cor, 1));
        setContentAreaFilled(false);

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabuleiro.getJanela().reagir((CasaGUI) e.getSource());
            }
        });
    }

    public int getPosicaoX() {
        return this.x;
    }

    public int getPosicaoY() {
        return this.y;
    }

    public void desenharPedraBranca() {
        setIcon(icone.getPedraBranca());
    }

    public void desenharPedraVermelha() {
        setIcon(icone.getPedraVermelha());
    }

    public void desenharDamaBranca() {
        setIcon(icone.getDamaBranca());
    }

    public void desenharDamaVermelha() {
        setIcon(icone.getDamaVermelha());
    }

    public void apagarPeca() {
        setIcon(null);
    }

    public boolean possuiPeca() {
        return getIcon() != null;
    }
    
    public int getCorPeca() {
        Icon icones = getIcon();
        
        if (icones == icone.getPedraBranca() || icones == icone.getDamaBranca()) {
            return PECA_BRANCA;
        }
        else if (icones == icone.getPedraVermelha() || icones == icone.getDamaVermelha()) {
             return PECA_VERMELHA;
        }
        else {
            return SEM_PECA;
        }
    }
    
    public void destacar() {
        setBackground(COR_DESTAQUE);
    }

    public void atenuar() {
        setBackground(cor);
    }

    /**
     * Pinta o componente com a cor de fundo, aceita valores RGBA
     */
    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }

}
