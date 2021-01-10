package it.academy.file;

import java.io.*;

public class WorkWithFile {
    String fileName;

    public WorkWithFile(String fileName) {
        this.fileName = fileName;
    }

    public int getNumberOfVisits() throws IOException {

        int numberOfVisits;
        String line;

        //File file = new File("D:\\jd2_hw\\hw4\\task9\\src\\main\\resources\\numberOfVisits.txt");
        File file = new File(fileName);

        if (!file.exists()) {
            file.createNewFile();
        }
        BufferedReader reader = new BufferedReader(new FileReader(file));

        if ((line = reader.readLine()) == null) {
            numberOfVisits = 0;
        } else {
            numberOfVisits = Integer.parseInt(line);
        }

        reader.close();

        return numberOfVisits;
    }

    public void writeNumberOfVisits(int numberOfVisits) throws IOException {

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(fileName)));
        bufferedWriter.write(String.valueOf(numberOfVisits));
        bufferedWriter.close();
    }
}
