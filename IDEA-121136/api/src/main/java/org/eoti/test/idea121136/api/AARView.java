package org.eoti.test.idea121136.api;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class AARView extends Activity
{
    private static final String TAG = "IDEA_121136_API";
    public static final String BUNDLE_KEY_APP = "app";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.api_aar_layout);

        try{
            String app = getIntent().getExtras().getString(BUNDLE_KEY_APP);
            ((TextView)findViewById(R.id.txtRequest)).setText(app);
        }catch(Exception e){
            Log.v(TAG, "Error showing AARView", e);
            onDeny(null);
        }
    }

    public void onGrant(View target)
    {
        setResult(RESULT_OK);
        finish();
    }

    public void onDeny(View target)
    {
        setResult(RESULT_CANCELED);
        finish();
    }
}
