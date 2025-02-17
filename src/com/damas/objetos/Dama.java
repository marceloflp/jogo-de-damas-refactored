package com.damas.objetos;

import com.damas.gui.CasaGUI;

/**
 * Dama do jogo.
 * <p>Recebe uma casa e um tipo associado</p>
 * @author João Victor da S. Cirilo {@link joao.cirilo@academico.ufpb.br}
 */
public class Dama extends Pedra{

    /**
     * @param casa Objeto Casa
     * @param tipo int tipo de peça (1 = Dama Branca, 3 = Dama vermelha) 
     */
    public Dama(Casa casa, int tipo) {
    	super(casa, tipo);

        casa.colocarPeca(this);
    }

    /**
     * Movimento da Dama que pode andar várias casas na diagonal
     * @param destino
     * @return boolean. True se puder ser movida e false se não 
     */
   @Override
    public boolean isMovimentoValido(Casa destino) {
        int distanciaX = Math.abs((destino.getX() - casa.getX()));
        int distanciaY = Math.abs((destino.getY() - casa.getY()));

        if (distanciaX == distanciaY) return true;

        return false;
    }
   
   @Override
   public void desenhar(CasaGUI casaGUI) {
       if (this.tipo == DAMA_BRANCA) {
           casaGUI.desenharDamaBranca();
       } else if (this.tipo == DAMA_VERMELHA) {
           casaGUI.desenharDamaVermelha();
       }
   }
   
   @Override
   public boolean isMesmoTipo(Peca outraPeca) {
       // Verifica se a outra peça é uma Dama e se tem o mesmo tipo (branca ou vermelha).
       return outraPeca instanceof Dama && this.getTipo() == outraPeca.getTipo();
   }

}
