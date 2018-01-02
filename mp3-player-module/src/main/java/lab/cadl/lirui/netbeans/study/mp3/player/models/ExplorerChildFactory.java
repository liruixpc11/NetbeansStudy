package lab.cadl.lirui.netbeans.study.mp3.player.models;

import org.openide.filesystems.FileObject;
import org.openide.nodes.ChildFactory;
import org.openide.nodes.Node;
import org.openide.util.lookup.Lookups;

import javax.swing.*;
import java.util.List;

public class ExplorerChildFactory extends ChildFactory<Action> {
    private FileObject folder = null;

    public ExplorerChildFactory(FileObject folder) {
        this.folder = folder;
    }

    @Override
    protected boolean createKeys(List<Action> toPopulate) {
        toPopulate.addAll(Lookups.forPath(folder.getPath()).lookupAll(Action.class));
        return true;
    }

    @Override
    protected Node createNodeForKey(Action key) {
        return new ExplorerLeafNode(key);
    }
}
