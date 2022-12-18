package ru.rsreu.exchangethings.model.datalayer;

import ru.rsreu.exchangethings.model.datalayer.entity.RequestEntity;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface RequestDAO {
    //Просмотр всех отмененных заявок
    List<RequestEntity> getRequestsByStatus(int requestStatus) throws SQLException;

    //Просмотр заявок на обмен, произведенных за определенный период
    List<RequestEntity> getRequestsFromPeriod(String firstPublicationTime, String secondPublicationTime) throws SQLException, ParseException;

    void insertRequest(String publicationTime, int requestStatus, String commentReceiver,
                       int itemSender, int itemReceiver) throws SQLException, ParseException;

    void updateRequestStatus(int requestStatus, int requestId) throws SQLException;

    void deleteRequest(int requestId) throws SQLException;

    public List<RequestEntity> getRequestsByUserIdAndStatus(int userId, int requestStatus) throws SQLException;
    public RequestEntity getRequestById(int requestStatus) throws SQLException;

}
