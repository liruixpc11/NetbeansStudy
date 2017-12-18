package lab.cadl.lirui.netbeans.study.mp3.player.actions;

import org.netbeans.api.actions.Editable;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@ActionID(
        id = "lab.cadl.lirui.netbeans.study.mp3.player.actions.MyContextAction",
        category = "Edit"
)
@ActionRegistration(
        displayName = "My Context Action",
        iconBase = "lab/cadl/lirui/netbeans/study/mp3/player/actions/context.png"
)
@ActionReferences({})
public class MyContextAction implements ActionListener {
    private final Editable context;

    public MyContextAction(Editable context) {
        this.context = context;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        context.edit();
    }
}
