package cn.javgo.javgo.design.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Desc：克隆一个HashMap散列表
 *
 * @author javgo
 * @date 2024-08-10
 */
public class Demo04 {

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
        // 浅拷贝 currentKeywords
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
                // 深拷贝需要更新的对象
                SearchWord oldSearchWord = new SearchWord(searchWord.getKeyword(), searchWord.getCount(), searchWord.getLastUpdateTime());
                newKeywords.put(searchWord.getKeyword(), oldSearchWord);
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
    @AllArgsConstructor
    private static class SearchWord {
        private String keyword;
        private long lastUpdateTime;
        private long count;
    }
}
