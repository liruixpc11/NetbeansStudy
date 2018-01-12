package lab.cadl.lirui.netbeans.study.mp3.player.actions;

import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

@ActionID(
        id = "lab.cadl.lirui.netbeans.study.mp3.player.actions.MessageAction",
        category = "File"
)
@ActionRegistration(
        displayName = "Message Action",
        iconBase = "lab/cadl/lirui/netbeans/study/mp3/player/actions/message.png"
)
@ActionReferences({
        @ActionReference(path = "Menu/File", position = 900),
        @ActionReference(path = "Toolbars/File", position = 300),
        @ActionReference(path = "MyDropDownActions", position = 300)
})
public class MessageAction implements ActionListener {
    private static Logger logger = Logger.getLogger(MessageAction.class.getName());

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        NotifyDescriptor md = new NotifyDescriptor.Message("Message");
        DialogDisplayer.getDefault().notify(md);
    }
}
