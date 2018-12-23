package com.ivano.dec2hex2bin;


// input esadecimale

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


public class MyNewScreen extends Activity {

        //BigInteger e' il tipo per interi lunghi. Limite e' la RAM del computer.
        //Ha delle ottimizzazioni per prodotto numeri primi lunghi usati nel criptaggio

        int esponente_bin=0, n, spazio=-1,  counter = 0;
        TextView display, display1, display2, display3;
        Button DtoH, B0,B1,B2,B3,B4,B5,B6,B7,B8,B9,Ba,Bb,Bc,Bd,Be,Bf,  esci, riazzera, go2b, go2d,go2oct;
         BigInteger val_inserito = new BigInteger ("0");
         BigInteger decimale = new BigInteger ("0");
         BigInteger Limit = new BigInteger ("0");
         BigInteger old_val_inserito = new BigInteger ("0");
         int  space;

            char[] vett_dec = new char[100];
            char[] vett_hex = new char[100];
            char[] vett_oct = new char[100];
            String[] vbin = new String[280];
            String tempD=" ",tempH=" ",tempB="", tempOct="";


         @Override  //***used to mark methods that override a method declaration in a superclass.
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState); //***onCreate : initialize your activity
                setContentView(R.layout.main2);

                display = (TextView) findViewById (R.id.showOut);
                display1 = (TextView) findViewById (R.id.showOut1);
                display2 = (TextView) findViewById (R.id.showOut2);
                display3 = (TextView) findViewById (R.id.showOut3);

                display.setText("Dec: 0");
                display1.setText("Hex: 0");
                display2.setText("Bin: 0");
                display3.setText("Oct: 0");
            // display.setTextIsSelectable(true);
            // display1.setTextIsSelectable(true);
            // display2.setTextIsSelectable(true);

                //vai alla activity per input binario
                go2b = (Button) findViewById (R.id.buttonBIN);
                go2b.setOnClickListener(new View.OnClickListener() {
                  public void onClick(View arg0) {
                      Intent i = new Intent(MyNewScreen.this, My3rdScreen.class);
                  startActivity(i);
                  //necessario finish() senno' restano aperte le activity che si lasciano
                  //fino a bloccarsi.
                  finish();
              }});

            //vai alla activity per input decimale
            go2d = (Button) findViewById (R.id.buttonDEC);
            go2d.setOnClickListener(new View.OnClickListener() {
              public void onClick(View arg0) {
                      Intent i = new Intent(MyNewScreen.this, MainActivity.class);
                  startActivity(i);
                  finish();
              }});


             //vai alla activity per input ottale
             go2oct = (Button) findViewById (R.id.buttonOCT);
             go2oct.setOnClickListener(new View.OnClickListener() {
                 public void onClick(View arg0) {
                     Intent i = new Intent(MyNewScreen.this, OctalActivity.class);
                     startActivity(i);
                     finish();
                 }});


            esci = (Button) findViewById (R.id.button12);
            esci.setOnClickListener(new View.OnClickListener() {
              public void onClick(View v) {
                      finish();
              }
            });

            B0 = (Button) findViewById (R.id.button0);
            B0.setOnClickListener(new View.OnClickListener() {
              public void onClick(View v) {
                      val_inserito= ValInserito(BigInteger.valueOf(16), val_inserito, BigInteger.ZERO);
                      //compareTo == 0 (valori uguali)
                      // == 1 (first is greater)
                      // == -1 (second is greater)
                             tempH=tempH+ "0";
                             display1.setText("Hex: "+tempH );
                     }});

            B1 = (Button) findViewById (R.id.button1);
            B1.setOnClickListener(new View.OnClickListener() {
              public void onClick(View v) {
                      val_inserito= ValInserito(BigInteger.valueOf(16), val_inserito, BigInteger.valueOf(1));
                             tempH=tempH+"1";
                             display1.setText("Hex: "+tempH );
                    }});

            B2 = (Button) findViewById (R.id.button2);
            B2.setOnClickListener(new View.OnClickListener() {
              public void onClick(View v) {
                      val_inserito= ValInserito(BigInteger.valueOf(16), val_inserito, BigInteger.valueOf(2));
                             tempH=tempH+ "2";
                             display1.setText("Hex: "+tempH );
                    }});

            B3 = (Button) findViewById (R.id.button3);
            B3.setOnClickListener(new View.OnClickListener() {
              public void onClick(View v) {
                      val_inserito= ValInserito(BigInteger.valueOf(16), val_inserito, BigInteger.valueOf(3));
                             tempH=tempH+ "3";
                             display1.setText("Hex: "+tempH );
                    }});

            B4 = (Button) findViewById (R.id.button4);
            B4.setOnClickListener(new View.OnClickListener() {
              public void onClick(View v) {
                      val_inserito= ValInserito(BigInteger.valueOf(16), val_inserito, BigInteger.valueOf(4));
                             tempH=tempH+ "4";
                             display1.setText("Hex: "+tempH );
                    }});

            B5 = (Button) findViewById (R.id.button5);
            B5.setOnClickListener(new View.OnClickListener() {
              public void onClick(View v) {
                      val_inserito= ValInserito(BigInteger.valueOf(16), val_inserito, BigInteger.valueOf(5));
                             tempH=tempH+ "5";
                             display1.setText("Hex: "+tempH );
                    }});

            B6 = (Button) findViewById (R.id.button6);
            B6.setOnClickListener(new View.OnClickListener() {
              public void onClick(View v) {
                      val_inserito= ValInserito(BigInteger.valueOf(16), val_inserito, BigInteger.valueOf(6));
                             tempH=tempH+ "6";
                             display1.setText("Hex: "+tempH );
                    }});

            B7 = (Button) findViewById (R.id.button7);
            B7.setOnClickListener(new View.OnClickListener() {
              public void onClick(View v) {
                      val_inserito= ValInserito(BigInteger.valueOf(16), val_inserito, BigInteger.valueOf(7));
                             tempH=tempH+"7";
                             display1.setText("Hex: "+tempH );
                    }});

            B8 = (Button) findViewById (R.id.button8);
            B8.setOnClickListener(new View.OnClickListener() {
              public void onClick(View v) {
                      val_inserito= ValInserito(BigInteger.valueOf(16), val_inserito, BigInteger.valueOf(8));
                             tempH=tempH+ "8";
                             display1.setText("Hex: "+tempH );
                    }});

            B9 = (Button) findViewById (R.id.button9);
            B9.setOnClickListener(new View.OnClickListener() {
              public void onClick(View v) {
                      val_inserito= ValInserito(BigInteger.valueOf(16), val_inserito, BigInteger.valueOf(9));
                             tempH=tempH+ "9";
                             display1.setText("Hex: "+tempH );
                    }});

            Ba = (Button) findViewById (R.id.buttonA);
            Ba.setOnClickListener(new View.OnClickListener() {
              public void onClick(View v) {
                      val_inserito= ValInserito(BigInteger.valueOf(16), val_inserito, BigInteger.valueOf(10));
                             tempH=tempH+ "A";
                             display1.setText("Hex: "+tempH );
                    }});


            Bb = (Button) findViewById (R.id.buttonB);
            Bb.setOnClickListener(new View.OnClickListener() {
              public void onClick(View v) {
                  val_inserito= ValInserito(BigInteger.valueOf(16), val_inserito, BigInteger.valueOf(11));
                     tempH=tempH+ "B";
                     display1.setText("Hex: "+tempH );
            }});


    Bc = (Button) findViewById (R.id.buttonC);
    Bc.setOnClickListener(new View.OnClickListener() {
      public void onClick(View v) {
              val_inserito= ValInserito(BigInteger.valueOf(16), val_inserito, BigInteger.valueOf(12));
                     tempH=tempH+"C";
                     display1.setText("Hex: "+tempH );
            }});


    Bd = (Button) findViewById (R.id.buttonD);
    Bd.setOnClickListener(new View.OnClickListener() {
      public void onClick(View v) {
              val_inserito= ValInserito(BigInteger.valueOf(16), val_inserito, BigInteger.valueOf(13));
                     tempH=tempH+"D";
                     display1.setText("Hex: "+tempH );
            }});


    Be = (Button) findViewById (R.id.buttonE);
    Be.setOnClickListener(new View.OnClickListener() {
      public void onClick(View v) {
              val_inserito= ValInserito(BigInteger.valueOf(16), val_inserito, BigInteger.valueOf(14));
                     tempH=tempH+"E";
                     display1.setText("Hex: "+tempH );
            }});

    Bf = (Button) findViewById (R.id.buttonF);
    Bf.setOnClickListener(new View.OnClickListener() {
      public void onClick(View v) {
              val_inserito= ValInserito(BigInteger.valueOf(16), val_inserito, BigInteger.valueOf(15));
                      tempH=tempH+ "F";
                      display1.setText("Hex: "+tempH );
             }});


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

