package com.umg.cramirez.estadisticasinsivumeh.handler;

import com.umg.cramirez.estadisticasinsivumeh.bean.Record;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Cristian Ramírez on 3/03/2017.
 * UMG
 * cristianramirezgt@gmail.com
 */
public class HandlerRecord {
    public static void makeFile(ArrayList<Record> list) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("septTEMP.tmp");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Record record : list) {
                bufferedWriter.write(record.getDay() + "," + record.getMonth()
                        + "," + record.getHour() + "," + record.getPressure() + ","
                        + record.getTemperature() + "\n");
            }
            bufferedWriter.close();
            System.out.println("Archivo creado con exito!");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static ArrayList<Record> readFile() {
        File file = new File("septTEMP.tmp");
        ArrayList<Record> recordArrayList = new ArrayList<>();
        Scanner scanner;
        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Scanner delimit = new Scanner(line);
                delimit.useDelimiter("\\s*,\\s*");
                Record record = new Record();
                record.setDay(Integer.parseInt(delimit.next()));
                record.setMonth(delimit.next());
                record.setHour(delimit.next());
                record.setPressure(delimit.next());
                record.setPressure(delimit.next());
                recordArrayList.add(record);
            }
            scanner.close();
        } catch (FileNotFoundException fne) {
            fne.printStackTrace();
        }
        return recordArrayList;
    }

    public static void addRecord(ArrayList<Record> recordArrayList) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("septTEMP.tmp", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Record record : recordArrayList) {
                bufferedWriter.write(record.getDay() + "," + record.getMonth()
                        + "," + record.getHour() + "," + record.getPressure() + ","
                        + record.getTemperature() + "\n");
            }
            bufferedWriter.close();
            System.out.println("Se modifico el archivo");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
