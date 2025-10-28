package gui.common.tablemodels;

import javax.swing.table.AbstractTableModel;

import common.data.StudentDatabase;
import javax.swing.table.TableRowSorter;

public class StudentTableModel extends AbstractTableModel {

    StudentDatabase db;
    
    public StudentTableModel(StudentDatabase db) {
        this.db = db;
    }
    public void refreshTable(){
        this.fireTableDataChanged();
    }
    @Override
    public int getRowCount() {
        return this.db.length();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return switch (columnIndex) {
            case 0 -> Integer.class;
            case 1 -> String.class;
            case 2 -> Integer.class;
            case 3 -> String.class;
            case 4 -> String.class;
            case 5 -> Double.class;
            default -> Object.class;
        };
    }
 
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        var student = this.db.getRecord(rowIndex);
        return switch (columnIndex) {
            case 0 -> student.getId();
            case 1 -> student.getName();
            case 2 -> student.getAge();
            case 3 -> student.getGender();
            case 4 -> student.getDepartment();
            case 5 -> student.getGpa();
            default -> null;
        };
    }

    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case 0 -> "ID";
            case 1 -> "Name";
            case 2 -> "Age";
            case 3 -> "Gender";
            case 4 -> "Department";
            case 5 -> "GPA";
            default -> super.getColumnName(column);
        };
    }

}
