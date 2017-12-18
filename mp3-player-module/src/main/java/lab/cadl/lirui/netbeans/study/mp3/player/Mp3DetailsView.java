package lab.cadl.lirui.netbeans.study.mp3.player;

import lab.cadl.lirui.netbeans.study.mp3.api.Mp3FileObject;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.util.*;
import org.openide.windows.TopComponent;

import java.util.Collection;

@TopComponent.Description(preferredID = "Mp3DetailsView",
        persistenceType = TopComponent.PERSISTENCE_ALWAYS,
        iconBase = "lab/cadl/lirui/netbeans/study/mp3/player/detail.png"
)
@TopComponent.Registration(mode = "output", openAtStartup = true)
@ActionID(category = "Window", id = "lab.cadl.lirui.netbeans.study.mp3.player.Mp3DetailsView")
@ActionReference(path = "Menu/Window" , position = 333)
@TopComponent.OpenActionRegistration(displayName = "#CTL_Mp3DetailsViewAction",
        preferredID = "Mp3DetailsView")
public class Mp3DetailsView extends TopComponent implements LookupListener {
    private Lookup.Result<Mp3FileObject> result = null;

    private javax.swing.JLabel artist;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel title;
    private javax.swing.JLabel year;

    public Mp3DetailsView() {
        initComponents();

        setName(NbBundle.getMessage(Mp3DetailsView.class, "CTL_Mp3DetailsView"));
        setToolTipText(NbBundle.getMessage(Mp3DetailsView.class, "HINT_Mp3DetailsView"));
    }

    @Override
    protected void componentOpened() {
        super.componentOpened();

        result = Utilities.actionsGlobalContext().lookupResult(Mp3FileObject.class);
        result.addLookupListener(this);
        resultChanged(null);
    }

    @Override
    protected void componentClosed() {
        super.componentClosed();

        result.removeLookupListener(this);
        result = null;
    }

    @Override
    public void resultChanged(LookupEvent lookupEvent) {
        Collection<? extends Mp3FileObject> mp3s = result.allInstances();
        if (!mp3s.isEmpty()) {
            Mp3FileObject mp3 = mp3s.iterator().next();
            artist.setText(mp3.getAuthor());
            title.setText(mp3.getTitle());
            year.setText(mp3.getYear());
        }
    }

    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        artist = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        year = new javax.swing.JLabel();

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, "MP3 Informationen");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, "Interpret:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11));
        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, "Titel:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11));
        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, "Jahr:");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(layout.createSequentialGroup()
                                .addContainerGap()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(jSeparator1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                                        .add(jLabel1)
                                        .add(layout.createSequentialGroup()
                                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                                        .add(jLabel3)
                                                        .add(jLabel2)
                                                        .add(jLabel4))
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                        .add(title)
                                                        .add(artist)
                                                        .add(year))))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(layout.createSequentialGroup()
                                .addContainerGap()
                                .add(jLabel1)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(jLabel2)
                                        .add(artist))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(jLabel3)
                                        .add(title))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(jLabel4)
                                        .add(year))
                                .addContainerGap(96, Short.MAX_VALUE))
        );
    }
}
