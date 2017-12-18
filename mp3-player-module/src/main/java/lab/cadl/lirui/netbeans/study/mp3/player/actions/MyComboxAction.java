package lab.cadl.lirui.netbeans.study.mp3.player.actions;

import org.openide.awt.*;
import org.openide.util.ImageUtilities;
import org.openide.util.actions.Presenter;
import org.openide.util.lookup.Lookups;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

@ActionID(
        id = "lab.cadl.lirui.netbeans.study.mp3.player.actions.MyComboxAction",
        category = "File"
)
@ActionRegistration(
        displayName = "My Combox Action",
        iconBase = "lab/cadl/lirui/netbeans/study/mp3/player/actions/context.png"
)
@ActionReferences({
        @ActionReference(path = "Toolbars/MyToolBox", position = 300)
})
public class MyComboxAction extends AbstractAction implements Presenter.Toolbar {
    private static Logger logger = Logger.getLogger(MyComboxAction.class.getName());
    private JComboBox<String> box = new JComboBox<>(new String[]{"100%", "200%"});

    public MyComboxAction() {
        box.setMaximumSize(box.getPreferredSize());
        box.setAction(this);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        logger.info(String.format("First Action Performed: %s", box.getSelectedItem()));
        Notification notification = NotificationDisplayer.getDefault().notify(
                String.format("My First Notification: %s", box.getSelectedItem()),
                ImageUtilities.loadImageIcon("lab/cadl/lirui/netbeans/study/mp3/player/actions/info.png", true),
                "... which disappears in a few seconds",
                Lookups.forPath("NotificationActions").lookup(ActionListener.class)
        );
    }

    @Override
    public Component getToolbarPresenter() {
        return box;
    }
}
