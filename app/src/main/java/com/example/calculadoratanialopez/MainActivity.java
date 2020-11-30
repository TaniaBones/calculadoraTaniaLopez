package com.example.calculadoratanialopez;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    //creamos todas las variables a las que vamos a vincular todos los componentes de nuestro layout
    protected TextView pantalla;
    protected Button uno,dos,tres,cuatro,cinco,seis,siete,ocho,nueve,cero,suma,resta,prod,div,borrar,igual;
    protected String input,respuesta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //relacionamos todos los componentes anteriores con sus correspondientes a partir de sus id

        pantalla=findViewById(R.id.pantalla);

        cero = (Button) findViewById(R.id.button);
        uno = (Button) findViewById(R.id.button1);
        dos = (Button) findViewById(R.id.button2);
        tres = (Button)findViewById(R.id.button3);
        cuatro = (Button) findViewById(R.id.button4);
        cinco = (Button) findViewById(R.id.button5);
        seis = (Button) findViewById(R.id.button6);
        siete = (Button) findViewById(R.id.button7);
        ocho = (Button) findViewById(R.id.button8);
        nueve = (Button) findViewById(R.id.button9);
        suma = (Button) findViewById(R.id.buttonSuma);
        resta = (Button) findViewById(R.id.buttonResta);
        prod = (Button) findViewById(R.id.buttonProducto);
        div = (Button) findViewById(R.id.buttonDiv);
        borrar = (Button) findViewById(R.id.buttonC);
        igual = (Button) findViewById(R.id.buttonIgual);


    }


    //creamos un método para cuando se pulsen los botones
    public void ButtonClick(View view){
        Button button = (Button) view;
         //creamos un string data que recoja el texto que contiene el mismo botón
        String data = button.getText().toString();

        // creamos un switch que nos analice el contenido de data
        switch (data) {
            //cuando se pulsa la tecla borrar nos devolverá el textview vacío
            case "C":
                input = "";
                break;
            case "x":
                //cuando se pulsa la tecla X nos devolverá el símbolo que se usa para el producto
                resolver();
                input += "*";
                break;
            case "=":
                //cuando se pulsa la tecla = se nos dará la respuesta tras el uso del método resolver
                resolver();
                respuesta = input;
                break;
            default:
                //en cualquier otro caso se busca si el input está vacío, que entonces seguirá vacío
                if(input == null){
                    input = "";
                }
                //en caso de que data registre alguno de los siguientes caracteres, pasará al método resolver
                if(data.equals("+") || data.equals("-") || data.equals("/")){
                    resolver();
                }
                //en la variable input se añadirá el contenido de data, sea cual sea
                input += data;
        }
        //nos mostrará en pantalla la operación escrita sin resolver
        pantalla.setText(input);
    }

    //creamos el método resolver, que registrará el resultado en la variable input
    private void resolver(){
        //si el largo del split del input es igual a 2, quitando y separando los elementos de ese array
        //generado por el split por el símbolo registrado en regex
        if(input.split("\\*").length==2){
            //entra dentro del condicional y se crea un array de texto llamado number, que contiene los
            //dos parametros, ignorando el producto en este caso
            String number[]=input.split("\\*");
            //de la siguiente manera, creamos una variable producto que registre el primer elemento del array
            //multiplicado por el segundo elemento del array
            double prod=Double.parseDouble(number[0])*Double.parseDouble(number[1]);
            //ese producto lo registramos en el input para su posterior muestra en pantalla
            input = prod+"";
        }
        else if(input.split("/").length==2){
            //entra dentro del condicional y se crea un array de texto llamado number, que contiene los
            //dos parametros, ignorando el producto en este caso
            String number[]=input.split("/");
            //de la siguiente manera, creamos una variable div que registre el primer elemento del array
            //dividido entre el segundo elemento del array
            double div=Double.parseDouble(number[0])/Double.parseDouble(number[1]);
            //esa división la registramos en el input para su posterior muestra en pantalla
            input = div+"";
        }
        else if(input.split("\\+").length==2){
            //entra dentro del condicional y se crea un array de texto llamado number, que contiene los
            //dos parametros, ignorando el producto en este caso
            String number[]=input.split("\\+");
            //de la siguiente manera, creamos una variable suma que registre el primer elemento del array
            //sumado al segundo elemento del array
            double suma=Double.parseDouble(number[0])+Double.parseDouble(number[1]);
            //esa suma la registramos en el input para su posterior muestra en pantalla
            input = suma+"";
        }
        else if(input.split("-").length==2){
            //entra dentro del condicional y se crea un array de texto llamado number, que contiene los
            //dos parametros, ignorando el producto en este caso
            String number[]=input.split("-");
            //de la siguiente manera, creamos una variable resta que registre el primer elemento del array
            //menos el segundo elemento del array
            double resta=Double.parseDouble(number[0])-Double.parseDouble(number[1]);
            //esa resta la registramos en el input para su posterior muestra en pantalla
            input = resta+"";
        }

        //aquí se nos mostrará por pantalla el resultado final
        pantalla.setText(input);

    }



}