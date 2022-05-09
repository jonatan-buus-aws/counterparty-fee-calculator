package dk.jonatanbuus.counterparty_fee_calculator.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;


/**
 * Service class for handling serving the generated documentation
 * 
 */
@Service
@RequiredArgsConstructor
public class DocumentationService {
    
    public String getDocumentation() {
        try {
            InputStream stream = this.getClass().getClassLoader().getResourceAsStream("openapi.yaml");
            return new String(stream.readAllBytes(), StandardCharsets.UTF_8);
        }
        catch (IOException e) {
            return null;
        }
    }
}