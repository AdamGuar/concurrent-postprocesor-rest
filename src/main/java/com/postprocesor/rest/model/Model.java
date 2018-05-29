//package com.postprocesor.rest.model;
//
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.InputStream;
//import javax.validation.constraints.NotBlank;
//
//@Document(collection = "models")
//public class Model {
//
//    @Id
//    String modelName;
//
//	String username;
//
//
//    public Model(String modelName, MultipartFile file) {
//        this.modelName = model_name;
//
//    }
//
//    private void parseFile(MultipartFile file) {
//        var stream = file.getInputStream();
//
//    }
//}
