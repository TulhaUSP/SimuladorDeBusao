package linha.de.onibus;

import java.util.Random;

public class Passageiros {
    
    private int tempo_embarque, origem, destino, tempo_viagem, tempo_espera;
    private boolean deficiente;
    Random rn = new Random();
    

    public int getTempo_embarque() {
        return tempo_embarque;
    }

    public void setTempo_embarque(int tempo_embarque) {
        this.tempo_embarque = tempo_embarque;
        
    }

    public int getOrigem() {
        return origem;
    }

    public void setOrigem(int origem) {
        this.origem = origem;
    }

    public int getDestino() {
        return destino;
    }

    public void setDestino(int destino) {
        this.destino = destino;
    }

    public int getTempo_viagem() {
        return tempo_viagem;
    }

    public void setTempo_viagem(int tempo_viagem) {
        this.tempo_viagem = tempo_viagem;
    }

    public int getTempo_espera() {
        return tempo_espera;
    }

    public void setTempo_espera(int tempo_espera) {
        this.tempo_espera = tempo_espera;
    }

    public boolean isDeficiente() {
        return deficiente;
    }

    public void setDeficiente(boolean deficiente) {
        this.deficiente = deficiente;
    }
    
    public Passageiros()
    {
        tempo_embarque = rn.nextInt(15)+5;
        if(rn.nextInt(100)<5)
        {
            deficiente = true;
            tempo_embarque *= 4;
        }
    }
    
    
    
}
