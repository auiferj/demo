package com.example.jdk8.collect;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashMapDemo {
    //默认初始容量16 - 必须是 2 的幂.计算索引时，高效、分布均匀
    static final int default_initial_capacity = 1 << 4;

    //最大容量，如果任一构造函数使用参数隐式指定了更高的值，则使用该容量。必须是 2 的幂 <= 1<<30。
    static final int maximum_capacity = 1 << 30;

    //构造函数中未指定时使用的负载系数。负载因子。
    static final float default_load_factor = 0.75f;

    //这是一个"桶"从使用链表转为使用树的数量阈值。
    static final int treeify_threshold = 8;

    //当桶中的元素数量因为删除而减少到6时，红黑树会退化成链表
    static final int untreeify_threshold = 6;

    /**
     * 首先要明确：仅仅因为一个桶的链表长度达到8（TREEIFY_THRESHOLD），并不一定会触发树化。
     * <p>
     * 树化需要同时满足两个条件：
     * <p>
     * 单个桶中的链表长度 >= TREEIFY_THRESHOLD (8)
     * <p>
     * HashMap的整个数组（table）的容量 >= MIN_TREEIFY_CAPACITY (64)
     * <p>
     * 如果条件1满足，但条件2不满足，HashMap会选择另一种优化方式：扩容（Resize）
     */
    static final int min_treeify_capacity = 64;


    /**
     * 基本哈希箱节点，参阅TreeNode,LinkedHashMap
     * @param <K>
     * @param <V>
     */
    static class Node<K, V> implements Map.Entry<K, V> {

        final int hash;
        final K key;
        V value;
        HashMapDemo.Node<K,V> next;

        Node(int hash, K key, V value, HashMapDemo.Node<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        //不是接口Map.Entry中的方法
        public final String toString() { return key + "=" + value; }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

    }
}
