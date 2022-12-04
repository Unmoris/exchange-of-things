package ru.rsreu.exchangethings.model.datalayer;

import ru.rsreu.exchangethings.model.datalayer.entity.ItemEntity;
import ru.rsreu.exchangethings.model.datalayer.entity.RequestEntity;
import ru.rsreu.exchangethings.model.datalayer.entity.UserEntity;

import java.sql.SQLException;
        import java.text.ParseException;
        import java.util.List;

public interface ExchangeOfThingsDAO {
    //Просмотр авторизованных/неавторизованных пользователей в данный момент:
    List<UserEntity> getUsersByAuthorizationStatus(String authorizationStatus) throws SQLException;
    //Просмотр пользователей за определенный период
    List<UserEntity> getUsersByLastLoginTime(String lastLoginTime) throws SQLException, ParseException;
    //Просмотр заблокированных пользователей
    List<UserEntity> getBlockedUsers(String blockedStatus) throws SQLException;
    //Просмотр всех отмененных заявок
    List<RequestEntity> getCanceledRequests(String requestStatus) throws SQLException;
    //Просмотр заявок на обмен, произведенных за определенный период
    List<RequestEntity> getRequestsFromPeriod(String firstPublicationTime, String secondPublicationTime) throws SQLException, ParseException;
    //Просмотр вещей, выставленных на обмен
    List<ItemEntity> getItemsForExchange(String exchangeStatus) throws SQLException;
    //Просмотр своих скрытых вещей
    List<ItemEntity> getHiddenItems(String itemStatus, int userId) throws SQLException;
    //Просмотр заявок на его вещи
    List<ItemEntity> getItemsForRequestsToUser(int userId, String requestStatus) throws SQLException;
    void insertUser(int id, String surname, String name, String patronymic,
                           String login, String password, String isAuthorized,
                           String lastLoginTime, String userRole, String userStatus)  throws SQLException, ParseException;

    void insertItem(int id, String title, String image, String description, String publicationTime, int userId,
                           String itemStatus, int countView) throws SQLException, ParseException;

    void insertRequest(int id, String publicationTime, int requestStatus, String commentReceiver,
                       int itemSender, int itemReceiver) throws SQLException, ParseException;


}

