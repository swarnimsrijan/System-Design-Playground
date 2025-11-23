public class TokenBucketAlgorithm {
    private final long bucketSize;
    private final long refillTokens;
    private final long refillIntervalMillis;
    private long availableTokens;
    private long lastRefillTimestamp;

    public TokenBucketAlgorithm(long bucketSize, long refillTokens, long refillIntervalMillis) {
        this.bucketSize = bucketSize;
        this.refillTokens = refillTokens;
        this.refillIntervalMillis = refillIntervalMillis;
        this.availableTokens = bucketSize;
        this.lastRefillTimestamp = System.currentTimeMillis();
    }

    public synchronized boolean allowRequest() {
        refillTokensIfNeeded();
        if (availableTokens > 0) {
            availableTokens--;
            return true;
        }
        return false;
    }

    private void refillTokensIfNeeded() {
        long now = System.currentTimeMillis();
        long elapsedTime = now - lastRefillTimestamp;

        if (elapsedTime >= refillIntervalMillis) {
            long tokensToAdd = (elapsedTime / refillIntervalMillis) * refillTokens;
            availableTokens = Math.min(bucketSize, availableTokens + tokensToAdd);
            lastRefillTimestamp = now;
        }
    }
}