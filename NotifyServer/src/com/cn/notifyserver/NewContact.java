package com.cn.notifyserver;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.cn.notifyserver.BD.DataBaseManager;

public class NewContact extends Activity
{
    EditText txtNombre, txtTelefono;
    private DataBaseManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newcontact);

        txtNombre= (EditText) findViewById(R.id.txtNombreContacto);
        txtTelefono= (EditText) findViewById(R.id.txtNumeroContacto);
        manager= new DataBaseManager(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.item) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void RegistrarContacto(View v){
        if(txtNombre.getText().toString().trim().length()==0) {
            Toast.makeText(getApplicationContext(), "Ingrese el nombre", Toast.LENGTH_SHORT).show();
            return;
        }

        if(txtTelefono.getText().toString().trim().length()==0) {
            Toast.makeText(getApplicationContext(), "Ingrese el número", Toast.LENGTH_SHORT).show();
            return;
        }

        manager.insertar(txtNombre.getText().toString(), txtTelefono.getText().toString());
		Intent intent= getIntent();
		setResult(1, intent);
        finish();
    }
}
