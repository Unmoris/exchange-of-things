package ru.rsreu.exchangethings.model.datalayer.oracledb;

import ru.rsreu.exchangethings.configuration.EntitiesResource;
import ru.rsreu.exchangethings.configuration.QueriesProperties;
import ru.rsreu.exchangethings.model.datalayer.DateFormatter;
import ru.rsreu.exchangethings.model.datalayer.RequestDAO;
import ru.rsreu.exchangethings.model.datalayer.entity.RequestEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class RequestDAOImpl implements RequestDAO {
    private Connection connection;
    public RequestDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<RequestEntity> getCanceledRequests(int requestStatus) throws SQLException {
        String query = QueriesProperties.getProperty("CanceledRequests.request");
        PreparedStatement preparedStatement = this.getPreparedStatement(query);
        preparedStatement.setInt(1, requestStatus);
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
    public void updateRequestStatus(int requestStatus, int requestId) throws SQLException {
        String query = QueriesProperties.getProperty("UpdateRequestStatus.request");
        PreparedStatement preparedStatement = this.getPreparedStatement(query);
        preparedStatement.setInt(1, requestStatus);
        preparedStatement.setInt(2, requestId);
        preparedStatement.executeUpdate();
    }

    @Override
    public void deleteRequest(int requestId) throws SQLException {
        String query = QueriesProperties.getProperty("DeleteRequest.request");
        PreparedStatement preparedStatement = this.getPreparedStatement(query);
        preparedStatement.setInt(1, requestId);
        preparedStatement.executeUpdate();
    }

    private List<RequestEntity> getRequestsFromQuery(ResultSet resultSet) throws SQLException {
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
