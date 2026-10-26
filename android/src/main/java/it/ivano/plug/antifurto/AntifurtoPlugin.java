package it.ivano.plug.antifurto;

import android.Manifest;
import android.content.pm.PackageManager;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.getcapacitor.annotation.Permission;
import com.getcapacitor.annotation.PermissionCallback;

@CapacitorPlugin(
    name = "Antifurto",
    permissions = {
        @Permission(
            alias = "sms",
            strings = {android.Manifest.permission.SEND_SMS}
        )
    }
)
public class AntifurtoPlugin extends Plugin {

    private Antifurto implementation = new Antifurto();

    @PluginMethod
    public void echo(PluginCall call) {
        String value = call.getString("value");

        JSObject ret = new JSObject();
        ret.put("value", implementation.echo(value));
        call.resolve(ret);
    }

    @PluginMethod
    public void sendMessage(PluginCall call){
        String phoneNumber = call.getString("phoneNumber");
        String message = call.getString("message");

        if(null == phoneNumber){
            call.reject("Valorizzare il numero di telefono");
            return;
        } else if(null == message){
            call.reject("Il messaggio non può essere vuoto");
            return;
        }

        if(getPermissionState("sms") != com.getcapacitor.PermissionState.GRANTED){
            requestPermissionForAlias("sms", call, "smsPermsCallback");
            return;
        }

        doSendMessage(call);
    }

    @PermissionCallback
    private void smsPermsCallback(PluginCall call){
        if(getPermissionState("sms") == com.getcapacitor.PermissionState.GRANTED){
            doSendMessage(call);
        } else {
            call.reject("Permesso per l'invio di SMS negato");
        }
    }

    private void doSendMessage(PluginCall call){
        String phoneNumber = call.getString("phoneNumber");
        String message = call.getString("message");

        try{
            boolean res = implementation.sendMessage(phoneNumber, message);
            JSObject ret = new JSObject();
            ret.put("result", res);
            call.resolve(ret);
        } catch(Exception ex){
            String error = ex.getMessage();
            call.reject("Errore durante l'invio del messaggio", error);
        }
    }
}
