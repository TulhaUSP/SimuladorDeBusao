package linha.de.onibus;

import java.util.Random;
import java.util.ArrayList;

public class Paradas {
    private int posicao, num_esperando;
    boolean terminal;
    Random rn = new Random();
    Onibus bus = new Onibus();

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public int getNum_esperando() {
        return num_esperando;
    }

    public void setNum_esperando(int num_esperando) {
        this.num_esperando = num_esperando;
    }
    
    public Paradas(boolean terminal, int passageiros)
    {
        this.terminal = terminal;
        
        if(terminal)
        {
            num_esperando = rn.nextInt(30);
            
        }
        else
        {
            num_esperando = rn.nextInt(15);
        }
       
        
        if(passageiros + num_esperando > bus.getEspaco())
        {
            num_esperando = bus.getEspaco() - passageiros;
        }
       
  /*
        for(Passageiros pas: p)//ArrayList de passageiros
        {
            if(pas.getDestino()>distanciaDaParadaAtual)
            {
                pessoasFicaram++;
            }
        }

        // Se o numero de passageiros que estão for maior que o espaço do ônibus 
        if ((p.size()+ num_passageiros)>bus.getEspaco())
        {
            //Precisa verificar aqueles que irão descer
            

            //Se somente sobem passageiros, o numero de passageiros será o espaco menos a quantidade
            num_passageiros = bus.getEspaco() - p.size();
            
            
  */              
    }
    
    public Paradas()
    {
        terminal = true;
    }
    
}
    
