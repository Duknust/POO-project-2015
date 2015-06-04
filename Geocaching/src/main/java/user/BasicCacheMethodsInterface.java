package user;

import caches.Cache;
import caches.Log;

public interface BasicCacheMethodsInterface {

    public boolean disableCache(Cache c);

    public boolean archiveCache(Cache c);

    public boolean enableCache(Cache c);

    public boolean logCache(Log l, Cache c);
}
