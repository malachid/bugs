package org.eoti.bugs.mavenandroidplugin.issue358.app;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import org.eoti.bugs.mavenandroidplugin.issue358.api.IdHelper;

public class Issue358 extends Activity {
    private Handler handler;
    private String id;

    private Runnable updateId = new Runnable(){
        @Override
        public void run() {
            ((TextView)findViewById(R.id.advertId)).setText(id);
        }
    };

    private Runnable getId = new Runnable() {
        @Override
        public void run() {
            IdHelper helper = new IdHelper();
            try {
                id = helper.getId(Issue358.this);
            } catch (Exception e) {
                id = e.getMessage();
            }
            handler.post(updateId);
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        handler = new Handler();
        (new Thread(getId)).start();
    }
}