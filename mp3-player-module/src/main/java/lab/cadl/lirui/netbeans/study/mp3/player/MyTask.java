package lab.cadl.lirui.netbeans.study.mp3.player;

public class MyTask extends AbstractTask {

    public MyTask(String id) {
        super(id);
    }

    @Override
    public void run() {
        p.start(100);
        for (int i = 1; i <= 100; i++) {
            p.progress("Step " + i, i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {
            }
        }

        p.finish();
    }
}
