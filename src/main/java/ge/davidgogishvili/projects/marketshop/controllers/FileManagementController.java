package ge.davidgogishvili.projects.marketshop.controllers;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.activation.MimetypesFileTypeMap;
import java.io.*;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("files/upload")
public class FileManagementController {


@GetMapping("getFile")
@Operation(tags = "File Management", summary = "ტექსტ დოკუმენტის ატვირთვა")

public void getfile () {
    File f = new File("/home/david/Projects/IdeaProjects/Files/test.txt");

    try {

        var bos = new BufferedOutputStream(new FileOutputStream(f));
        bos.write("test/n".getBytes());

//        var bos = System.out;
        var out = new PrintWriter(bos);
        out.println("abaa kaco");
        out.flush();
        out.close();
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}




    @GetMapping("{filename}")
    @Operation(tags = "File Management", summary = "ზოგადი ფაილის ატვირთვა")

    public ResponseEntity <?> getFile(@PathVariable String filename, HttpServletResponse response) {
        var prefix = "/home/david/Projects/IdeaProjects/Files/";
        File file = new File(prefix + filename);
        var absolute = file.getAbsolutePath();
        if (!absolute.startsWith(prefix)) {
            return ResponseEntity.notFound().build();
        }

        if (!file.exists()) {
            return ResponseEntity.notFound().build();
        }

        try {
            MimetypesFileTypeMap fileTypeMap = new MimetypesFileTypeMap();
            response.setHeader(HttpHeaders.CONTENT_TYPE, fileTypeMap.getContentType(file));
            response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName()+"\"");
            response.getOutputStream().write(new FileInputStream(file).readAllBytes());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.notFound().build();

    }

}

