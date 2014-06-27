package mr.helloworld;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

/**
 * Created by mr on 25.06.14.
 */

public class SecondActivity extends FragmentActivity implements View.OnClickListener {

    private ToggleButton toggleButton;
    private CustomFragment customFragment;
    private boolean showImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        customFragment = new CustomFragment(this);

        toggleButton = (ToggleButton) findViewById(R.id.switch_fragment);
        toggleButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()) {
            case(R.id.switch_fragment):
            if (toggleButton.isChecked()) {
                if(showImage){
                    customFragment.setLocalLayout(R.id.framelayout, R.layout.layout_fragment_image);
                    showImage = false;
                    toggleButton.setTextOff(getResources().getString(R.string.show_button));
                }
                else{
                    customFragment.setLocalLayout(R.id.framelayout, R.layout.layout_fragment_button);
                    showImage = true;
                    toggleButton.setTextOff(getResources().getString(R.string.show_image));
                }
            } else {
                customFragment.setLocalLayout(R.id.framelayout, 0);
            }
                break;
            case(R.id.show_message):
                Toast.makeText(this, R.string.hello_world, Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        final Dialog dialog = new Dialog(this);

        dialog.setContentView(R.layout.layout_dialog);
        dialog.setCancelable(false);
        dialog.setTitle(getString(R.string.back_to_activity));

        Button positiveButton = (Button) dialog.findViewById(R.id.positive_button);
        Button negativeButton = (Button) dialog.findViewById(R.id.negative_button);

        negativeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        positiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               dialog.dismiss();
               finish();
            }
        });
        dialog.show();
    }
}
