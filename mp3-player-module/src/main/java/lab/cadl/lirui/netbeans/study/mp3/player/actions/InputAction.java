package lab.cadl.lirui.netbeans.study.mp3.player.actions;

import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.windows.IOProvider;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

@ActionID(
        id = "lab.cadl.lirui.netbeans.study.mp3.player.actions.Input",
        category = "File"
)
@ActionRegistration(
        displayName = "Input Action",
        iconBase = "lab/cadl/lirui/netbeans/study/mp3/player/actions/input.png"
)
@ActionReferences({
        @ActionReference(path = "Menu/File", position = 900),
        @ActionReference(path = "Toolbars/File", position = 300),
        @ActionReference(path = "MyDropDownActions", position = 300)
})
public class InputAction implements ActionListener {
    private static Logger logger = Logger.getLogger(InputAction.class.getName());

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        NotifyDescriptor md = new NotifyDescriptor.InputLine("Input", "title");
        Object ret = DialogDisplayer.getDefault().notify(md);

        IOProvider.getDefault().getIO("LOG", false).getOut().println(ret);
    }
}
