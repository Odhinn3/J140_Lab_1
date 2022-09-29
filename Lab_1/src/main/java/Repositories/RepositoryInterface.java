
package Repositories;

import Data.User;

/**
 *
 * @author A.Konnov <github.com/Odhinn3>
 */
public interface RepositoryInterface {
    public User checkUsers(String name, String password);
}