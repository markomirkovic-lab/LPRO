import java.util.Scanner;

public class SnippetSerie10_manipolazione_stringhe_e_numeri 
{
    public static void main(String[] args) 
    {
        
        
        //-------------------------------------------------------------
        //Controllare se una stringa contiene solo caratteri consentiti
        String daControllare= "ssse";        
                
        boolean check= true;        
        for (int i = 0; i < daControllare.length(); i++) 
        {
            char c= daControllare.charAt(i);
            
                                        //Sono consentite, aggiungete ocn l'OR (||) i caratteri validi
            if(!(c>='a' && c<='z' ||    //Lettere minuscole
                 c>='A' && c<='Z' ||    //Lettere maiuscole
                 c>='0' && c<='9' ||    //Cifre
                 c=='.'))               //Il punto
            {
                check= false;
                break;
            }            
        }        
        if(!check) System.out.println("Caratteri errati");   
        else System.out.println("Tutto ok");
        
        
        
        //-------------------------------------------------
        //Convertire una stringa che contiene solo caratteri 
        //numerici nel rispettivo valore numerico.
        //Questo lavoro viene svolto ad esempio dalla nextInt();
        String numero= "123";
        int valore= 0;
        for (int i = 0; i < numero.length(); i++) 
        {
            char c= numero.charAt(i);       //Prelevo il carattere
            valore= valore*10 + (c-'0');    //Trasformo il carattere in valore numerico
            
            //NOTA BENE. L'operazione c-'0' serve a calcolare il valore numerico
            //           di un char, sapendo che i char hanno valori
            //           incrementali che seguono l'ordinamento ascendente
            //              '0' ha valore numerico 48
            //              '1'                    49 e così via
            //           quindi '5'-'0' darà 5
            //
            //           Il calcolo vi consente di evitare questo lungo e 
            //           fastidioso switch:
            //              int cifra;
            //              switch(c)
            //              {
            //                  case '0':
            //                      cifra= 0;
            //                      break;
            //                  case '1':
            //                      cifra= 1;
            //                      break;
            //                  case '2':
            //                      cifra= 2;
            //                      break;
            //                  case '3':
            //                      cifra= 3;
            //                      break;
            //                  case '4':
            //                      cifra= 4;
            //                      break;
            //                  case '5':
            //                      cifra= 5;
            //                      break;
            //                  case '6':
            //                      cifra= 6;
            //                      break;
            //                  case '7':
            //                      cifra= 7;
            //                      break;
            //                  case '8':
            //                      cifra= 8;
            //                      break;
            //                  case '9':
            //                      cifra= 9;
            //                      break;
            //                  default:
            //                      cifra= 0;
            //              }
            //              valore= valore*10 + cifra; 
        }
        System.out.println(valore);
        
        
        //-------------------------------------------------
        //Estrarre le signole cifre da un numero
        while(valore!=0)                    //While perché non sappiamo quante volte ripetere il ciclo: con 123 lo farà 3 volte, con 5678914 lo farà 7
        {
            int cifra= valore%10;           //Con % estraggo la cifra a destra            
            valore=valore/10;               //Con / tolgo la cifra a destra
            
            System.out.println(cifra);
        }               
    }
    
    
}



