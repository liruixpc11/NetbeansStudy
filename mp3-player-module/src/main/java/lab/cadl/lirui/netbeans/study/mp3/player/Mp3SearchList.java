package lab.cadl.lirui.netbeans.study.mp3.player;

import lab.cadl.lirui.netbeans.study.mp3.api.Mp3FileObject;
import lab.cadl.lirui.netbeans.study.mp3.api.Mp3Finder;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.util.Lookup;
import org.openide.util.NbBundle;
import org.openide.util.lookup.AbstractLookup;
import org.openide.util.lookup.InstanceContent;
import org.openide.windows.TopComponent;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.Collections;
import java.util.List;

@TopComponent.Description(preferredID = "Mp3SearchList",
        persistenceType = TopComponent.PERSISTENCE_ALWAYS,
        iconBase = "lab/cadl/lirui/netbeans/study/mp3/player/music2.png")
@TopComponent.Registration(mode = "explorer", openAtStartup = true)
@ActionID(category = "Window", id = "lab.cadl.lirui.netbeans.study.mp3.player.Mp3SearchList")
@ActionReference(path = "Menu/Window", position = 334)
@TopComponent.OpenActionRegistration(displayName = "#CTL_Mp3SearchListAction", preferredID = "Mp3SearchList")
public class Mp3SearchList extends TopComponent implements ListSelectionListener {
    private Mp3SearchListModel model = new Mp3SearchListModel();
    private InstanceContent content = new InstanceContent();

    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable searchResults;

    public Mp3SearchList() {
        initComponents();

        setName(NbBundle.getMessage(Mp3SearchList.class, "CTL_Mp3SearchList"));
        setToolTipText(NbBundle.getMessage(Mp3SearchList.class, "HINT_Mp3SearchList"));

        searchResults.setModel(model);
        searchResults.getSelectionModel().addListSelectionListener(this);

        associateLookup(new AbstractLookup(content));
    }

    public void doSearch(String search) {
        Mp3Finder finder = Lookup.getDefault().lookup(Mp3Finder.class);
        List<Mp3FileObject> list = finder.find(search);
    }

    @Override
    public void valueChanged(ListSelectionEvent event) {
        if (!event.getValueIsAdjusting()) {
            Mp3FileObject mp3 = model.getRow(searchResults.getSelectedRow());
            content.set(Collections.singletonList(mp3), null);
        }
    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane = new javax.swing.JScrollPane();
        searchResults = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(Mp3SearchList.class, "Mp3SearchList.jLabel1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jButton1, org.openide.util.NbBundle.getMessage(Mp3SearchList.class, "Mp3SearchList.jButton1.text")); // NOI18N

        searchResults.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{

                }
        ));
        jScrollPane.setViewportView(searchResults);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(Mp3SearchList.class, "Mp3SearchList.jLabel2.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 400, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                                                .addGap(11, 11, 11)
                                                .addComponent(jButton1))
                                        .addComponent(jScrollPane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 300, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                                .addContainerGap())
        );
    }

}
