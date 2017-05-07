package model;

/**
 * Created by anbu.ezhilan on 7/05/2017.
 */

public class BoardColumns {

    private int columnId;
    private String columnName;
    private int columnPointsLimit;

    public int getColumnId() {
        return columnId;
    }

    public void setColumnId(int columnId) {
        this.columnId = columnId;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public int getColumnPointsLimit() {
        return columnPointsLimit;
    }

    public void setColumnPointsLimit(int columnPointsLimit) {
        this.columnPointsLimit = columnPointsLimit;
    }
}
