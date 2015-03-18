package com.juandiego.calculadora;

import android.R.*;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity implements OnClickListener {

	boolean error = false;
	boolean decimal = false;
	boolean suma = false;
	boolean resta = false;
	boolean multi = false;
	boolean division = false;
	boolean potencia = false;
	boolean raiz = false;
	boolean sen = false;
	boolean cos = false;
	boolean tan = false;
	Double[] numero = new Double[20];
	double resultado = 0;
	boolean existepunto = false;
	boolean igual;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Numeros de la calculadora
		Button n0 = (Button) findViewById(R.id.Btn0);
		n0.setOnClickListener(this);
		Button n1 = (Button) findViewById(R.id.Btn1);
		n1.setOnClickListener(this);
		Button n2 = (Button) findViewById(R.id.Btn2);
		n2.setOnClickListener(this);
		Button n3 = (Button) findViewById(R.id.Btn3);
		n3.setOnClickListener(this);
		Button n4 = (Button) findViewById(R.id.Btn4);
		n4.setOnClickListener(this);
		Button n5 = (Button) findViewById(R.id.Btn5);
		n5.setOnClickListener(this);
		Button n6 = (Button) findViewById(R.id.Btn6);
		n6.setOnClickListener(this);
		Button n7 = (Button) findViewById(R.id.Btn7);
		n7.setOnClickListener(this);
		Button n8 = (Button) findViewById(R.id.Btn8);
		n8.setOnClickListener(this);
		Button n9 = (Button) findViewById(R.id.Btn9);
		n9.setOnClickListener(this);

		// Operaciones
		Button Sen = (Button) findViewById(R.id.BtnSen);
		Sen.setOnClickListener(this);
		Button Cos = (Button) findViewById(R.id.BtnCos);
		Cos.setOnClickListener(this);
		Button Tan = (Button) findViewById(R.id.BtnTan);
		Tan.setOnClickListener(this);

		Button Sum = (Button) findViewById(R.id.BtnSum);
		Sum.setOnClickListener(this);
		Button Res = (Button) findViewById(R.id.BtnRest);
		Res.setOnClickListener(this);
		Button Mult = (Button) findViewById(R.id.BtnMult);
		Mult.setOnClickListener(this);
		Button Div = (Button) findViewById(R.id.BtnDiv);
		Div.setOnClickListener(this);
		Button Raiz = (Button) findViewById(R.id.BtnRaiz);
		Raiz.setOnClickListener(this);
		Button Potencia = (Button) findViewById(R.id.BtnPotencia);
		Potencia.setOnClickListener(this);
		Button Igual = (Button) findViewById(R.id.BtnIgual);
		Igual.setOnClickListener(this);

		// Punto
		Button Punto = (Button) findViewById(R.id.BtnPunto);
		Punto.setOnClickListener(this);

		// Del es borrar uno a uno AC limpia la salida de la calcualdora
		Button Del = (Button) findViewById(R.id.BtnDel);
		Del.setOnClickListener(this);
		Button AC = (Button) findViewById(R.id.BtnAC);
		AC.setOnClickListener(this);

		Button Salir = (Button) findViewById(R.id.BtnSalir);
		Salir.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {

		TextView Pantalla = (TextView) findViewById(R.id.texto);
		String Cifra = Pantalla.getText().toString();
		int seleccion = v.getId();
		if (Cifra == "") {
			Cifra = "0";
		}
		try {

			switch (seleccion) {

			case R.id.BtnSalir:
				finish();
				break;

			case R.id.Btn0:
				if (Cifra == "0") {
					Pantalla.setText(Cifra);
				} else {
					Pantalla.setText(Cifra + "0");
				}
				break;

			case R.id.Btn1:
				if (Cifra == "0") {
					Pantalla.setText("1");
				} else {
					Pantalla.setText(Cifra + "1");
				}
				break;

			case R.id.Btn2:
				if (Cifra == "0") {
					Pantalla.setText("2");
				} else {
					Pantalla.setText(Cifra + "2");
				}
				break;

			case R.id.Btn3:
				if (Cifra == "0") {
					Pantalla.setText("3");
				} else {
					Pantalla.setText(Cifra + "3");
				}
				break;

			case R.id.Btn4:
				if (Cifra == "0") {
					Pantalla.setText("4");
				} else {
					Pantalla.setText(Cifra + "4");
				}
				break;

			case R.id.Btn5:
				if (Cifra == "0") {
					Pantalla.setText("5");
				} else {
					Pantalla.setText(Cifra + "5");
				}
				break;

			case R.id.Btn6:
				if (Cifra == "0") {
					Pantalla.setText("6");
				} else {
					Pantalla.setText(Cifra + "6");
				}
				break;

			case R.id.Btn7:
				if (Cifra == "0") {
					Pantalla.setText("7");
				} else {
					Pantalla.setText(Cifra + "7");
				}
				break;

			case R.id.Btn8:
				if (Cifra == "0") {
					Pantalla.setText("8");
				} else {
					Pantalla.setText(Cifra + "8");
				}
				break;

			case R.id.Btn9:
				if (Cifra == "0") {
					Pantalla.setText("9");
				} else {
					Pantalla.setText(Cifra + "9");
				}
				break;

			case R.id.BtnPunto:
				if (decimal == false) {
					if (Cifra == "") {
						Pantalla.setText("0.");
					} else {
						Pantalla.setText(Cifra + ".");
					}
					decimal = true;
				} else {
					return;
				}
				break;

			case R.id.BtnAC:
				Pantalla.setText("");
				decimal = false;
				break;

			case R.id.BtnDel:

				Cifra = Cifra.substring(0, Cifra.length() - 1);
				Pantalla.setText(Cifra);

				if (Cifra.indexOf(".") == -1) {
					decimal = false;
				} else {
					decimal = true;
				}

				break;

			case R.id.BtnSen:
				
				if (igual == true) {
					Pantalla.setText("");
					igual = false;
				}
				
				numero[0] = Double.parseDouble(Cifra);
				Pantalla.setText(String.valueOf(Math.sin(numero[0])));
				igual = true;
				
				break;

			case R.id.BtnCos:
				
				if (igual == true) {
					Pantalla.setText("");
					igual = false;
				}
				
				numero[0] = Double.parseDouble(Cifra);
				Pantalla.setText(String.valueOf(Math.cos(numero[0])));
				igual = true;
						
				break;

			case R.id.BtnTan:
				
				if (igual == true) {
					Pantalla.setText("");
					igual = false;
				}
				
				numero[0] = Double.parseDouble(Cifra);
				Pantalla.setText(String.valueOf(Math.tan(numero[0])));
				igual = true;
				
				break;

			case R.id.BtnSum:
				
				suma = true;
				numero[0] = Double.parseDouble(Cifra);
				Pantalla.setText("");
				
				break;

			case R.id.BtnRest:
				
				resta = true;
				numero[0] = Double.parseDouble(Cifra);
				Pantalla.setText("");
				break;

			case R.id.BtnMult:	
				
				multi = true;
				numero[0] = Double.parseDouble(Cifra);
				Pantalla.setText("");
				break;

			case R.id.BtnDiv:
				
				igual = false;
				division = true;
				numero[0] = Double.parseDouble(Cifra);
				Pantalla.setText("");
				break;

			case R.id.BtnIgual:
				numero[1] = Double.parseDouble(Cifra);
				if (igual == true) {
					Pantalla.setText("");
					igual = false;
				}
				if (suma == true) {

					resultado = numero[0] + numero[1];
					Pantalla.setText(String.valueOf(resultado));
					suma = false;
					decimal = true;
					numero[0] = resultado;

				} else if (resta == true) {

					resultado = numero[0] - numero[1];
					Pantalla.setText(String.valueOf(resultado));
					resta = false;
					decimal = true;
					numero[0] = resultado;

				} else if (multi == true) {

					resultado = numero[0] * numero[1];
					Pantalla.setText(String.valueOf(resultado));
					multi = false;
					decimal = true;
					numero[0] = resultado;

				} else if (division == true) {

					resultado = numero[0] / numero[1];
					Pantalla.setText(String.valueOf(resultado));
					division = false;
					numero[0] = resultado;

				} else if (potencia == true) {
					numero[1] = Double.parseDouble(Cifra);
					Pantalla.setText(String.valueOf(Math.pow(numero[0],
							numero[1])));
					potencia = false;
					decimal = true;
					numero[0] = resultado;
				}
				igual = true;
				break;

			case R.id.BtnPotencia:
				if (igual == true) {
					Pantalla.setText("");
					igual = false;
				}

				numero[0] = Double.parseDouble(Cifra);
				Pantalla.setText("");
				potencia = true;
				numero[0] = resultado;
				igual = true;

				break;

			case R.id.BtnRaiz:
				if (igual == true) {
					Pantalla.setText("");
					igual = false;
				}

				numero[0] = Double.parseDouble(Cifra);
				Pantalla.setText(String.valueOf(Math.sqrt(numero[0])));
				igual = true;
				
				break;

			}
			;
		} catch (Exception e) {
			Pantalla.setText("Error");
			error = true;
		}

	}
}
