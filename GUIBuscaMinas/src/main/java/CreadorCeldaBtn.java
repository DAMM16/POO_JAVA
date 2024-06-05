
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JButton;


public class CreadorCeldaBtn implements ICreadorCeldaBtn{
    public CreadorCeldaBtn(int size) {
        this.size = size;
    }
    int size;
    @Override
    public JButton createButton(int i, int j) {
        JButton btn = new JButton();
        btn.setBounds(10+i*size, 70+j*size, size, size);
        btn.setFont(new Font("Arial", Font.BOLD, 18));
        btn.setMargin(new Insets(0, 0, 0, 0));
        return btn;
    }

}
