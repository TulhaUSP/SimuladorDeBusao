/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linha.de.onibus;
import java.util.ArrayList;
/**
 *
 * @author a10723670
 */
public class Onibus {
    	private double velocidade;
    
	private String conservacao;
    
	private String tamanho;
    
	private boolean adaptacao;
    	
	private int espaco;
    
	private int posicao;
    
	private int tempo_viagem_seg;
        
        private int tempo_onibus;
        
        private int tempo_tot_embarque;
        
        
        public void Onibus()
        {
            tempo_onibus = 0;
            tempo_tot_embarque = 0;
        }
    
    

	public double getVelocidade()
        {
            return velocidade;                 
    
	}
    
    

	public String getConservacao()
    	{
            return conservacao;
    
	}
    
    
	
	public String getTamanho()
    	{
            return tamanho;
    
	}
    
    

	public boolean getAdaptacao()
  	{
            return adaptacao;               
               
    
	}
    
    
	
	public int getEspaco()
  	{
            return espaco;
            
	}
    
    

	public int getPosicao()
  	{
        
            return posicao;
	}
    
    

	public int getTempo()
  	{
        
            return tempo_viagem_seg;
	}
    
    
	
	/*
        public double getVelocidadeImprevisto()
  	{
        
            
	}
        
    
    

	public int getQuantEmbarca()
  	{
            
    
	}
    
    

	public int getQuantDesembarca()
  	{
        
    
	}
        */


	public void setVelocidade(double velocidade)
  	{
            this.velocidade=velocidade;
    
	}
    
    

	public void setConservacao(String conservacao)
  	{
            this.conservacao=conservacao;
    
	}
    
    
	
	public void setTamanho(String tamanho)
  	{
            this.tamanho=tamanho;
    
	}
    
    

	public void setAdaptacao(boolean adaptacao)
  	{
            this.adaptacao=adaptacao;
    
	}
    
    
	
	public void setEspaco(int espaco)
  	{
            this.espaco=espaco;
    
	}
    
    


        
        public void setTempo_Onibus(Paradas[] paradas)
        {
            int distancia = (paradas[paradas.length-1].getPosicao()) - (paradas[0].getPosicao());
            tempo_onibus = (int) (distancia/velocidade);
            
            tempo_viagem_seg += tempo_onibus;
        }
        
        public void setTempo_Tot_Embarque(ArrayList<Passageiro> passageiros)
        {
            for(int i=0; i<passageiros.size(); i++)
            {
                tempo_tot_embarque += passageiros.get(i).getTempo_embarque();
            }
            
            tempo_viagem_seg += tempo_tot_embarque;
        }
    
            
}
