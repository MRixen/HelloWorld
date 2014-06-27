package mr.helloworld;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by mr on 22.05.14.
 *
 * This class set the fragments for the joystick buttons
 */
public class CustomFragment extends Fragment {

    private SecondActivity context;
    private int localLayoutResource;

    public CustomFragment(SecondActivity context) {
        this.context = context;
    }

    public void setLocalLayout(int frameLayout, int localLayoutResource) {
        this.localLayoutResource = localLayoutResource;
        if (this.localLayoutResource != 0) context.getSupportFragmentManager().beginTransaction().replace(frameLayout, this).commit();
        else context.getSupportFragmentManager()
                .beginTransaction().remove(this).commit();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(localLayoutResource, container, false);
    }
}
