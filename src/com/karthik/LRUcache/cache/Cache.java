package com.karthik.LRUcache.cache;

import com.karthik.LRUcache.exception.CacheFullException;
import com.karthik.LRUcache.exception.NotFoundException;
import com.karthik.LRUcache.policy.EvictPolicy;
import com.karthik.LRUcache.storage.Storage;

public class Cache<Key, Value>
{
	private final EvictPolicy<Key> evictPolicy;
	private final Storage<Key, Value> storage;

	public Cache(EvictPolicy<Key> evictPolicy, Storage<Key, Value> storage)
	{
		this.evictPolicy = evictPolicy;
		this.storage = storage;
	}

	public void put(Key key, Value value)
	{
		try
		{
			this.storage.add(key, value);
			this.evictPolicy.keyAccessed(key);
		}
		catch (CacheFullException exception)
		{
			System.out.println("Cache full. Will try to evict.");

			Key keyToRemove = evictPolicy.evictKey();
			if (keyToRemove == null)
				throw new RuntimeException("Unexpected State. Storage full and no key to evict.");

			this.storage.remove(keyToRemove);
			System.out.println(keyToRemove + " key is removed");
			put(key, value);
		}
	}

	public Value get(Key key)
	{
		try
		{
			Value value = this.storage.get(key);
			this.evictPolicy.keyAccessed(key);
			return value;
		}
		catch (NotFoundException e)
		{
			System.out.println("key not found");
			return null;
		}
	}
}
