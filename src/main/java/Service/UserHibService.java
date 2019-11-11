package Service;

import DAO.UserHibernateDAO;
import Model.User;

import java.util.List;

public class UserHibService {
    private static UserHibService userHibService;

    private static UserHibernateDAO userHibernateDAO;

    private UserHibService() {
        userHibernateDAO = new UserHibernateDAO();
    }

    public static UserHibService getInstance() {
        if (userHibService == null) {
            userHibService = new UserHibService();
        }
        return userHibService;
    }

    public List<User> getAllUserHib() {
        return userHibernateDAO.getAllUser();
    }

    public void addUserHib(User user) {
        userHibernateDAO.addUser(user);
    }

    public boolean deleteUserHib(Long id) {
        userHibernateDAO.deleteUser(id);
        return true;
    }

    public void updateUserHib(User user) {
        userHibernateDAO.updateUser(user);
    }

    public User getUserByNameHib(String name) {
        return userHibernateDAO.getUserByName(name);
    }

    public User getUserByIdHib(Long id) {
        return userHibernateDAO.getUserById(id);
    }
}

