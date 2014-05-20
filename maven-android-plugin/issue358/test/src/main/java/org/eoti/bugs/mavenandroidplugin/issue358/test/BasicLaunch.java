package org.eoti.bugs.mavenandroidplugin.issue358.test;

import android.annotation.TargetApi;
import android.app.Instrumentation;
import android.content.Intent;
import android.os.Build;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;
import org.eoti.bugs.mavenandroidplugin.issue358.app.Issue358;
import static java.lang.Thread.sleep;

@TargetApi(Build.VERSION_CODES.GINGERBREAD)
public class BasicLaunch
extends ActivityInstrumentationTestCase2<Issue358>
{
    protected String TAG = getClass().getSimpleName();

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public BasicLaunch()
    {
        super(Issue358.class);
    }

    @SmallTest
    public void testStart() throws Exception
    {
        Issue358 app = startActivitySync();
        sleep(500);
        app.finish();
    }

    @SuppressWarnings("unchecked")
    protected Issue358 startActivitySync() {
        Intent intent = new Intent(getInstrumentation().getTargetContext(), Issue358.class);
        intent.setFlags(intent.getFlags() | Intent.FLAG_ACTIVITY_NEW_TASK);
        return (Issue358) getInstrumentation().startActivitySync(intent);
    }
}
