package lab.cadl.lirui.netbeans.study.mp3.player.actions;

import lab.cadl.lirui.netbeans.study.mp3.player.AbstractTask;
import lab.cadl.lirui.netbeans.study.mp3.player.MyTask;
import org.netbeans.api.progress.aggregate.AggregateProgressFactory;
import org.netbeans.api.progress.aggregate.AggregateProgressHandle;
import org.netbeans.api.progress.aggregate.ProgressContributor;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@ActionID(
        id = "lab.cadl.lirui.netbeans.study.mp3.player.actions.ProgressGroupAction",
        category = "File"
)
@ActionRegistration(
        displayName = "Progress Group Action",
        iconBase = "lab/cadl/lirui/netbeans/study/mp3/player/actions/thread-group.png"
)
@ActionReferences({
        @ActionReference(path = "Menu/File", position = 900),
        @ActionReference(path = "Toolbars/File", position = 300),
        @ActionReference(path = "MyDropDownActions", position = 300)
})
public class ProgressGroupAction implements ActionListener {
    private static Logger logger = Logger.getLogger(ProgressGroupAction.class.getName());

    private boolean stopped = false;

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        logger.info("Progress Group Action Performed");

        List<AbstractTask> tasks = new ArrayList<>();
        tasks.add(new MyTask("Task1"));
        tasks.add(new MyTask("Task2"));
        tasks.add(new MyTask("Task3"));

        ProgressContributor[] cps = new ProgressContributor[tasks.size()];
        for (int i = 0; i < cps.length; i++) {
            cps[i] = tasks.get(i).getProgressContributor();
        }

        AggregateProgressHandle aggregateProgressFactory = AggregateProgressFactory.createHandle(
                "My Tasks",
                cps,
                null,
                null
        );

        aggregateProgressFactory.start();
        for (AbstractTask task : tasks) {
            task.start();
        }
    }

    private synchronized void stop() {
        stopped = true;
    }

    private synchronized boolean isStopped() {
        return stopped;
    }
}
