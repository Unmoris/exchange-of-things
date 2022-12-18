package ru.rsreu.exchangethings.model.service;

import ru.rsreu.exchangethings.exceptions.IncludeParameterException;
import ru.rsreu.exchangethings.model.ExchangeStatusEnum;
import ru.rsreu.exchangethings.model.datalayer.DBType;
import ru.rsreu.exchangethings.model.datalayer.RequestDAO;
import ru.rsreu.exchangethings.model.datalayer.entity.ItemEntity;
import ru.rsreu.exchangethings.model.datalayer.entity.RequestEntity;
import ru.rsreu.exchangethings.model.datalayer.entity.RequestStatusEntity;
import ru.rsreu.exchangethings.model.datalayer.oracledb.OracleDBDAOFactory;
import ru.rsreu.exchangethings.view.beans.ItemBean;
import ru.rsreu.exchangethings.view.beans.RequestBean;
import ru.rsreu.exchangethings.view.beans.UserBean;

import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RequestService {
    public static RequestService instance = new RequestService();
    private static Logger logger = Logger.getLogger("Request Service ");
    private RequestDAO requestDAO = DBType.ORACLE.getDAOFactory().getRequestDAOImpl();

    public List<RequestBean> getRequestByStatus(ExchangeStatusEnum exchangeStatusEnum) {
        List<RequestBean> exchanges = new LinkedList<>();
        try {
            requestDAO.getRequestsByStatus(exchangeStatusEnum.order).forEach(exchange -> exchanges.add(new RequestBean(exchange)));
        } catch (SQLException e) {
            logger.log(Level.WARNING, "SQL EXCEPTION :" + e.getMessage());
            throw new IncludeParameterException();
        }
        return exchanges;
    }

    public List<RequestBean> getRequestByUserIdAndStatus(int userId, ExchangeStatusEnum exchangeStatusEnum) {
        List<RequestBean> exchanges = new LinkedList<>();
        try {
            requestDAO.getRequestsByUserIdAndStatus(userId, exchangeStatusEnum.order).forEach(exchange -> exchanges.add(new RequestBean(exchange)));
        } catch (SQLException e) {
            logger.log(Level.WARNING, "SQL EXCEPTION :" + e.getMessage());
            throw new IncludeParameterException();
        }
        return exchanges;
    }

    public void createRequest(int requestStatus, String commentReceiver, int itemSender, int itemReceiver) {
        try {
            requestDAO.insertRequest(LocalDate.now().toString(), requestStatus, commentReceiver, itemSender, itemReceiver);
        } catch (SQLException e) {
            logger.log(Level.WARNING, "SQL EXCEPTION :" + e.getMessage());
            throw new IncludeParameterException();
        } catch (ParseException e) {
            logger.log(Level.WARNING, "PARSE EXCEPTION :" + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void updateRequestStatus(int requestStatus, int requestId) {
        try {
            requestDAO.updateRequestStatus(requestStatus, requestId);
        } catch (SQLException e) {
            logger.log(Level.WARNING, "SQL EXCEPTION :" + e.getMessage());
            throw new IncludeParameterException();
        }
    }

    public RequestEntity getById(int id) {
        RequestEntity exchange = null;
        try {
            exchange = requestDAO.getRequestById(id);
        } catch (SQLException e) {
            logger.log(Level.WARNING, "SQL EXCEPTION :" + e.getMessage());
            throw new IncludeParameterException();
        }
        return exchange;
    }

    List<RequestBean> getRequestsByStatus(int requestStatus) {
        List<RequestBean> exchanges = new LinkedList<>();
        try {
            requestDAO.getRequestsByStatus(requestStatus)
                    .stream()
                    .forEach(request -> exchanges.add(new RequestBean(request)));
        } catch (SQLException e) {
            logger.log(Level.WARNING, "SQL EXCEPTION :" + e.getMessage());
            throw new IncludeParameterException();
        }
        return exchanges;
    }

    public void deleteRequest(int requestId) {
        try {
            requestDAO.deleteRequest(requestId);
        } catch (SQLException e) {
            logger.log(Level.WARNING, "SQL EXCEPTION :" + e.getMessage());
            throw new IncludeParameterException();
        }
    }

    public void deleteRequestsByItem(int itemId) {
        try {
            requestDAO.deleteRequestByItemId(itemId);
        } catch (SQLException e) {
            logger.log(Level.WARNING, "SQL EXCEPTION :" + e.getMessage());
            throw new IncludeParameterException();
        }
    }

    public void updateStatusByItem(int itemId, ExchangeStatusEnum exchangeStatus) {
        try {
            requestDAO.updateStatusByItem(itemId, exchangeStatus.order);
        } catch (SQLException e) {
            logger.log(Level.WARNING, "SQL EXCEPTION :" + e.getMessage());
            throw new IncludeParameterException();
        }
    }
}