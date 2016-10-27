package hu.paprikapp.husi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText volume = (EditText) findViewById(R.id.volume);
        final EditText alcohol = (EditText) findViewById(R.id.alcohol);
        final Button addButton = (Button) findViewById(R.id.add_button);
        final TextView listText = (TextView) findViewById(R.id.list_textView);

        CheckBox checkbox = (CheckBox) findViewById(R.id.test_check);
        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(MainActivity.this, "IsChecked: " + String.valueOf(isChecked), Toast.LENGTH_LONG).show();
                addButton.setEnabled(isChecked);
            }
        });

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
