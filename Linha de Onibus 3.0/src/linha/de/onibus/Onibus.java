/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linha.de.onibus;
/**
 *
 * @author José Luis, Daniel Tulha e Levi
 */
public class Onibus {
  private double velocidade;

  private String conservacao;

  private boolean adaptacao;

  private int espaco;

  private int posicao;

  private int tempo_viagem_seg;

  private int tempo_onibus;

  private int tempo_tot_embarque;


  public void Onibus()
  {
      this.tempo_onibus = 0;
      this.tempo_tot_embarque = 0;
  }



	public double getVelocidade()
  {
      return velocidade;

  }


/*
  public String getConservacao()
	{
      return conservacao;

	}






	public boolean getAdaptacao()
	{
      return adaptacao;
	}

*/

	public int getEspaco()
	{
      return espaco;

	}



	public int getPosicao()
	{
      return posicao;
	}

    public void setVelocidade(double velocidade)
        {
      this.velocidade=velocidade;
	}
/*
	public int getTempo()
	{
     return tempo_viagem_seg;
	}

  



	public void setConservacao(String conservacao)
	{
    this.conservacao=conservacao;

	}






/*
	public void setAdaptacao(boolean adaptacao)
  {
     this.adaptacao=adaptacao;

	}
*/


	public void setEspaco(int espaco)
  {
      this.espaco=espaco;

	}


  /*public void setTempo_Onibus()
  {
      //int distancia = (paradas[paradas.length-1].getPosicao()) - (paradas[0].getPosicao()); -> Desnecessario com a adicao de Distancia total
      tempo_onibus = (int) (distancia_total/velocidade);

      tempo_viagem_seg += tempo_onibus;
  }

  public void setTempo_Tot_Embarque(ArrayList<Passageiro> passageiros_linha)
  {
      for(int i=0; i<passageiros_linha.size(); i++)
      {
         
                 
            tempo_tot_embarque += passageiros_linha.get(i).getTempo_embarque();
      }

      tempo_viagem_seg += tempo_tot_embarque;
  }
   /*

*/
}