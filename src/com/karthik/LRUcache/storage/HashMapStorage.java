package com.karthik.LRUcache.storage;

import java.util.HashMap;
import java.util.Map;

import com.karthik.LRUcache.exception.CacheFullException;
import com.karthik.LRUcache.exception.NotFoundException;

public class HashMapStorage<Key, Value> implements Storage<Key, Value>
{
	Map<Key, Value> map;
	private int capacity;

	public HashMapStorage(int capacity)
	{
		this.capacity = capacity;
		map = new HashMap<>();
	}

	private boolean isMapFull()
	{
		return map.size() == capacity;
	}

	@Override
	public void add(Key key, Value value) throws CacheFullException
	{
		if (isMapFull())
			throw new CacheFullException("Capacity Full.....");
		map.put(key, value);
	}

	@Override
	public void remove(Key key) throws NotFoundException
	{
		if (!map.containsKey(key))
			throw new NotFoundException(key + " doesn't exist in cache.");
		map.remove(key);
	}

	@Override
	public Value get(Key key) throws NotFoundException
	{
		if (!map.containsKey(key))
			throw new NotFoundException(key + " doesn't exist in cache.");
		return map.get(key);
	}

}
