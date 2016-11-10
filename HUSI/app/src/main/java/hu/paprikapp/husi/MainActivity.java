package hu.paprikapp.husi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<AlcoholVolume> alcoholVolumeList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText volume = (EditText) findViewById(R.id.volume);
        final EditText alcohol = (EditText) findViewById(R.id.alcohol);
        final Button addButton = (Button) findViewById(R.id.add_button);
        final TextView listText = (TextView) findViewById(R.id.list_textView);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String volumeStr = volume.getText().toString();
                String alcoholStr = alcohol.getText().toString();
                String volumeAlc = String.format("%s ml - %s%%", volumeStr, alcoholStr);
                listText.setText(volumeAlc + "\n" + listText.getText().toString());
            }
        });
    }
}
