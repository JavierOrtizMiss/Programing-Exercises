interface Database {
    void saveData(String data);
}

class mySQLDataBase implements Database {
    @Override
    public void saveData(String data) {
        System.out.println("Guardando datos en MySQL: " + data);
    }
}

class DataManager {
    private Database db;

    public DataManager(Database db) {
        this.db = db;
    }

    public void save(String data) {
        db.saveData(data);
    }
}