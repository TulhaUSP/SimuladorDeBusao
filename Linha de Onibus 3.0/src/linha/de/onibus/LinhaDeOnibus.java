/*
     GPL-2.0-or-later
 */
package linha.de.onibus;

import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

public class LinhaDeOnibus {

   
    public static ArrayList<Passageiro> passageiros_linha = new ArrayList<>(); 
    public static ArrayList<Passageiro> passageiros_onibus = new ArrayList<>();
    public static ArrayList<Integer> posicao_paradas = new ArrayList<>();
    public static Random rn = new Random();
    public static int distancia;
    public static int distancia_total;
    final int nParadas; 
    //static int nParadas = 3;
    //public static int[] dist_total = new int[nParadas];
    static int indice = 0;
    
    
    LinhaDeOnibus(){
        this.nParadas = rn.nextInt(10)+5; //cria número de paradas randomicamente
        
        for(int i=0; i<nParadas; i++) //calcula distancia entre as paradas (relativa) e insere posicao (absoluta) no posicao_paradas
        {
            distancia = rn.nextInt(800)+200;
            distancia_total += distancia;
            posicao_paradas.add(distancia_total);
            
        }
        //cria ArrayList base de passageiros:
        for (int pas = 0; pas < rn.nextInt(150)+30;pas++)//determina numero de passageiros na linha
        {
            int od = 0;
            int od2 = 0;
            while(od == od2){//while que garante que origem e destino serão diferentes
                od = rn.nextInt(nParadas + 1); //define origem e destino
                od2 = rn.nextInt(nParadas) + 1; // os dois valores não podem ser 0
            }
            passageiros_linha.add(new Passageiro(Math.min(od,od2),Math.max(od, od2)));
        }
        
    }
    public static void main(String[] args) {
        int distance = 0;
        int t = 0;
        Scanner in = new Scanner(System.in);
        
        LinhaDeOnibus l = new LinhaDeOnibus();//mais importante adição
        Onibus BusaoDoLevi = new Onibus();
        System.out.println("Insira a velocidade constante do onibus(metros por segundo)");
        BusaoDoLevi.setVelocidade(in.nextDouble());
        System.out.println("Insira a capacidade de passageiros do onibus");
        BusaoDoLevi.setEspaco(in.nextInt());
        
        for (int u = 0; u < passageiros_linha.size(); u++){//loop que adiciona os passageiros que embarcam na primeira parada
            if (passageiros_linha.get(u).getOrigem()==0){
                passageiros_onibus.add(passageiros_linha.get(u));
            }
        }
        System.out.println();
        System.out.println("O onibus saiu do terminal com "+ passageiros_onibus.size()+ " passageiros.");
        System.out.println();
        while (distance <= posicao_paradas.get(posicao_paradas.size() - 1)) //esse while se tornou muito mais importante: será necessário atualizar o numero de passageiros no onibus por ele
        {
            int entraram = 0;
            int desceram = 0;
            int esperam = 0;
            
            if (distance >= posicao_paradas.get(indice)){
                System.out.println("Parou na parada "+ (indice+1) +" localizada no metro "+ posicao_paradas.get(indice) + " no segundo "+ t + " com "+ passageiros_onibus.size()+" passageiros.");
                int tempoParado = 0;
                for (int u = 0; u < passageiros_linha.size(); u++){//processo de entrada e descida do onibus
                    
                    if (indice == passageiros_linha.get(u).getDestino()){//quantos vao descer
                        for (int y = 0; y<passageiros_onibus.size();y++){//checa se o passageiro esta dentro do onibus
                            if (passageiros_onibus.get(y).equals(passageiros_linha.get(u)))
                                    {
                                        passageiros_onibus.remove(y);
                                        desceram++;
                                    }
                            
                        }
                    }
                    if (passageiros_linha.get(u).getOrigem() == indice){
                        if (BusaoDoLevi.getEspaco() > passageiros_onibus.size()){
                            passageiros_onibus.add(passageiros_linha.get(u));
                            tempoParado += passageiros_linha.get(u).getTempo_embarque();//calcula e soma tempo de embarque individual
                            
                            entraram++;
                        }else esperam++;//se cheio, o passageiro espera na parada
                    }
                    
                }
                t+= tempoParado;//adiciona tempo de embarque da parada ao tempo total
                System.out.println("Entraram "+ entraram+ " passageiros e sairam "+ desceram + ". O onibus ficou parado "+tempoParado+" segundos");
                System.out.println();
                indice++;
            }
           
            distance += BusaoDoLevi.getVelocidade(); //distancia substituida por tempo
            t ++;
           
        }
        System.out.println("Sairam " + passageiros_onibus.size()+" na ultima estacao. O onibus terminou a sua rota.");
        
    }
    
    
    
    /*
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
   
   */
    
}