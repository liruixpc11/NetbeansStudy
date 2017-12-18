package lab.cadl.lirui.netbeans.study.mp3.player;

import org.netbeans.api.progress.aggregate.AggregateProgressFactory;
import org.netbeans.api.progress.aggregate.ProgressContributor;

public abstract class AbstractTask extends Thread {
    protected ProgressContributor p = null;

    public AbstractTask(String id) {
        p = AggregateProgressFactory.createProgressContributor(id);
    }

    public ProgressContributor getProgressContributor() {
        return p;
    }
}
