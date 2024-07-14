package com.karthik.LRUcache.storage;

import com.karthik.LRUcache.exception.CacheFullException;
import com.karthik.LRUcache.exception.NotFoundException;

public interface Storage<Key, Value>
{
	public void add(Key key, Value value) throws CacheFullException;

    void remove(Key key) throws NotFoundException;

    Value get(Key key) throws NotFoundException;
}
