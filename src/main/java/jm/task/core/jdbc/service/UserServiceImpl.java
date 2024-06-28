package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import java.util.List;

public class UserServiceImpl  implements UserService {
    private final UserDao userDao;

    public UserServiceImpl() {
        userDao = new UserDaoHibernateImpl();
    }

    public void createUsersTable() {
        userDao.createUsersTable();
    }

    public void dropUsersTable() {
        userDao.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        userDao.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        userDao.removeUserById(id);
    }

    public List<User> getAllUsers() {

        return  userDao.getAllUsers();
    }

    public void cleanUsersTable() {
        try {
            userDao.cleanUsersTable();
        } catch (HeuristicRollbackException e) {
            throw new RuntimeException(e);
        } catch (SystemException e) {
            throw new RuntimeException(e);
        } catch (HeuristicMixedException e) {
            throw new RuntimeException(e);
        } catch (RollbackException e) {
            throw new RuntimeException(e);
        }

    }
}