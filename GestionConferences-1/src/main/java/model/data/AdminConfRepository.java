package model.data;

import java.util.List;

import model.AdminConf;

public interface AdminConfRepository {
	void save(List<AdminConf> form);
	Iterable<AdminConf> findConfByAdmin(String admin);
	void delete(String admin);
}
