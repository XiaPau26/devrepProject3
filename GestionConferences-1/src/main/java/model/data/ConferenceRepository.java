package model.data;

import model.Conference;

public interface ConferenceRepository {
	void save(Conference form);

	Iterable<Conference> findAllConference();

	Conference findOneConference(long idConference);
}