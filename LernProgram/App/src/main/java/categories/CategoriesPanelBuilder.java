package categories;


import java.util.List;

import app.DBClient;
import app.Panel;
import app.PanelBuilder;
import category_types.CategoryTypesPanelBuilder;

/**
 * This {@link PanelBuilder} is used to build all categories from the database.
 * 
 * @author Paul Faller
 *
 */
public class CategoriesPanelBuilder extends PanelBuilder
{
    public CategoriesPanelBuilder(List<String> categoriesList)
    {
        super(categoriesList);
    }


    @Override
    protected void buildCategoryPanel(List<String> categoriesList, Panel mainPanel)
    {
        for (String category : categoriesList)
        {
            CategoryTypesPanelBuilder categoryTypesPanelBuilder = new CategoryTypesPanelBuilder(DBClient.getCategoryTypes(), category);
            mainPanel.add(categoryTypesPanelBuilder.buildPanel(), category + PANEL);
        }
    }
}
