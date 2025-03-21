package com.damas.objetos;

import com.damas.gui.CasaGUI;

/**
 * Representa uma Peça do jogo.
 * Possui uma casa e um tipo associado.
 * 
 * @author Alan Moraes &lt;alan@ci.ufpb.br&gt;
 * @author Leonardo Villeth &lt;lvilleth@cc.ci.ufpb.br&gt;
 * @author José Alisson Rocha da Silva {@link jose.alisson2@academico.ufpb.br}
 */
public class Pedra extends Peca {

    protected Casa casa;
    protected int tipo;

    /**
     * @param casa Objeto Casa
     * @param tipo int tipo de peça (0 = Pedra Branca, 2 = Pedra vermelha) 
     */
    public Pedra(Casa casa, int tipo) {
        this.casa = casa;
        this.tipo = tipo;
        casa.colocarPeca(this);
    }
    
    @Override
    public void mover(Casa destino) {
        casa.removerPeca();
        destino.colocarPeca(this);
        casa = destino;
    }

    @Override
    public boolean isMovimentoValido(Casa destino) {

        // SENTIDO UNITÁRIO E DISTANCIA X E Y DA CASA ATUAL ATÉ A CASA DE DESTINO
        int distanciaX = Math.abs(destino.getX() - casa.getX());
        int distanciaY = Math.abs(destino.getY() - casa.getY());

        if ((distanciaX == 0) || (distanciaY == 0)) return false;

        // REGRA DE MOVIMENTO NO CASO DA DISTÂNCIA SER DE 2 CASAS (MOVIMENTO DE COMER PEÇA)
        if ((distanciaX <= 2 || distanciaY <= 2) && (distanciaX == distanciaY)) {
            return true;
        }

        return false;
    }

    @Override
    public int getTipo() {
        return tipo;
    }
    
    @Override
    public void desenhar(CasaGUI casaGUI) {
        if (this.tipo == PEDRA_BRANCA) {
            casaGUI.desenharPedraBranca();
        } else if (this.tipo == PEDRA_VERMELHA) {
            casaGUI.desenharPedraVermelha();
        }
    }
    
    @Override
    public boolean pertenceAoJogador(int jogador) {
        return (jogador == 1 && (tipo == PEDRA_BRANCA || tipo == DAMA_BRANCA)) ||
               (jogador == 2 && (tipo == PEDRA_VERMELHA || tipo == DAMA_VERMELHA));
    }

	@Override
	public boolean isMesmoTipo(Peca outraPeca) {
		// Verifica se a outra peça é uma Pedra e se tem o mesmo tipo (branca ou vermelha).
        return outraPeca instanceof Pedra && this.getTipo() == outraPeca.getTipo();
		
	}

	@Override
	public boolean isPedra() {
		return true;
	}
	
	@Override
    public boolean podeTransformarParaDama(int y) {
        if (this.tipo == PEDRA_BRANCA) {
            return y == 7;
        } else if (this.tipo == PEDRA_VERMELHA) {
            return y == 0;
        }
        return false;
    }
	
	public Dama transformarEmDama(Casa casa) {
        if (this.tipo == PEDRA_BRANCA) {
            return new Dama(casa, DAMA_BRANCA); 
        } else if (this.tipo == PEDRA_VERMELHA) {
            return new Dama(casa, DAMA_VERMELHA);
        }
        return null;
    }
}
