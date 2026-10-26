package it.ivano.plug.antifurto;

import android.util.Log;
import android.telephony.SmsManager;

public class Antifurto {

    public String echo(String value) {
        Log.i("Echo", value);
        return value;
    }

    public boolean sendMessage(String number ,String message) throws Exception{
        boolean inviato = false;
        try{
            SmsManager smsManager = SmsManager.getDefault();
            if(message.length() > 160){
                smsManager.sendMultipartTextMessage(number, 
                    null,
                    smsManager.divideMessage(message),
                    null,null
                );
            } else {
                smsManager.sendTextMessage(number, null, message, null, null);
            }
            inviato = true;
        } catch (Exception ex){
            throw new Exception("Impossibile inviare il messaggio");
        }
        return inviato;
    }
}
