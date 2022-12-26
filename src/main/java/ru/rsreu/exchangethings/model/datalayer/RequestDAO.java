package ru.rsreu.exchangethings.model.datalayer;

import ru.rsreu.exchangethings.model.datalayer.entity.RequestEntity;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
/**
 * DAO Request interface
 */
public interface RequestDAO {
    /**
     * View all canceled tickets
     * @param requestStatus
     * @return
     * @throws SQLException
     */
    List<RequestEntity> getRequestsByStatus(int requestStatus) throws SQLException;

    //Просмотр заявок на обмен, произведенных за определенный период
    List<RequestEntity> getRequestsFromPeriod(String firstPublicationTime, String secondPublicationTime) throws SQLException, ParseException;

    /**
     * Insert Request
     * @throws SQLException
     * @throws ParseException
     */
    void insertRequest(String publicationTime, int requestStatus, String commentReceiver,
                       int itemSender, int itemReceiver) throws SQLException, ParseException;

    /**
     * Update Request Status
     * @param requestStatus
     * @param requestId
     * @throws SQLException
     */
    void updateRequestStatus(int requestStatus, int requestId) throws SQLException;

    /**
     * delete Request
     * @param requestId
     * @throws SQLException
     */
    void deleteRequest(int requestId) throws SQLException;

    /**
     * get Requests By User Id And Status
     * @param userId
     * @param requestStatus
     * @return
     * @throws SQLException
     */
    public List<RequestEntity> getRequestsByUserIdAndStatus(int userId, int requestStatus) throws SQLException;

    /**
     * get Request By Id
     * @param requestStatus
     * @return
     * @throws SQLException
     */
    public RequestEntity getRequestById(int requestStatus) throws SQLException;

    /**
     * delete Request By Item Id
     * @param itemId
     * @throws SQLException
     */
    void deleteRequestByItemId(int itemId) throws  SQLException;

    /**
     * Update Status By Item
     * @param itemId
     * @param status
     * @throws SQLException
     */
    void updateStatusByItem(int itemId, int status) throws  SQLException;

    List<RequestEntity> getRequestEntitiesByItem(int itemSenderId, int itemReciverId) throws  SQLException;
}
