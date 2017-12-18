package lab.cadl.lirui.netbeans.study.mp3.player;

import lab.cadl.lirui.netbeans.study.mp3.player.models.Mp3DataObject;

public class PlaySupport implements PlayInterface {
    private Mp3DataObject mp3 = null;
    public PlaySupport(Mp3DataObject mp3) {
        this.mp3 = mp3;
    }

    @Override
    public void play() {
        System.out.println(String.format("Play: %s", mp3.getPrimaryFile().getName()));
        this.mp3.playing(true);
    }
}
