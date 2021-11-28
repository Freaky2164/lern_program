package app;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cards.Card;

/**
 * This class can be used to manage the calls to the database.
 * 
 * @author Paul Faller
 */
public class DBClient
{
    private static final String CATEGORIES_DB = "categories";
    private static final String CATEGORIES = "Kategorien";
    private static final String SQL_COMMAND = "SELECT * FROM ";

    private static final String CATEGORY_TYPES = "Kategorie Typen";
    private static final String CATEGORY_TYPES_TABLE = "kategorie_typen";
    private static final String FIELDS = "Felder";
    private static final String FIELDS_TABLE = "felder";

    private static final String QUESTION = "Frage";
    private static final String ANSWER = "Antwort";
    private static final String NUMBER = "Nummer";

    public DBClient()
    {}


    public static List<String> getFields()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/" + CATEGORIES_DB, "username", "secret");
            Statement statement = con.createStatement();
            statement.executeQuery(SQL_COMMAND + FIELDS_TABLE);
            ResultSet resultSet = statement.getResultSet();
            List<String> categoriesList = new ArrayList<>();
            while (resultSet.next())
            {
                categoriesList.add(resultSet.getString(FIELDS));
            }
            return categoriesList;
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return new ArrayList<>();
    }


    public static List<String> getCategoryTypes()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/" + CATEGORIES_DB, "username", "secret");
            Statement statement = con.createStatement();
            statement.executeQuery(SQL_COMMAND + CATEGORY_TYPES_TABLE);
            ResultSet resultSet = statement.getResultSet();
            List<String> categoryTypesList = new ArrayList<>();
            while (resultSet.next())
            {
                categoryTypesList.add(resultSet.getString(CATEGORY_TYPES));
            }
            return categoryTypesList;
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return new ArrayList<>();
    }


    public static List<String> getCategories(String field)
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/" + CATEGORIES_DB, "username", "secret");
            Statement statement = con.createStatement();
            statement.executeQuery(SQL_COMMAND + field.replace(" ", "_"));
            ResultSet resultSet = statement.getResultSet();
            List<String> categoriesList = new ArrayList<>();
            while (resultSet.next())
            {
                categoriesList.add(resultSet.getString(CATEGORIES).replace("_", " ").toUpperCase());
            }
            return categoriesList;
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return new ArrayList<>();
    }


    public static List<Card> getCards(String category, String categoryType)
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/" + category.replace(" ", "_"), "username", "secret");
            Statement statement = con.createStatement();
            statement.executeQuery(SQL_COMMAND + categoryType);
            ResultSet resultSet = statement.getResultSet();
            List<Card> cardsList = new ArrayList<>();
            while (resultSet.next())
            {
                Card card = new Card(resultSet.getString(QUESTION), resultSet.getString(ANSWER), resultSet.getInt(NUMBER));
                cardsList.add(card);
            }
            return cardsList;
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return new ArrayList<>();
    }
}
