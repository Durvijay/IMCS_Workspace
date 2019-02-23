package trng.imcs.dao;
import java.util.List;

import trng.imcs.entity.User;

/**
 * Interface for repository functionality that ought to be implemented manually.
 * 
 * @author Oliver Gierke
 * @author Thomas Darimont
 */
interface UserRepositoryCustom {

	/**
	 * Custom repository operation.
	 * 
	 * @return
	 */
	List<User> myCustomBatchOperation();
}