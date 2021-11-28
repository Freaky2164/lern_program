package fields;


import java.util.List;

import app.DBClient;
import app.Panel;
import app.PanelBuilder;
import categories.CategoriesPanelBuilder;

/**
 * This {@link PanelBuilder} is used to build all fields from the database.
 * 
 * @author Paul Faller
 *
 */
public class FieldsPanelBuilder extends PanelBuilder
{
    public FieldsPanelBuilder(List<String> fieldsList)
    {
        super(fieldsList);
    }


    @Override
    protected void buildCategoryPanel(List<String> fieldsList, Panel mainPanel)
    {
        for (String field : fieldsList)
        {
            CategoriesPanelBuilder categoriesPanelBuilder = new CategoriesPanelBuilder(DBClient.getCategories(field));
            mainPanel.add(categoriesPanelBuilder.buildPanel(), field + PANEL);
        }
    }
}
