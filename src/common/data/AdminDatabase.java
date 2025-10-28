package common.data;

import java.io.IOException;
import java.util.ArrayList;

public class AdminDatabase extends Database<Admin> {
    private static final ArrayList<AdminDatabase> instances = new ArrayList<>();

    public AdminDatabase(String filename) throws IOException {
        super(filename);
    }

    public static AdminDatabase getInstance(String filename) throws IOException {
        for (var i : instances) {
            if (i.filename.equals(filename))
                return i;
        }
        var db = new AdminDatabase(filename);
        instances.add(db);
        return db;
    }

    @Override
    public Admin createRecordFrom(String text) {
        String[] arr = text.split("[,]");
        String name = arr[0];
        String pass = arr[1];
        Admin user = new Admin(name, pass);
        return user;
    }
}
