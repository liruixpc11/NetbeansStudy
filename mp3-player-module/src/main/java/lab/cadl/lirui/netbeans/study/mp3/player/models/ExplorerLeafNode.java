package lab.cadl.lirui.netbeans.study.mp3.player.models;

import org.openide.awt.Actions;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;

import javax.swing.*;
import java.awt.*;

public class ExplorerLeafNode extends AbstractNode {
    private Action action = null;

    public ExplorerLeafNode(Action action) {
        super(Children.LEAF);
        this.action = action;
        setDisplayName(Actions.cutAmpersand((String) action.getValue(Action.NAME)));
    }

    @Override
    public Action getPreferredAction() {
        return action;
    }

    @Override
    public Image getIcon(int type) {
        ImageIcon imageIcon = (ImageIcon) action.getValue(Action.SMALL_ICON);
        if (imageIcon != null) {
            return imageIcon.getImage();
        } else {
            return null;
        }
    }
}
