package com.opendroid.helper.mail;

import android.content.Context;
import android.content.Intent;

public class EMailFactory {

    private Context context;
    
    public EMailFactory(Context context) {
        this.context = context;
    }
    
    public void sendDefault()  {
        Intent emailIntent = new Intent(Intent.ACTION_SEND_MULTIPLE);
        context.startActivity(emailIntent);
    }
    
    
}
