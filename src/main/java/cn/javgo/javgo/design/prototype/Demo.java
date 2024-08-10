package cn.javgo.javgo.design.prototype;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Desc：克隆一个HashMap散列表
 *
 * @author javgo
 * @date 2024-08-10
 */
public class Demo {

    /**
     * 搜索关键词
     */
    private ConcurrentHashMap<String, SearchWord> currentKeywords = new ConcurrentHashMap<>();

    /**
     * 刷新数据
     */
    public void refresh() {
        // 从数据库中取出更新时间 > lastUpdateTime 的数据，更新到 currentKeywords 中
        List<SearchWord> toBeUpdatedSearchWords = getSearchWords(lastUpdateTime);
        // 暂存最新的时间戳
        long maxNewUpdatedTime = lastUpdateTime;
        for (SearchWord searchWord : toBeUpdatedSearchWords) {
            // 更新时间戳
            if (searchWord.getLastUpdateTime() > maxNewUpdatedTime) {
                maxNewUpdatedTime = searchWord.getLastUpdateTime();
            }

            // 已经存在的数据进行更新
            if (currentKeywords.containsKey(searchWord.getKeyword())) {
                currentKeywords.replace(searchWord.getKeyword(), searchWord);
            } else {
                // 不存在的数据进行添加
                currentKeywords.put(searchWord.getKeyword(), searchWord);
            }
        }

        // 更新 lastUpdateTime
        lastUpdateTime = maxNewUpdatedTime;
    }

    private List<SearchWord> getSearchWords(long lastUpdateTime) {
        // TODO: 从数据库中取出更新时间 > lastUpdateTime 的数据
        return null;
    }

    /**
     * 上一次更新的时间
     */
    private long lastUpdateTime = -1;

    // SearchWord 内部类
    private static class SearchWord {
        private String keyword;
        private long lastUpdateTime;

        public SearchWord(String keyword, long lastUpdateTime) {
            this.keyword = keyword;
            this.lastUpdateTime = lastUpdateTime;
        }

        public String getKeyword() {
            return keyword;
        }

        public long getLastUpdateTime() {
            return lastUpdateTime;
        }
    }
}
