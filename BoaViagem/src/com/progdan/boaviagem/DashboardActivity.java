package com.progdan.boaviagem;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DashboardActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dashboard);
	}
	
	public void selecionarOpcao(View view) {
		/*
		 * com base na view que for clicada
		 * iremos tomar a ação correta
		 */
		TextView textView = (TextView) view;
		String opcao = "Opção: " + textView.getText().toString();
		Toast.makeText(this, opcao, Toast.LENGTH_LONG).show();
	}

}
