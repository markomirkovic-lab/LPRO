/**
 * Modello di esempio che mostra come realizzare un oggetto Carta da gioco
 * partendo:
 * - dai suoi attributi
 * - introducendo delle costanti
 * - inserendo dei metodi setter e getter
 * 
 * 
 * @author gisi
 */

public class SnippetSerie17_Oggetto_Carta 
{
    /* 
        Alcune utili costanti
        Le rendiamo private per non esporle all'esterno.
        I metodi della classe però possono usarle.
    */
    private static final char CUORI= '\u2661';
    private static final char QUADRI= '\u2662';
    private static final char FIORI= '\u2663';
    private static final char PICCHE= '\u2660';
    private static final char JOLLYSEME= 'J';
    
    private static final int JOLLY= 0;      
    private static final int A= 1;      
    private static final int J= 11;      
    private static final int Q= 12;      
    private static final int K= 13;      
    
    
    
    
    
    //Attributi dell'oggetto carta
    //Sono private per nasconderle all'utilizzatore
    //che dovrà passare dai setter e getter per interagire
    //permettendo a noi di gestire internamente gli attributi
    private char seme;
    private int valore;
    
    
    
    
    //----------------------------------------------------------------------
    //  Costruttore vuoto, imposta per default la carta Jolly
    public Carta()
    {
        this.setJolly();
    }
    
    
    
    //----------------------------------------------------------------------
    //  Setter e getter per una carta speciale quale il Jolly
    
    public void setJolly()
    {
        this.setValore(JOLLY);
        this.seme= JOLLYSEME;    //Il jolly è un po' speciale. Ha valori predefiniti sia nel seme che nel valore
    }   
    
    
    public boolean isJolly()
    {
        return this.seme==JOLLYSEME;
    }
    
    

    //----------------------------------------------------------------------
    //  Setter e getter per i valori della carta
    
    /**
     * Imposta il valore della carta.
     * Se il valore fornito NON è valido imposta JOLLY.
     * 
     * @param valore 
     */
    public void setValore(int valore)
    {
        if( valore>=1 && valore<=13)
            this.valore= valore;
        else
            this.valore=JOLLY;
    }
    
    /**
     * Setter specifico per creare un Fante, senza sapere che valore di carta dare
     */
    public void setJ()
    {
        this.setValore(J);  //Notare che uso una costante, mi lascia la libertà di modificarla in futuro
    }
    
    public void setQ()
    {
        this.setValore(Q);
    }
    
    public void setK()
    {
        this.setValore(K);
    }
    
    public void setA()
    {
        this.setValore(A);
    }
    
    
    
    /**
     * Restituisce il valore di una carta
     * 
     * @return 
     */
    public int getValore()
    {
        return this.valore;
    }
    
    public boolean isJ()
    {
        return this.valore==J;
    }

    public boolean isQ()
    {
        return this.valore==Q;
    }

    public boolean isK()
    {
        return this.valore==K;
    }
    
    public boolean isA()
    {
        return this.valore==A;
    }    
    
    
    
    
    //----------------------------------------------------------------------
    //  Setter e getter per i valori del seme
    
    /**
     * Questo metodo è SCONSIGLIATO perché:
     * - espone all'esterno l'implementazione interna dei semi
     * - forza l'utente a conoscere le costanti, che però vogliamo mantenere private
     * 
     * @param seme
     * @throws Exception 
     */
    public void setSeme(char seme) throws Exception
    {
        if(seme!=CUORI || seme!=QUADRI || seme!=FIORI || seme!=PICCHE) 
            throw new Exception("Seme non valido");
        
        this.seme= seme;
    }
    
    
    public void setFiori()
    {
        this.seme= FIORI;
    }
    
    public void setCuori()
    {
        this.seme= CUORI;
    }

    public void setQuadri()
    {
        this.seme= QUADRI;
    }

    public void setPicche()
    {
        this.seme= PICCHE;
    }

    
    /**
     * Restituisce un char che rappresenta il seme della carta.
     * Non è necessariamente legato all'implementazione interna dell'oggetto 
     * (ovvero l'attributo seme)
     * 
     * @return 
     */
    public char getSeme()
    {
        return this.seme;
    }        
    
    public boolean isFiori()
    {
        return this.seme== FIORI;
    }
    
    public boolean isPicche()
    {
        return this.seme== PICCHE;
    }

    public boolean isQuadri()
    {
        return this.seme== QUADRI;
    }

    public boolean isCuori()
    {
        return this.seme== CUORI;
    }
}