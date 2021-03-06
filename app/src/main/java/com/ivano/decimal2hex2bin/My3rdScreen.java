package com.ivano.dec2hex2bin;

// input binario

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import java.math.BigInteger;  //la RAM e' il limite del valore massimo
import android.graphics.Color; //oppure con java java.awt.Color
import android.view.MotionEvent;
import android.view.View.OnTouchListener;



public class My3rdScreen extends Activity {

        //BigInteger e' il tipo per interi lunghi. Limite e' la RAM del computer.
        //Ha delle ottimizzazioni per i numeri primi lunghi usati nel criptaggio

        //BigInteger val_inserito,decimale,Limit;
        int esponente_bin=0, n, spazio=-1,  counter = 0;
        TextView display, display1, display2,display3 ;
        Button DtoH, B0,B00,B000,B0000,B1,B11,B111,B1111,  esci, riazzera, go2d, go2h, go2oct;
         BigInteger val_inserito = new BigInteger ("0");
         BigInteger decimale = new BigInteger ("0");
         BigInteger Limit = new BigInteger ("0");
         BigInteger old_val_inserito;


            char[] vett_dec = new char[100];
            char[] vett_oct = new char[100];
            char[] vett_hex = new char[100];
            String[] vbin = new String[280];

            String tempD=" ",tempH=" ",tempB="", tempOct="";


         @Override  //***used to mark methods that override a method declaration in a superclass.
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState); //***onCreate : initialize your activity
                setContentView(R.layout.main3);

                display = (TextView) findViewById (R.id.showOut);
                display1 = (TextView) findViewById (R.id.showOut1);
                display2 = (TextView) findViewById (R.id.showOut2);
                display3 = (TextView) findViewById (R.id.showOut3);

                display.setText("Dec: 0");
                display1.setText("Hex: 0");
                display2.setText("Bin: 0");
                display3.setText("Oct: 0");

                          //vai alla activity per input decimale
                go2d = (Button) findViewById (R.id.buttonD);
                go2d.setOnClickListener(new View.OnClickListener() {
                  public void onClick(View arg0) {
                          Intent i = new Intent(My3rdScreen.this, MainActivity.class);
                      startActivity(i);
                      //necessario finish() senno' restano aperte le activity che si lasciano
                      //fino a bloccarsi.
                      finish();
                  }});

                //vai alla activity per input esadecimale
                go2h = (Button) findViewById (R.id.buttonH);
                go2h.setOnClickListener(new View.OnClickListener() {
                  public void onClick(View arg0) {
                          Intent i = new Intent(My3rdScreen.this, MyNewScreen.class);
                      startActivity(i);
                      finish();
                  }});

           //vai alla activity per input ottale
           go2oct = (Button) findViewById (R.id.buttonOCT);
           go2oct.setOnClickListener(new View.OnClickListener() {
             public void onClick(View arg0) {
                     Intent i = new Intent(My3rdScreen.this, OctalActivity.class);
                 startActivity(i);
                 finish();
             }});


                esci = (Button) findViewById (R.id.button12);
                esci.setOnClickListener(new View.OnClickListener() {
                  public void onClick(View v) {
                          finish();
                  }
                });


                B0 = (Button) findViewById (R.id.buttonB0);
                B0.setOnClickListener(new View.OnClickListener() {
                  public void onClick(View v) {
                          val_inserito= ValInserito(BigInteger.valueOf(2), val_inserito, BigInteger.ZERO, spazio);
                          if (spazio == 3) spazio=0;
                          else spazio++;
                }});


                B00 = (Button) findViewById (R.id.buttonB00);
                B00.setOnClickListener(new View.OnClickListener() {
                  public void onClick(View v) {
                          val_inserito= ValInserito(BigInteger.valueOf(2), val_inserito, BigInteger.ZERO, spazio);
                          if (spazio == 3) spazio=0;
                          else spazio++;
                        }});

               B000 = (Button) findViewById (R.id.buttonB000);
                B000.setOnClickListener(new View.OnClickListener() {
                  public void onClick(View v) {
                          val_inserito= ValInserito(BigInteger.valueOf(2), val_inserito, BigInteger.ZERO, spazio);
                          if (spazio == 3) spazio=0;
                          else spazio++;
                        }});


                B0000 = (Button) findViewById (R.id.buttonB0000);
                B0000.setOnClickListener(new View.OnClickListener() {
                  public void onClick(View v) {
                          val_inserito= ValInserito(BigInteger.valueOf(2), val_inserito, BigInteger.ZERO, spazio);
                          if (spazio == 3) spazio=0;
                          else spazio++;
                        }});


                B1 = (Button) findViewById (R.id.buttonB1);
                B1.setOnClickListener(new View.OnClickListener() {
                  public void onClick(View v) {
                          val_inserito= ValInserito(BigInteger.valueOf(2), val_inserito, BigInteger.valueOf(1), spazio);
                          if (spazio == 3) spazio=0;
                          else spazio++;
                        }});



                B11 = (Button) findViewById (R.id.buttonB11);
                B11.setOnClickListener(new View.OnClickListener() {
                          public void onClick(View v) {
                                  val_inserito= ValInserito(BigInteger.valueOf(2), val_inserito, BigInteger.valueOf(1), spazio);
                                  if (spazio == 3) spazio=0;
                                  else spazio++;
                                }});



                B111 = (Button) findViewById (R.id.buttonB111);
                B111.setOnClickListener(new View.OnClickListener() {
                          public void onClick(View v) {
                                  val_inserito= ValInserito(BigInteger.valueOf(2), val_inserito, BigInteger.valueOf(1), spazio);
                                  if (spazio == 3) spazio=0;
                                  else spazio++;
                                }});


                B1111 = (Button) findViewById (R.id.buttonB1111);
                B1111.setOnClickListener(new View.OnClickListener() {
                          public void onClick(View v) {
                                  val_inserito= ValInserito(BigInteger.valueOf(2), val_inserito, BigInteger.valueOf(1), spazio);
                                  if (spazio == 3) spazio=0;
                                  else spazio++;
                                }});


