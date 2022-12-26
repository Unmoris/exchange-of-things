package ru.rsreu.exchangethings.model.datalayer;

import ru.rsreu.exchangethings.model.datalayer.entity.ItemEntity;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
/**
 * DAO Item interface
 */
public interface ItemDAO {
    /**
     * View items for exchange
     * @param userId
     * @param itemStatus
     * @return
     * @throws SQLException
     */
    List<ItemEntity> getItemsForExchange(int userId, int itemStatus) throws SQLException;

    //Просмотр своих скрытых вещей
    List<ItemEntity> getHiddenItems(int itemStatus, int userId) throws SQLException;

    /**
     * View user items
     * @param userId
     * @return
     * @throws SQLException
     */
    List<ItemEntity> getItemsByUser(int userId, int itemStatus) throws SQLException;

    /**
     * Get All
     * @return
     * @throws SQLException
     */
    List<ItemEntity> getAll() throws SQLException;

    /**
     * Get Item By Id
     * @param id
     * @return
     * @throws SQLException
     */
    ItemEntity getItemById(int id) throws SQLException;

    /**
     * Increment Count View
     * @param id
     * @throws SQLException
     */
    void incrementCountView(int id) throws SQLException;

    //Просмотр заявок на его вещи
    List<ItemEntity> getItemsForRequestsToUser(int userId, int requestStatus) throws SQLException;

    /**
     * InsertItem
     * @throws SQLException
     * @throws ParseException
     */
    void insertItem(String title, String image, String description, String publicationTime, int userId,
                    int itemStatus) throws SQLException, ParseException;

    /**
     * Update Item Status
     * @param itemStatus
     * @param itemId
     * @throws SQLException
     */
    void updateItemStatus(int itemStatus, int itemId) throws SQLException;

    /**
     * Delete Item
     * @param userId
     * @throws SQLException
     */
    void deleteItem(int userId) throws SQLException;

    /**
     * Update Item User Owner
     * @param itemId
     * @param userId
     * @throws SQLException
     */
    void updateItemUserOwner(int itemId, int userId) throws SQLException;
}
