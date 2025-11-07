public class SnippetSerie06 
{
    public static void main(String[] args) 
    {
        float temperatura= (float)34.7;             //Casting esplicito da float a double
        int lunghezza= (int)123L;                   //Casting esplicito da long a int
        
        int lettera= 100;
        System.out.println( (char)lettera );        //Casting esplicito da int a char
        System.out.println( (char)(lettera+1) );
        
        int lettera2= (int)'d';                     //Casting esplicito da char a int
        System.out.println( lettera2+1 );
        
        System.out.println( (int)'a' + (int)'b');
               
        System.out.println( " fa " + 7+5);          //Casting implicito da int a String
        

        String n= "scuola specializzata";
        //         01234567891111111111
        //                   0123456789
        
        System.out.println( n.length() );
        System.out.println("Il primo: " + n.charAt(0));                 // 's'
        System.out.println("Il nono: " + n.charAt(8));                  // 'p'
        System.out.println("L\'ultimo: " + n.charAt(n.length()-1) );    // 'a'
        
        System.out.println( n.indexOf("spec") );                        //mi da la posizione della prima sottostringa
        System.out.println( n.indexOf("a") );
        
        System.out.println( n.substring(5));                            //estrae la sottostringa che inizia dalla posizine 5
        System.out.println( n.substring(n.indexOf(" ")+1) );            //estrae partendo dalla posizione che segue il carattere ' '
        System.out.println( n.substring(0, n.indexOf(" ") ) );          //parte dall'indice 0 e temrina prima dello spazio
        System.out.println( n.substring(5, n.length() ) );
        
        System.out.println( n.replace("a", "A"));
        System.out.println( n.replace("zz", "DOPPIAZETA"));
        
        System.out.println( n.toUpperCase() );
        
        System.out.println("   aaaa    bbbb   ".trim());                //Toglie gli spazi esterni ma mantiene quelli interni
        
        System.out.println("aaa".equals("bbb"));
        System.out.println("aaa".equals("AAA"));
        System.out.println("aaa".equalsIgnoreCase("AAA"));



	//Esercizio richiesto da SGT1b
        String frase= "   Lasciate ogni speranza o voi che entrate   ";
        frase= frase.trim();
        
        char primaLettera= frase.charAt(0);
        char ultimaLettera= frase.charAt(frase.length()-1);
        
        int posizione= frase.indexOf("ogni");
        System.out.println( posizione==-1 ? "Non trovata" : "Trovata in posizione " + posizione );
        
        String estrazione= frase.substring(posizione, posizione+"ogni".length());
        
        String farfallino= frase.replace("a", "afa").replace("e","efe").replace("i","ifi").replace("o","ofo").replace("u","ufu");
        System.out.println(farfallino);
        
        farfallino= farfallino.toUpperCase();
        
        String a= "Simone";
        String b= "Luca";
        System.out.println( a == b);
        System.out.println( a.equals(b) );
        System.out.println( b.equals(a) );
        System.out.println( !a.equals(b) );
        
        
        
        //Prendiamo la stringa
        //Calcoliamo dove inizia la parola
        //Calcoliamo dove termina
        //Mettiamo quel pezzo in uppercase
        frase= "Lasciate ogni speranza o voi che entrate";
        String cerca= "entrate";
        int inizio= frase.indexOf(cerca);
        int fine= inizio+cerca.length();
        
        String prima= frase.substring(0, inizio);
        String upper= frase.substring(inizio, fine).toUpperCase();
        String dopo=  frase.substring(fine);
        
        
        System.out.println(prima + upper + dopo);

        
    }
    
}
