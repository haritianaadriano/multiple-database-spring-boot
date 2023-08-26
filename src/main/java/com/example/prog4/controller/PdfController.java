package com.example.prog4.controller;

import com.example.prog4.service.PdfService;
import com.lowagie.text.DocumentException;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@AllArgsConstructor
public class PdfController {
    private final PdfService pdfService;

    @GetMapping("/employee/{id_employee}/raw/pdf")
    public void getOneEmployeePdf(
            @PathVariable(name = "id_employee")String idEmploye,
            HttpServletResponse response
    ) {
        try {
            Path file = Paths.get(pdfService.generatedPdf(idEmploye).getAbsolutePath());
            if(Files.exists(file)) {
                response.setContentType("application/pdf");
                response.addHeader(
                        "Content-Disposition",
                        "attachment; filename:"+file.getFileName()
                );
                Files.copy(file, response.getOutputStream());
                response.getOutputStream().flush();
            }
        }
        catch (IOException | DocumentException e) {
            e.printStackTrace();
        }
    }
}
