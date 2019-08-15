package leetcode;

import org.junit.Test;

import java.util.*;

public class Collection {
    public void collect(){
        Queue<Integer> queue = new LinkedList<>();
        //推荐，Inserts the specified element into this queue,the tail of this queue
        queue.add(0);
        //Retrieves, but does not remove, the head of this queue.it throws an exception if this queue is empty.
        queue.element();
        //同add
        queue.offer(1);
        //Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
        queue.peek();
        //Retrieves and removes the head of this queue, or returns null if this queue is empty.
        queue.poll();
        //Retrieves and removes the head of this queue. This method differs from poll only in that it throws an exception if this queue is empty.
        queue.remove();

        Deque<Integer> deque = new LinkedList<>();
        //同addLast
        deque.add(0);
        //Inserts the specified element at the front of this deque
        deque.addFirst(1);
        //Inserts the specified element at the end of this deque
        deque.addLast(2);
        deque.getFirst();
        deque.getLast();
        deque.remove();
        //Retrieves and removes the first element of this deque. it throws an exception if this deque is empty.
        deque.removeFirst();
        deque.removeLast();

        //同add，offerLast
        deque.offer(3);
        //不推荐使用，Inserts the specified element at the front of this deque
        deque.offerFirst(4);
        deque.offerLast(5);
        //Retrieves, but does not remove the first element of this deque
        deque.peek();
        //同peek
        deque.peekFirst();
        deque.peekLast();
        //Retrieves and removes the head of the queue，returns null if this deque is empty.
        deque.poll();
        deque.pollFirst();
        deque.pollLast();
        //同 removeFirst()，removes and returns the first element of this deque
        deque.pop();
        //同addFirst，头部插入
        deque.push(6);
        deque.contains(6);


        List<String> list = new ArrayList<>();
        //Appends the specified element to the end of this list
        list.add("a");
        list.add(1, "b");
        //Appends all of the elements in the specified collection to the end of this list
        list.addAll(Arrays.asList("c","d","e"));
        //Returns the element at the specified position in this list.
        list.get(1);
        //Replaces the element at the specified position in this list with the specified element
        list.set(1, "x");
        list.indexOf("a");
        list.lastIndexOf("a");
        list.remove("a");
        list.remove(0);
        list.contains("b");
        //Returns an array containing all of the elements in this list
        list.toArray();
        Set<String> listSet = new HashSet<>(list);

        LinkedList<String> linkedlist = new LinkedList<>();
        linkedlist.add("a");
        linkedlist.add(1, "b");
        linkedlist.contains("a");
        linkedlist.addAll(Arrays.asList("c", "d", "e"));
        linkedlist.get(0);
        linkedlist.set(3, "f");
        linkedlist.indexOf("a");
        linkedlist.lastIndexOf("e");
        linkedlist.remove("a");
        linkedlist.remove(1);
        linkedlist.toArray();
        /**
         * 还有更多方法，LinkedList实现了List和的Deque接口
         */

        Set<String> set = new HashSet<>();
        set.add("a");
        set.contains("a");
        set.addAll(Arrays.asList("b","c","d"));
        set.remove("a");
        set.clear();

        Map<Integer,String> map = new HashMap<>();
        map.put(0, "a");
        map.put(1, "b");
        map.put(2, "c");
        map.putIfAbsent(3, "e");
        map.get(0);
        map.containsKey(0);
        map.containsValue("a");
        map.remove(0);
        map.remove(0, "a");
        map.replace(0, "d");
        map.keySet();

        Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
        for(Map.Entry<Integer, String> entry:entrySet){
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key+"="+value);
        }
    }

    @Test
    public void test(){
        List<String> list = new ArrayList<>();
        //Appends the specified element to the end of this list
        list.add("a");
        list.add(1, "b");
        //Appends all of the elements in the specified collection to the end of this list
        list.addAll(Arrays.asList("c","d","e"));
        Set<String> listSet = new HashSet<>(list);
        System.out.println(listSet);
    }

}
