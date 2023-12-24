import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MySet {
    //declaring fields
    private Set<Integer> setData;
    private Set<MySet>  setSet;
    private Set<String> Data;

    /**
     * MySet Constructor
     *
     */
    public MySet(){
        setSet = new HashSet<MySet>();
        setData = new HashSet<Integer>();
        Data = new HashSet<String>();
    }

    /**
     * MySet Constructor
     *
     * @param data A parameter
     */
    public MySet(Set<Integer> data){
        this.setData = new HashSet<Integer>(data);
    }

    /**
     * Method getSetData to get set of integer
     *
     * @return The return value
     */
    public Set<Integer> getSetData() {
        return setData;
    }

    /**
     * Method getData to set of string
     *
     * @return The return value
     */
    public Set<String> getData() {
        return Data;
    }

    /**
     * Method getSetSet to get set of sets
     *
     * @return The return value
     */
    public Set<MySet> getSetSet() {
        return setSet;
    }

    /**
     * Method addSetToSet to add set to set
     *
     * @param set A parameter
     * @return The return value
     */
    public boolean addSetToSet(MySet set){
        return setSet.add(set);
    }

    /**
     * Method addToSet to add integer to set
     *
     * @param value A parameter
     * @return The return value
     */
    public boolean addToSet(int value){
        return setData.add(value);
    }

    /**
     * Method addString to add string to set
     *
     * @param value A parameter
     * @return The return value
     */
    public boolean addString(String value){
        return Data.add(value);
    }

    /**
     * Method isSetEmpty to check set is empty or not
     *
     * @return The return value
     */
    public boolean isSetEmpty(){
        return setData.isEmpty();
    }

    /**
     * Method printSet to print a set
     *
     */
    public void printSet(){
        System.out.println(setData);
    }

    /**
     * Method isInSet to check particulate value exist in set or not
     *
     * @param number A parameter
     * @return The boolean
     */
    public boolean isInSet(int number){
        return setData.contains(number);
    }

    /**
     * Method getCardinality to get set size
     *
     * @return The return value
     */
    public int getCardinality(){
        return setData.size();
    }

    /**
     * Method intersection to intersect with set
     *
     * @param secondSet A parameter
     * @return a set which contain intersection
     */
    public MySet intersection(MySet secondSet){
        MySet set = new MySet(setData);
        set.getSetData().retainAll(secondSet.getSetData());
        return set;
    }
}
