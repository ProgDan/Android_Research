package com.progdan.helloandroid;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Build;

public class MainActivity extends Activity {
	private EditText nomeEditText;
	private TextView saudacaoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        this.nomeEditText = (EditText) findViewById(R.id.nomeEditText);
        this.saudacaoTextView = (TextView) findViewById(R.id.saudacaoTextView);
    }


    public void surpreenderUsuario(View v) {
    	// demais códigos existentes
    	Editable texto = this.nomeEditText.getText();
    	String saudacao = getResources().getString(R.string.saudacao);
    	String msg = saudacao + " " + texto.toString();
    	this.saudacaoTextView.setText(msg);
    }

}
