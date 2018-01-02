package lab.cadl.lirui.netbeans.study.mp3.player;

import lab.cadl.lirui.netbeans.study.mp3.player.models.ExplorerFolderFactory;
import lab.cadl.lirui.netbeans.study.mp3.player.models.ExplorerFolderNode;
import org.openide.actions.CopyAction;
import org.openide.actions.CutAction;
import org.openide.actions.DeleteAction;
import org.openide.actions.PasteAction;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.explorer.ExplorerManager;
import org.openide.explorer.ExplorerUtils;
import org.openide.explorer.view.BeanTreeView;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.nodes.Children;
import org.openide.util.NbBundle;
import org.openide.windows.TopComponent;

@TopComponent.Description(preferredID = "ExplorerTopComponent",
        iconBase = "lab/cadl/lirui/netbeans/study/mp3/player/explorer.png",
        persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "explorer", openAtStartup = true)
@ActionID(category = "Window", id = "lab.cadl.lirui.netbeans.study.mp3.player.ExplorerTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(displayName = "#CTL_ExplorerAction",
        preferredID = "ExplorerTopComponent")
public class ExplorerTopComponent extends TopComponent implements ExplorerManager.Provider {
    private static final String ROOT_NODE = "Explorer";
    private final ExplorerManager manager = new ExplorerManager();

    public ExplorerTopComponent() {
        initComponents();
        initActions();
        initTree();

        associateLookup(ExplorerUtils.createLookup(manager, getActionMap()));
        setName(NbBundle.getMessage(ExplorerTopComponent.class, "CTL_ExplorerTopComponent"));
        setToolTipText(NbBundle.getMessage(ExplorerTopComponent.class, "HINT_ExplorerTopComponent"));
    }

    private void initComponents() {

        jScrollPane1 = new BeanTreeView();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
        );
    }

    // Variables declaration - do not modify
    private javax.swing.JScrollPane jScrollPane1;

    // End of variables declaration
    private void initActions() {
        getActionMap().put(CutAction.get(CutAction.class).getActionMapKey(),
                ExplorerUtils.actionCut(manager));
        getActionMap().put(CopyAction.get(CopyAction.class).getActionMapKey(),
                ExplorerUtils.actionCopy(manager));
        getActionMap().put(PasteAction.get(PasteAction.class).getActionMapKey(),
                ExplorerUtils.actionPaste(manager));
        getActionMap().put(DeleteAction.get(DeleteAction.class).getActionMapKey(),
                ExplorerUtils.actionDelete(manager, true));
    }

    private void initTree() {
        FileObject root = FileUtil.getConfigFile(ROOT_NODE);

        if (root != null) { /* folder found */
            manager.setRootContext(new ExplorerFolderNode(
                    root,
                    Children.create(new ExplorerFolderFactory(root), false)));
        }
    }

    @Override
    protected void componentActivated() {
        ExplorerUtils.activateActions(manager, true);
    }

    @Override
    protected void componentDeactivated() {
        ExplorerUtils.activateActions(manager, false);
    }

    @Override
    public ExplorerManager getExplorerManager() {
        return manager;
    }
}
