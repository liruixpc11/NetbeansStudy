package lab.cadl.lirui.netbeans.study.mp3.player.models;

import org.openide.filesystems.FileObject;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;

public class ExplorerFolderNode extends AbstractNode {
    public ExplorerFolderNode(FileObject node, Children children) {
        super(children);

        setDisplayName(node.getName());
        String iconBase = (String) node.getAttribute("icon");
        if (iconBase != null) {
            setIconBaseWithExtension(iconBase);
        }
    }
}
