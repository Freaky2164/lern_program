package category_types;


import java.util.List;

import app.DBClient;
import app.Panel;
import app.PanelBuilder;
import cards.CardsPanelBuilder;

/**
 * This {@link PanelBuilder} is used to build all categories types from the database.
 * 
 * @author Paul Faller
 *
 */
public class CategoryTypesPanelBuilder extends PanelBuilder
{
    private final String category;

    public CategoryTypesPanelBuilder(List<String> categoryTypesList, String category)
    {
        super(categoryTypesList);
        this.category = category;
    }


    @Override
    protected void buildCategoryPanel(List<String> categoryTypesList, Panel mainPanel)
    {
        for (String categoryType : categoryTypesList)
        {
            CardsPanelBuilder cardsPanelBuilder = new CardsPanelBuilder(DBClient.getCards(category, categoryType));
            mainPanel.add(cardsPanelBuilder.buildPanel(), categoryType + PANEL);
        }
    }
}
