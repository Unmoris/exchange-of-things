package ru.rsreu.exchangethings.model.datalayer;

import ru.rsreu.exchangethings.model.datalayer.entity.ItemEntity;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface ItemDAO {
    //Просмотр вещей, выставленных на обмен
    List<ItemEntity> getItemsForExchange(int itemStatus) throws SQLException;
    //Просмотр своих скрытых вещей
    List<ItemEntity> getHiddenItems(int itemStatus, int userId) throws SQLException;
    //Просмотр заявок на его вещи
    List<ItemEntity> getItemsForRequestsToUser(int userId, int requestStatus) throws SQLException;


    void insertItem(String title, String image, String description, String publicationTime, int userId,
                    int itemStatus) throws SQLException, ParseException;
    void updateItemStatus(int itemStatus, int itemId) throws SQLException;
    void deleteItem(int userId) throws SQLException;
}
