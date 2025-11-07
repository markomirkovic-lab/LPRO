package tris;

public class Fase_0_Appunti_iniziali 
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
        //          3.1. controllo le colonne
        //          4.1. controllo le diagonali
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
    }    
}
