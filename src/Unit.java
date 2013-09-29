/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 9/29/13
 * Time: 4:57 PM
 * To change this template use File | Settings | File Templates.
 */
public enum Unit {
    ML("ml"), G("g");

    String unit;
    private Unit(String str){
        this.unit = str;
    }

    @Override
    public String toString() {
        return unit;
    }
}
