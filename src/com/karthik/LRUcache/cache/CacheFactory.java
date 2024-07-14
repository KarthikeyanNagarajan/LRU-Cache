package com.karthik.LRUcache.cache;

import com.karthik.LRUcache.policy.LRUEvictPolicy;
import com.karthik.LRUcache.storage.HashMapStorage;

public class CacheFactory<Key, Value>
{
	public Cache<Key, Value> getCache(int capacity)
	{
		return new Cache<Key, Value>(new LRUEvictPolicy<Key>(), new HashMapStorage<Key, Value>(capacity));
	}
}
