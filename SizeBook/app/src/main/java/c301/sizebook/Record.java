package c301.sizebook;

/**
 * Created by Sal on 2017-02-04.
 */


/*
This class contains the individual information for each person added to the recordList
 */
public class Record {
    private String name;
    private float neckSize;
    private float bustSize;
    private float chestSize;
    private float waistSize;
    private float hipSize;
    private float inseamSize;
    private String comment;

    public Record(String name, float neckSize, float bustSize,
                  float chestSize, float waistSize, float hipSize,
                  float inseamSize, String comment){
        setName(name);
        setNeck(neckSize);
        setBust(bustSize);
        setChest(chestSize);
        setWaist(waistSize);
        setHip(hipSize);
        setInseam(inseamSize);
        setComment(comment);
    }

    @Override
    public String toString() {
        String entry_log = getName() + "\nBust:" + getBustSize() + "\nChest:" +
                getChestSize() + "\nWaist:" + getWaistSize() + "\nInseam:" +
                getInseamSize();
        return entry_log;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return this.name;
    }


    public void setNeck (float neckSize){
        this.neckSize =  neckSize;
    }

    public float getNeckSize() {
        return this.neckSize;
    }

    public void setBust(float bustSize){
        this.bustSize = bustSize;
    }

    public float getBustSize(){
        return this.bustSize;
    }

    public void setChest (float chestSize){
        this.chestSize = chestSize;
    }

    public float getChestSize(){
        return this.chestSize;
    }

    public void setWaist (float waistSize) {
        this.waistSize = waistSize;
    }

    public float getWaistSize(){
        return this.waistSize;
    }

    public void setHip (float hipSize){
        this.hipSize = hipSize;
    }

    public float getHipSize(){
        return this.hipSize;
    }

    public void setInseam (float inseamSize){
        this.inseamSize = inseamSize;
    }
    public float getInseamSize(){
        return this.inseamSize;
    }

    public void setComment (String comment){
        this.comment = comment;
    }

    public String getComment(){
        return this.comment;
    }

}
