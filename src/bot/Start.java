package bot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Start extends JFrame {

    public Start() throws AWTException {
        super("Dota2Bot");
        super.setBounds(906, 529, 350,200);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = super.getContentPane();
        container.setLayout(new GridLayout(4, 1, 10, 10));

        JButton but_start = new JButton("Start bot");
        container.add(but_start);

        JButton but_finish = new JButton("Stop bot");
        container.add(but_finish);

        but_start.addActionListener(new butEManager());
    }

    static class butEManager implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            DotaBot bot = new DotaBot();
            try {
                bot.setStart();
            } catch (AWTException ex) {
                throw new RuntimeException(ex);
            }
        }
    }


}
