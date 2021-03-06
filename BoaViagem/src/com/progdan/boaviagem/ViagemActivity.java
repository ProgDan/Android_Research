package com.progdan.boaviagem;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

public class ViagemActivity extends Activity {
	private int ano, mes, dia;
	private Button dataSaida;
	private Button dataChegada;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viagem);
		Calendar calendar = Calendar.getInstance();
		ano = calendar.get(Calendar.YEAR);
		mes = calendar.get(Calendar.MONTH);
		dia = calendar.get(Calendar.DAY_OF_MONTH);
		
		dataSaida = (Button)findViewById(R.id.dataSaida);
		dataSaida.setText(dia + "/" + (mes+1) + "/" + ano);
		dataChegada = (Button)findViewById(R.id.dataChegada);
		dataChegada.setText((dia+1) + "/" + (mes+1) + "/" + ano);
	}
	
	public void selecionarData(View view) {
		showDialog(view.getId());
	}
	
	@Override
	protected Dialog onCreateDialog(int id) {
		if(R.id.dataSaida == id){
			return new DatePickerDialog(this, listener, ano, mes, dia);
		}
		if(R.id.dataChegada == id){
			return new DatePickerDialog(this, listener, ano, mes, (dia+1));
		}
		return null;
	}
	
	private OnDateSetListener listener = new OnDateSetListener() {
		@Override
		public void onDateSet(DatePicker view, int year, int montOfYear, int dayOfMonth) {
			ano = year;
			mes = montOfYear;
			dia = dayOfMonth;
			dataSaida.setText(dia + "/" + (mes + 1) + "/" + ano);
		}
	};

}
