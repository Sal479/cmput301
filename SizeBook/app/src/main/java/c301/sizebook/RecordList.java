package c301.sizebook;

import java.util.ArrayList;

/**
 * Created by Sal on 2017-02-05.
 */

/*
The RecordList class places all the records created into a list to display onto the application
 */

public class RecordList {

    private static final RecordList logs = new RecordList();

    public static RecordList getLogs() {
        return logs;
    }

    public RecordList(){
        this.listOfRecords = new ArrayList<Record>();
    }

    private ArrayList<Record> listOfRecords;

    public void addRecord(Record record){
        listOfRecords.add(record);
    }

    public void editRecord(int index, Record record){
        this.listOfRecords.set(index, record);
    }

    public void deleteRecord (Record record) {
        listOfRecords.remove(record);
    }

    public Record getRecord(int index){
        return listOfRecords.get(index);
    }

    public void setListOfRecords (ArrayList<Record> listOfRecords){
        this.listOfRecords = listOfRecords;
    }

    public ArrayList<Record> getListOfRecords(){
        return this.listOfRecords;
    }


}
