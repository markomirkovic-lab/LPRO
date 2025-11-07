package tris;

public class Fase_1_Primi_algoritmi 
{
    public static void main(String[] args) 
    {
        //      0. Il gioco si basa su turni fra due giocatori
        //          0.1. Inizia la 'x'
        //      1. la cella deve essere vuota e valida
        //          1.1. inserire le coordinate
        //              1.1.1. Le coordinate le chiederemo per cella o per riga e colonna?              
        //      2. Vittoria?
        //          2.1. controllo le righe
        //          2.3. controllo le colonne
        //          2.4. controllo le diagonali
        //      3. Pareggio?
        //      4. Cambio turno
        //      5. Ricomincia da 4



        
        
        
        //Tabella di gioco
        char[][] tris= new char[3][3];
        
        
        //Due giocatori
        final char G1= 'x';   //Potrei anche farlo iniziare chiedendo il simbolo al giocatore
        final char G2= 'o';
        final char VUOTA= ' ';
        
        
        
        //Quando finisce?
        boolean parità=false;
        boolean vittoria= false;
        
        
        
        
        
        //--------------------------------------------------
        //Requisito 4.
        //Come faccio a cambiare turno?
        char simbolo= G1;   //Simulo che il gioco inizi con il simbolo G1
        do
        {
            //...
            
            //...
            if(simbolo==G1) simbolo=G2;
            else simbolo=G1; //else if(simbolo==G2) simbolo=G1;            
            
        } while(!parità && !vittoria);
        
        if(parità) System.out.println("Pari");
        else if(vittoria) System.out.println("Vinto");

        
        
        

        //--------------------------------------------------  
        //Requisito 4.
        //Come faccio a cambiare turno? 
        //Siccome so per certo che avrò al massimo 9 turni, posso usare un for
        simbolo= G1;   //Simulo che il gioco inizi con il simbolo G1
        for(int t=0; t<tris.length*tris[0].length; t++)     //Uso length per adattrmi alla scacchiera, così potrei giocare anche con una 5x5 o 7x7
        {
            if(simbolo==G1) simbolo=G2;
            else simbolo=G1; //else if(simbolo==G2) simbolo=G1;            
            
            if(parità || vittoria) break;
        }
        
        
        
        
        //-------------------------------------------------
        //Requisito 1.
        //L'utente mi inserir?à numeri fra 1 e 3.
        //Dovrò poi adattarli alle coordinate per la matrice
        int riga=2, colonna=2;      //Simulo le coordinate della cella centrale
        riga--; colonna--;          //Adatto le coordinate
        
        if( tris[riga][colonna]==VUOTA )    //Controllo se la cella è vuota
        {
            tris[riga][colonna]= simbolo;   //Inserisco il simbolo
        }
        
        
        
        
        //-------------------------------------------------
        //Requisito 2.1
        //Vittoria sulle righe
        //Devo avere tutti i simboli uguali sulla stessa riga.
        //Uguali fra loro ma diversi da VUOTA
        //
        //          0   1   2
        //        +---+---+---+
        //      0 | O | X |   |         Qui non vince nessuno
        //        +---+---+---+
        //      1 | X | X | X |         Qui vince X sulla riga 1
        //        +---+---+---+
        //      2 |   | O | O |         Qui non controllo nemmeno perché la prima cella è vuota!
        //        +---+---+---+
        //
        vittoria= false;
        if(    tris[0][0]!=VUOTA && tris[0][0]==tris[0][1] && tris[0][0]==tris[0][2]        //Inserisco tutte le combinazioni
            || tris[1][0]!=VUOTA && tris[1][0]==tris[1][1] && tris[1][0]==tris[1][2]
            || tris[2][0]!=VUOTA && tris[2][0]==tris[2][1] && tris[2][0]==tris[2][2] )
        {
            vittoria=true;
        }
        
        
        //Versione un po' più automatizzata, usop un for per scorrere le righe
        vittoria= false;
        for(int r=0; r<tris.length; r++)
        {
            if( tris[r][0]!=VUOTA && tris[r][0]==tris[r][1] && tris[r][0]==tris[r][2] )
            {
                vittoria=true;      //Segnalo che ha vinto
                break;              //Interrompo il for, perché è inutile procedere visto che c'è stata una vittoria
            }
        }
        
        
        //Versione completamente automatica, che si adatta alle dimensioni della scacchiera
        vittoria= false;
        for(int r=0; r<tris.length; r++)
        {
            vittoria= true;                                         //Do per scontato che qualcuno ha vinto
            
            for(int c=1; c<tris[r].length; c++)                     //Scorro le altre celle, notate che il ciclo parte da 1, e le confronto con la prima
            {
                if( tris[r][0]==VUOTA || tris[r][c]!= tris[r][0] )  //Se la prima cella è vuota, oppure è diversa dalla cella che sto controllando
                {
                    vittoria=false;                                 //Non c'è vittoria
                    break;                                          //Interrompo il for
                }
            }
        }        
               
        
        
        //-------------------------------------------------
        //Requisito 2.4
        //Diagonali
        //
        //         DIAGONALE 1          DIAGONALE 2
        //          0   1   2            0   1   2
        //        +---+---+---+        +---+---+---+
        //      0 | O |   |   |      0 |   |   | O |  
        //        +---+---+---+        +---+---+---+
        //      1 |   | O |   |      1 |   | O |   |   
        //        +---+---+---+        +---+---+---+
        //      2 |   |   | O |      2 | O |   |   |   
        //        +---+---+---+        +---+---+---+
        //        
        vittoria= false;
        for(int d=0; d<tris.length; d++)
        {
            //Controllo la prima diagonale, indice di riga e colonna sono identici: 0-0 1-1 2-2
            if( tris[0][0]!=VUOTA && tris[0][0]==tris[d][d] )
            {
                vittoria=true;
                break;
            }
            
            //Controllo la seconda diagonale, indiced di colonna corrisponde a lunghezza-1-riga: 0-2 1-1 2-0
            if( tris[0][tris.length-1]!=VUOTA && tris[0][tris.length-1]==tris[d][tris.length-1-d] )
            {
                vittoria=true;
                break;
            }                
        }
    }    
}
