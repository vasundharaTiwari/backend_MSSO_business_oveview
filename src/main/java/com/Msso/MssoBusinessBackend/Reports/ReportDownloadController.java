package com.Msso.MssoBusinessBackend.Reports;



import lombok.Data;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JRException;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.nio.file.NoSuchFileException;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@Data
@RequestMapping("/api/v1/report")
public class ReportDownloadController {




}
