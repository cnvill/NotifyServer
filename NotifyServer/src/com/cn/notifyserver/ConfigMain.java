package com.cn.notifyserver;


import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.widget.AdapterView.OnItemClickListener;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.database.Cursor;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.AsyncTask;
import com.cn.notifyserver.BD.DataBaseManager;
import com.cn.notifyserver.Class.GeneralCn;
import java.util.List;
public class ConfigMain extends Activity
{
	static boolean isServerClient=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.configmain);
		getActionBar().hide();
    }
	
	public void onRadioButtonClicked(View view){
		boolean checked=((RadioButton)view).isChecked();
		switch(view.getId()){
	 		case R.id.rbtnServidor:
				if(checked)
					isServerClient=true;
				break;
			case R.id.rbtnCliente:
				if(checked)
					isServerClient=false;
				break;
		}
	}
	
	public void OnSaveOption(View view){
	if(isServerClient){
		this.finish();
			Intent mainIntent= new Intent(this, MainActivity.class);
			startActivity(mainIntent);
		}
		
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
}
