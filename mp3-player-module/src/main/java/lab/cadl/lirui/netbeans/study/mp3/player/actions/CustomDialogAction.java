package lab.cadl.lirui.netbeans.study.mp3.player.actions;

import org.openide.DialogDescriptor;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

@ActionID(
        id = "lab.cadl.lirui.netbeans.study.mp3.player.actions.CustomDialogAction",
        category = "File"
)
@ActionRegistration(
        displayName = "Custom Dialog Action",
        iconBase = "lab/cadl/lirui/netbeans/study/mp3/player/actions/custom.png"
)
@ActionReferences({
        @ActionReference(path = "Menu/File", position = 900),
        @ActionReference(path = "Toolbars/File", position = 300),
        @ActionReference(path = "MyDropDownActions", position = 300)
})
public class CustomDialogAction implements ActionListener {
    private static Logger logger = Logger.getLogger(CustomDialogAction.class.getName());

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        DialogDescriptor dd = new DialogDescriptor("Custom Dialog Action", "title", true, e -> {
        });
        DialogDisplayer.getDefault().notify(dd);
    }
}
