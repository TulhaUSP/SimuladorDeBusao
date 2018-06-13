/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linha.de.onibus;

import java.util.Random;
import java.util.ArrayList;

public class LinhaDeOnibus {

    public static Paradas[] paradas = null;
    public static ArrayList<Passageiro> passageiros = new ArrayList<>(); 
    public static Random rn = new Random();
    //static int nParadas = rn.nextInt(20)+5; //cria número de paradas randomicamente
    static int nParadas = 3;
    public static int[] dist_total = new int[nParadas];
    static int indice = 0;
    
    public static void main(String[] args) {
        int distance = 0;
        
        criaParadas();
        
        Onibus BusaoDoLevi = new Onibus();
        BusaoDoLevi.setVelocidade(1.0);
        BusaoDoLevi.setEspaco(40);
        BusaoDoLevi.setTempo_Onibus(paradas);
        BusaoDoLevi.setTempo_Tot_Embarque(passageiros);
        for (int t = 1; t<=BusaoDoLevi.getTempo();t++)
        {
            distance += BusaoDoLevi.getVelocidade();
            
           

            if (distance >= dist_total[indice]){
                System.out.println("Passou pela parada "+ (indice+1));
                    indice++;
            }
            
            
            System.out.println("tempo: " + t);
            System.out.println("distancia: " + distance);
        }
        
    }
    
    public static void criaParadas()
    {
       
        int distancia; 
       paradas = new Paradas[nParadas];
        
        for(int i=0; i<nParadas; i++)
        {
            distancia = rn.nextInt(800)+200; //distância entre cada parada
            if(i==0) //para o primeiro terminal
            {
                paradas[i] = new Paradas(true, passageiros); //passa parâmetro true para terminal
                paradas[0].setPosicao(0);
            }
            else if(i==nParadas-1) //ultimo terminal
            {
                paradas[i] = new Paradas(); //construtor do terminal final
                paradas[i].setPosicao((distancia+paradas[i-1].getPosicao())); //formula posição anterior + distância entre paradas
                dist_total[i] = paradas[i].getPosicao();
            }
            else //paradas restantes
            {
                paradas[i] = new Paradas(false, passageiros);
                paradas[i].setPosicao((distancia+paradas[i-1].getPosicao()));
            }
            dist_total[i] = paradas[i].getPosicao();
        }
    }
    
    public static void criaPessoa()
    {
        for (int j = 0; j < paradas.length; j++)
        {
            for (int delta = 0; delta < paradas[j].getNum_esperando(); delta++)
            {
                Passageiro p = new Passageiro();
                passageiros.add(p);
            }
        }
    }
   
   
    
}
