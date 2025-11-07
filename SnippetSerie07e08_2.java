

public class SnippetSerie07e08
{
    public static void main(String[] args)
    {
        //---------------------------------------------
        //Arrotondamenti
        double n,x;
        
        x= 13.761;
        
        n= ((int)(x*10))/10.0;
        System.out.println(n);
        
        n= ((int)(x*100))/100.0;                
        System.out.println(n);

        n= ((int)(x*20))/20.0;          //5 cts equivalgono ad arrotondare al 1/20esimo
        System.out.println(n);
        
        //Se invece di esprimere l'arrotondamento in parti dell'intero volete usare la cifra, dovete utilizzare questo sistema
        n= ((int)(x/0.1))*0.1;        //1 decimo
        System.out.println(n);

        n= ((int)(x/0.01))*0.01;      //1 centesimo
        System.out.println(n);        
        
        n= ((int)(x/0.05))*0.05;      //5 centesimi
        System.out.println(n);
        
        n= ((int)(x/0.05+0.5))*0.05;  //5 centesimi più prossimo
        System.out.println(n);        
        
        
        
        //---------------------------------------------
        //Operatore resto
        int resto;
        
        resto= 12 % 3;
        System.out.println(resto);
        
        resto= 12 % 4;
        System.out.println(resto);
        
        resto= 1+6*2 % 5;
        System.out.println(resto);
        
        
        
        
        //---------------------------------------------
        //Operatori unari
        //Hanno la precedenza su tutti gli altir (incluse le parentesi).
        //Vengono valutate da sinistra a destra!        
        int a=8;
        int b= a++ * 2 * ++a;
        //     8   * 2 * ++a;          a=9
        //     8   * 2 *  10;          a=10
        //        16   *  10;
        //           160    ;
        System.out.println(a + "   " + b);
        
        a=8;
        b= a++ * 2 * a++;
        // 8   * 2 * a++;          a=9
        // 8   * 2 * 9  ;          a=10
        //    16   * 9  ;
        //       144    ;
        System.out.println(a + "   " + b);

        a=8;
        b= a++ * 2 * a++ - ++a;
        // 8   * 2 * a++ - ++a;    a=9
        // 8   * 2 * 9   - ++a;    a=10
        // 8   * 2 * 9   - 11 ;    a=11
        //    16   * 9   - 11 ;    
        //       144     - 11 ;    
        //             133    ;
        System.out.println(a + "   " + b);
        

        a=8;
        b= ++a * 2 * ++a;
        // 9   * 2 * ++a;        a=9
        // 9   * 2 * 10 ;       a=10      
        //    18   * 10 ;
        //       180    ;
        System.out.println(a + "   " + b);
        

        a=8;
        b= ++a * 2 * --a;
        // 9   * 2 * --a;        a=9
        // 9   * 2 *   8;        a=8                
        //    18   *   8;
        //       144
        
        System.out.println(a + "   " + b);


        a=8;
        int c= 3;
        b= ++a - c++ * --a;
        // 9   - c++ * --a;             a=9    c=3
        // 9   - 3   * --a;             a=9    c=4
        // 9   - 3   *   8;             a=8    c=4
        // 9   -    24    ;
        //   -15          ;
        System.out.println(a + "   " + b + "   " + c);


        a=8;
        c= 3;
        b= ++a - c++ * (--a);
        // 9   - c++ * --a;             a=9    c=3
        // 9   - 3   * --a;             a=9    c=4
        // 9   - 3   *   8;             a=8    c=4
        // 9   -    24    ;             a=8    c=4     
        //   -15          ;
        System.out.println(a + "   " + b + "   " + c);

        
        double z=7.88;
        z++;
        System.out.println(z);
        
        

        //---------------------------------------------
        //Operatori unari, parte 2
        //ATTENZIONE, gli operatori unari influiscono sul valore delle variabili sulla destra!
        
        a= 3;
        b= a - a * a + a;
        // 3 - a * a + a;
        // 3 - 3 * a + a;
        // 3 - 3 * 3 + a;
        // 3 - 3 * 3 + 3;
        // 3 -   9   + 3;
        //  -6       + 3;        
        //          -3
        System.out.println(a + "   " + b);


        a= 3;        
        b=  a - a * a + ++a;
        //  3 - a * a + ++a;
        //  3 - 3 * a + ++a;
        //  3 - 3 * 3 + ++a;
        //  3 - 3 * 3 +   4;    a=4
        //  3 -   9   +   4;
        //   -6       +   4        
        //           -2            
        System.out.println(a + "   " + b);


        a= 3;        
        b= a - a * ++a + a;
        // 3 - a * ++a + a;
        // 3 - 3 * ++a + a;
        // 3 - 3 *   4 + a;     a=4   Tutte le prossime a (quelle sulla destra) partono dal valore 4
        // 3 - 3 *   4 + 4;     a=4   
        // 3 -  12     + 4;     
        // -9          + 4;     
        //            -5
        System.out.println(a + "   " + b);
        

        a= 3;        
        b= a - ++a * a + a;
        // 3 - ++a * a + a;
        // 3 -   4 * a + a;     a=4   Tutte le prossime a (quelle a destra) partono dal valore 4
        // 3 -   4 * 4 + a;     
        // 3 -   4 * 4 + 4; 
        // 3 -    16   + 4;                         
        // -13         + 4;                         
        //            -9
        System.out.println(a + "   " + b);
        

        a= 3;        
        b= ++a - a * ++a + a;
        //   4 - a * ++a + a;   a=4   Tutte le prossime a (quelle a destra) partono dal valore 4  
        //   4 - 4 * ++a + a;   a=4
        //   4 - 4 *   5 + a;   a=5   Tutte le prossime a (quelle a destra) partono dal valore 5  
        //   4 - 4 *   5 + 5;   a=5
        //   4 -  20     + 5;   
        //   -16         + 5;   
        //             -11
        System.out.println(a + "   " + b);
        


        a= 1;
        b= 5;
        c= 10;
        int d= ++a + b + ++c +  (a * b + c);
        //       2 + b + ++c +  (a * b + c);     a=2        Tutte le prossime a (quelle a destra) partono dal valore 2  
        //       2 + b + ++c +  (2 * b + c);     a=2 
        //       2 + 5 + ++c +  (2 * 5 + c);     a=2 
        //       2 + 5 +  11 +  (2 * 5 + c);     a=2 c=11   Tutte le prossime c (quelle a destra) partono dal valore 11
        //       2 + 5 +  11 +  (2 * 5 +11);     a=2 c=11
        //       2 + 5 +  11 +  ( 10   +11);     
        //       2 + 5 +  11 +  (     21  );     
        //         7   +  11 +  (     21  );     
        //            18     +  (     21  );     
        //                  39             ;
        System.out.println(a + "   " + b + "   " + c + "   " + d);


        a= 1;
        b= 5;
        c= 10;        
        d= ++a + b + ++c +  (++a * b + c) + a;
        //   2 + b + ++c +  (++a * b + c) + a;      a=2
        //   2 + b + ++c +  (  3 * b + c) + a       a=3
        //   2 + b + ++c +  (  3 * b + c) + 3       a=3
        //   2 + b +  11 +  (  3 * b + c) + 3       a=3   c=11
        //   2 + b +  11 +  (  3 * b +11) + 3       a=3   c=11
        //   2 + 5 +  11 +  (  3 * 5 +11) + 3       a=3   c=11
        //   2 + 5 +  11 +  (   15   +11) + 3     
        //   2 + 5 +  11 +  (       26  ) + 3     
        //     7   +  11 +  (       26  ) + 3     
        //        18     +  (       26  ) + 3     
        //              44                + 3     
        //                               47
        System.out.println(a + "   " + b + "   " + c + "   " + d);
        
        
                
        
        
        
        int somma=12;
        int quantità=3;
        
        System.out.println(somma/quantità);
        
        somma+=7;                               //somma= somma+7
        quantità=quantità+1;
        System.out.println(somma/quantità);
        
        somma+=3;
        System.out.println(somma/++quantità);  //quantità=quantità+1;
        
        

        //---------------------------------------------
        //Operatori compatti
        resto= 7;
        resto += 4;     // resto= resto +4

        
        
        //---------------------------------------------
        //Operatori di confronto
        boolean u;
        u= 3>7;     //false
        u= 3<7;     //true
        u= 7>=7;    //true
        u= 7<=7;    //true
        u= 3==7;    //false
        u= 3!=7;    //true      <>        
        
        
        //---------------------------------------------
        //Operatori logici
        int età= 23;
        boolean birra= età>=18 && età<=65;
        System.out.println("Birra: " + birra);
        
        boolean figlioDelCapo= true;
        boolean sconto=  età>65 || figlioDelCapo;
                sconto=  età>65 || figlioDelCapo==true;
                sconto=  età>65 && figlioDelCapo==false;    //Variante 1
                sconto=  età>65 && !figlioDelCapo;          //Variante 2
                sconto=  età>65 && figlioDelCapo!=true;     //Variante 3
        System.out.println(sconto);
        

        
        boolean afccpc= false;      //Possiede un AFC commerciale
        boolean afcinfo= false;     //Possiede un AFC di informatico
        
        boolean maturità= true;     //Ha una maturità liceale
        int esperienza= 5;          //Ha esperienza lavorativa di quanti anni
        
        //Determino l'accesso alla scuola
        boolean accesso= afccpc || afcinfo || maturità && esperienza>=3;
        System.out.println("Accesso SIG: " + accesso); 

        
        //Negazione, se negate un numero pari di vole, il valore non cambia, se dispari si.
        boolean zz= true;
        System.out.println(!!!!!!!!!zz);
        
        
        
        //---------------------------------------------
        //Operatore ternario. È identico alla funzione SE( test , severo, sefalso ) di EXCEL
        int aa=7;
        int bb= 12;
        int maggiore= aa>bb ? aa   :  bb    ;  // Excel: se(aa>bb; aa; bb)
        //            test    vero    falso
        System.out.println(maggiore);
        
                
        double prezzoBirra= 3.5;
        boolean happyHour= true;
        double prezzoFinale;
        prezzoFinale= prezzoBirra * (100 - (happyHour ? 10 : 0));   //Se c'è l'happyhour sconto del 10% altrimenti nessuno sconto
        
        
        double latoA= 4.0;
        double latoB= 4.0;
        double latoC= 4.0;
        String triangolo= latoA==latoB && latoB==latoC ? "Equilatero" : "Non equilatero";        
        System.out.println("Triangolo: " + triangolo);
    }
}
