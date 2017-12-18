package lab.cadl.lirui.netbeans.study.mp3.db;

import lab.cadl.lirui.netbeans.study.mp3.api.Mp3FileObject;
import lab.cadl.lirui.netbeans.study.mp3.api.Mp3Finder;
import org.openide.util.lookup.ServiceProvider;

import java.util.Collections;
import java.util.List;

@ServiceProvider(service = Mp3Finder.class)
public class Mp3DatabaseFinder implements Mp3Finder {
    @Override
    public List<Mp3FileObject> find(String search) {
        return Collections.singletonList(new Mp3FileObject());
    }
}
