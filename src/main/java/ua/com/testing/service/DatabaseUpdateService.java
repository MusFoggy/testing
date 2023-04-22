package ua.com.testing.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DatabaseUpdateService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ResourceLoader resourceLoader;

    public void updateDatabase() {
        List<String> sqlStatements = readSqlStatementsFromFile("classpath:db/update_my_category.sql");
        for (String sql : sqlStatements) {
            jdbcTemplate.execute(sql);
        }
    }

    private List<String> readSqlStatementsFromFile(String path) {
        Resource resource = resourceLoader.getResource(path);
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8))) {
            return reader.lines()
                    .filter(line -> !line.trim().isEmpty()) // Filter out empty lines
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Не вдалося прочитати SQL-файл", e);
        }
    }
}


