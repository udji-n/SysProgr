package ru.ssau.systemprogramming.controller;

import javafx.fxml.FXML;
import ru.ssau.systemprogramming.model.Record;
import javafx.scene.control.*;


public class RecordChangerController {

    private Record record;
    private TableView table;

    @FXML
    TextField nameField;
    @FXML
    TextField sizeField;
    @FXML
    TextField dateField;

    public RecordChangerController(){
        record = new Record();
    }

    public void setRecord(Record record, TableView table) {
        this.table = table;
        this.record = record;
        nameField.setText(record.getFileName());
        sizeField.setText(String.valueOf(record.getFileSize()));
        dateField.setText(record.getDate());
    }

    @FXML
    public void okButtonClicked(){
        try {
            record.setFileSize(Integer.parseInt(sizeField.getText()));
            record.setFileName(nameField.getText());
            record.setDate(dateField.getText());
            table.refresh();
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Wrong type of size!!!");
            alert.showAndWait();
        }
    }

}