/*****************************
DtoH = (Button) findViewById (R.id.button11);
DtoH.setOnClickListener(new View.OnClickListener() {
   public void onClick(View v) {
****************************************/

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
                                                //FERMO il valore inserito in "decimale"
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
                        //cerco valore esponente piu' prossimo per limitare sotto il numero dei cicli
                        while (val_inserito.compareTo(Limit.pow(esponente)) == 1) {
                               esponente++;}

                        //esponente e' la potenza di 16 che da' valore superiore a val_inserito
                        //quindi : val_inserito < 16**(esponente)
                        //e :      val_inserito > 16**(esponente-1)

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
                       // CONVERSIONE valori ESA in valori BINARI, CON SPAZI
                       // CONVERSIONE valori ESA in valori BINARI, CON SPAZI



                       vbin[esponente] = h2b(vett_hex[esponente]);
                       n = 0;
                       esponente--;
                  }


                          //scrivo stringhe hex e bin da stampare
                          tempH="";
                          tempB="";
                          tempOct="";
                          while (esponente_hex >= 0) {
                              tempH=tempH+vett_hex[esponente_hex];
                              tempB=tempB+vbin[esponente_hex];
                              esponente_hex--;
                          }
                          // scrivo stringa ottale
                          while (esponente_oct >= 0) {
                             tempOct=tempOct+vett_oct[esponente_oct];
                             esponente_oct--;
                          }



         //display1.setText("Hex: "+tempH);
     display.setText("Dec: "+decimale);
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


  char d2h(int m) {char c =' ';

                    if      (m  == 0)  c =  '0';
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
      if      (c == '0') s = "0000 ";
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

  //FUNZIONE   VAL_INSERITO
  //FUNZIONE   VAL_INSERITO

  BigInteger  ValInserito(BigInteger BASE, BigInteger val_inserito, BigInteger v){
         //se il valore e' nullo e si e' inserito uno zero,  si ferma subito
 if(val_inserito.compareTo(BigInteger.ZERO) == 0 && v.compareTo(BigInteger.ZERO) == 0){
       riazzera_function();}
    else {
           val_inserito = val_inserito.multiply(BASE);
           val_inserito = val_inserito.add(v);
           int val_inserito_bit = val_inserito.bitLength();
              if (val_inserito_bit > 256) {
                 riazzera_function();
                 ScalePrint (0);
                 display.setText("");
                 display1.setText("LIMIT REACHED !!!");
                 display2.setText("limit: 256 bits");
                 val_inserito = BigInteger.valueOf(0);//sta anche in riazzerq ma pare lo voglia 2 volte
              }  else
                {  ScalePrint (val_inserito_bit);
                   Limit = BigInteger.ZERO;
                   display2.setText("Bin: ");
                   display.setText("Dec: ");
                   display1.setText("Hex: ");
                   display3.setText("Oct: ");
                }
         }
//         display.setText("Dec: "+val_inserito);
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



//FUNZIONE RIAZZERA
//FUNZIONE RIAZZERA

        void riazzera_function() {
              ScalePrint (0);
              val_inserito = BigInteger.ZERO;
                  Limit = BigInteger.ZERO;

               tempD="";
               tempB="";
               tempH="";
               tempOct="";
                  for (n=0; n<100; n++){
                      vett_oct[n]='0';
                      }
               spazio=-1;
          // val_inserito = BigInteger.valueOf(0);
               val_inserito = BigInteger.ZERO;
           display.setText( "Dec: 0");
           display1.setText( "Hex: 0");
           display2.setText( "Bin: 0");
           display3.setText( "Oct: 0");


  }

 }
