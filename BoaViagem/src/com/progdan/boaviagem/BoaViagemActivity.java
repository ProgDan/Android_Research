package com.progdan.boaviagem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class BoaViagemActivity extends Activity {
	private EditText usuario;
	private EditText senha;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		usuario = (EditText) findViewById(R.id.usuario);
		senha = (EditText) findViewById(R.id.senha);
	}
	
	public void entrarOnClick(View v) {
		String usuarioInformado = usuario.getText().toString();
		String senhaInformada = senha.getText().toString();
		
		if(usuarioInformado.equals("leitor") &&
				senhaInformada.equals("123")) {
			// Vai para outra activity
			startActivity(new Intent(this,DashboardActivity.class));
		}
		else {
			// Mostra uma mensagem de erro
			String mensagemErro = getString(R.string.erro_autenticacao);
			Toast toast = Toast.makeText(this, mensagemErro, Toast.LENGTH_SHORT);
			toast.show();
		}
	}

}
