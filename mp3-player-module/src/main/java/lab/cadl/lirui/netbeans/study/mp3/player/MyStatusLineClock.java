package lab.cadl.lirui.netbeans.study.mp3.player;

import org.openide.awt.StatusLineElementProvider;
import org.openide.util.lookup.ServiceProvider;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;

@ServiceProvider(service = StatusLineElementProvider.class)
public class MyStatusLineClock implements StatusLineElementProvider {
    private static final DateFormat format = DateFormat.getTimeInstance(DateFormat.MEDIUM);
    private static JLabel time = new JLabel(" " + format.format(new Date()) + " ");
    private JPanel panel = new JPanel(new BorderLayout());

    public MyStatusLineClock() {
        Timer timer = new Timer(1000, actionEvent -> time.setText(" " + format.format(new Date()) + " "));

        timer.start();
        panel.add(new JSeparator(SwingConstants.VERTICAL), BorderLayout.WEST);
        panel.add(time, BorderLayout.CENTER);
    }

    @Override
    public Component getStatusLineElement() {
        return panel;
    }
}
