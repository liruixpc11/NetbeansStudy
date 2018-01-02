package lab.cadl.lirui.netbeans.study.mp3.player.models;

import org.openide.filesystems.FileObject;
import org.openide.nodes.ChildFactory;
import org.openide.nodes.Children;
import org.openide.nodes.Node;

import java.util.Arrays;
import java.util.List;

public class ExplorerFolderFactory extends ChildFactory<FileObject> {
    private FileObject folder = null;

    public ExplorerFolderFactory(FileObject folder) {
        this.folder = folder;
    }

    @Override
    protected boolean createKeys(List<FileObject> toPopulate) {
        toPopulate.addAll(Arrays.asList(folder.getChildren()));
        return true;
    }

    @Override
    protected Node createNodeForKey(FileObject key) {
        return new ExplorerFolderNode(key, Children.create(new ExplorerFolderFactory(key), false));
    }
}
