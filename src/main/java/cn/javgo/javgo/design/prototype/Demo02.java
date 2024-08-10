package cn.javgo.javgo.design.prototype;

import lombok.Data;

import java.util.HashMap;
import java.util.List;

/**
 * Desc：克隆一个HashMap散列表
 *
 * @author javgo
 * @date 2024-08-10
 */
public class Demo02 {

    /**
     * 搜索关键词
     */
    private HashMap<String, SearchWord> currentKeywords = new HashMap<>();

    /**
     * 上一次更新的时间
     */
    private long lastUpdateTime = -1;

    /**
     * 刷新数据
     */
    public void refresh() {
        // 使用原型模式克隆 currentKeywords, Java 的 clone 方法返回的是浅拷贝
        HashMap<String, SearchWord> newKeywords = (HashMap<String, SearchWord>) currentKeywords.clone();

        // 从数据库中取出更新时间 > lastUpdateTime 的数据，更新到 newKeywords 中
        List<SearchWord> toBeUpdatedSearchWords = getSearchWords(lastUpdateTime);
        long maxNewUpdatedTime = lastUpdateTime;

        for (SearchWord searchWord : toBeUpdatedSearchWords) {
            // 更新时间戳
            if (searchWord.getLastUpdateTime() > maxNewUpdatedTime) {
                maxNewUpdatedTime = searchWord.getLastUpdateTime();
            }

            // 已经存在的数据进行更新
            if (newKeywords.containsKey(searchWord.getKeyword())) {
                // 获取旧的数据
                SearchWord oldSearchWord = newKeywords.get(searchWord.getKeyword());
                // 设置新的数据
                oldSearchWord.setCount(searchWord.getCount());
                oldSearchWord.setLastUpdateTime(searchWord.getLastUpdateTime());
            } else {
                // 不存在则添加
                newKeywords.put(searchWord.getKeyword(), searchWord);
            }
        }

        lastUpdateTime = maxNewUpdatedTime;
        // 替换
        currentKeywords = newKeywords;
    }

    private List<SearchWord> getSearchWords(long lastUpdateTime) {
        // TODO: 从数据库中取出更新时间 > lastUpdateTime 的数据
        return null;
    }

    // SearchWord 内部类
    @Data
    private static class SearchWord {
        private String keyword;
        private long lastUpdateTime;
        private long count;
    }
}
