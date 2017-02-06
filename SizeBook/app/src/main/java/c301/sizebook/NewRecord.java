package c301.sizebook;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/*
This class adds a new person entry to the list of records
 */
public class NewRecord extends AppCompatActivity {
    private EditText name;
    private EditText neckSize;
    private EditText bustSize;
    private EditText chestSize;
    private EditText waistSize;
    private EditText hipSize;
    private EditText inseamSize;
    private RecordList log = RecordList.getLogs();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_record);
        Button save = (Button) findViewById(R.id.btn_save);

        save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditText nameRecord = (EditText) findViewById(R.id.et_name);
                String str_name = nameRecord.getText().toString();

                // Neck Entry
                EditText neckRecord = (EditText) findViewById(R.id.et_neckSize);
                String str_neckSize = neckRecord.getText().toString();
                float neckSize;
                if (str_neckSize.length() == 0) {
                    neckSize = 0;
                } else {
                    neckSize = Float.parseFloat(str_neckSize);
                }

                // Bust Entry
                EditText bustRecord = (EditText) findViewById(R.id.et_bustSize);
                String str_bustSize = bustRecord.getText().toString();
                float bustSize;
                if (str_bustSize.length() == 0) {
                    bustSize = 0;
                } else {
                    bustSize = Float.parseFloat(str_bustSize);
                }


                // Chest Entry
                EditText chestRecord = (EditText) findViewById(R.id.et_chestSize);
                String str_chestSize = chestRecord.getText().toString();
                float chestSize;
                if (str_chestSize.length() == 0) {
                    chestSize = 0;
                } else {
                    chestSize = Float.parseFloat(str_chestSize);
                }


                // Waist Entry
                EditText waistRecord = (EditText) findViewById(R.id.et_waistSize);
                String str_waistSize = waistRecord.getText().toString();
                float waistSize;
                if (str_waistSize.length() == 0) {
                    waistSize = 0;
                } else {
                    waistSize = Float.parseFloat(str_waistSize);
                }

                // Hip Entry
                EditText hipRecord = (EditText) findViewById(R.id.et_hipSize);
                String str_hipSize = hipRecord.getText().toString();
                float hipSize;
                if (str_hipSize.length() == 0) {
                    hipSize = 0;
                } else {
                    hipSize = Float.parseFloat(str_hipSize);
                }

                // Inseam Entry
                EditText inseamRecord = (EditText) findViewById(R.id.et_inseamSize);
                String str_inseamSize = inseamRecord.getText().toString();
                float inseamSize;
                if (str_inseamSize.length() == 0) {
                    inseamSize = 0;
                } else {
                    inseamSize = Float.parseFloat(str_inseamSize);
                }

                // Comment Entry
                EditText commentRecord = (EditText) findViewById(R.id.et_comment);
                String str_comment = commentRecord.getText().toString();

                if (nameRecord.getText().toString().length() == 0) {
                    Toast.makeText(getApplicationContext(), "Enter a name", Toast.LENGTH_SHORT).show();
                } else {
                    Record newRecord = new Record(str_name, neckSize, bustSize, chestSize, waistSize,
                            hipSize, inseamSize, str_comment);

                    log.addRecord(newRecord);
                }
                finish();
            }

        });
    }
}