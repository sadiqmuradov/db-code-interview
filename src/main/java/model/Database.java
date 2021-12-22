package model;

import java.util.List;

/**
 * Given the following interface, provide an implementation that allows multiple clients to insert / modify / read data
 * stored in the database. Data will be stored in files, one file per table, in an appropriate format (format is not
 * of material importance, text based formats like CSV are acceptable).
 *
 * <p>Build a server with a REST API that exposes your database implementation, with all its operations. The server can
 * be, for example, implemented using Spring Boot: https://spring.io/guides/gs/spring-boot/
 *
 * <p>Focus on building a maintainable and efficient implementation. Producing a fully working system within the
 * allotted time is of secondary importance.
 */
public interface Database {
    /**
     * Stores the given values in the given table as a new row, returning the ID of the newly inserted row. If the table
     * does not exist, it must be created.
     *
     * <p>Once an ID is returned, the row is guaranteed to be retrievable by subsequent {@link #select} calls.
     *
     * @param tableName identifies the table to insert the values into. If the table does not exist, it will be created.
     * @param values a list of values to populate the new row
     * @return a numerical ID that uniquely identifies the newly inserted row within the table
     */
    int insert(String tableName, List<String> values);

    /**
     * Replaces the values of the row identified by the given ID in the given table.
     *
     * @param tableName identifies the table containing the row to be updated
     * @param rowId the numerical ID identifying the row to be updated
     * @param values a list of values to replace the current row values with
     * @throws NotFoundException if the table / row ID combination did not match an existing row
     */
    void update(String tableName, int rowId, List<String> values);

    /**
     * Retrieves the values associated with the given row ID in the given table (as previously inserted / updated).
     *
     * @param tableName identifies the table containing the row to be retrieved
     * @param rowId the numerical ID identifying the row to be retrieved
     * @return the list of values associated with the given table / row ID
     * @throws NotFoundException if the table / row ID combination did not match an existing row
     */
    List<String> select(String tableName, int rowId);
}
