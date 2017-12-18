package lab.cadl.lirui.netbeans.study.mp3.player.actions;

import org.openide.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

@ActionID(
        id = "lab.cadl.lirui.netbeans.study.mp3.player.actions.MyFirstAction",
        category = "File"
)
@ActionRegistration(
        displayName = "My First Action",
        iconBase = "lab/cadl/lirui/netbeans/study/mp3/player/actions/context.png"
)
@ActionReferences({
        @ActionReference(path = "Menu/File", position = 900),
        @ActionReference(path = "Toolbars/File", position = 300),
        @ActionReference(path = "MyDropDownActions", position = 300)
})
public class MyFirstAction implements ActionListener {
    private static Logger logger = Logger.getLogger(MyFirstAction.class.getName());

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        logger.info("First Action Performed");
        StatusDisplayer.getDefault().setStatusText("My First Status");
    }
}
