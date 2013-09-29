import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 9/26/13
 * Time: 4:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class Material {
    private float quantity;
    private Unit unit;
    private String name;
    private Color color;
    //todo add concentration

    public Material(int quantity, Unit unit, String name, Color color) {
        this.quantity = quantity;
        this. unit = unit;
        this.name = name;
        this.color = color;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