/**********************
                riazzera = (Button) findViewById (R.id.button10);
                riazzera.setOnClickListener(new View.OnClickListener() {
                                          public void onClick(View v) {
                                           riazzera_function() ;
                }});
*************************/



           riazzera = (Button) findViewById (R.id.button10);
             riazzera.setOnTouchListener(new OnTouchListener() {
                 public boolean onTouch(View v, MotionEvent event) {
                     if (event.getAction() == MotionEvent.ACTION_DOWN) {
                         v.setBackgroundColor(Color.parseColor("#87CEEB"));
                         riazzera_function();
                     }
                     if (event.getAction() == MotionEvent.ACTION_UP) {
                         v.setBackgroundColor(Color.parseColor("#000000"));
                     }
                     return true;
                 }

             });






                   //CONVERSIONE esadecimale  e stampa:

/********************
   DtoH = (Button) findViewById (R.id.button11);
   DtoH.setOnClickListener(new View.OnClickListener() {
              public void onClick(View v) {
*******************/

DtoH = (Button) findViewById (R.id.button11);
DtoH.setOnTouchListener(new OnTouchListener() {
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            v.setBackgroundColor(Color.parseColor("#87CEEB"));



 spazio = -1;
 if (val_inserito == BigInteger.ZERO)
 {  display.setText( "Dec: 0" );
    display1.setText( "Hex: 0" );
    display3.setText( "Oct: 0" );
    display2.setText( "Bin: 0" ); }
 else  if (val_inserito != old_val_inserito) {
                                                        //FISSO il valore inserito
                                decimale=val_inserito;
                                int esponente = 0;


     //CONVERSIONE OCTAL
     //CONVERSIONE OCTAL
     //CONVERSIONE OCTAL

    for (n=0; n<100; n++){
     vett_oct[n]='0'; }

     esponente = 0;
     Limit = new BigInteger ("8");
   //cerco valore esponente piu" prossimo per limitare sotto il numero dei cicli
    while (val_inserito.compareTo(Limit.pow(esponente)) == 1) {
       esponente++;
    }
    int esponente_oct=esponente;
    n = 0;
    BigInteger BASE8 = new BigInteger ("8");
    while (esponente >= 0) {
       Limit = BASE8.pow(esponente);
       Limit = Limit.subtract(BigInteger.ONE) ;
          while(val_inserito.compareTo(Limit) == 1) {
            n = n + 1;
            val_inserito = val_inserito.subtract(BASE8.pow(esponente));
          }
            vett_oct[esponente] = d2h(n);  //in questo caso serve solo per cambiare il tipo di variabile
          n = 0;
          esponente--;
    }

//riassegno valore originale a val_inserito
 val_inserito = decimale;



                                //CONVERSIONE    E S A
                                //CONVERSIONE    E S A
                                //CONVERSIONE    E S A

        for (n=0; n<100; n++){
           vett_hex[n]='0';
        }

               esponente = 0;
          Limit = new BigInteger ("16");
          //cerco valore esponente piu" prossimo per limitare sotto il numero dei cicli
          while (val_inserito.compareTo(Limit.pow(esponente)) == 1) {
          esponente++;}

          int esponente_hex=esponente;

          n = 0;
          BigInteger BASE16 = new BigInteger ("16");
          while (esponente >= 0) {
                Limit = BASE16.pow(esponente);
                Limit = Limit.subtract(BigInteger.ONE) ;
                 while(val_inserito.compareTo(Limit) == 1) {
                   n = n + 1;
                   val_inserito = val_inserito.subtract(BASE16.pow(esponente));
                 }
                     vett_hex[esponente] = d2h(n);
                     // CONVERSIONE valori ESA in valori BINARI, CON SPAZI
                     vbin[esponente] = h2b(vett_hex[esponente]);
                                   n = 0;
                                   esponente--;
                                   }
                                       //scrivo stringhe da stampare
                                       tempOct="";
                                       tempH="";
                                       tempB="";
                                       while (esponente_hex >= 0) {
                                            tempH=tempH+vett_hex[esponente_hex];
                                            tempB=tempB+vbin[esponente_hex];
                                            esponente_hex--;
                                       }
                                       while (esponente_oct >= 0) {
                                           tempOct=tempOct+vett_oct[esponente_oct];
                                           esponente_oct--;
                                       }

                   display.setText("Dec: "+decimale);
                   display1.setText("Hex: "+tempH);
                   display2.setText("Bin: "+tempB);
                   display3.setText("Oct: "+tempOct);

                   val_inserito = decimale;
                   old_val_inserito = val_inserito;

           } // else
        } // if ACTION_DOWN

        if (event.getAction() == MotionEvent.ACTION_UP) {
            v.setBackgroundColor(Color.parseColor("#ffd700"));
        }
        return true;
    } // ontouch event
}); // Fine listener bottone conversione

}  // MainActivity


