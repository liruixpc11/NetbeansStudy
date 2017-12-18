package lab.cadl.lirui.netbeans.study.mp3.player.actions;

import org.openide.awt.*;
import org.openide.util.ImageUtilities;
import org.openide.util.Utilities;
import org.openide.util.actions.Presenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.logging.Logger;

@ActionID(
        id = "lab.cadl.lirui.netbeans.study.mp3.player.actions.MyDropDownButton",
        category = "File"
)
@ActionRegistration(
        displayName = "My DropDown Button",
        iconBase = "lab/cadl/lirui/netbeans/study/mp3/player/actions/context.png"
)
@ActionReferences({
        @ActionReference(path = "Toolbars/MyToolBox", position = 300)
})
public class MyDropDownButton extends AbstractAction implements Presenter.Toolbar {
    final static String EXTENSION_POINT = "MyDropDownActions";
    private static Logger logger = Logger.getLogger(MyDropDownButton.class.getName());
    JPopupMenu popup = new JPopupMenu();

    public MyDropDownButton() {
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
    }

    @Override
    public Component getToolbarPresenter() {
        for (Action a : Utilities.actionsForPath(EXTENSION_POINT)) {
            popup.add(a);
        }

        return DropDownButtonFactory.createDropDownButton(
                ImageUtilities.loadImageIcon("lab/cadl/lirui/netbeans/study/mp3/player/actions/folder.png", false),
                popup
        );
    }
}
