package lab.cadl.lirui.netbeans.study.mp3.player;

import lab.cadl.lirui.netbeans.study.mp3.api.Mp3FileObject;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class Mp3SearchListModel extends AbstractTableModel {
    private String[] columns = {"作者", "名称", "年份"};
    private List<Mp3FileObject> data = new ArrayList<Mp3FileObject>();

    public Mp3SearchListModel() {
        data.add(new Mp3FileObject("Li Rui", "Victory", "2006"));
        data.add(new Mp3FileObject("Li Rui", "Victory2", "2006"));
    }

    public Mp3FileObject getRow(int row) {
        return data.get(row);
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Mp3FileObject mp3 = data.get(row);
        switch (col) {
            case 0: return mp3.getAuthor();
            case 1: return mp3.getTitle();
            case 2: return mp3.getYear();
            default: return "";
        }
    }
}
