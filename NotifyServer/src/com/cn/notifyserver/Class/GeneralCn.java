package com.cn.notifyserver.Class;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.telephony.gsm.SmsManager;
import android.widget.Toast;

/**
 * Created by CN on 19/10/2014.
 */
public class GeneralCn {

    private Context ctx;

    public GeneralCn( Context ctx){
        this.ctx=ctx;
    }

    public void sendSMS(String phoneNumber, String message){
        try {

            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage(phoneNumber, null, message, null,null);

        } catch (Exception e) {
            // TODO: handle exception
            Toast.makeText( ctx.getApplicationContext(),"Error al enviar sms "+e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    public void sendSMS(String phoneNumber){
        try {

            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage(phoneNumber, null, "-12.1203998;-77.03025556", null,null);

        } catch (Exception e) {
            // TODO: handle exception
            Toast.makeText( ctx.getApplicationContext(),"Error al enviar sms "+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public String readSMS(){

        String smsContenido="";
        try {

            Uri uri = Uri.parse("content://sms/inbox");
            Cursor cursor = ctx.getContentResolver().query(uri, new String[] { "_id", "thread_id", "address", "person", "date", "body" }, null,null,null);
            String address="",body="",time="";
            long timestamp=0;
            if (cursor != null)
            {
                try
                {
                    int count = cursor.getCount();
                    if (count > 0)
                    {
                        cursor.moveToFirst();
                        long messageId = cursor.getLong(0);
                        long threadId = cursor.getLong(1);
                        address = cursor.getString(2);
                        long contactId = cursor.getLong(3);
                        String contactId_string = String.valueOf(contactId);
                        body = cursor.getString(5);

                    }
                }
                finally { cursor.close(); }
                smsContenido= address+ "|" + body;
            }


            return smsContenido;
        } catch (Exception e) {
            Toast.makeText( ctx.getApplicationContext(),"Error al leer SMS"+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return smsContenido;
    }
}
