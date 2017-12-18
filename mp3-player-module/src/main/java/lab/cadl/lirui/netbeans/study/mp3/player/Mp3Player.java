package lab.cadl.lirui.netbeans.study.mp3.player;

import lab.cadl.lirui.netbeans.study.mp3.api.Mp3FileObject;
import org.openide.util.Lookup;

public abstract class Mp3Player {
    public abstract void play(Mp3FileObject mpe);
    public abstract void stop();

    public static Mp3Player getDefault() {
        Mp3Player player = Lookup.getDefault().lookup(Mp3Player.class);
        if (player == null) {
            player = new DefaultMp3Player();
        }

        return player;
    }

    private static class DefaultMp3Player extends Mp3Player {

        @Override
        public void play(Mp3FileObject mpe) {

        }

        @Override
        public void stop() {

        }
    }
}