// seguono le funzioni

              char d2h(int m) {char c =' ';

                                if (m  == 0) c =  '0';
                                else if (m  == 1)  c =  '1';
                                else if (m  == 2)  c =  '2';
                                else if (m  == 3)  c =  '3';
                                else if (m  == 4)  c =  '4';
                                else if (m  == 5)  c =  '5';
                                else if (m  == 6)  c =  '6';
                                else if (m  == 7)  c =  '7';
                                else if (m  == 8)  c =  '8';
                                else if (m  == 9)  c =  '9';
                                else if (m  == 10) c =  'A';
                                else if (m  == 11) c =  'B';
                                else if (m  == 12) c =  'C';
                                else if (m  == 13) c =  'D';
                                else if (m  == 14) c =  'E';
                                else if (m  == 15) c =  'F';
                  return c ;
              }

              String h2b(char c) {String s = "0000 ";
                  if (c == '0') s = "0000 ";
                  else if (c == '1') s = "0001 ";
                  else if (c == '2') s = "0010 ";
                  else if (c == '3') s = "0011 ";
                  else if (c == '4') s = "0100 ";
                  else if (c == '5') s = "0101 ";
                  else if (c == '6') s = "0110 ";
                  else if (c == '7') s = "0111 ";
                  else if (c == '8') s = "1000 ";
                  else if (c == '9') s = "1001 ";
                  else if (c == 'A') s = "1010 ";
                  else if (c == 'B') s = "1011 ";
                  else if (c == 'C') s = "1100 ";
                  else if (c == 'D') s = "1101 ";
                  else if (c == 'E') s = "1110 ";
                  else if (c == 'F') s = "1111 ";

                 return s;

              }





    //stampa la stringa binaria con spazi e ne calcola l'equivalente decimale
    BigInteger  ValInserito(BigInteger BASE, BigInteger val_inserito, BigInteger v, int space){
                   //se il valore e' nullo si ferma subito
         if(val_inserito.compareTo(BigInteger.ZERO) == 0 && v.compareTo(BigInteger.ZERO) == 0){
                 riazzera_function();}
                  else {  val_inserito = val_inserito.multiply(BASE);
                          val_inserito = val_inserito.add(v);
                          int val_inserito_bit = val_inserito.bitLength();
                          if (val_inserito_bit > 256) {
                             riazzera_function();
                             ScalePrint (0);
                             val_inserito = BigInteger.valueOf(0);  //sta anche in riazzerq ma pare lo voglia 2 volte
                             display.setText("");
                             display1.setText("LIMIT REACHED !!!");
                             display2.setText("limit: 256 bits");
                             val_inserito = BigInteger.valueOf(0);//sta anche in riazzerq ma pare lo voglia 2 volte
                          } else {   ScalePrint (val_inserito_bit);
                                     Limit = BigInteger.ZERO;
                                     if (v.compareTo(Limit) == 0 && space == 3 ) tempB=tempB+" 0";
                                     else if (v.compareTo(Limit) == 0 && space != 3 ) tempB=tempB+"0";
                                     else if (v.compareTo(Limit) == 1 && space == 3 ) tempB=tempB+" 1";
                                     else if (v.compareTo(Limit) == 1 && space != 3 ) tempB=tempB+"1";

                                     display.setText("Dec: ");
                                     display1.setText("Hex: ");
                                     display3.setText("Oct: ");
                                     display2.setText("Bin: "+tempB);
                                 }
         }
         return(val_inserito);
   }



        //FUNZIONE imposta dimensione caratteri
 void ScalePrint (int bL) {

 if (bL < 38) {
                  display.setTextSize(25);
                    display1.setTextSize(22);
                    display3.setTextSize(22);
                    display2.setTextSize(15);}


                   else if (bL > 37 &&  bL < 78) {
                          display.setTextSize(20);
                          display1.setTextSize(20);
                          display3.setTextSize(15);
                          display2.setTextSize(12); }

                      else if (bL > 77 && bL < 84 ) {
                                  display.setTextSize(18);
                                  display1.setTextSize(18);
                                  display3.setTextSize(15);
                                  display2.setTextSize(11); }

                      else if (bL > 83 &&  bL < 90) {
                                  display.setTextSize(16);
                                  display1.setTextSize(16);
                                  display3.setTextSize(14);
                                  display2.setTextSize(11); }

                      else if (bL > 89 && bL < 110) {
                  display.setTextSize(14);
                  display1.setTextSize(14);
                  display3.setTextSize(12);
                  display2.setTextSize(10); }

                      else if (bL > 109 && bL < 200) {
                                  display.setTextSize(8);
                                  display1.setTextSize(9);
                                  display3.setTextSize(7);
                                  display2.setTextSize(9); }
                      else if (bL > 199 && bL < 257) {
                                  display.setTextSize(6);
                                  display1.setTextSize(7);
                                  display3.setTextSize(5);
                                  display2.setTextSize(6); }

                      else if (bL > 256)  riazzera_function();

                  }



         void riazzera_function() {
           ScalePrint(0);
           val_inserito = BigInteger.ZERO;
           Limit = BigInteger.ZERO;
            tempD="";
            tempB="";
            tempH="";
            tempOct="";
                 for (n=0; n<100; n++){
                      vett_hex[n]='0';
                     }

                spazio=-1;
             // val_inserito = BigInteger.valueOf(0);
                val_inserito = BigInteger.ZERO;
              display1.setText( "Hex: 0");
              display2.setText( "Bin: 0");
              display3.setText( "Oct: 0");
              display.setText( "Dec: 0");
          }
}
