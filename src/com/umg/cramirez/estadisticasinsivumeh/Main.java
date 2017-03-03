package com.umg.cramirez.estadisticasinsivumeh;

import com.umg.cramirez.estadisticasinsivumeh.bean.Record;
import com.umg.cramirez.estadisticasinsivumeh.handler.HandlerRecord;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("main_view.fxml"));
        primaryStage.setTitle("Insivumeh");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        //launch(args);
        ArrayList<Record> recordArrayList = new ArrayList<>();

        // Registro 1
        Record record1 = new Record(
            1,
            "Septiembre",
            "8:00am",
            "15",
            "10° C");

        recordArrayList.add(record1);

        // Registro 2
        Record record2 = new Record(
            2,
            "Septiembre",
            "12:00am",
            "14",
            "-6° C");

        recordArrayList.add(record2);

        // Registro 1
        Record record3 = new Record(
            8,
            "Octubre",
            "8:00am",
            "30",
            "0° C");

        recordArrayList.add(record3);

        HandlerRecord.makeFile(recordArrayList);

        // Registro 1
        Record record4 = new Record(
            1,
            "Noviembre",
            "7:00am",
            "10",
            "11°C");

        ArrayList<Record> tempRecordList = new ArrayList<>();
        tempRecordList.add(record4);

        HandlerRecord.addRecord(tempRecordList);

        ArrayList<Record> arrayFromFile;

        arrayFromFile = HandlerRecord.readFile();
        for (Record record : arrayFromFile) {
            System.out.println(record.getDay() + "," + record.getMonth()
                    + "," + record.getHour() + "," + record.getPressure() + ","
                    + record.getTemperature() +  "\n");
            System.out.print(record.getPressure());
        }
        System.out.print(recordArrayList.get(0).getPressure());
    }
}
