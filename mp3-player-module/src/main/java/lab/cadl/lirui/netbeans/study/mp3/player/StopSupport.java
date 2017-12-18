package lab.cadl.lirui.netbeans.study.mp3.player;

import lab.cadl.lirui.netbeans.study.mp3.player.models.Mp3DataObject;

public class StopSupport implements StopInterface {
    private Mp3DataObject mp3 = null;

    public StopSupport(Mp3DataObject mp3) {
        this.mp3 = mp3;
    }

    @Override
    public void stop() {
        System.out.println("stop");
        mp3.playing(false);
    }
}
