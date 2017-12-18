package lab.cadl.lirui.netbeans.study.mp3.player.actions;

import lab.cadl.lirui.netbeans.study.mp3.player.PlayInterface;
import lab.cadl.lirui.netbeans.study.mp3.player.StopInterface;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@ActionID(
        id = "lab.cadl.lirui.netbeans.study.mp3.player.actions.StopAction",
        category = "Edit"
)
@ActionRegistration(
        displayName = "Stop",
        iconBase = "lab/cadl/lirui/netbeans/study/mp3/player/actions/stop.png"
)
@ActionReferences({})
public class StopAction implements ActionListener {
    private final StopInterface context;

    public StopAction(StopInterface context) {
        this.context = context;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        context.stop();
    }
}
