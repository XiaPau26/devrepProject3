package model.data;

import model.URL;

public interface UrlRepository {
	void save(URL url);

	Iterable<URL> findAllUrl();

	URL findOneUrl(String url);
	
	void delete(long id);
}
