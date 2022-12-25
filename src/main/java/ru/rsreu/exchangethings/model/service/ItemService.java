package ru.rsreu.exchangethings.model.service;

import ru.rsreu.exchangethings.exceptions.IncludeParameterException;
import ru.rsreu.exchangethings.model.ItemStatusEnum;
import ru.rsreu.exchangethings.model.datalayer.DBType;
import ru.rsreu.exchangethings.model.datalayer.ItemDAO;
import ru.rsreu.exchangethings.model.datalayer.UserDAO;
import ru.rsreu.exchangethings.model.datalayer.entity.ItemEntity;
import ru.rsreu.exchangethings.view.beans.ItemBean;
import ru.rsreu.exchangethings.view.beans.UserBean;

import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ItemService {

    private ItemDAO itemDAO = DBType.ORACLE.getDAOFactory().getItemDAOImpl();

    private UserDAO userDAO = DBType.ORACLE.getDAOFactory().getUserDAOImpl();

    private static Logger logger = Logger.getLogger("Items  Service");

    public static ItemService instance = new ItemService();

    public List<ItemBean> getUserItems(int userId,int itemStatus) {
        List<ItemBean> items = new LinkedList<>();
        UserBean owner;
        try {
            owner = new UserBean(userDAO.getUserById(userId));
            itemDAO.getItemsByUser(userId, itemStatus)
                    .stream()
                    .filter(Objects::nonNull)
                    .forEach(itemEntity -> items.add(new ItemBean(itemEntity, owner)));
        } catch (SQLException e) {
            logger.log(Level.WARNING, "SQL EXCEPTION :" + e.getMessage());
            throw new IncludeParameterException();
        }
        return items;
    }

    public List<ItemBean> getItemForUser(int userId, ItemStatusEnum status) {
        List<ItemBean> items = new LinkedList<>();
        try {
            itemDAO.getItemsForExchange(userId, status.order)
                    .stream()
                    .filter(Objects::nonNull)
                    .forEach(itemEntity -> items.add(new ItemBean(itemEntity)));
        } catch (SQLException e) {
            logger.log(Level.WARNING, "SQL EXCEPTION :" + e.getMessage());
            throw new IncludeParameterException();
        }
        return items;
    }

    public void saveItem(String title, String imagePath, String description, int userId) {
        try {
            itemDAO.insertItem(title, imagePath, description, LocalDate.now().toString(), userId, ItemStatusEnum.OPEN.order);
        } catch (SQLException e) {
            logger.log(Level.WARNING, "SQL EXCEPTION :" + e.getMessage());
            throw new IncludeParameterException();
        } catch (ParseException e) {
            logger.log(Level.WARNING, "PARSE EXCEPTION :" + e.getMessage());
            throw new RuntimeException(e);
        }
    }


    public void updateStatus(int idItem, ItemStatusEnum statusEnum) {
        try {
            itemDAO.updateItemStatus(statusEnum.order, idItem);
        } catch (SQLException e) {
            logger.log(Level.WARNING, "SQL EXCEPTION :" + e.getMessage());
            throw new IncludeParameterException();
        }
    }

    public void incrementCountView(int idItem) {
        try {
            itemDAO.incrementCountView(idItem);
        } catch (SQLException e) {
            logger.log(Level.WARNING, "SQL EXCEPTION :" + e.getMessage());
            throw new IncludeParameterException();
        }
    }

    public ItemBean getItemByIdWithOwner(int idItem) {
        ItemBean itemBean = null;
        try {
            ItemEntity itemEntity = itemDAO.getItemById(idItem);
            UserBean owner = new UserBean(userDAO.getUserById(itemEntity.getUserID()));
            itemBean = new ItemBean(itemEntity, owner);
        } catch (SQLException e) {
            logger.log(Level.WARNING, "SQL EXCEPTION :" + e.getMessage());
            throw new IncludeParameterException();
        }
        return itemBean;
    }

    public void updateItemUserOwner(int itemId, int userId) {
        try {
            itemDAO.updateItemUserOwner(itemId, userId);
        } catch (SQLException e) {
            logger.log(Level.WARNING, "SQL EXCEPTION :" + e.getMessage());
            throw new IncludeParameterException();
        }
    }

    public void deleteItem(int id) {
        try {
            itemDAO.deleteItem(id);
        } catch (SQLException e) {
            logger.log(Level.WARNING, "SQL EXCEPTION :" + e.getMessage());
            throw new IncludeParameterException();
        }
    }

    public List<ItemBean> getAllItems() {
        List<ItemBean> itemBeans = new LinkedList<>();
        try {
            itemDAO.getAll().forEach(itemEntity -> itemBeans.add(new ItemBean(itemEntity)));
        } catch (SQLException e) {
            logger.log(Level.WARNING, "SQL EXCEPTION :" + e.getMessage());
            throw new IncludeParameterException();
        }
        return itemBeans;
    }
}
