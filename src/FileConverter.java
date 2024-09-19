//Structural Design Patterns = File converter = Adapter Pattern 
interface File {
    void read();
}

class CSVFile implements File {
    public void read() {
        System.out.println("Reading CSV file");
    }
}

class JSONFile {
    public void write(String data) {
        System.out.println("Writing to JSON file: " + data);
    }
}

class CSVAdapter extends JSONFile implements File {
    private CSVFile csvFile;

    public CSVAdapter(CSVFile csvFile) {
        this.csvFile = csvFile;
    }

    public void read() {
        csvFile.read();
        // Convert CSV data to JSON and write to JSON file
        write("{\"key\": \"value\"}");
    }
}

public class FileConverter {
    public static void main(String[] args) {
        CSVFile csvFile = new CSVFile();
        CSVAdapter adapter = new CSVAdapter(csvFile);
        adapter.read();
    }
}