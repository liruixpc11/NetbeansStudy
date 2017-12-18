package lab.cadl.lirui.netbeans.study.mp3.player.models;

import lab.cadl.lirui.netbeans.study.mp3.player.PlayInterface;
import lab.cadl.lirui.netbeans.study.mp3.player.PlaySupport;
import lab.cadl.lirui.netbeans.study.mp3.player.StopInterface;
import lab.cadl.lirui.netbeans.study.mp3.player.StopSupport;
import org.openide.filesystems.FileObject;
import org.openide.loaders.DataNode;
import org.openide.loaders.DataObjectExistsException;
import org.openide.loaders.MultiDataObject;
import org.openide.loaders.MultiFileLoader;
import org.openide.nodes.Children;
import org.openide.nodes.Node;
import org.openide.util.Lookup;

public class Mp3DataObject extends MultiDataObject {
    private PlaySupport playSupport = null;
    private StopSupport stopSupport = null;

    public Mp3DataObject(FileObject fo, MultiFileLoader loader) throws DataObjectExistsException {
        super(fo, loader);


        playSupport = new PlaySupport(this);
        stopSupport = new StopSupport(this);

        getCookieSet().assign(PlayInterface.class, playSupport);
    }

    @Override
    protected Node createNodeDelegate() {
        return new DataNode(this, Children.LEAF, getLookup());
    }

    @Override
    public Lookup getLookup() {
        return getCookieSet().getLookup();
    }

    public void playing(boolean playing) {
        if (playing) {
            getCookieSet().assign(PlayInterface.class);
            getCookieSet().assign(StopInterface.class, stopSupport);
        } else {
            getCookieSet().assign(PlayInterface.class, playSupport);
            getCookieSet().assign(StopInterface.class);
        }
    }
}
