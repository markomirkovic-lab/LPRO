package tris;

import java.util.Scanner;


/**
 * Differisce dalla precedente versione in quanto le coordinate sono inserite con il numero di cella.
 * 
 * @author gisi
 */
public class Fase_99_Finito_v3 
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



        
        //Due giocatori
        final char G1= 'x';   //Potrei anche farlo iniziare chiedendo il simbolo al giocatore
        final char G2= 'o';
        final char VUOTA= ' ';
        
        
        
        
        //Tabella di gioco
        int r, c;
        char[][] tris= new char[5][5];
        
        //Inizializzo tutte le celle a VUOTA
        for(r=0; r<tris.length; r++)
        {
            for(c=0; c<tris[r].length; c++)
            {
                tris[r][c]= VUOTA;
            }
        }
        
        
        //Quando finisce?
        boolean parità=false;
        boolean vittoria= false;
        
        
        Scanner in= new Scanner(System.in);
        
        char simbolo= G2;   //Simulo che il gioco inizi con il simbolo G2, tanto verrà subito cambiato n G1        
        int celleVuote= tris.length*tris[0].length-1;
        do
        {
            //------------------------------------------------------------------
            //Cambio giocatore
            if(simbolo==G1) simbolo=G2;
            else simbolo=G1;
            
            
            //------------------------------------------------------------------
            //Stampo
            for(r=0; r<tris.length; r++)
            {
                for(c=0; c<tris[r].length; c++)
                {
                    int larg= 5;
                    System.out.print( String.format("%4d[%-" + larg + "c]%s", (r*tris.length+c)+1, tris[r][c], "     ") );
                    //System.out.print( (r*tris.length+c)+1 + "[" + tris[r][c] + "]\t");          //Notare come calcolo le celle: come tutti i numeri in base 10, ma usando la base 3! Aggiungo 1 per non partire da 0
                }
                System.out.println("");
            }
            
            
            //-----------------------------------------------------------------
            //Chiedo al giocatore di inserire le coordinate            
            do
            {                
                int cella;
                do
                {
                    System.out.print("Giocatore '" + simbolo + "' cella [1..9]: ");

                    while(!in.hasNextInt())
                    {
                        in.nextLine();
                        System.out.print("Giocatore '" + simbolo + "' cella [1..9]: ");
                    }
                    cella= in.nextInt();
                    in.nextLine();
                }while(cella<1 || cella>tris.length*tris.length);
                
                cella--;        //Calcolo riga e colonna.
                r= cella/tris.length;     //Come se fossimo in base 10, ma ragione in base 3
                c= cella%tris.length;                
            }while(tris[r][c]!=VUOTA);
            System.out.println("\n\n");


            
            
            //Occupo la cella
            tris[r][c]=simbolo;
            

            //------------------------------------------------------------------
            //Vittoria?
            
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

            //Versione completamente automatica, che si adatta alle dimensioni della scacchiera
            vittoria= false;
            for(r=0; r<tris.length; r++)
            {
                vittoria= true;                                         //Do per scontato che qualcuno ha vinto

                for(c=1; c<tris[r].length; c++)                         //Scorro le altre celle, notate che il ciclo parte da 1, e le confronto con la prima
                {
                    if( tris[r][0]==VUOTA || tris[r][c]!= tris[r][0] )  //Se la prima cella è vuota, oppure è diversa dalla cella che sto controllando
                    {
                        vittoria=false;                                 //Non c'è vittoria
                        break;                                          //Interrompo il for
                    }
                }

                if(vittoria) break;                                     //Interrompo il ciclo se c'è la vittoria
            }


            //Non ha vinto sulle righe, controllo le colonne
            if(!vittoria)
            {
                for(c=0; c<tris[0].length; c++)                         //Uguale uguale all'algoritmo usato sopra per le righe
                {
                    vittoria= true;                 

                    for(r=1; r<tris.length; r++)
                    {
                        if( tris[0][c]==VUOTA || tris[r][c]!= tris[0][c] )
                        {
                            vittoria=false;
                            break;         
                        }
                    }
                }                    
            }


            //Non ha vinto sulle colonne, controllo le diagonali
            if(!vittoria)
            {
                vittoria=true;
                for(int d=1; d<tris.length; d++)
                {
                    if( tris[0][0]==VUOTA || tris[d][d]!= tris[0][0] )
                    {
                        vittoria=false;
                        break;         
                    }
                }
            }      
            if(!vittoria)
            {
                vittoria=true;
                for(int d=1; d<tris.length; d++)
                {
                    if( tris[0][tris.length-1]==VUOTA || tris[d][tris.length-1-d]!= tris[0][tris.length-1] )
                    {
                        vittoria=false;
                        break;         
                    }
                }
            }                
    
            
            //------------------------------------------------------------------
            //Parità?
            if(celleVuote--==0)
            {
                if(!vittoria) parità= true;     //Se c'è vittoria non può esserci parità
            }
            
        } while(!parità && !vittoria);
        
        if(vittoria) System.out.println("Vinto giocatore '" + simbolo + "'");
        else if(parità) System.out.println("Pari");
        
        
        
        //------------------------------------------------------------------
        //Stampo
        for(r=0; r<tris.length; r++)
        {
            for(c=0; c<tris[r].length; c++)
            {
                System.out.print( r*3+c+1 + "[" + tris[r][c] + "]\t");
            }
            System.out.println("");
        }        
    }    
}
