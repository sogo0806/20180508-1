import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Objects;
import java.util.Random;

public class MainFrame extends JFrame {
    private JButton jbutge = new JButton("Generate");
    private JButton jbutexit = new JButton("Exit");
    private JLabel jlb [] = new JLabel[6];
    private Random rand = new Random();
    private Container cp;
    private JPanel jpnn = new JPanel(new GridLayout(1,6,3,3));
    private JPanel jpnc = new JPanel(new GridLayout(1,2,3,3));
    public MainFrame (){
        init();
    }
    private void init(){
        setBounds(100,100,600,300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        cp = this.getContentPane();
        jpnc.add(jbutge);
        jpnc.add(jbutexit);
        cp.add(jpnn,BorderLayout.NORTH);
        cp.add(jpnc,BorderLayout.CENTER);

        for (int i =0 ; i < 6 ;i++){
            jlb[i] = new JLabel();
            jlb[i].setFont(new Font(null,Font.BOLD,32));
            jpnn.add(jlb[i]);
        }


        jbutge.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for (int i = 0 ; i<6 ; i++){
                    jlb[i].setText(Integer.toString(rand.nextInt(49)+1));
                    for (int j = 0 ; j < i; j++){
                        if (jlb[j].getText() == jlb[i].getText()){
                            jlb[i].setText(Integer.toString(rand.nextInt(49)+1));
                        }
                    }
                    jpnn.add(jlb[i]);
                }

            }
        });

            jbutexit.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    System.exit(0);
                }
            });

    }
}
