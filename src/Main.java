import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        String INSTALLATION_PATH = "C://Game";
        StringBuilder saveLog = new StringBuilder();

        ArrayList<String> listDirecories = new ArrayList<>();
        listDirecories.add(INSTALLATION_PATH + "/src");
        listDirecories.add(INSTALLATION_PATH + "/res");
        listDirecories.add(INSTALLATION_PATH + "/savegames");
        listDirecories.add(INSTALLATION_PATH + "/temp");
        listDirecories.add(INSTALLATION_PATH + "/src/main");
        listDirecories.add(INSTALLATION_PATH + "/src/test");
        listDirecories.add(INSTALLATION_PATH + "/res/drawables");
        listDirecories.add(INSTALLATION_PATH + "/res/vectors");
        listDirecories.add(INSTALLATION_PATH + "/res/icons");

        ArrayList<String> listFile = new ArrayList<>();
        listFile.add(INSTALLATION_PATH + "/src/main/Main.java");
        listFile.add(INSTALLATION_PATH + "/src/main/Utils.java");
        listFile.add(INSTALLATION_PATH + "/temp/temp.txt");

        createDirectories(listDirecories, saveLog);
        createFiles(listFile, saveLog);
        log(saveLog);
    }
    static void createDirectories(ArrayList<String> listDirectories, StringBuilder saveLog) {
        for (String directoryPath : listDirectories) {
            File directory = new File(directoryPath);
            if (!directory.exists()) {
                if (directory.mkdirs()) {
                    saveLog.append("Папка " + directoryPath + " успешно создана\n");
                } else {
                    saveLog.append("Ошибка при создании папки " + directoryPath + "\n");
                }
            }
        }
    }
    static void createFiles(ArrayList<String> listFiles, StringBuilder saveLog) {
        for (String filePath : listFiles) {
            File file = new File(filePath);
            try {
                if (!file.exists()) {
                    if (file.createNewFile()) {
                        saveLog.append("Файл " + filePath + " успешно создан\n");
                    } else {
                        saveLog.append("Ошибка при создании файла " + filePath + "\n");
                    }
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    static void log(StringBuilder saveLog) {
        try (FileWriter writer = new FileWriter("C://Game/temp/temp.txt")) {
            writer.write(saveLog.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

