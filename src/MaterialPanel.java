import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 9/29/13
 * Time: 4:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class MaterialPanel extends JPanel{


    public MaterialPanel(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    private List<Material> materials = new ArrayList<Material>();

    public void addMaterial(Material m){
        materials.add(m);
        this.removeAll();
        for(Material mat: materials)
        this.add(new JLabel(mat.getQuantity() + m.getUnit().toString() + " " + mat.getName()));
        this.validate();
    }
}
