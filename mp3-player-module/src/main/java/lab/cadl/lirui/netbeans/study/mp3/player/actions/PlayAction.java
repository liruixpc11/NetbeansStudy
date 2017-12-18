package lab.cadl.lirui.netbeans.study.mp3.player.actions;

import lab.cadl.lirui.netbeans.study.mp3.player.PlayInterface;
import lab.cadl.lirui.netbeans.study.mp3.player.models.Mp3DataObject;
import org.netbeans.api.actions.Editable;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@ActionID(
        id = "lab.cadl.lirui.netbeans.study.mp3.player.actions.PlayAction",
        category = "Edit"
)
@ActionRegistration(
        displayName = "Play",
        iconBase = "lab/cadl/lirui/netbeans/study/mp3/player/actions/play.png"
)
@ActionReferences({})
public class PlayAction implements ActionListener {
    private final PlayInterface context;

    public PlayAction(PlayInterface context) {
        this.context = context;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        context.play();
    }
}
