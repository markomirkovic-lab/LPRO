

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Serie16_Files_Modalità_di_scrittura 
{
    public static void main(String[] args) 
    {
        //Primo giro,
        //verrà creato il file provaCreateNew.txt
        //verrà creato il file provaAppend.txt
        //verrà generato un errore nella procedura di APPEND
        provaFiles(0);      
        
        
        //Secondo giro,
        //verrà generato un errore nella procedura di CREATE_NEW
        //verranno accodati i dati nel file provaAppend.txt
        //Nel file provaAppend.txt i primi bytes verranno SOSTITUITI da "11111111 CREATE\n\n"
        provaFiles(11111111);      
    }
    
    
    
    
    
    public static void provaFiles(int nroSessione)
    {
        //Preparo il testo che sarà contenuto nel file di testo
        String daScrivere= nroSessione + "\nTanto va la\ngatta\nal lardo...\n\n";
        
        
        //Lo converto in un array di bytes, specificando la codifica
        byte[] b= daScrivere.getBytes(Charset.forName("UTF-8"));
        byte[] bCreate= (nroSessione + " CREATE\n\n").getBytes(Charset.forName("UTF-8"));
        
        
        //Preparo il percorso al file da scrivere
        Path fNew= Paths.get(".", "provaCreateNew.txt");
        Path fAppend= Paths.get(".", "provaAppend.txt");
        Path fCreate= fAppend;
        
                
        //La prima volta che eseguirete questo codice
        //non trovando il file, verrà scritto.
        //La seconda volta solleverà un'eccezione, lasciando il file così com'è!
        try
        {
            //Scrivo, il file esiste?
            //  - si, solleva un'eccezione
            //  - no, lo creo e gli scrivo dentro
            Files.write(fNew, b, StandardOpenOption.CREATE_NEW);  
            
            System.out.println(nroSessione + " CREATE_NEW: File creato e scritto");
        }
        catch (IOException ex) 
        {
            System.out.println(nroSessione + " CREATE_NEW: Il file esiste già. Non lo tocco.");            
        }
            

        
        //La prima volta che eseguirete questo codice, il file non esiste
        //Verrà sollevata un'eccezione.
        //La seconda volta invece lo troverà (perché lo creeremo nel prossimo blocco)
        //e quindi troverete i dati scritti due volte, in quanto accodati.
        try
        {
            //Accodo al file. Il file esiste?
            //  - si, accodo i nuovi dati in fondo al file
            //  - no, solleva un 'eccezione
            Files.write(fAppend, b, StandardOpenOption.APPEND); 
            
            System.out.println(nroSessione + " APPEND: Aggiunto i nuovi dati al file");
        }
        catch (IOException ex) 
        {
            System.out.println(nroSessione + " APPEND: Il file non esiste, non posso accodare");
        }

        
        
        //La prima volta il file non esiste, verrà creato
        //e verranno inseriti i dati.
        //Questo farà in modo che l'APPEND precedente funzionerà al secondo giro
        //La seconda volta, trovando il file, ci scriverà i dati, 
        //lasciando eventuali dati supplementari già presenti nel file:
        //      Se il file conteneva "abcdefgh" e volete scrivere "QQ",
        //      otterrete un file con scritto "QQcdefgh"
        //Per evitare questo effetto potete scrivere con l'istruzione
        //      Files.write(fCreate, bCreate, 
        //                  new OpenOption[] { StandardOpenOption.CREATE, 
        //                                     StandardOpenOption.TRUNCATE_EXISTING} );   
        //combinando quindi due opzioni
        try
        {            
            //Scrivo, il file esiste?
            //  - si, scrivo i dati SOVRASCRIVENDO quanto trovo nel file e 
            //    lasciando inalterato l'eventuale contenuto supplementare 
            //    già presente nel file!
            //  - no, lo crea e ci scrive i dati
            Files.write(fCreate, bCreate, StandardOpenOption.CREATE);   
            //Files.write(fCreate, bCreate, 
            //            new OpenOption[] { StandardOpenOption.CREATE, 
            //                               StandardOpenOption.TRUNCATE_EXISTING} );   
            
            System.out.println(nroSessione + " CREATE: File creato e scritto");
        }
        catch (IOException ex) 
        {
            System.out.println(nroSessione + " CREATE: Non entreremo mai qui, a meno che non ci siano problemi di diritti sul file");
        }        
    }
    
}
