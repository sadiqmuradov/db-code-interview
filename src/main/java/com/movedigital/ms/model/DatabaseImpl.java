package com.movedigital.ms.model;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Repository
public class DatabaseImpl implements Database {

    @Override
    public int insert(String tableName,
                      List<String> values) {
        int id = 0;
        if (values != null && !values.isEmpty()) {
            try {
                Path path = Paths.get(tableName);
                if (!Files.exists(path)) {
                    Files.createFile(path);
                }
                List<String> rows = Files.readAllLines(path);
                Files.write(path, (getRow(values) + "\n").getBytes(), StandardOpenOption.APPEND);
                id = rows.size() + 1;
            } catch (IOException e) {
                log.error("Insert IO exception. Cause: {}",
                        e.getMessage());
            }
        }
        return id;
    }

    @Override
    public void update(String tableName,
                       int rowId,
                       List<String> values) {
        if (values != null && !values.isEmpty()) {
            try {
                Path path = Paths.get(tableName);
                List<String> rows = getTableRows(path, tableName, rowId);
                rows.set(rowId - 1, getRow(values));
                Files.write(path, rows);
            } catch (IOException e) {
                log.error("Update IO exception. Cause: {}",
                          e.getMessage());
                throw new RuntimeException("rows could not be retrieved");
            }
        } else {
            throw new IllegalArgumentException("values not provided");
        }
    }

    @Override
    public List<String> select(String tableName, int rowId) {
        try {
            Path path = Paths.get(tableName);
            List<String> rows = getTableRows(path, tableName, rowId);
            return Arrays.asList(rows.get(rowId - 1).split(" "));
        } catch (IOException e) {
            log.error("Select IO exception. Cause: {}",
                      e.getMessage());
            throw new RuntimeException("rows could not be retrieved");
        }
    }

    private String getRow(List<String> values) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.size(); i++) {
            sb.append(values.get(i));
            if (i < values.size() - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    private List<String> getTableRows(Path path,
                                      String tableName,
                                      int rowId)
            throws IOException {
        List<String> rows;
        if (!Files.exists(path)) {
            throw new NotFoundException("table with name '" + tableName + "' not found");
        }
        rows = Files.readAllLines(path);
        if (rowId <= 0 || rowId > rows.size()) {
            throw new NotFoundException("row with id '" + rowId + "' not found");
        }
        return rows;
    }
}
