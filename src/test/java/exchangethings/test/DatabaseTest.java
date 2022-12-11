package exchangethings.test;

import org.junit.jupiter.api.Test;
import ru.rsreu.exchangethings.model.datalayer.*;
import ru.rsreu.exchangethings.model.datalayer.entity.ItemEntity;
import ru.rsreu.exchangethings.model.datalayer.entity.RequestEntity;
import ru.rsreu.exchangethings.model.datalayer.entity.UserEntity;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class DatabaseTest {
    @Test
    public void Test() throws SQLException, ParseException {
        try {

            DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);

            UserDAO userDAO = factory.getUserDAOImpl();
            //List<UserEntity> usersByAuthorizationStatus = userDAO.getUsersByAuthorizationStatus("1");
            //System.out.println(usersByAuthorizationStatus);
            //List<UserEntity> usersByLastLoginTime = userDAO.getUsersByLastLoginTime("1997-05-25");
            //System.out.println(usersByLastLoginTime);
            //List<UserEntity> usersBlockedUsers= userDAO.getBlockedUsers(2);
            //System.out.println(usersBlockedUsers);
            //userDAO.insertUser("aaa", "bbb", "ccc", "abc", "1", "1", "2022-12-11", 2, 2);
            //userDAO.updateUserStatus(1, 21);
            //userDAO.deleteUser(21);

            ItemDAO itemDAO = factory.getItemDAOImpl();
            //List<ItemEntity> itemsForExchange = itemDAO.getItemsForExchange(1);
            //System.out.println(itemsForExchange);
            //List<ItemEntity> hiddenItems = itemDAO.getHiddenItems(2, 6);
            //System.out.println(hiddenItems);
            //List<ItemEntity> itemsForRequestsToUser = itemDAO.getItemsForRequestsToUser(2, 1);
            //System.out.println(itemsForRequestsToUser);
            //itemDAO.insertItem("myItem","pppgg", "aaaa", "2022-12-11", 6, 2);
            //itemDAO.updateItemStatus(3, 21);
            //itemDAO.deleteItem(21);

            RequestDAO requestDAO = factory.getRequestDAOImpl();
            //List<RequestEntity> сanceledRequests = requestDAO.getCanceledRequests(3);
            //System.out.println(сanceledRequests);
            //List<RequestEntity> RequestsFromPeriod = requestDAO.getRequestsFromPeriod("2022-11-07", "2022-12-11");
            //System.out.println(RequestsFromPeriod);
            //requestDAO.updateRequestStatus(3, 2);
            //requestDAO.insertRequest("2022-12-11", 3, "aaaa", 5,  6);
            //requestDAO.deleteRequest(21);

        } catch (DBTypeException e) {
            e.printStackTrace();
        }
    }
}
