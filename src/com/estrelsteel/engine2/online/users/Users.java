package com.estrelsteel.engine2.online.users;

import java.util.ArrayList;
import java.util.Iterator;

import com.estrelsteel.engine2.online.OnlineInfo;
import com.estrelsteel.engine2.online.exception.UnknownUserException;

public class Users implements Iterable<UserData> {
	private ArrayList<UserData> users;
	private OnlineInfo info;

	public Users(OnlineInfo info) {
		this.users = new ArrayList<UserData>();
		this.info = info;
	}
	
	public Iterator<UserData> iterator() {
		Iterator<UserData> i = users.listIterator();
		return i;
	}
	
	public UserData get(String ip, String port) throws UnknownUserException {
		for(int i = 0; i < users.size(); i++) {
			if(users.get(i).getIP().equals(ip)
					&& users.get(i).getPort().equals(port)) {
				return users.get(i);
			}
		}
		throw new UnknownUserException(ip + info.getSplit() + port);
	}
	
	public UserData get(String username) throws UnknownUserException {
		for(int i = 0; i < users.size(); i++) {
			if(users.get(i).getUsername().equals(username)) {
				return users.get(i);
			}
		}
		throw new UnknownUserException(username);
	}
	
	public UserData get(int i) {
		return users.get(i);
	}
	
	public int size() {
		return users.size();
	}
	
	public UserData add(UserData user) {
		users.add(user);
		return user;
	}
	
	public UserData remove(String ip, String port) throws UnknownUserException {
		for(int i = 0; i < users.size(); i++) {
			if(users.get(i).getIP().equals(ip)
					&& users.get(i).getPort().equals(port)) {
				return users.remove(i);
			}
		}
		throw new UnknownUserException(ip + info.getSplit() + port);
	}

	public UserData remove(String username) throws UnknownUserException {
		for(int i = 0; i < users.size(); i++) {
			if(users.get(i).getUsername().equalsIgnoreCase(username)) {
				return users.remove(i);
			}
		}
		throw new UnknownUserException(username);
	}
	
	public UserData remove(int i) {
		return users.remove(i);
	}
}
