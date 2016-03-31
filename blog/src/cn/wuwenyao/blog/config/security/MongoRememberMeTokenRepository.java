package cn.wuwenyao.blog.config.security;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import cn.wuwenyao.blog.site.dao.mongo.RememberMeTokenDao;
import cn.wuwenyao.blog.site.entity.mongo.RememberMeToken;

public class MongoRememberMeTokenRepository implements PersistentTokenRepository {

	@Autowired
	private RememberMeTokenDao tokenDao;

	@Override
	public void createNewToken(PersistentRememberMeToken token) {
		tokenDao.save(
				new RememberMeToken(token.getUsername(), token.getSeries(), token.getTokenValue(), token.getDate()));

	}

	@Override
	public void updateToken(String series, String tokenValue, Date lastUsed) {
		RememberMeToken token = tokenDao.findUniqueAttribute("series", series);
		if (token != null) {
			token.setTokenValue(tokenValue);
			token.setDate(lastUsed);
		}
		tokenDao.save(token);
	}

	@Override
	public PersistentRememberMeToken getTokenForSeries(String seriesId) {
		RememberMeToken token = tokenDao.findUniqueAttribute("series", seriesId);
		if (token == null) {
			return null;
		}
		return new PersistentRememberMeToken(token.getUsername(), seriesId, token.getTokenValue(), token.getDate());
	}

	@Override
	public void removeUserTokens(String username) {
		List<RememberMeToken> tokens = tokenDao.findByAttribute("username", username);
		tokenDao.delete(tokens);
	}

}
