package lab.cadl.lirui.netbeans.study.mp3.player.actions;

import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@ActionID(
        id = "lab.cadl.lirui.netbeans.study.mp3.player.actions.RefreshAction",
        category = "File"
)
@ActionRegistration(
        displayName = "Refresh",
        iconBase = "lab/cadl/lirui/netbeans/study/mp3/player/actions/refresh.png",
        key = "RefreshAction"
)
@ActionReferences({
        @ActionReference(path = "Menu/File", position = 900),
        @ActionReference(path = "Toolbars/File", position = 300),
        @ActionReference(path = "MyDropDownActions", position = 300)
})
public class RefreshAction implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
    }
}
