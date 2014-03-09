package org.eoti.test.idea121136.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import org.eoti.test.idea121136.api.AARView;

public class Launcher extends Activity
{
    private static final int REQUEST_CODE = 1234;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_launcher_layout);
    }

    public void onRequested(View target)
    {
        Intent intent = new Intent(this, AARView.class);
        intent.putExtra(AARView.BUNDLE_KEY_APP, getResources().getString(R.string.app_name));
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_CODE)
            ((TextView)findViewById(R.id.txtStatus)).setText(resultCode == RESULT_OK ? "Granted" : "Denied");

        super.onActivityResult(requestCode, resultCode, data);
    }
}

