package cn.wuwenyao.blog.log.mongodb;

import java.net.UnknownHostException;

import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.MongoURI;

/***
 * 
 * @author 文尧
 *
 */
public class MongoDBConnectionSource {

	private volatile DBCollection dbCollection = null;

	
	private String host = "localhost";
	
	private int port = 27017;

	private String db = null;

	private String collection = null;

	protected DBCollection getDBCollection() {
		DBCollection dbCollectionHelper = dbCollection;
		if (dbCollectionHelper == null) {
			synchronized (this) {
				dbCollectionHelper = dbCollection;
				if (dbCollectionHelper == null) {
					try {
						MongoClient mongo = new MongoClient(host,port);
						
						dbCollection = mongo.getDB(db)
								.getCollection(collection);
						Runtime.getRuntime().addShutdownHook(
								new Thread(new Runnable() {

									@Override
									public void run() {
										mongo.close();
									}
								}, "mongo shutdown"));
					} catch (MongoException mongoException) {
						mongoException.printStackTrace();
					} catch (UnknownHostException unknownHostException) {
						unknownHostException.printStackTrace();
					}
				}
			}
		}
		return dbCollection;
	}

	

	public void setHost(String host) {
		this.host = host;
	}



	public void setPort(int port) {
		this.port = port;
	}



	public void setDb(String db) {
		this.db = db;
	}

	public void setCollection(String collection) {
		this.collection = collection;
	}

}