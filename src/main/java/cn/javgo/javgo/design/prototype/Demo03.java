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
public class Demo03 {

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
        // 深拷贝 currentKeywords
        HashMap<String, SearchWord> newKeywords = new HashMap<>();
        for (Map.Entry<String, SearchWord> entry : currentKeywords.entrySet()) {
            SearchWord searchWord = entry.getValue();
            // 重新创建一个 SearchWord 对象
            SearchWord newSearchWord = new SearchWord(searchWord.getKeyword(), searchWord.getCount(), searchWord.getLastUpdateTime());
            newKeywords.put(entry.getKey(), newSearchWord);
        }

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
    @AllArgsConstructor
    private static class SearchWord {
        private String keyword;
        private long lastUpdateTime;
        private long count;
    }

    /**
     * 深拷贝 - 使用序列化和反序列化
     * 通过将对象序列化为字节数组，然后通过反序列化生成新的对象实例，实现深拷贝
     * 这种方法适用于实现 Serializable 接口的对象
     *
     * @param object 待拷贝的对象
     * @return 拷贝后的对象
     * @throws IOException IO 异常
     * @throws ClassNotFoundException 类未找到异常
     */
    public Object deepCopy(Object object) throws IOException, ClassNotFoundException {
        // 使用ByteArrayOutputStream临时存储序列化后的对象数据
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        // 创建ObjectOutputStream，用于将对象序列化
        ObjectOutputStream oos = new ObjectOutputStream(bos);

        // 将对象序列化并写入ByteArrayOutputStream
        oos.writeObject(object);
        oos.flush();

        // 使用ByteArrayInputStream读取序列化后的对象数据
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        // 创建ObjectInputStream，用于将序列化数据反序列化为对象
        ObjectInputStream ois = new ObjectInputStream(bis);
        // 返回反序列化后的对象
        return ois.readObject();
    }

}
