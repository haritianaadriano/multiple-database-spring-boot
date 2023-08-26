package com.example.prog4.service;

import com.example.prog4.conf.company.CompanyConf;
import com.example.prog4.controller.mapper.EmployeeMapper;
import com.example.prog4.model.Employee;
import com.lowagie.text.DocumentException;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Service
public class PdfService {
    private final String PDF_RESOURCE = "templates/";
    private EmployeeService employeeService;
    private SpringTemplateEngine templateEngine;
    private final EmployeeMapper mapper;

    public File generatedPdf(String idEmployee) throws IOException, DocumentException {
        Context context = getContext(idEmployee);
        String html = loadAndFillTemplate(context);
        return renderPdf(html);
    }

    private File renderPdf(String html) throws IOException, DocumentException {
        File templateFile = File.createTempFile("employee", "pdf");
        OutputStream outputStream = new FileOutputStream(templateFile);
        ITextRenderer renderer = new ITextRenderer(20f * 4f / 3f, 20);
        renderer.setDocumentFromString(html, new ClassPathResource(PDF_RESOURCE).getURL().toExternalForm());
        renderer.layout();
        renderer.createPDF(outputStream);
        outputStream.close();
        templateFile.deleteOnExit();
        return templateFile;
    }

    private String loadAndFillTemplate(Context context) {
        return templateEngine.process("employee_pdf", context);  // The template name here should be "employee_pdf"
    }

    private Context getContext(String idEmployee) {
        Context context = new Context();
        Employee employee = mapper.toView(employeeService.getOne(idEmployee));
        CompanyConf companyConf = new CompanyConf();
        Map<String, Object> variables = new HashMap<>();
        variables.put("employee", employee);
        variables.put("companyConf", companyConf);
        context.setVariables(variables);
        return context;
    }
}
