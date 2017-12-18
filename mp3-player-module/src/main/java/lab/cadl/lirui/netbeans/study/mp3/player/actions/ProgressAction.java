package lab.cadl.lirui.netbeans.study.mp3.player.actions;

import org.netbeans.api.progress.ProgressHandle;
import org.netbeans.api.progress.ProgressHandleFactory;
import org.openide.awt.*;
import org.openide.util.Cancellable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

@ActionID(
        id = "lab.cadl.lirui.netbeans.study.mp3.player.actions.ProgressAction",
        category = "File"
)
@ActionRegistration(
        displayName = "Progress Action",
        iconBase = "lab/cadl/lirui/netbeans/study/mp3/player/actions/thread.png"
)
@ActionReferences({
        @ActionReference(path = "Menu/File", position = 900),
        @ActionReference(path = "Toolbars/File", position = 300),
        @ActionReference(path = "MyDropDownActions", position = 300)
})
public class ProgressAction implements ActionListener {
    private static Logger logger = Logger.getLogger(ProgressAction.class.getName());

    private boolean stopped = false;

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        logger.info("Progress Action Performed");


        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                ProgressHandle p = ProgressHandleFactory.createHandle("My Task", new Cancellable() {
                    @Override
                    public boolean cancel() {
                        stop();
                        return true;
                    }
                });

                p.start(100);
                for (int i = 1; i <= 100 && !isStopped(); i++) {
                    p.progress("Step " + i, i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ignored) {
                    }
                }

                p.finish();
            }
        };

        new Thread(runnable).start();
    }

    private synchronized void stop() {
        stopped = true;
    }

    private synchronized boolean isStopped() {
        return stopped;
    }
}
