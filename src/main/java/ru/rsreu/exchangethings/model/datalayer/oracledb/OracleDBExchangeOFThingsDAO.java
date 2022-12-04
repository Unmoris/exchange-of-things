package ru.rsreu.exchangethings.model.datalayer.oracledb;

import ru.rsreu.exchangethings.configuration.EntitiesResource;
import ru.rsreu.exchangethings.configuration.QueriesProperties;
import ru.rsreu.exchangethings.model.datalayer.DateFormatter;
import ru.rsreu.exchangethings.model.datalayer.ExchangeOfThingsDAO;
import ru.rsreu.exchangethings.model.datalayer.entity.ItemEntity;
import ru.rsreu.exchangethings.model.datalayer.entity.RequestEntity;
import ru.rsreu.exchangethings.model.datalayer.entity.UserEntity;

import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class OracleDBExchangeOFThingsDAO implements ExchangeOfThingsDAO {

    private Connection connection;
    public OracleDBExchangeOFThingsDAO(Connection connection) {
        this.connection = connection;
    }


    @Override
    public List<UserEntity> getUsersByAuthorizationStatus(String authorizationStatus) throws SQLException {
        String query = QueriesProperties.getProperty("UsersByAuthorizationStatus.request");
        PreparedStatement preparedStatementUsers = this.getPreparedStatement(query);
        preparedStatementUsers.setString(1, authorizationStatus);
        ResultSet resultSet = preparedStatementUsers.executeQuery();
        return this.getUsersFromQuery(resultSet);
    }

    @Override
    public List<UserEntity> getUsersByLastLoginTime(String lastLoginTime) throws SQLException, ParseException {
        String query = QueriesProperties.getProperty("UsersByLastLoginTime.request");
        PreparedStatement preparedStatementUsers = this.getPreparedStatement(query);
        preparedStatementUsers.setDate(1, DateFormatter.getSimpleDateFormatTime(lastLoginTime));
        ResultSet resultSet = preparedStatementUsers.executeQuery();
        return this.getUsersFromQuery(resultSet);
    }

    @Override
    public List<UserEntity> getBlockedUsers(String blockedStatus) throws SQLException {
        String query = QueriesProperties.getProperty("BlockedUsers.request");
        PreparedStatement preparedStatementUsers = this.getPreparedStatement(query);
        preparedStatementUsers.setString(1, blockedStatus);
        ResultSet resultSet = preparedStatementUsers.executeQuery();
        return this.getUsersFromQuery(resultSet);
    }

    @Override
    public List<RequestEntity> getCanceledRequests(String requestStatus) throws SQLException {
        String query = QueriesProperties.getProperty("CanceledRequests.request");
        PreparedStatement preparedStatement = this.getPreparedStatement(query);
        preparedStatement.setString(1, requestStatus);
        ResultSet resultSet = preparedStatement.executeQuery();
        return this.getRequestsFromQuery(resultSet);
    }

    @Override
    public List<RequestEntity> getRequestsFromPeriod(String firstPublicationTime, String secondPublicationTime) throws SQLException, ParseException {
        String query = QueriesProperties.getProperty("RequestsFromPeriod.request");
        PreparedStatement preparedStatement = this.getPreparedStatement(query);
        preparedStatement.setDate(1, DateFormatter.getSimpleDateFormatTime(firstPublicationTime));
        preparedStatement.setDate(2, DateFormatter.getSimpleDateFormatTime(secondPublicationTime));
        ResultSet resultSet = preparedStatement.executeQuery();
        return this.getRequestsFromQuery(resultSet);
    }

    @Override
    public List<ItemEntity> getItemsForExchange(String exchangeStatus) throws SQLException {
        String query = QueriesProperties.getProperty("ItemsForExchange.request");
        PreparedStatement preparedStatement = this.getPreparedStatement(query);
        preparedStatement.setString(1, exchangeStatus);
        ResultSet resultSet = preparedStatement.executeQuery();
        return this.getItemsFromQuery(resultSet);
    }

    public List<ItemEntity> getHiddenItems(String itemStatus, int userId) throws SQLException {
        String query = QueriesProperties.getProperty("HiddenItems.request");
        PreparedStatement preparedStatement = this.getPreparedStatement(query);
        preparedStatement.setString(1, itemStatus);
        preparedStatement.setInt(2, userId);
        ResultSet resultSet = preparedStatement.executeQuery();
        return this.getItemsFromQuery(resultSet);
    }

    @Override
    public List<ItemEntity> getItemsForRequestsToUser(int userId, String requestStatus) throws SQLException {
        String query = QueriesProperties.getProperty("ItemsForRequestsToUser.request");
        PreparedStatement preparedStatement = this.getPreparedStatement(query);
        preparedStatement.setInt(1, userId);
        preparedStatement.setString(2, requestStatus);
        ResultSet resultSet = preparedStatement.executeQuery();
        return this.getItemsFromQuery(resultSet);
    }

    @Override
    public void insertUser(String surname, String name, String patronymic,
                           String login, String password, String isAuthorized,
                           String lastLoginTime, String userRole, String userStatus)  throws SQLException, ParseException  {
        String query = QueriesProperties.getProperty("InsertUser.request");
        PreparedStatement preparedStatement = this.getPreparedStatement(query);
        preparedStatement.setString(1, surname);
        preparedStatement.setString(2, name);
        preparedStatement.setString(3, patronymic);
        preparedStatement.setString(4, login);
        preparedStatement.setString(5, password);
        preparedStatement.setString(6, isAuthorized);
        preparedStatement.setDate(7, DateFormatter.getSimpleDateFormatTime(lastLoginTime));
        preparedStatement.setString(8, userRole);
        preparedStatement.setString(9, userStatus);
        preparedStatement.executeUpdate();
    }

    @Override
    public void insertItem(String title, String image, String description, String publicationTime, int userId,
                           String itemStatus) throws SQLException, ParseException {
        String query = QueriesProperties.getProperty("InsertItem.request");
        PreparedStatement preparedStatement = this.getPreparedStatement(query);
        preparedStatement.setString(1, title);
        preparedStatement.setString(2, image);
        preparedStatement.setString(3, description);
        preparedStatement.setDate(4, DateFormatter.getSimpleDateFormatTime(publicationTime));
        preparedStatement.setInt(5, userId);
        preparedStatement.setString(6, itemStatus);
        preparedStatement.executeUpdate();

    }

    @Override
    public void insertRequest(String publicationTime, int requestStatus, String commentReceiver,
                              int itemSender, int itemReceiver) throws SQLException, ParseException {
        String query = QueriesProperties.getProperty("InsertRequest.request");
        PreparedStatement preparedStatement = this.getPreparedStatement(query);
        preparedStatement.setDate(1, DateFormatter.getSimpleDateFormatTime(publicationTime));
        preparedStatement.setInt(2, requestStatus);
        preparedStatement.setString(3, commentReceiver);
        preparedStatement.setInt(4, itemSender);
        preparedStatement.setInt(5, itemReceiver);
        preparedStatement.executeUpdate();
    }

    @Override
    public void updateUserStatus(String userStatus, int userId) throws SQLException {
        String query = QueriesProperties.getProperty("UpdateUserStatus.request");
        PreparedStatement preparedStatement = this.getPreparedStatement(query);
        preparedStatement.setString(1, userStatus);
        preparedStatement.setInt(2, userId);
        preparedStatement.executeUpdate();
    }

    @Override
    public void updateItemStatus(String itemStatus, int itemId) throws SQLException {
        String query = QueriesProperties.getProperty("UpdateItemStatus.request");
        PreparedStatement preparedStatement = this.getPreparedStatement(query);
        preparedStatement.setString(1, itemStatus);
        preparedStatement.setInt(2, itemId);
        preparedStatement.executeUpdate();
    }

    @Override
    public void updateRequestStatus(String requestStatus, int requestId) throws SQLException {
        String query = QueriesProperties.getProperty("UpdateRequestStatus.request");
        PreparedStatement preparedStatement = this.getPreparedStatement(query);
        preparedStatement.setString(1, requestStatus);
        preparedStatement.setInt(2, requestId);
        preparedStatement.executeUpdate();
    }

    @Override
    public void deleteUser(int userId) throws SQLException {
        String query = QueriesProperties.getProperty("DeleteUser.request");
        PreparedStatement preparedStatement = this.getPreparedStatement(query);
        preparedStatement.setInt(1, userId);
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
    public void deleteRequest(int requestId) throws SQLException {
        String query = QueriesProperties.getProperty("DeleteRequest.request");
        PreparedStatement preparedStatement = this.getPreparedStatement(query);
        preparedStatement.setInt(1, requestId);
        preparedStatement.executeUpdate();
    }

    private  List<UserEntity> getUsersFromQuery(ResultSet resultSet) throws SQLException {
        List<UserEntity> users = new ArrayList<>();
        while (resultSet.next()) {
            UserEntity user =
                    new UserEntity(resultSet.getInt(EntitiesResource.getProperty("id")),
                            resultSet.getString(EntitiesResource.getProperty("surname")),
                            resultSet.getString(EntitiesResource.getProperty("name")),
                            resultSet.getString(EntitiesResource.getProperty("patronymic")),
                            resultSet.getString(EntitiesResource.getProperty("login")),
                            resultSet.getString(EntitiesResource.getProperty("password")),
                            resultSet.getString(EntitiesResource.getProperty("is_authorized")),
                            resultSet.getDate(EntitiesResource.getProperty("last_login_time")),
                            resultSet.getString(EntitiesResource.getProperty("user_role")),
                            resultSet.getString(EntitiesResource.getProperty("user_status")));
            users.add(user);
        }
        return users;
    }

    private  List<RequestEntity> getRequestsFromQuery(ResultSet resultSet) throws SQLException {
        List<RequestEntity> requests = new ArrayList<>();
        while (resultSet.next()) {
            RequestEntity request =
                    new RequestEntity(resultSet.getInt(EntitiesResource.getProperty("id_request")),
                            resultSet.getDate(EntitiesResource.getProperty("publication_time_request")),
                            resultSet.getInt(EntitiesResource.getProperty("request_status")),
                            resultSet.getString(EntitiesResource.getProperty("comment_receiver")),
                            resultSet.getInt(EntitiesResource.getProperty("item_sender")),
                            resultSet.getInt(EntitiesResource.getProperty("item_receiver")));
            requests.add(request);
        }
        return requests;
    }
    private  List<ItemEntity> getItemsFromQuery(ResultSet resultSet) throws SQLException {
        List<ItemEntity> items = new ArrayList<>();
        while (resultSet.next()) {
            ItemEntity item =
                    new ItemEntity(resultSet.getInt(EntitiesResource.getProperty("id_items")),
                            resultSet.getString(EntitiesResource.getProperty("title")),
                            resultSet.getString(EntitiesResource.getProperty("image")),
                            resultSet.getString(EntitiesResource.getProperty("description")),
                            resultSet.getDate(EntitiesResource.getProperty("publication_time_items")),
                            resultSet.getInt(EntitiesResource.getProperty("user_id")),
                            resultSet.getString(EntitiesResource.getProperty("item_status")),
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
