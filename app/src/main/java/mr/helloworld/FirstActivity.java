package mr.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import static android.os.Process.myPid;

/**
 * Created by mr on 25.06.14.
 */
public class FirstActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        android.os.Process.killProcess(myPid());
    }

    public void onButtonClicked(View view) {
        switch (view.getId()) {
            case (R.id.start_next_activity):
                Intent intent = new Intent(this, SecondActivity.class);
                startActivity(intent);
                break;
        }
    }
}
