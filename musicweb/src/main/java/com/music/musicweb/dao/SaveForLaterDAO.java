package com.music.musicweb.dao;

import java.util.List;

import com.music.musicweb.model.SaveForLater;

public interface SaveForLaterDAO {
	
	public boolean addSavedItem(SaveForLater savedItem);
	public SaveForLater getSavedItem(int savedItemId);
	public boolean deleteSavedItem(SaveForLater savedItem);
	public List<SaveForLater> savedItemsList(String username);

}
