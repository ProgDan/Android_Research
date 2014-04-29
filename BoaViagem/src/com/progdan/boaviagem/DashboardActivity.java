package com.progdan.boaviagem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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
		switch(view.getId()) {
		case R.id.nova_viagem:
			startActivity(new Intent(this, ViagemActivity.class));
			break;
		case R.id.novo_gasto:
			startActivity(new Intent(this, GastoActivity.class));
			break;
		case R.id.minhas_viagens:
			startActivity(new Intent(this, ViagemListActivity.class));
			break;
		}
	}
	
}
