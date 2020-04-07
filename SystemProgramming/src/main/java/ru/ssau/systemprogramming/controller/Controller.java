package ru.ssau.systemprogramming.controller;


import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ru.ssau.systemprogramming.model.FileCSV;

import java.io.File;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;

import ru.ssau.systemprogramming.model.NativeCallsClass;
import ru.ssau.systemprogramming.model.Record;
import ru.ssau.systemprogramming.model.analyzer.Analyzer;
import ru.ssau.systemprogramming.model.analyzer.Result;
import ru.ssau.systemprogramming.model.analyzer.StringReader;
import ru.ssau.systemprogramming.model.analyzer.states.Error;
import ru.ssau.systemprogramming.model.analyzer.states.State;
import ru.ssau.systemprogramming.model.io.FileInformationReader;
import ru.ssau.systemprogramming.model.io.InvalidRecordException;
import ru.ssau.systemprogramming.model.io.TextAreaLogger;

import java.io.IOException;


public class Controller {

    ObservableList<Record> recordList;

    TextAreaLogger logger;

    FileCSV fileCSV;

    @FXML
    Button loadButton;
    @FXML
    Button saveButton;
    @FXML
    Button addButton;
    @FXML
    Button deleteButton;
    @FXML
    Button changeButton;

    @FXML
    TextField firstOperTextField;
    @FXML
    TextField secondOperTextField;
    @FXML
    Label firstOperLabel;
    @FXML
    Label secondOperLabel;
    @FXML
    Label nativeResultLabel;

    @FXML
    TextArea logsTextArea;
    @FXML
    TextArea analyzerTextArea;
    @FXML
    TableView<Record> tableView;
    @FXML
    TableColumn<Record, String> columnName;
    @FXML
    TableColumn<Record, String> columnSize;
    @FXML
    TableColumn<Record, String> columnDate;

    @FXML
    private void initialize() {
        logsTextArea.setEditable(false);
        logger = new TextAreaLogger(logsTextArea);
        recordList = FXCollections.observableArrayList();
        fileCSV = new FileCSV(recordList);

        columnName.setCellValueFactory(new PropertyValueFactory<Record, String>("FileName"));
        columnSize.setCellValueFactory(new PropertyValueFactory<Record, String>("FileSize"));
        columnDate.setCellValueFactory(new PropertyValueFactory<Record, String>("Date"));
        recordList.add(new Record("Name.exe",148832228,"23041999"));
        tableView.setItems(recordList);

    }

    @FXML
    private void saveButtonClicked() throws IOException{

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save file");
        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("CSV file", "*.csv");
        fileChooser.getExtensionFilters().add(extensionFilter);
        File file = fileChooser.showSaveDialog(saveButton.getScene().getWindow());
        if (file != null) {
            fileCSV.writeToFile(file);
            logger.log(String.format("Saving data to file: \"%s\"",file.getName()));
        }
    }

    @FXML
    private void loadButtonClicked() throws IOException{
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Load file");
        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("CSV file", "*.csv");
        fileChooser.getExtensionFilters().add(extensionFilter);
        File file = fileChooser.showOpenDialog(loadButton.getScene().getWindow());
        if (file != null) {
            try {
                fileCSV.readFromFile(file);
                logger.log(String.format("Loading data from file: \"%s\"", file.getName()));
            }catch (InvalidRecordException e){
                logger.log(String.format("Error of loading from file: \"%s\" \n Error message: %s", file.getName(),e.getMessage()));
            }
        }
    }

    @FXML
    private void addButtonClicked() throws IOException{
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Add record via file");
        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("EXE file", "*.exe");
        fileChooser.getExtensionFilters().add(extensionFilter);
        File file = fileChooser.showOpenDialog(addButton.getScene().getWindow());
        if (file != null) {
            fileCSV.addNote(new FileInformationReader(file).getFileInformation());
            logger.log(String.format("Adding new note via file: \"%s\"",file.getName()));
        }
    }

    @FXML
    private void deleteButtonClicked() {
        int index = tableView.getSelectionModel().getSelectedIndex();

        if(index == -1){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Important Information");
            alert.setHeaderText(null);
            alert.setContentText("You haven't chosen a record!!!");
            alert.showAndWait();
        }else {
            logger.log("Delete record");
            recordList.remove(index);
        }
    }

    @FXML
    private void analyzeButtonClicked(){
        StringReader stringReader = new StringReader(analyzerTextArea.getText().toLowerCase());
        Analyzer analyzer = new Analyzer(stringReader);
        Result result = analyzer.analyze();
        State state = result.getState();
        logger.log("Analyzing completed");
        if (!(Error.class.isInstance(state))) {
            String amount = "";
            if (result.getSemantic().getNumberOfExecutions() == -1) {
                amount = "Infinity";
            } else {
                amount = String.valueOf(result.getSemantic().getNumberOfExecutions());
            }
            logger.log(String.format("The cycle structure is correct. Cycle will be executed %s times", amount));

        }else {
            Error error = (Error)state;

            logger.log(String.format("The cycle structure is uncorrect.\nError info: %s; Line: %s; Position: %s",
                    error.getMessage(),
                    error.getLine(),
                    error.getLinePosition()
            ));
        }

    }

    @FXML
    private void nativeButtonClicked(){
        try {
            if(firstOperTextField.getText() == null || secondOperTextField.getText() == null){throw new Exception();}
            int firstOper = Integer.parseInt(firstOperTextField.getText());
            int secondOper = Integer.parseInt(secondOperTextField.getText());
            firstOperLabel.setText(Integer.toBinaryString(firstOper));
            secondOperLabel.setText(Integer.toBinaryString(secondOper));
            int result = NativeCallsClass.inputInt(firstOper, secondOper);
            nativeResultLabel.setText(String.format("%s  == %d",Integer.toBinaryString(result),result));


            logger.log("Native OR Complited");
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Wrong type of numbers!!!");
            alert.showAndWait();
        }
    }
    @FXML
    private void changeButtonClicked(){
        TableView.TableViewSelectionModel<Record> selectionModel = tableView.getSelectionModel();
        int index = selectionModel.getSelectedIndex();

        if(index == -1){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Important Information");
            alert.setHeaderText(null);
            alert.setContentText("You haven't chosen a record!!!");
            alert.showAndWait();
        }else {
            Record record = selectionModel.getSelectedItem();
            showChangeRecordDialogForm(record);
            tableView.refresh();
        }
    }

    private void showChangeRecordDialogForm(Record record) {

        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/changeRecordWindow.fxml"));
            Scene scene = new Scene(loader.load());

            RecordChangerController recordChangerController = loader.getController();
            recordChangerController.setRecord(record,tableView);

            Stage newWindow = new Stage();
            newWindow.setTitle("Change record window");
            newWindow.initModality(Modality.WINDOW_MODAL);
            newWindow.initOwner(changeButton.getScene().getWindow());

            newWindow.setScene(scene);
            newWindow.show();

            logger.log("Changing record");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
