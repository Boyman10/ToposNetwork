package org.climb.business.manager.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.climb.business.manager.interfaces.UserManager;
import org.climb.model.bean.user.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

@Component("userManager")
public class UserManagerImpl extends AbstractManager implements UserManager {

	// private static final Log LOGGER = LogFactory.getLog("climb");
	static final Logger LOGGER = LogManager.getLogger(UserManagerImpl.class);

	@Inject
	@Named("txUserManager")
	private PlatformTransactionManager platformTransactionManager;

	@Override
	public List<User> getUsersList() {

		LOGGER.debug("REtrieving user lising - User manager");
		return getDaoFactory().getUserDao().getListUsers();
	}

	@Override
	public Boolean addUser(User user) {

        TransactionTemplate vTransactionTemplate = new TransactionTemplate(platformTransactionManager);
        
        Boolean result = vTransactionTemplate.execute(new TransactionCallback<Boolean>() {

			@Override
			public Boolean doInTransaction(TransactionStatus status) {
				
				LOGGER.debug("Adding new user - User manager " + user.getUsername());

				return getDaoFactory().getUserDao().addUser(user);					
			}
        	
        	
        });

        return result;
	}

	@Override
	public User findUserByBean(User user) {
		LOGGER.debug("Matching submitted user - User manager " + user.getUsername());
		return getDaoFactory().getUserDao().findUserByBean(user);
	}

}
