package gui.common.tablemodels;

import javax.swing.table.AbstractTableModel;

import common.data.StudentDatabase;

public class StudentTableModel extends AbstractTableModel {

    StudentDatabase db;

    public StudentTableModel(StudentDatabase db) {
        this.db = db;
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
        switch (columnIndex) {
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return Integer.class;
            case 3:
                return String.class;
            case 4:
                return String.class;
            case 5:
                return Double.class;
            default:
                return Object.class;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        var student = this.db.getRecord(rowIndex);
        switch (columnIndex) {
            case 0:
                return student.getId();
            case 1:
                return student.getName();
            case 2:
                return student.getAge();
            case 3:
                return student.getGender();
            case 4:
                return student.getDepartment();
            case 5:
                return student.getGpa();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Name";
            case 2:
                return "Age";
            case 3:
                return "Gender";
            case 4:
                return "Department";
            case 5:
                return "GPA";
            default:
                return super.getColumnName(column);
        }
    }

}
