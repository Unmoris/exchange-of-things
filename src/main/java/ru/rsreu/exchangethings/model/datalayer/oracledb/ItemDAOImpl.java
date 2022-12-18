package ru.rsreu.exchangethings.model.datalayer.oracledb;

import ru.rsreu.exchangethings.configuration.EntitiesResource;
import ru.rsreu.exchangethings.configuration.QueriesProperties;
import ru.rsreu.exchangethings.model.datalayer.DateFormatter;
import ru.rsreu.exchangethings.model.datalayer.ItemDAO;
import ru.rsreu.exchangethings.model.datalayer.entity.ItemEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAOImpl implements ItemDAO {
    private Connection connection;

    public ItemDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<ItemEntity> getItemsForExchange(int userId, int itemStatus) throws SQLException {
        String query = QueriesProperties.getProperty("ItemsForExchange.request");
        PreparedStatement preparedStatement = this.getPreparedStatement(query);
        preparedStatement.setInt(1, itemStatus);
        preparedStatement.setInt(2, userId);
        ResultSet resultSet = preparedStatement.executeQuery();
        return this.getItemsFromQuery(resultSet);
    }

    public List<ItemEntity> getHiddenItems(int itemStatus, int userId) throws SQLException {
        String query = QueriesProperties.getProperty("HiddenItems.request");
        PreparedStatement preparedStatement = this.getPreparedStatement(query);
        preparedStatement.setInt(1, itemStatus);
        preparedStatement.setInt(2, userId);
        ResultSet resultSet = preparedStatement.executeQuery();
        return this.getItemsFromQuery(resultSet);
    }

    public List<ItemEntity> getItemsByUser(int userId) throws SQLException {
        String query = QueriesProperties.getProperty("GetItemsByUser");
        PreparedStatement preparedStatement = this.getPreparedStatement(query);
        preparedStatement.setInt(1, userId);
        ResultSet resultSet = preparedStatement.executeQuery();
        return this.getItemsFromQuery(resultSet);
    }

    @Override
    public ItemEntity getItemById(int id) throws SQLException {
        String query = QueriesProperties.getProperty("SelectItemById");
        PreparedStatement preparedStatement = this.getPreparedStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        return this.getItemsFromQuery(resultSet).stream().findFirst().get();
    }

    @Override
    public void incrementCountView(int id) throws SQLException {
        String query = QueriesProperties.getProperty("IncrementCountView");
        PreparedStatement preparedStatement = this.getPreparedStatement(query);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }

    @Override
    public List<ItemEntity> getItemsForRequestsToUser(int userId, int requestStatus) throws SQLException {
        String query = QueriesProperties.getProperty("ItemsForRequestsToUser.request");
        PreparedStatement preparedStatement = this.getPreparedStatement(query);
        preparedStatement.setInt(1, userId);
        preparedStatement.setInt(2, requestStatus);
        ResultSet resultSet = preparedStatement.executeQuery();
        return this.getItemsFromQuery(resultSet);
    }

    @Override
    public void insertItem(String title, String image, String description, String publicationTime, int userId,
                           int itemStatus) throws SQLException, ParseException {
        String query = QueriesProperties.getProperty("InsertItem.request");
        PreparedStatement preparedStatement = this.getPreparedStatement(query);
        preparedStatement.setString(1, title);
        preparedStatement.setString(2, image);
        preparedStatement.setString(3, description);
        preparedStatement.setDate(4, DateFormatter.getSimpleDateFormatTime(publicationTime));
        preparedStatement.setInt(5, userId);
        preparedStatement.setInt(6, itemStatus);
        preparedStatement.executeUpdate();

    }

    @Override
    public void updateItemStatus(int itemStatus, int itemId) throws SQLException {
        String query = QueriesProperties.getProperty("UpdateItemStatus.request");
        PreparedStatement preparedStatement = this.getPreparedStatement(query);
        preparedStatement.setInt(1, itemStatus);
        preparedStatement.setInt(2, itemId);
        preparedStatement.executeUpdate();
    }

    @Override
    public void deleteItem(int itemId) throws SQLException {
        String query = QueriesProperties.getProperty("DeleteItem.request");
        PreparedStatement preparedStatement = this.getPreparedStatement(query);
        preparedStatement.setInt(1, itemId);
        preparedStatement.executeUpdate();
    }

    @Override
    public void updateItemUserOwner(int itemId, int userId) throws SQLException {
        String query = QueriesProperties.getProperty("UpdateItemOwner");
        PreparedStatement preparedStatement = this.getPreparedStatement(query);
        preparedStatement.setInt(2, itemId);
        preparedStatement.setInt(1, userId);
        preparedStatement.executeUpdate();
    }

    private List<ItemEntity> getItemsFromQuery(ResultSet resultSet) throws SQLException {
        List<ItemEntity> items = new ArrayList<>();
        while (resultSet.next()) {
            ItemEntity item = new ItemEntity(resultSet.getInt(EntitiesResource.getProperty("id_items")),
                    resultSet.getString(EntitiesResource.getProperty("title")),
                    resultSet.getString(EntitiesResource.getProperty("image")),
                    resultSet.getString(EntitiesResource.getProperty("description")),
                    resultSet.getDate(EntitiesResource.getProperty("publication_time_items")),
                    resultSet.getInt(EntitiesResource.getProperty("user_id")),
                    resultSet.getInt(EntitiesResource.getProperty("item_status")),
                    resultSet.getInt(EntitiesResource.getProperty("count_view")));
            items.add(item);
        }
        return items;
    }
    


    private PreparedStatement getPreparedStatement(String sqlQuery) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }
}
