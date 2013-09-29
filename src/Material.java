import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 9/26/13
 * Time: 4:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class Material {
    private float volume;
    private String name;
    private Color color;

    public Material(int volume, String name, Color color) {
        this.volume = volume;
        this.name = name;
        this.color = color;
    }


    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume = volume;
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
