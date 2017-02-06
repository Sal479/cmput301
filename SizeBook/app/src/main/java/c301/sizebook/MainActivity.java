package c301.sizebook;



import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.icu.text.AlphabeticIndex;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;



/* The main activity of the application. Deals with showing the records on the screen and
calling other activities.

Known issues: Could not get save to work. Edit Adds another entry instead of editing old one, possible because new intent is being 
created.
 */

public class MainActivity extends AppCompatActivity {

    private ListView listRecords;
    private RecordList logs = RecordList.getLogs();
    private Button newRecordButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newRecordButton = (Button) findViewById(R.id.btn_add);

        newRecordButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewRecord.class);
                startActivity(intent);

                //saveInFile();
            }
        });
    }

    protected void onStart() {
        super.onStart();

        //loadFromFile();

        ArrayAdapter<Record> logsAdapter = new ArrayAdapter<Record>(this, android.R.layout.simple_list_item_1, logs.getListOfRecords());
        listRecords = (ListView) findViewById(R.id.listRecords);
        listRecords.setAdapter(logsAdapter);

        listRecords.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
                Record record = (Record) parent.getItemAtPosition(position);

                adb.setMessage(record.getName() + "\nNeck Size: " + record.getNeckSize() + "\nChest Size:" + record.getChestSize()
                        + "\nBust Size: " + record.getBustSize() + "\nWaist Size: " + record.getWaistSize() + "\nHip Size: " + record.getHipSize()
                        + "\nInseam Size: " + record.getInseamSize() + "\nComments: " + record.getComment());

                final int finalPosition = position;

                adb.show();

            }

        });

        listRecords.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(final AdapterView<?> parent, View view,
                                           int position, long id){
                AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
                adb.setMessage("Delete "+parent.getItemAtPosition(position).toString()+"?");
                adb.setCancelable(true);
                final int finalPosition = position;
                adb.setPositiveButton("Delete", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Record record = (Record) parent.getItemAtPosition(finalPosition);
                        logs.deleteRecord(record);
                    }
                });
                adb.setNegativeButton("Edit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Record record = (Record) parent.getItemAtPosition(finalPosition);
                        int recordListIndex = logs.getListOfRecords().indexOf(record);
                        Intent intent = new Intent(MainActivity.this, NewRecord.class);
                        intent.putExtra("Edit",recordListIndex);
                        startActivity(intent);
                    }
                });
                adb.show();
                return true;
            }
        });
    }

    protected void onResume() {
        super.onResume();

        ListView listview_ = (ListView) findViewById(R.id.listRecords);
        String count = "" + listview_.getAdapter().getCount();

        int count_ = Integer.parseInt(count);

        TextView countText = (TextView) findViewById(R.id.recordCount);
        countText.setText("Number of records: " + count);

        TextView norecord = (TextView) findViewById(R.id.emptyRecords);
        if (count_ > 0){
            norecord.setVisibility(View.GONE);
        }


    }
/*
    private void loadFromFile() {
        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            Gson gson = new Gson();
            listRecords = gson.fromJson(in, new TypeToken<ArrayList<Record>>() {
            }.getType());

            fis.close();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
'/

   /*private void saveInFile() {
        try {
            FileOutputStream fos = openFileOutput(FILENAME,
                    Context.MODE_PRIVATE);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

            Gson gson = new Gson();
            gson.toJson(listRecords, out);

            out.flush();

            fos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

*/
    @Override
    protected void onStop() {
        super.onStop();
    }

}
