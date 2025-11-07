public class SnippetSerie06_TerzaParte_Stringhe_Avanzate 
{
    public static void main(String[] args) 
    {
        //Uso avanzato delle stringhe
        
        //-----------------------------------------------------------------------------------------------------
        //Esempio 1, estrarre una parte di stringa, ad esempio il prefisso locale di un numero di telefono
        String tel= "+41 (0)91 111 22 33";
        
        //Una volta individuato i separatori che delimitano l'elemento da trovare
        int inizio= tel.indexOf(" ")+1;           //Cerco il primo spazio. Essendo un solo char, aggiungo uno per partire dalla posizione seguente
        int fine= tel.indexOf(" ", inizio);       //Cerco il secondo spazio partendo dal charAt dopo il primo

        //Trovati i due limiti, estraggo la sottostring
        String prefissoLocale= tel.substring(inizio, fine);   //Si parte sempre dalla posizione iniziale
        
        System.out.println( prefissoLocale );

        
        
        //-----------------------------------------------------------------------------------------------------
        //Esempio 2, estrarre una parte di stringa, ad esempio il dominio da un indirizzo email
        String email= "pinco.pallino@edu.ti.ch";
        
        //Una volta individuato i separatori che delimitano l'elemento da trovare
        inizio= email.indexOf("@")+1;               //Cerco il primo '@'. Essendo un solo char, aggiungo uno per partire dalla posizione seguente
        fine= email.lastIndexOf(".");               //Cerco l'ultimo punto

        //Trovati i due limiti, estraggo la sottostring
        String dominio= email.substring(inizio, fine);   //Si parte sempre dalla posizione iniziale +1
        
        System.out.println( dominio );




        
        
        //-----------------------------------------------------------------------------------------------------
        //Esempio 3, estrarre una parte di stringa, delimitata da parole e non da singoli char
        String t= "Questa è una STOP frase telegrafica STOP con le frasi STOP separate dalla stringa STOP";
        
        //Una volta individuato i separatori che delimitano l'elemento da trovare
        inizio= t.indexOf("STOP")+"STOP".length();               //Cerco il primo delimitatore, essendo una parola devo aggiungere la sua lunghezza per determinare la posizione finale del delimitatore
        fine= t.indexOf("STOP", inizio);

        //Trovati i due limiti, estraggo la sottostring
        String tt= t.substring(inizio+1, fine);   //Si parte sempre dalla posizione iniziale +1
        
        System.out.println( tt );    
    }
}
